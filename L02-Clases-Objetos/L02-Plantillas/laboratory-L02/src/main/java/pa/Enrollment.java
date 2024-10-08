/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa;


public class Enrollment {

    
    public static void main(String[] args) {
    	Student s1, s2, s3, s4;
    	s1 = new Student("Monica Galler", "A00234");
    	s1.addCredits(24);
    	s1.print();
    	s2 = new Student("Joe Tribiani","C22044");
    	s2.addCredits(56);
    	s2.print();
    	s3 = new Student("Chandler Bing", "A12003");
    	s3.addCredits(6);
    	s3.print();
    	s4 = new Student("Rachel Green", "B66003");
    	s4.addCredits(12);
    	s4.print();
    
    	LabClass lab1,lab2;
    	lab1 = new LabClass(2);
    	lab1.setInstructor("Eli");
    	lab1.setTime("Miercoles 15h");
    	lab1.setRoom("Aulario2");
    	lab2 = new LabClass(1);
    	lab2.setInstructor("Jose Antonio");
    	lab2.setTime("Miercoles 17h");
    	lab2.setRoom("Aulario2");
    	lab1.enrollStudent(s1);
    	lab1.enrollStudent(s2);
    	lab2.enrollStudent(s3);
    	lab2.enrollStudent(s4);
    	lab1.printList();
    	lab2.printList();
    	
      
    }
    
}
