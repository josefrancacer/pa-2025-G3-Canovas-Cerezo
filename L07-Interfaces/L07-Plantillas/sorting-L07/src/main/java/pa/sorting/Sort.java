package pa.sorting;
import pa.interfaces.IOrdenable;
/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sort {
   /**
      Sorts an array of int elements, using selection sort.
      @param a the array to sort
   */
   public static void selectionSort(IOrdenable[] a)
   {  
       
      for (int i = 0; i < a.length - 1; i++)
      {  
         int minPos = minimumPosition(a, i);
         //intercambiamos los elementos de la posición minPos e i
         IOrdenable temp = a[minPos];
         a[minPos] = a[i];
         a[i] = temp;
         
      }
      
   }

   /**
      Finds the smallest element in a tail range of the array.
      @param a the array to sort
      @param from the first position in a to compare
      @return the position of the smallest element in the
      range a[from] . . . a[a.length - 1]
   */
   private static int minimumPosition(IOrdenable[] a, int from)  {  
      int minPos = from;
      for (int i = from + 1; i < a.length; i++) {
         if (a[i].menorQue(a[minPos]) ) { 
        	 minPos = i;
        	 }
      }
      return minPos;
   }
}
