package pa;

/**
 * Clase que representa a un médico
 * 
 */
public class Medico {
    /**
     * El identificador del médico es una cadena de caracteres que es única para cada médico,
     * una vez definida no se puede cambiar
     */
    private String idMedico;
    /** La especialidad es una cadena de caracteres */
    private String especialidad;
    /** El horario es una matriz de tamaño NUM_DIAS X NUM_HORAS 
     *  <p>
     *  Consideraremos 5 días (0=lunes, 1= martes, ..., 4=viernes
     *  y 8 horas por día (9:00h, 10:00h,..,12:00h, 16:00h, 17:00h,...,19h)
     *  <p>
     *  La franja de 9:00h hasta 12:00h se considera de "mañanas"
     *  la franja de 16:00 hasta 19:00h se considera de "tardes"
     */
    private String[][] horario; 
    /** NUM_DIAS es una constante que representa el máximo de días
     *  Un médico trabaja 5 días a la semana
     */
    private final int NUM_DIAS=5; 
    /** NUM_HORAS es una constante que representa el máximo de horas de trabajo al día
     *  Un médico trabaja 8 horas cada día
     */
    private final int NUM_HORAS=8; //9, 10. 11. 12, 16, 17, 18, 19
    
    /**
     * Creamos un médito indicando su identificador y su especialidad
     * 
     * Cuando creamos un objeto de tipo Medico su horario está "vacío"
     * (el valor de cada "casilla" es null)
     * 
     * @param id identificador alfanumérico único para cada médico
     * @param especialidad : especialidad de ese médico
     */
    public Medico(String id, String especialidad) {
        this.idMedico = id;
        this.especialidad = especialidad; 
        horario = new String[NUM_DIAS][NUM_HORAS];
        //por defecto cada posición de la matriz se inicializa a null
    }
     
    /**
     * método getter
     * @return devuelve el identificador del médico
     */
    public String getIdMedico() {
        return idMedico;
    }

    /**
     * método getter
     * @return devuelve la especialidad del médico
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * método setter para cambiar la especialidad del médico
     * @param especialidad  cadena de caracteres que representa la especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Un día es válido si es un entero comprendido entre 0..4
     * @param dia valor entero que queremos validar
     * @return devuelve true si se trata de un día válido, y false en caso contrario
     */
    private boolean diaValido(int dia) {
        boolean valido;
        if(dia >= 0 && dia <= 4) {
        	valido = true;
        } else {
        	valido = false;
        }
        return valido;
    }
    
    /**
     * Una franja es válida si tiene como valor "mañana" o "tarde"
     * @param franja cadena de caracteres que representa la franja horaria
     * @return true, si se trata de una franja válida, y false en caso contrario
     */
    private boolean franjaValida(String franja) {
    	boolean valido = false;
        if(franja.equals("mañana") || franja.equals("tarde")) {
        	valido = true;
        }
        return valido;
    }
    
    /**
     * Método para crear una cita
     * @param dia entero que representa el día que queremos la cita (0..4)
     * @param franja franja horaria en la que queremos la cita ("mañana" o "tarde")
     * La franja de "mañana" se corresponde con el horaro de 9 a 12h
     * La franja de "tarde" se corresponde con el horario de 16 a 19h
     * @param paciente nombre del paciente que solicita la cita
     * @return devuelve un objeto de tipo Cita con el primer hueco libre en el 
     * horario del médico, para el día y franja horaria especificados.
     * Devuelve el valor null si no hay ningún "hueco" disponible en el horario del médico
     * o bien el día especificado es inválido o la franja especificada es inválida 
     */
    public Cita reservarCita(int dia, String franja, String paciente) {
    	int hora;
    	Cita cita = null;
    	if(this.diaValido(dia)&& this.franjaValida(franja)) {
    		int i = 0;
    		boolean horario_cubierto = false;
    		if(franja.equals("mañana")) {
    			while(!(horario[dia][i] == null)&& (i<4)) {
        			i++;
        			if(i == 4) {
        				horario_cubierto = true;
        				
        			}
        		}
    		}else {
    			i = 4;
    			while(!(horario[dia][i] == null) && (i<8)) {
            			i++;
            			if(i == 8) {
            				horario_cubierto = true;
            			}
    		}}
    		if(!horario_cubierto) {
    			horario[dia][i] = paciente;
    			hora = i;
        		cita = new Cita(paciente, this.getIdMedico(), this.getEspecialidad(), this.dia(dia),this.hora(i));
    		}else {
    			System.out.println("Cita no posible para " + paciente);
    		}
    		
    	} else {
    		System.out.println("Cita no posible para " + paciente);
    	}
    	
        return cita;    
    }
    
    /**
     * Método para imprimir por pantalla el horario de un médico
     * Se imprimirá la tabla con el horario del médico en la que se mostrará una 
     * cabecera con la hora de cada columna: 9:00h, 10:00h, ... 19h. También se
     * mostrará una columna de cabecera que indicará los días de la semana: Lunes, 
     * Martes, ...., Viernes. Finalmente, en cada en cada posición del horario se 
     * mostrará el nombre del paciente que ha reservado una cita o bien se mostrará 
     * " --- " indicando que ese día, a esa hora, el médico no tiene 
     * ninguna cita asignada
     */ 
    public void printHorario() {
    	System.out.print("Horario del doctor: " + this.getIdMedico() + "\t");
    	System.out.println("Especialidad : " + this.getEspecialidad());
    	System.out.print("           ");
    	String espacio = "---";
    	for(int i = 0; i<= 7; i++) {
    		System.out.printf("%-7s", this.hora(i));
    	}
    	System.out.println("");
    	for(int i = 0; i<=4; i++) {
    		System.out.printf("%-11s", this.dia(i));
    		for( int j = 0; j<= 7; j++) {
    			if(this.horario[i][j] == null) {
    				System.out.printf("%-7s", espacio);
    			} else {
    				System.out.printf("%-7s", this.horario[i][j]);
    			}
    			
    		}
    		System.out.println("");
    	}
    	
        
        
    }
    
    /**
     * Método que devuelve la cadena de caracteres asociada al valor numérico correspondiente
     * @param indice representa un valor entre 0..4
     * @return "Lunes" o "Martes", ..., o "Viernes", dependiendo de si el día es 0 ó 1 ... ó 4
     * Si el valor numérico introducido no se corresponde con ningún día se devuelve una cadena vacía
     */
    private String dia(int indice) {
    	String dia;
    	if(this.diaValido(indice)) {
    		String [] dias = new String[] {"Lunes","Martes", "Miércoles", "Jueves", "Viernes"};
    		dia = dias[indice];
    	}else {
    		dia = "";
    	}
        
        return dia;
    }
    /**
     * Método que devuelve la cadena de caracteres asociada al valor numérico correspondiente
     * @param indice representa un valor entre 0..7
     * @return "9:00h " o "10:00h", ..., o "19:00h", dependiendo de si el día es 0 ó 1 ... ó 7
     * Si el valor numérico introducido no se corresponde con ningún día se devuelve una cadena vacía
     */
    private String hora(int indice) {
        String hora;
        if(indice >= 0 && indice <= 7 ) {
        	String [] horas = new String[] {"9:00h","10:00h", "11:00h", "12:00h","16:00h","17:00h","18:00h","19:00h"};
        	hora = horas[indice];
        }else {
        	hora = "";
        }
        return hora;
    }
        
}
