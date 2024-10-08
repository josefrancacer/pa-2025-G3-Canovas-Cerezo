/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa;


public class Dibujar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Circle sol1;
    	sol1 = new Circle();
    	sol1.makeVisible();
    	sol1.changeColor("yellow");
        sol1.moveHorizontal(1);
        sol1.moveVertical(-40);
        Square fachada1;
        Square puerta1;
        fachada1 = new Square();
        fachada1.makeVisible();
        fachada1.changeColor("blue");
        fachada1.moveHorizontal(-200);
        fachada1.moveVertical(50);
        Person persona1;
        persona1 = new Person();
        persona1.makeVisible();
        persona1.moveHorizontal(5);
        persona1.moveVertical(10);
    	System.out.println("\n\n Ejercicio pendiente de realizar \n\n");
        
    }
    
}
