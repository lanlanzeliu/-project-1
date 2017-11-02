/*
The name of program is HW5.
This program will be to test and time searching methods.
10/03/2017
Ze Liu
Program #5, CS 2050
*/
import java.util.*;
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
    
      String num;
      Scanner in= new Scanner(System.in);
      System.out.println("Please enter the file name:");
      num = in.nextLine();
      ArrayList<String> lines = new ArrayList<String>();
      
      String temp;
     
      while (inputFile.hasNext()) {
         temp = inputFile.nextLine();
         if(temp.isEmpty()){
         }
         else {
            String myRegex = "[^a-zA-Z0-9]";
           
            for(String word: temp.split("\\s+")){ 
            lines.add(word.replaceAll(myRegex, " "));
            }

         }        
      }
      
      for ( int i = 0; i < lines.size(); i++) {
         lines.set(i, lines.get(i).toLowerCase());
         }
         
      System.out.println(lines);
            
      LinkedList<String> clone = new LinkedList<String>();
      for(String s: lines){
         String[] Words= s.split(" ");
            for(int i = 0; i<Words.length; i++){
            clone.add(Words[i]);
            }
      }
      
      System.out.println(clone);

      wordOutput(clone,outputFile);
      output(outputFile);
   }   
  
    
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



