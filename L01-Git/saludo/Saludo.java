/**
 * Clase Saludo
 *
 */
class Saludo {
    /**
     * Método que imprime un saludo general 
     */
    public void todos() {
        System.out.println("Hola a todos");
    }
    
    /**
     * Metodo que imprime un saludo particular 
     */
    public void personal(String nombre) {
        System.out.println(" *** Hola, "+ nombre);
    }
    
    /**
     *  main method
     */
    public static void main(String[] args) {
        Saludo saludo = new Saludo();
        saludo.personal("Miguel");
        saludo.personal("Juan");
    }
}
