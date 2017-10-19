/*
The name of program is HW4.
This program test and time two sorts to see the difference between them.
09/26/2017
Ze Liu
Program #4, CS 2050
*/
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.*;
public class HW4 {
   final static int myWallClockArraySize = 4;
   private static int[] bwcs = new int[myWallClockArraySize];//hours, minutes, seconds, milliseconds
   private static int[] bwce = new int[myWallClockArraySize];//hours, minutes, seconds, milliseconds
   private static int[] iwcs = new int[myWallClockArraySize];//hours, minutes, seconds, milliseconds
   private static int[] iwce = new int[myWallClockArraySize];//hours, minutes, seconds, milliseconds
   
   public static int[] getWallClockDifference(boolean bubble)
   {
      //still need to subtract the start and end times for both sorts
      //60 mins in 1 hour, 60 secs in 1 min, 1 second = 1000 milliseconds
      // 9:40:03.400 
      //-8:41:04.500
      //
      // 8:99:62.1400
      //-8:41:04.500
      // 0:58:58.900
      
      int[] result = new int[myWallClockArraySize];
      
      boolean borrowing = false;
      boolean sub = true;
      int conversionFactor = 0;
      int returnIndex = -1;
      for (int i = myWallClockArraySize - 1; i > -1; i+=0)
      {
         int b = 0, a = 0;
         if (bubble)
         {
            bwce[i] += conversionFactor;
            b = bwce[i];
            a = bwcs[i];
         }
         else
         {
            iwce[i] += conversionFactor;
            b = iwce[i];
            a = iwcs[i];
         }
         conversionFactor = 0;
         
         if (borrowing)
         {
            if (b > 0)
            {
               sub = false;//move back
               if (i == 2)
               {
                  if (bubble) bwce[i] -= 1;
                  else iwce[i] -= 1;
                  conversionFactor = 1000;
               }
               else if (i == 1 || i == 0)
               {
                  if (bubble) bwce[i] -= 1;
                  else iwce[i] -= 1;
                  conversionFactor = 60;
               }
               //else;//do nothing for milliseconds
            }
         }
         
         int diff = b - a;
         if (i == returnIndex && borrowing)
         {
            borrowing = false;
            sub = true;
         }
         
         if (borrowing == false)
         {
            if (diff < 0)
            {
               //we need to borrow
               borrowing = true;
               //we must advance to the next value and
               //check to see if the b value is greater than 0
               //if this is found, we need to subtract 1 from the current b value (array)
               returnIndex = i;
            }
            else
            {
               result[i] = diff;
               //we can move on
            }
         }
         
         if (sub) i--;
         else i++;
      }
      
      return result;
   }
   
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
      
      // long start = System.
      Scanner input = new Scanner(System.in);
      System.out.println("please enter the file name: ");
      TimeUnit t;
      long searchTime1 = bubbleSort(lines);
      long searchTime2 = builtInJavaSort(clone);
      int[] bwt = getWallClockDifference(true);
      int[] iwt = getWallClockDifference(false);
      System.out.print("Wall clock:" + "\n     Bubble sort:");
      for (int i = 0; i < myWallClockArraySize; i++)
      {
         System.out.print(bwt[i]);
         if (i < myWallClockArraySize - 1) System.out.print(":");
      }
      System.out.println();
      System.out.print("\t  Internal sort:");
      for (int i = 0; i < myWallClockArraySize; i++)
      {
         System.out.print(iwt[i]);
         if (i < myWallClockArraySize - 1) System.out.print(":");
      }
      System.out.println();
      
      // + TimeUnit.MINUTES.convert(searchTime1, TimeUnit.MINUTES) + "\nInternal sort:" + TimeUnit.MINUTES.convert(searchTime2, TimeUnit.MINUTES));
      System.out.println("CPU:" + "\n     Bubble sort:" + searchTime1 + "\n     Internal sort:" + searchTime2);
   }
   public static long bubbleSort(ArrayList<String> lines) {
      long startTime = System.currentTimeMillis();
      final GregorianCalendar gc = new GregorianCalendar();
      bwcs[0] = gc.get(Calendar.HOUR);
      bwcs[1] = gc.get(Calendar.MINUTE);
      bwcs[2] = gc.get(Calendar.SECOND);
      bwcs[3] = gc.get(Calendar.MILLISECOND);      
      
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
      
      bwce[0] = gc.get(Calendar.HOUR);
      bwce[1] = gc.get(Calendar.MINUTE);
      bwce[2] = gc.get(Calendar.SECOND);
      bwce[3] = gc.get(Calendar.MILLISECOND);
      long endTime = System.currentTimeMillis();
      return endTime - startTime;
   }
   public static long builtInJavaSort(ArrayList<String> clone) {
      long startTime = System.currentTimeMillis();
      final GregorianCalendar gc = new GregorianCalendar();
      iwcs[0] = gc.get(Calendar.HOUR);
      iwcs[1] = gc.get(Calendar.MINUTE);
      iwcs[2] = gc.get(Calendar.SECOND);
      iwcs[3] = gc.get(Calendar.MILLISECOND);
      
      String[]array = new String[clone.size()];
      clone.toArray(array);
      Arrays.sort(array);
      for(int i = 0; i< clone.size();i++){
         System.out.println();
      }
      
      iwce[0] = gc.get(Calendar.HOUR);
      iwce[1] = gc.get(Calendar.MINUTE);
      iwce[2] = gc.get(Calendar.SECOND);
      iwce[3] = gc.get(Calendar.MILLISECOND);
      long endTime = System.currentTimeMillis();
      return endTime - startTime;
   }
   
}   