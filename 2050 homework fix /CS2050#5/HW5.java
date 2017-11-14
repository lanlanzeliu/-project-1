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
      
      final String OUTPUT_FILE = "HW5-output.txt";
            
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
    
 
     ArrayList<String> lines = new ArrayList<String>();
      

      Scanner in= new Scanner(System.in);
      System.out.println("Please enter the file name:");
      String name = in.nextLine();
      //ArrayList<String> lines = new ArrayList<String>();
      
      try{
     Scanner s= new Scanner(new File(name));

      while (s.hasNext()) {
         String temp = s.nextLine();
         if(temp.isEmpty()){
         }
         else {
            String myRegex = "[^a-zA-Z0-9]";
           
            for(String word: temp.split("\\s+")){ 
               lines.add(word.replaceAll(myRegex, " "));
            }

         }        
      }
      }
      catch(Exception e){
      System.out.println("could not find file");
 }         


      for ( int i = 0; i < lines.size(); i++) {
         lines.set(i, lines.get(i).toLowerCase());
         lines.size();
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
      output(outputFile,lines,name);
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
   public static void output(PrintWriter outputFile, ArrayList<String> lines, String name){
      System.out.println(name + ": name of the input file to be processed" 
     + "\n" + lines.size() + ": number of unique words in the file");
         }

}



