/*
The name of program is HW2.
This program uses Java I/O and  nested loop to implement a list two ways-an array and a linked list.
09/12/2017
Ze Liu
Program #2, CS 2050
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;
public class HW2 {
   public static void main (String [] args) throws IOException {
      final String INPUT_FILE = "fileInput.txt";
      final String OUTPUT_FILE = "fileOutput.txt";
      int input = 0;
      //ArrayList<Countries>countryArray = new ArrayList<Countries>();
      Countries[] countryArray = new Countries[9];
      LinkedList<Countries>countryLL = new LinkedList<Countries>(); 
      
      // Access the input/output files
      File inputDataFile = new File (INPUT_FILE);
      Scanner inputFile = new Scanner (inputDataFile);
   
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
      
      Scanner input1 = new Scanner(System.in);
      
      while (input <=5) {

         System.out.println("please pick up any number from 1 to 5");          
         input = input1.nextInt();
        
         if(input == 1){
            readData(inputFile, countryArray, countryLL);
         } 
         else if(input == 2){
            Borders b = new Borders();
               for ( int j=0; j < b.borders[0].length; j++){
                  System.out.println(b.borders[0][j]);
                  outputFile.println(b.borders[0][j]);
               }
         }
         else if (input==3){
            for(int i = 0; i< countryArray.length; i++){
               if (countryArray[i].countryPopulation >=35000000) {
                  System.out.println(countryArray[i].countryName);
                  outputFile.println(countryArray[i].countryName);       
               }
            }
         }
         else if (input == 4){
            Borders b = new Borders();
            for (int j = 0; j < b.borders[0].length; j++){
               for(int i = 0; i< countryArray.length; i++){
                  if (countryArray[i].countryPopulation >= 35000000) {
                     if (countryArray[i].countryName.equals(b.borders[0][j])){
                        System.out.println(countryArray[i].countryName);
                        outputFile.println(countryArray[i].countryName); 
                     }      
                  }  
               }
            }
         }
         else if (input == 5){
         System.exit(0);
         }
         
      }
      inputFile.close();
      outputFile.close();
      System.exit(0);
   } // end main
   
   // Read the input file into the country array 
   public static void readData(Scanner inputFile, Countries[] countryArray, LinkedList countryLL) {
      inputFile.nextLine(); // reads titles
      int i = 0;
      int len = countryArray.length;
      String data[];
      
      while (inputFile.hasNext() && i < len) {
         data = inputFile.nextLine().split("\\s+");
         Countries c = new Countries ();
         c.countryName = data[0];
         c.latitude = data[1];
         c.longitude = data[2];
         c.countryArea = Integer.parseInt(data[3]);
         c.countryPopulation = Integer.parseInt(data[4]);
         c.countryGDP = Double.parseDouble(data[5]); // represented in billions
         c.countryYear = Integer.parseInt(data[6]);
         countryArray[i] = c; //.add(c);
         countryLL.add(c);
         i++;
      } // end while
   } // end readData
   
} // end class
           

 
 
    
   

      