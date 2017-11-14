/*
The name of program is HW6.
This program practices with sorting and timing different data types.
10/26/2017
Ze Liu
Program #6, CS 2050
*/
import java.util.*;
import java.io.*;
public class HW6{
   public long wallStartTime, wallEndTime, cpuStartTime, cpuEndTime, wallClock, cpuTime;

   public int Size, Big;
   public static void main (String [] args) throws IOException {
      final String OUTPUT_FILE = "HW6output.txt";

      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE,true);
      PrintWriter outputFile = new PrintWriter (outputDataFile);

      HW6 choose = new HW6();
      System.out.println("Please choose integer sorts or real number sorts or string sorts:");
      Scanner input = new Scanner(System.in);
      String input1 = input.nextLine();
         if (input1.equalsIgnoreCase("Integer"))
            choose.chooseInteger(outputFile);
         if (input1.equalsIgnoreCase("RealNumber"))
          choose.chooseRealNumber(outputFile);
         if (input1.equalsIgnoreCase("String"))
            choose.chooseString(outputFile);
         outputFile.close();
   }

   public void chooseInteger(PrintWriter outputFile){
      Scanner scan = new Scanner(System.in);
    
      MergeSortA mn = new MergeSortA();
      System.out.println("\nPlease type the size of the array which gonna sort");
      outputFile.println("\nPlease type the size of the array which gonna sort");
      Size = scan.nextInt();

      System.out.println("Please type the largest number of the array which gonna sort");
      outputFile.println("\nPlease type the largest number of the array which gonna sort\n");

      Big = scan.nextInt();
              
      if (Size>Big){
      System.out.println("This is not right");  
      outputFile.println("\nThis is not right");  
      }
      else{
         int[]inputArray = new int[Size];

         if(Size <= 10){
            generateInteger(inputArray, Big);
            System.out.println("The unsort array is:");
            outputFile.println("\nThe unsort array is:");

         for(int i = 0; i< inputArray.length; i++){
            System.out.print(" " + inputArray[i]);
            outputFile.print(" " + inputArray[i]);

          }
         
          mn.mergeSortInteger(inputArray);
          System.out.println("\nThe sort array is:");
          outputFile.println("\nThe sort array is:");

          for(int i = 0; i< inputArray.length; i++){
             System.out.print(" " + inputArray[i]);
             outputFile.print(" " + inputArray[i]);

          }

          }
           else {
                generateInteger(inputArray, Big);
                mn.mergeSortInteger(inputArray);
                
                                
                System.out.println(mn.wallClock(outputFile));
                //outputFile.println(mn.wallClock(outputFile));

                System.out.println(mn.cpuTime(outputFile));
                //outputFile.println(mn.cpuTime(outputFile));


                generateInteger(inputArray, Big);
                long[] times = javaIntegerSort(inputArray);
                System.out.println("This is the wall clock time for java");
                outputFile.println("\nThis is the wall clock time for java");

                System.out.println(times[0]);
                outputFile.println(times[0]);

                System.out.println("This is the cpu  time for java");
                outputFile.println("\nThis is the cpu  time for java");


                System.out.println(times[1]);
                outputFile.println(times[1]);

            }
          }
      }
   public void generateInteger(int [] inputArray, int Big){

      for(int i = 0; i< inputArray.length; i++){
      inputArray[i] = (int)(Math.random()*(Big)+1);

      }
                          
   }
     // java sort for integer
   public long[]  javaIntegerSort( int[] inputArray) {
      List<Integer> inputArrayA = new ArrayList<Integer>();
      for(int i=0; i<inputArray.length; i++){
      inputArrayA.add(inputArray[i]);
   }
        
      wallStartTime = System.currentTimeMillis();
      cpuStartTime = System.nanoTime();
        
      Collections.sort(inputArrayA);
      wallEndTime = System.currentTimeMillis();
      cpuEndTime = System.nanoTime();
      wallClock = wallEndTime - wallStartTime;
      cpuTime = cpuEndTime - cpuStartTime;
         
      long[] returnValues = {wallClock, cpuTime};
         return returnValues;
        
      }
    
 /********************************/
   public void chooseRealNumber(PrintWriter outputFile){
      Scanner scan = new Scanner(System.in);
      MergeSortA mn = new MergeSortA();

      System.out.println("Please type the size of the array which gonna sort");
      outputFile.println("\nPlease type the size of the array which gonna sort");

      int Size = scan.nextInt();

      System.out.println("Please type the largest number of the array which gonna sort");
      outputFile.println("\nPlease type the largest number of the array which gonna sort");

      int Big = scan.nextInt();
              
      if (Size>Big){
      System.out.println("This is not right"); 
      outputFile.println("\nThis is not right");
      } 
      else{
         double[]inputArray = new double[Size];

         if(Size <= 10){
            
         generateDouble(inputArray, Big);
         System.out.println("The unsort array is:");
         outputFile.println("\nThe unsort array is:");

         for(int i = 0; i< inputArray.length; i++){
         System.out.print(" " + inputArray[i]);
         outputFile.print(" " + inputArray[i]);

         }

          mn.mergeSortReal(inputArray);
          System.out.println("\nThe sort array is:");
          outputFile.println("\nThe sort array is:");

          for(int i = 0; i< inputArray.length; i++){
             
          System.out.print(" " + inputArray[i]);
          outputFile.print(" " + inputArray[i]);

          }

          }

          else {
             generateDouble(inputArray,Big);
             mn.mergeSortReal(inputArray);
                
             System.out.println(mn.wallClock(outputFile));
             //outputFile.println(mn.wallClock(outputFile));

             System.out.println(mn.cpuTime(outputFile));
             //outputFile.println(mn.cpuTime(outputFile));


             generateDouble(inputArray,Big);
             long[] times = javaDoubleSort(inputArray);
             System.out.println("This is the wall clock time for java");
             outputFile.println("\nThis is the wall clock time for java");

             System.out.println(times[0]);
             outputFile.println(times[0]);

             System.out.println("This is the cpu time for java");
             outputFile.println("\nThis is the cpu time for java");


             System.out.println(times[1]);
             outputFile.println(times[1]);


            }
          }
      }
   public static void generateDouble(double []inputArray, double Big){
      for(int i = 0; i< inputArray.length; i++){
         inputArray[i] = (double)(Math.random()*(Big)+1);          
      }
   }
   public long [] javaDoubleSort(double []inputArray) {
      List<Double> inputArrayB = new ArrayList<Double>();
         for(int i=0; i<inputArray.length; i++){
            inputArrayB.add(inputArray[i]);
         }

      wallStartTime = System.currentTimeMillis();
      cpuStartTime = System.nanoTime();
      Collections.sort(inputArrayB);
      wallEndTime = System.currentTimeMillis();
      cpuEndTime = System.nanoTime();
      wallClock = wallEndTime - wallStartTime;
      cpuTime = cpuEndTime - cpuStartTime;

      long[] returnValues = {wallClock, cpuTime};
      return returnValues;
        
   }
