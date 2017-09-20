/*
The name of program is HW3.
This program uses Java I/O and  nested loop to implement the array and linked list in HW2 
using the Java classes, ArrayList<> and LinkedList.
09/19/2017
Ze Liu
Program #3, CS 2050
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;
public class HW3 {
   static ArrayList<Countries> countryArrayList = new ArrayList<Countries>();
   static LinkedList<Countries> countryLL = new LinkedList<Countries>(); 
      
   public static void main (String [] args) throws IOException {
      final String INPUT_FILE = "fileInput.txt";
      final String OUTPUT_FILE = "fileOutput.txt";
      int input = 0;
      
      // Access the input/output files
      File inputDataFile = new File (INPUT_FILE);
      Scanner inputFile = new Scanner (inputDataFile);
   
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
            
      Scanner input1 = new Scanner(System.in);
      System.out.println("1 means import the data, 2 means list of all countries" 
         + "\nthat border Germany, 3 means list of all countries that have a population" 
         + "\ngreater than 35 million, 4 means list of all countries that border Germany" 
         + "\nand have a population greater than 35 million, 5 means quit the program");
      while (input <=5) {

         System.out.println("please pick up any number from 1 to 5"); 
         input = input1.nextInt();
        
         if(input == 1){
            readData(inputFile);//, countryArrayList, countryLL);
            
         } 
         else if(input == 2){
            Borders b = new Borders();
               for ( int j=0; j < b.borders[0].length; j++){
                  System.out.println(b.borders[0][j]);
                  outputFile.println(b.borders[0][j]);
               }
                  outputFile.println();
         }
         else if (input==3){
            for(int i = 0; i< countryArrayList.size(); i++){
               if (countryArrayList.get(i).countryPopulation >=35000000) {
                  System.out.println(countryArrayList.get(i).countryName);
                  outputFile.println(countryArrayList.get(i).countryName);       
               }  
            }
            outputFile.println();
         }
         else if (input == 4){
            Borders b = new Borders();
            for (int j = 0; j < b.borders[0].length; j++){
               for(int i = 0; i< countryArrayList.size(); i++){
                  if (countryArrayList.get(i).countryPopulation >= 35000000) {
                     if (countryArrayList.get(i).countryName.equals(b.borders[0][j])){
                        System.out.println(countryArrayList.get(i).countryName);
                        outputFile.println(countryArrayList.get(i).countryName); 
                     }      
                  }  
               }
            }
                        
            outputFile.println();
         }
         else if (input == 5){
         inputFile.close();
         outputFile.close();
         System.exit(0);
         }
         
      }
      
   } // end main
   
   // Read the input file into the country array 
   public static void readData(Scanner inputFile){//, ArrayList countryArrayList, LinkedList countryLL) {
      inputFile.nextLine(); // reads titles
      String data[];
      
      while (inputFile.hasNext()) {
         data = inputFile.nextLine().split("\\s+");
         Countries c = new Countries ();
         c.countryName = data[0];
         c.latitude = data[1];
         c.longitude = data[2];
         c.countryArea = Integer.parseInt(data[3]);
         c.countryPopulation = Integer.parseInt(data[4]);
         c.countryGDP = Double.parseDouble(data[5]); // represented in billions
         c.countryYear = Integer.parseInt(data[6]);
         //countryArray[i] = c; //.add(c);
         countryArrayList.add(c);
         countryLL.add(c);
      } // end while
      
   } // end readData
   
} // end class
           

 
 
    
   

      