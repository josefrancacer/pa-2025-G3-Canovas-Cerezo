package pa.coffe;
import pa.excepciones.TooColdException;
import pa.excepciones.TooHotException;
public class VirtualPerson {
	private static final int TOO_COLD = 35;
	private static final int TOO_HOT = 85;
	private String name;
	
	public VirtualPerson(){
		name = "anónimo";
	}
	public VirtualPerson(String nombre) {
		name = nombre;
	}
	public String getName() {
		return name;
	}
	public void drinkCoffe(CoffeCup cup) throws TooHotException, TooColdException {
		System.out.println(name + ": me voy a tomar un café");
			if(cup.getTemperatura()>TOO_HOT) {
				throw new TooHotException(name + ":el café está a " + cup.getTemperatura() + 
						" grados: Demasiado CALIENTE");
			}else if (cup.getTemperatura()<TOO_COLD){
				throw new TooColdException(name + ":el café está a " + cup.getTemperatura() + 
						" grados: Demasiado FRÍO");
			}

	}
}
