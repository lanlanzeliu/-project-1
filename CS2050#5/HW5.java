/*
The name of program is HW5.
This program will be to test and time searching methods.
10/03/2017
Ze Liu
Program #5, CS 2050
*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Set;
import java.io.*;
public class HW5 {
   public static void main (String [] args) throws IOException {
      final String INPUT_FILE = "HW5.txt";
      final String OUTPUT_FILE = "HW5-output.txt";
            
      // Access the input/output files
      File inputDataFile = new File (INPUT_FILE);
      Scanner inputFile = new Scanner (inputDataFile);
   
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
    
      
      Scanner input1 = new Scanner(System.in);
      System.out.println("Please enter the file name:");
      
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
         lines.set(i, lines.get(i).toLowerCase());
         StringBuilder line = new StringBuilder(lines.get(i));
         
         for ( int j = 0; j < line.length(); j++) {
            if (!(Character.isAlphabetic(line.charAt(j)) && line.charAt(j)==' ')){
            
            /*line.charAt(j) >= 33&&line.charAt(j) <=38 ||line.charAt(j) >=40 && line.charAt(j) <=47 ||line.charAt(j) >=58 &&line.charAt(j)<=64 ||
            line.charAt(j) >=91 && line.charAt(j)<=96 || line.charAt(j) >=123 && line.charAt(j)<=126 
            */
               line.deleteCharAt(j); 
               j--;
            }// End if
         }// End for
      }//End for
            
      LinkedList<String> clone = new LinkedList<String>();
      for(String s: lines){
         String[] Words= s.split(" ");
            for(int i = 0; i<Words.length; i++){
            clone.add(Words[i]);
            }
      }
      
      wordOutput(clone,outputFile);
      output(outputFile);
      
  }
     // builtInJavaSort(clone);

     public static void  wordOutput(LinkedList<String> lines, PrintWriter outputFile) {
        HashMap<String, Integer> hm  = new HashMap<String, Integer>();
        for ( int i = 0; i < lines.size(); i++) {
           if(!hm.containsKey(lines.get(i))){
              hm.put(lines.get(i), 1);
           }
           else {
              hm.put(lines.get(i), 1 + hm.get(lines.get(i)));
           }
         } 
         ArrayList<String> fhm = new ArrayList<String>(hm.keySet());
         java.util.Collections.sort(fhm);
         
         for (int i = 0; i < fhm.size(); i++) {

           outputFile.println(fhm.get(i) + " " + hm.get(fhm.get(i)));
         }   
     }
     public static void output(PrintWriter outputFile){
        System.out.println("Felename: name of the input file to be processed" 
     + "\nNumber of words: number of unique words in the file");
      outputFile.println("Felename: name of the input file to be processed" 
     + "\nNumber of words: number of unique words in the file");
      }

}
