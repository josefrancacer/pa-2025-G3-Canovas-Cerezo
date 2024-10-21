/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.gui;

import javax.swing.*;
import java.awt.*;  
import pa.music.organizer.MusicOrganizer;

/**
 *
 * @author eli
 */
public class EntornoGrafico {
    private String[] listaTemas;
    private MusicOrganizer organizadorMusica;
    private boolean playing;  
    
    public EntornoGrafico (String[] listaTemas) {
        
        this.listaTemas = listaTemas;
        organizadorMusica = new MusicOrganizer();              
        System.out.println("Cargando las canciones en el reproductor...");        
        //aquí tienes que cargar en el organizador de música la lista de temas
        playing = false; 
    }
  
    //public static void main(String args[]) {    
    public void startAplicacion () { 
        
        // Creamos el Marco        
        JFrame frame = new JFrame("Reproductor mp3");       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        //frame.setSize(400, 400); 
        frame.setSize(650, 400);
        int cancion_actual=4;
  
        
        // Creamos el panel de la parte inferior con los botones
        JPanel panelBotones = new JPanel();             
        JButton play = new JButton("Play");       
        JButton stop = new JButton("Stop");
        JButton exit = new JButton("Exit");
        JButton next = new JButton("Next");
        JButton previous = new JButton("Previous");
        exit.addActionListener(e -> {
         frame.dispose();
        });
        // Componentes agregados usando Flow Layout
        panelBotones.add(play);       
        panelBotones.add(stop);
        panelBotones.add(exit); 
        panelBotones.add(next);
        panelBotones.add(previous);        
        
        //Cremos el panel superior con el texto y el menú desplegable
        JPanel panelCanciones = new JPanel();
        JLabel texto = new JLabel("Selecciona la canción: "); 
        
        JComboBox<String> listaCanciones = new JComboBox<>(listaTemas);
        listaCanciones.setSelectedIndex(cancion_actual); //cancion_actual=4
        panelCanciones.add(texto);
        panelCanciones.add(listaCanciones);
        
        // Área de texto en el centro con un scrollpane
        JTextArea ta = new JTextArea(); 
        ta.append(" Bienvenido");
        ta.setEditable(false);
        ta.append("\n Puede escuchar "+ listaTemas.length+ " temas");
        
        JScrollPane scrollpane = new JScrollPane(ta);
        
        // Agregamos todos los componentes al marco.      
        frame.getContentPane().add(BorderLayout.SOUTH, panelBotones);       
        frame.getContentPane().add(BorderLayout.CENTER, scrollpane);  
        frame.getContentPane().add(BorderLayout.NORTH, panelCanciones);             
        frame.setVisible(true);  

         
        //añadimos la funcionalidad del botón play
        play.addActionListener(e -> {
         System.out.println("Botón play habilitado, valor = "+play.isEnabled());
         if (play.isEnabled()) {
            play.setEnabled(false);
            System.out.println("Deshabilitamos el botón play, valor = "+play.isEnabled());
            
            String cancion = (String)listaCanciones.getSelectedItem();
            if (!playing) {
                ta.append("\n Escuchando el tema: "+ cancion+ " ..."); 
                organizadorMusica.startPlaying(listaCanciones.getSelectedIndex()+1); 
                playing= true;
                System.out.println("Canción actual: "+listaCanciones.getSelectedIndex()+1);
            } else ta.append("\n Reproductor ocupado. Pulse primero stop");
                       
            play.setEnabled(true);
         }
        });
  
        //añadimos la funcionalidad del botón stop
        stop.addActionListener(e -> {
         if (play.isEnabled() || next.isEnabled() || previous.isEnabled()) {
           organizadorMusica.stopPlaying();
           System.out.println("Reproductor detenido");
           ta.append("\n Reproductor detenido"); 
           playing=false;
         } 
        }); 
        
        //añadimos la funcionalidad del botón next
        next.addActionListener(e -> {
         System.out.println("Botón next habilitado = "+next.isEnabled());
         if (next.isEnabled()) {
            next.setEnabled(false);
            System.out.println("Botón next habilitado = "+next.isEnabled());
            
            if (!playing) {
                //avanzamos a la siguiente canción en la lista
                int sig_indice= (listaCanciones.getSelectedIndex()+1) % listaCanciones.getItemCount();
                System.out.println("el indice de la siguiente canción es: "+ sig_indice);
                listaCanciones.setSelectedIndex(sig_indice);
                String cancion = (String)listaCanciones.getSelectedItem();
            
                ta.append("\n Escuchando el tema: "+ cancion+ " ..."); 
                organizadorMusica.startPlaying(listaCanciones.getSelectedIndex()+1); 
                playing= true;
            } else ta.append("\n Reproductor ocupado. Pulse primero stop");
                       
            next.setEnabled(true);
         }
        });
        
      //añadimos la funcionalidad del botón previous
        previous.addActionListener(e -> {
         System.out.println("Botón previous habilitado = "+previous.isEnabled());
         if (previous.isEnabled()) {
        	 previous.setEnabled(false);
            System.out.println("Botón previous habilitado = "+previous.isEnabled());
            
            if (!playing) {
                //retrocedemos una posición en la lista
                int indice_anterior= (listaCanciones.getSelectedIndex()-1) % listaCanciones.getItemCount();
                if (indice_anterior<0) indice_anterior= listaCanciones.getItemCount()-1;
                System.out.println("el indice de la canción anterior es: "+ indice_anterior);
                listaCanciones.setSelectedIndex(indice_anterior);
                String cancion = (String)listaCanciones.getSelectedItem();
            
                ta.append("\n Escuchando el tema: "+ cancion+ " ..."); 
                organizadorMusica.startPlaying(listaCanciones.getSelectedIndex()+1); 
                playing= true;
            } else ta.append("\n Reproductor ocupado. Pulse primero stop");
                       
            previous.setEnabled(true);
         }
        });   
    }
}
