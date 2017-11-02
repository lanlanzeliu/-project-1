/*
The name of program is HW4.
This program test and time two sorts to see the difference between them.
09/26/2017
Ze Liu
Program #4, CS 2050
*/
import java.util.*;
import java.io.*;
public class HW4 {
       
       public static void main (String [] args) throws IOException {
      final String INPUT_FILE = "HW4.txt";
      
            
      // Access the input
      File inputDataFile = new File (INPUT_FILE);
      Scanner inputFile = new Scanner (inputDataFile);
      
      String num;
      Scanner in= new Scanner(System.in);
      System.out.println("Please type the input file name:");
      num = in.nextLine();

      ArrayList<String> lines = new ArrayList<String>();
             
       

      String temp;
      while (inputFile.hasNext()) {
         temp = inputFile.nextLine();
         if(temp.isEmpty()){
         }
         else {
            //lines.add(temp);
            for(String word: temp.split("\\s+")){ 
            lines.add(word.replaceAll("[^a-zA-Z0-9]", ""));
            }

         }        
      }
      
      //lines.trimToSize();
      
      /*for ( int i = 0; i < lines.size(); i++) {
         //StringBuilder line = new StringBuilder(lines.get(i));
                  
         for ( int j = 0; j < lines.get(i).length(); j++) {
            if (lines.charAt(j) > 32 && lines.charAt(j) <=47 ||lines.charAt(j) >=58 &&lines.charAt(j)<=64 ||
            lines.charAt(j) >=91 && lines.charAt(j)<=96 || lines.charAt(j) >=123 && lines.charAt(j)<=126 ||lines.charAt(j) >=48 &&lines.charAt(j)<=57){
               lines.deleteCharAt(j); 
               j--;
               
            }
         }
      }
      */
      ArrayList<String> clone = new ArrayList<String>();
      for(String s: lines){
         clone.add(s);
         }
      //bubbleSort(lines);
      //bubbleWallClock();
      //bubbleCpuTime();
      //javaSort(clone);
      //javaWallClock();
      //javaCpuTime();
      
     // Scanner input = new Scanner(System.in);
     // TimeUnit t;
      //long searchTime1 = bubbleSort(lines);
      //long searchTime2 = builtInJavaSort(clone);
      
      
      System.out.print("Wall clock:" + "\n     Bubble sort:" + bubbleWallClock(lines));
      System.out.print("\n     Internal sort:"+ javaWallClock(clone) + "\n" );
      System.out.println("CPU:" + "\n     Bubble sort:" + bubbleCpuTime(lines) + "\n     Internal sort:" + javaCpuTime(clone));
   }
   
   //public void bubbleSort(ArrayList<String> lines) {
        //copies list to bubblesort list so original list stays the same
        //bubblesort = lines;
        /*for (int j = 0; j < lines.size(); j++) {
            for (int i = j+1; i < lines.size(); i++) {
                if ((lines.get(i)).compareTo(lines.get(j)) < 0) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(i));
                    lines.set(i, t);
                }

            }
         }
    }*/
   
   
   
   
   public static long bubbleWallClock(ArrayList<String> lines) {
   ArrayList<String> bubblesortA = new ArrayList<String>();
   bubblesortA = lines;


         for (int j = 0; j < lines.size(); j++) {
            for (int i = j+1; i < lines.size(); i++) {
                if ((lines.get(i)).compareTo(lines.get(j)) < 0) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(i));
                    lines.set(i, t);
                }

            }
         }
         long startTime = System.currentTimeMillis();
         //bubbleSort(lines);
         long endTime = System.currentTimeMillis();
         return endTime - startTime;
    }
    
    public static long bubbleCpuTime(ArrayList<String> lines) {
    ArrayList<String> bubblesortB = new ArrayList<String>();
    bubblesortB = lines;

         for (int j = 0; j < lines.size(); j++) {
            for (int i = j+1; i < lines.size(); i++) {
                if ((lines.get(i)).compareTo(lines.get(j)) < 0) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(i));
                    lines.set(i, t);
                }

            }
         }

         long startTime = System.nanoTime();
         //bubbleSort(lines);
         long endTime = System.nanoTime();
         return endTime - startTime;
      }
         
         //public static void javaSort(ArrayList<String> clone) {
         //copies list to javasort list so original list stays the same
        //javasort = clone;
        //Collections.sort(javasort);
        //System.out.println("This is javasort result:\n" + javasort);
    //}

         
         public static long javaWallClock(ArrayList<String> clone) {
         ArrayList<String> javasortA = new ArrayList<String>();
         long startTime = System.currentTimeMillis();
         //javaSort(clone);
          Collections.sort(javasortA);

         long endTime = System.currentTimeMillis();
         
         return endTime - startTime;
    }

    public static long javaCpuTime(ArrayList<String> clone) {
    ArrayList<String> javasortB = new ArrayList<String>();
         long startTime = System.nanoTime();
         //javaSort(clone);
          Collections.sort(javasortB);

         long endTime = System.nanoTime();
         return endTime - startTime;
    }

    }


  /* public static long bubbleSort(ArrayList<String> lines) {
      long startTime = System.currentTimeMillis();
            String temp; 
      long endTime = System.currentTimeMillis();
      return endTime - startTime;
   }
   public static long builtInJavaSort(ArrayList<String> clone) {
      long startTime = System.currentTimeMillis();
                  
      String[]array = new String[clone.size()];
      clone.toArray(array);
      Arrays.sort(array);
      for(int i = 0; i< clone.size();i++){
         System.out.println();
      }
      
      long endTime = System.currentTimeMillis();
      return endTime - startTime;
   }
   */
