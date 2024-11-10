package pa.sorting;

import pa.interfaces.IOrdenable;

/**
 * Write a description of class Grades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grade implements IOrdenable
{
    // instance variables - replace the example below with your own
    private double value;

    /**
     * Constructor for objects of class Grades
     */
    public Grade(double grade)
    {
        // initialise instance variables
        value = grade;
    }
    
    public double getValue() {
        return value;
    }
    @Override
    public boolean menorQue(IOrdenable a) {
    	Grade nota = (Grade) a;
    	return (this.getValue() < nota.getValue());
    		
    	}
}
