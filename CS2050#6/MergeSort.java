import java.util.*;

import java.io.*;

public class MergeSort {

   public long wallStartTime, wallEndTime, cpuStartTime, cpuEndTime, wallclock, cpuTime;
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
   public  void mergeSortReal(double[] inputArray) {
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
 

public void mergeSortString(String[] mb) {
   int size = mb.length;
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
        }
   private void mergesortTime(){
      wallStartTime = System.currentTimeMillis();
      cpuStartTime = System.nanoTime();
      wallEndTime = System.currentTimeMillis();
      cpuEndTime = System.nanoTime();
   }
        
   public long  wallClock() {
      System.out.println("This is the wall clock time for merge sort: " );
      return wallEndTime - wallStartTime;
   }

   public long cpuTime() {
      System.out.println("This is the CPU time for merge sort: ");
      return cpuEndTime - cpuStartTime;
    }

}
    
    
        