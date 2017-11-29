import java.util.*;

import java.io.*;


public class MergeSort {
   

   public long wallStartTime, wallEndTime, cpuStartTime, cpuEndTime, wallclock, cpuTime;
   public void mergeSort(Object[] temp ){
      if (temp.length < 2)
         return;
      int mid = temp.length / 2;
      int leftSize = mid;
      int rightSize = temp.length - mid;
            
      Object[] left = new Object [leftSize];
      Object[] right = new Object[rightSize];
      
      for (int i = 0; i < mid; i++) {
         left[i] = temp[i];
      }
      
      for (int i = mid; i <temp.length ; i++) {
         right[i - mid] = temp[i];
      }
        
      mergeSort(left);
      mergeSort(right);
      merge(left, right, temp);
      //ClassDemo o1 = new ClassDemo();
      //ClassDemo o2 = new ClassDemo();
      //compareTo(o1,o2);
      //mergeSortTime(temp);
      
   }
   
   public static void merge(Object[] left, Object[] right, Object[] temp) {
      int leftSize = left.length;
      int rightSize = right.length;
      int i = 0, j = 0, k = 0;
      
      while (i < leftSize && j < rightSize) {
       if (compareTo(left[i], right[j]) >= 0) { 
                 temp[k] = left[i];
                 i++;
                 k++;
                 j++;
        } else {
                 temp[k] = right[j];
                 k++;
                j++;
             }
        }
        while (i < leftSize) {
            temp[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            temp[k] = right[j];
            k++;
            j++;
        }
   }
    
   public static int compareTo(Object o1, Object o2){
      
      Class c = o1.getClass();
      
      switch(c.toString()){
         case "class java.lang.Integer":
            return ((Integer)o1).compareTo((Integer)o2);
            /*if((Integer) o1 > (Integer) o2){
               return -1;
            } else {
               return 1;
            }*/
         case "class java.lang.Double":
            
            return ((Double)o1).compareTo((Double)o2);
            //if((Double) o1 > (Double) o2){
            //   return -1;
            //} else {
            //   return 1;
            //}
         case "class java.lang.String":
            return ((String) o1).compareTo((String) o2);
         default:
            System.out.println("Error: invalid class " + c.toString());
            return 0;
      }
   }
   

/*/////////////////////
   
   public void mergeSortInteger(int[] inputArray) {
      if (inputArray.length < 2)
         return;
      int mid = inputArray.length / 2;
      int leftSize = mid;
      int rightSize = inputArray.length - mid;
      int[] left = new int[leftSize];
      int[] right = new int[rightSize];
      for (int i = 0; i < mid; i++) {
      left[i] = inputArray[i];

      }
      for (int i = mid; i <inputArray.length ; i++) {
         right[i - mid] = inputArray[i];
      }
        
       mergeSortInteger(left);
       mergeSortInteger(right);
       mergeInt(left, right, inputArray);
       mergesortTime();
    }
   public static void mergeInt(int[] left, int[] right, int[] arr) {
      int leftSize = left.length;
      int rightSize = right.length;
      int i = 0, j = 0, k = 0;
      while (i < leftSize && j < rightSize) {
         if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
            k++;
          } else {
                arr[k] = right[j];
                k++;
                j++;
            }
          }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
        
        
                
    
     
/************************/  
  /* public  void mergeSortReal(double[] inputArray) {
      int size = inputArray.length;
      if (size < 2)
         return;
      int mid = inputArray.length / 2;
      int leftSize = mid;
      int rightSize = inputArray.length - mid;
      double[] left = new double[leftSize];
      double[] right = new double[rightSize];
      for (int i = 0; i < mid; i++) {
         left[i] = inputArray[i];

       }
      for (int i = mid; i < inputArray.length; i++) {
         right[i - mid] = inputArray[i];
       }
      mergeSortReal(left);
      mergeSortReal(right);
      mergeReal(left, right, inputArray);
      mergesortTime();

      }
   public static void mergeReal(double[] left, double[] right, double[] arr) {
      int leftSize = left.length;
      int rightSize = right.length;
      int i = 0, j = 0, k = 0;
      while (i < leftSize && j < rightSize) {
         if (left[i] <= right[j]) {
             arr[k] = left[i];
               i++;
                k++;
          } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    
 }               
            
/*************************************************/
 

/*   int size = mb.length;
   if (size < 2)
   return;
   int mid = mb.length / 2;
   int leftSize = mid;
   int rightSize = mb.length - mid;
   String[] left = new String[leftSize];
   String[] right = new String[rightSize];
   for (int i = 0; i < mid; i++) {
       left[i] = mb[i];

        }
        for (int i = mid; i < mb.length; i++) {
            right[i - mid] = mb[i];
        }
        mergeSortString(left);
        mergeSortString(right);
        mergeString(left, right, mb);
        mergesortTime();

    }
   public static void mergeString(String[] left, String[] right, String[] arr) {
      int leftSize = left.length;
      int rightSize = right.length;
      int i = 0, j = 0, k = 0;
      while (i < leftSize && j < rightSize) {
      if (left[i].compareTo(right[j]) >= 0) {
                arr[k] = left[i];
                i++;
                k++;
         } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
        }*/
   public void mergeSortTime(Object[] temp){
      wallStartTime = System.currentTimeMillis();
      cpuStartTime = System.nanoTime();
      mergeSort(temp);
      wallEndTime = System.currentTimeMillis();
      cpuEndTime = System.nanoTime();
   }
        
   public long  wallClock(PrintWriter outputFile){
      System.out.println("This is the wall clock time for merge sort: " );
      outputFile.println("This is the wall clock time for merge sort: " );
      outputFile.println(wallEndTime-wallStartTime);
     

      return wallEndTime - wallStartTime;
   }

   public long cpuTime(PrintWriter outputFile) {
      System.out.println("This is the CPU time for merge sort: ");
      outputFile.println("This is the CPU time for merge sort: ");

      outputFile.println(cpuEndTime - cpuStartTime);

      return cpuEndTime - cpuStartTime;
    }

}
    
    
        
