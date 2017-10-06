/*
The name of program is HW4.
This program test and time two sorts to see the difference between them.
09/26/2017
Ze Liu
Program #4, CS 2050
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.*;
public class HW4 {
   public static void main (String [] args) throws IOException {
      final String INPUT_FILE = "TEST-master/HW4.txt";
      
            
      // Access the input
      File inputDataFile = new File (INPUT_FILE);
      Scanner inputFile = new Scanner (inputDataFile);
       
      ArrayList<String> lines = new ArrayList<String>();
      
      String temp;
      while (inputFile.hasNext()) {
         temp = inputFile.nextLine();
         if(temp.isEmpty()){
         }
         else {
            lines.add(temp); 
         }        
      }
      lines.trimToSize();
      
      for ( int i = 0; i < lines.size(); i++) {
         StringBuilder line = new StringBuilder(lines.get(i));
         //String line = lines.get(i);
         
         for ( int j = 0; j < line.length(); j++) {
            if (line.charAt(j) >= 32 && line.charAt(j) <=47 ||line.charAt(j) >=58 &&line.charAt(j)<=64 ||
            line.charAt(j) >=91 && line.charAt(j)<=96 || line.charAt(j) >=123 && line.charAt(j)<=126 ){
               line.deleteCharAt(j); 
               j--;
            }
         }
      }
      ArrayList<String> clone = new ArrayList<String>();
      for(String s: lines){
         clone.add(s);
         }
      
      
      Scanner input = new Scanner(System.in);
      System.out.println("please enter the file name: ");
      bubbleSort(lines);
      builtInJavaSort(clone);
      
   }
   public static void bubbleSort(ArrayList<String> lines) {
            
      String temp; 
      char m, n;
      for(int i = 0; i< lines.size()-1; i++){
      
      m = lines.get(i).charAt(0);
      n = lines.get(i+1).charAt(0);
         
         if ( m > n ) {                     
            temp = lines.get(i);
            lines.remove(i);
            lines.add(i+1,temp);
            
         }  
      }
       
   }
   public static void builtInJavaSort(ArrayList<String> clone) {
      String[]array = new String[clone.size()];
      clone.toArray(array);
      Arrays.sort(array);
      for(int i = 0; i< clone.size();i++){
         System.out.println();
      }
   }
   
   public abstract Instant instant(bubbleSort){
      System.out.println("Wall clock:" + "\n     Bubble sort:" + clock.instant());
   }
   public abstract Instant instant(builtInJavaSort){
      System.out.println("Internal sort:" + clock.instant());
      }
   pubic static void long getProcessCpuTime(bubbleSort) {
      long startTime = System.currentTimeMillis();
      myfunction();
      long endTime = System.currentTimeMillis();
      long searchTime = endTime - startTime;
     System.out.println("Wall clock:" + "\n     Bubble sort:" + searchTime);
   }
   public static void long getProcessCpuTime(builtInJavaSort){
      long startTime = System.currentTimeMillis();
      myfunction();
      long endTime = System.currentTimeMillis();
      long searchTime = endTime - startTime;
      System.out.println("Internal sort:" + searchTime)
    }
}
