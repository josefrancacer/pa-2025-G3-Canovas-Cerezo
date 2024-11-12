package pa;
import pa.interfaces.*;
import pa.sorting.*;
public class Demo1 {
	public static void main(String [] args) {
		Country countries [] = {
				new Country("España"),
				new Country("Venezuela"),
				new Country("Francia"),
				new Country("Belgica"),
				new Country("Holanda")
		};
		for(Country con : countries) {
			System.out.print("  " + con.getName());
		}
		System.out.println();
		Sort.selectionSort(countries);		
		for(Country con : countries) {
			System.out.print("  " + con.getName());
		}
		System.out.println();
		
		Grade grades [] = {
			new Grade(8.5),
			new Grade(4.5),
			new Grade(0.2),
			new Grade(5.0),
			new Grade(1.6)
		};
		for(Grade grade : grades) {
			System.out.print("  " + grade.getValue());
		}
		System.out.println();
		Sort.selectionSort(grades);
		for(Grade con : grades) {
			System.out.print("  " + con.getValue());
		}
		System.out.println();
		
		
	}
		
		
	}

