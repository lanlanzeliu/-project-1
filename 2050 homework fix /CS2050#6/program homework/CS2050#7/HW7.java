/*
The name of program is HW7.
This program creats hash table and also use java in built hash table to read the file.
11/03/2017
Ze Liu
Program #7, CS 2050
*/

import java.util.*;
import java.io.*;

//* Class HashTable */
class HW7{

    public SLLNode[] table;
    //public int size ;
    public ArrayList<String> lines;
    public int [] arr;
    public int n=0;
    
    public class SLLNode 
    {
      SLLNode next;
      String data;
 
      /* Constructor */
    public SLLNode(String x)
    {
        data = x;
        next = null;
    }
    public String toString(){
      return data;//Integer.toString(data);
    }

    }
    

    /* Constructor */
    
    public HW7()
    {    
        //size = 0;
        //n = 0;
        lines = new ArrayList<String>();
        //arr = new int [lines.size()];

    }
 /**************************************/
    public void readFile() {
      Scanner in= new Scanner(System.in);
      //Scanner on= new Scanner(System.in);

      System.out.println("Please enter the file name:");
      String name = in.nextLine();
      System.out.println("Please enter the prime number");
      n = in.nextInt();
      table = new SLLNode[ nextPrime() ];
      //in.nextLine();
        
      //ArrayList<String> lines = new ArrayList<String>();
      
      try{
     Scanner s= new Scanner(new File(name));
      String myRegex = "[^a-zA-Z0-9]";

      while (s.hasNext()) {
         String temp = s.nextLine();
         if(!temp.isEmpty()){
         
                    
            for(String word: temp.split("\\s+")){ 
            lines.add(word.replaceAll(myRegex, " "));
            }

         }        
      }
      }
      catch(Exception e){
      System.out.println("could not find file");
 }
  
 }
/******************************/
public void heading( ){
     arr = new int [lines.size()];

     //System.out.println(arr);


            

      for ( int i = 0; i < lines.size(); i++) {
        int ascii=0;

         //lines.set(i, lines.get(i).toLowerCase());
         lines.size();
                  //System.out.println(arr);

       System.out.print(" ");
         for  (int j = 0; j < lines.get(i).length(); j++) {
         ascii += (int) lines.get(i).charAt(j);
           
       }
         arr[i] = ascii;
       }  
      
      }
 
      
    /* Function to check if given number is prime */
    private boolean isPrime( )
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
  
    /* Function to generate next prime number >= n */
       private  int nextPrime(  )
    {
        if (n % 2 == 0)
            n++;
        for ( ; !isPrime(  ); n += 2);
         
         //System.out.println("The next prime number bigger than what you input is: " + n);
        return n;
    }
     

 /* Function myhash and insert an element*/
    private void insert( /*arr[i]*/)
    {
        int hashKey = 0;
        for ( int i = 0; i < arr.length; i++) {
        
                 
        hashKey = arr[i]%n;
        int pos = hashKey;
        SLLNode nptr = new SLLNode(lines.get(i));
        if (table[pos] == null)
            table[pos] = nptr;            
        else
        {
            nptr.next = table[pos];
            table[pos] = nptr;
        }
        }
      }  
       
            
    
    public void printHashTable ()throws IOException {

      PrintWriter outputfile = new PrintWriter (new File("HW7.out"));
         int largestIndex = -1;
         int largestListAmount = 0;
         int listAmount = 1;

        int count = 1;
        int i = 0;
        while (count<6) {
            if (i >= table.length)
                break;
            else {
                
                if (table[i] != null) {
                  SLLNode node = table[i];
                  outputfile.print((i+1) +" : " + node+" ->  ");
                  
                  while(node.next != null){
                     listAmount++;
                     node = node.next;
                   
                     if(node.next == null){
                        outputfile.println(node);
                     }else{
                        outputfile.print(node+" ->  ");
                     }
                  }//end while
                
                  if(listAmount > largestListAmount){
                     largestListAmount = listAmount;
                     largestIndex = i;
                  }
                 
                  listAmount = 1;   
                  count++;
                  i++;
                  }
                  else
                      i++;
             }
            
        } // end while
       outputfile.println("Largest Index: " + (largestIndex+1)+ " with "+largestListAmount +" nodes");
      outputfile.close();
    }
                 
    /*part 2*/ 
         public void javaHashTable()throws IOException {
 
        final String OUTPUT_FILE = "HW7.hash";

            
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
    
         Hashtable<Integer, String> realHashTable = new Hashtable(arr.length);
        
        for (int i = 0; i < lines.size(); i++) {
            realHashTable.put(i, lines.get(i));
        }
        outputFile.println ("This is the first 5 keys and values of Java's built in hash table:");
        //Set set = realHashTable.entrySet();
        //Iterator itr = set.iterator();
        //int count = 1;
        for(int i  = 0; i  <=4; i ++){
            //prints out the first 5 key - int pairs
            //Map.Entry entry = (Map.Entry) itr.next();
            //outputFile.println("the index " +  entry.getKey() + " with the value is: " + entry.getValue());
            outputFile.println("the index " +  i + " with the value is: " + realHashTable.get(i));
            
        }
        outputFile.close();
       }
        


   public static void main (String [] args) throws IOException {
      
          
       HW7 test = new HW7();
       test.readFile();
       test.heading();
       test.isPrime();
       //test.nextPrime();
       test.insert();
       test.printHashTable();
       test.javaHashTable();
}
}
           
           
           
           
     