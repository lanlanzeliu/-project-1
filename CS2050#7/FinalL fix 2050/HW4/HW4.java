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
        int n = 0;         
       ArrayList<String> lines = new ArrayList<String>();
      Scanner in= new Scanner(System.in);
      System.out.println("Please type the input file name:");
      String name = in.nextLine();
     
     
    try{
     Scanner s= new Scanner(new File(name));
             

      
      while (s.hasNext()) {
         String temp = s.nextLine();
         if(temp.isEmpty()){
         }
         else {
                        for(String word: temp.split("\\s+")){ 
            lines.add(word.replaceAll("[^a-zA-Z0-9]", ""));
            }
                      }        
      }
      System.out.println("There are " + lines.size() +  " words in the file.");
      }
      catch(Exception e){
       System.out.println("could not find file");
 }         

     ArrayList<String> clone = new ArrayList<String>();
      for(String s: lines){
         clone.add(s);
         }
           
      System.out.print("Wall clock:" + "\n     Bubble sort:" + bubbleWallClock(lines));
      System.out.print("\n     Internal sort:"+ javaWallClock(clone) + "\n" );
      System.out.println("CPU:" + "\n     Bubble sort:" + bubbleCpuTime(lines) + "\n     Internal sort:" + javaCpuTime(clone));
   }
   
      
   
   
   public static long bubbleWallClock(ArrayList<String> lines) {
      
         long startTime = System.currentTimeMillis();
          for (int j = 0; j < lines.size(); j++) {
            for (int i = j+1; i < lines.size(); i++) {
                if ((lines.get(i)).compareTo(lines.get(j)) < 0) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(i));
                    lines.set(i, t);
                }

            }
         }
                 long endTime = System.currentTimeMillis();
         return endTime - startTime;
    }
    
    public static long bubbleCpuTime(ArrayList<String> lines) {
        long startTime = System.nanoTime();

        for (int j = 0; j < lines.size(); j++) {
            for (int i = j+1; i < lines.size(); i++) {
                if ((lines.get(i)).compareTo(lines.get(j)) < 0) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(i));
                    lines.set(i, t);
                }

            }
         }

         long endTime = System.nanoTime();
         return endTime - startTime;
      }
         
                  
         public static long javaWallClock(ArrayList<String> clone) {
         
         long startTime = System.currentTimeMillis();
         Collections.sort(clone);

         long endTime = System.currentTimeMillis();
         
         return endTime - startTime;
    }

    public static long javaCpuTime(ArrayList<String> clone) {
         long startTime = System.nanoTime();
         Collections.sort(clone);

         long endTime = System.nanoTime();
         return endTime - startTime;
    }

    }


       