/*******************************/
    
    
   public  void chooseString(PrintWriter outputFile){
      Scanner scan = new Scanner(System.in);
      MergeSortA mn = new MergeSortA();

      System.out.println("Please type the size of the array which gonna sort");
      outputFile.println("\nPlease type the size of the array which gonna sort");

      Size = scan.nextInt();

      if (Size<0){
      System.out.println("This is not right");
      outputFile.println ("\nThis is not right");
      }
      else {
          
          if(Size <= 10){
             String[] mb = new String[Size];
             generateString(mb, Size);
             System.out.println("The unsort array is:");
             outputFile.println("\nThe unsort array is:");

                 
             for (int j = 0; j < Size; j++){
             System.out.print(" ");
             outputFile.print(" ");

             System.out.print(mb[j]);
             outputFile.print(mb[j]);
          } 
          
           mn.mergeSortString(mb); 
           System.out.println("\nThe sort array is:");
           outputFile.println("\nThe sort array is:");

           for (int j = 0; j < Size; j++){
              System.out.print(mb[j]);
              outputFile.print(mb[j]);

              System.out.print(" ");
              outputFile.print(" ");

           }
         
        }  

           else {
              String[] mb = new String[Size];
              generateString(mb, Size);
              mn.mergeSortString(mb);

              System.out.println(mn.wallClock(outputFile));
              //outputFile.println(mn.wallClock(outputFile));

              System.out.println(mn.cpuTime(outputFile));
              //outputFile.println(mn.cpuTime(outputFile));


              generateString(mb, Size);
              long[] times = javaStringSort(mb);
              System.out.println("This is the wall clock time for java");
              outputFile.println("\nThis is the wall clock time for java");


              System.out.println(times[0]);
              outputFile.println(times[0]);

              System.out.println("This is the cpu time for java");
              outputFile.println("\nThis is the cpu time for java");


              System.out.println(times[1]);
              outputFile.println(times[1]);
            }
            }
           }
   public static void generateString(String [] mb, int Size){
      Random rand = new Random();
      String AL = "ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxy0123456789";
      char[] chars = AL.toCharArray();
      for (int j = 0; j < Size; j++){
      mb[j] = "";
      for(int i = 0; i<6; i++){
      mb[j] += chars[rand.nextInt(chars.length)];
      }
      }
   }
   public long[] javaStringSort(String [] mb) {
      List<String> inputArrayC = new ArrayList<String>();
         for(int i=0; i<mb.length; i++){
         inputArrayC.add(mb[i]);
         }

       wallStartTime = System.currentTimeMillis();
       cpuStartTime = System.nanoTime();
       Collections.sort(inputArrayC);
       wallEndTime = System.currentTimeMillis();
       cpuEndTime = System.nanoTime();
       wallClock = wallEndTime - wallStartTime;
       cpuTime = cpuEndTime - cpuStartTime;

       long[] returnValues = {wallClock, cpuTime};
       return returnValues;
   }
    
}
                
    
