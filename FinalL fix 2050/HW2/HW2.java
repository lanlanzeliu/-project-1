/*
The name of program is HW2.
This program will be to implement a List two ways - an array and a linked list. 
Ze Liu
Program #2, CS 2050
*/
import java.util.*;
import java.io.*;
public class HW2 {
   public static void main (String [] args) throws IOException {
   Scanner input = new Scanner(System.in);
   BufferedReader s1 = new BufferedReader (new FileReader ("Countries.txt"));
   BufferedReader s2 = new BufferedReader (new FileReader ("Borders.txt"));
   BufferedReader s3 = new BufferedReader (new FileReader ("Countries.txt"));
   BufferedReader s4 = new BufferedReader (new FileReader ("Borders.txt"));
   Countries[] name1 = new Countries [9];
   Borders[] name2 = new Borders [8];

   MyLL<Countries> name3 = new MyLL<Countries>();
   MyLL<Borders> name4 = new MyLL <Borders>();
   int choose = 0;
   
   choose = input.nextInt();
   
   while(choose!=5){
      switch (choose) {
     	 case 1:
		      name1 = countryA(name1, s1);
		      name2 = borderA(name2, s2);
		      name3 = CountryLL(name3, s3);
		      name4 = BordersLL(name4, s4);
		      break;
     	 case 2:
     		 Bording(name2, name4);
     		 break;
     	 case 3:
     		 Population(name1, name3);
     		 break;
     	 case 4:
     		 Comb(name1, name2, name3, name4);
     		 break;
     	 case 5:
     		 break;
     	default: 
     		break;
      } // end switch
      choose = input.nextInt();
   } // end while
   
      s1.close();
      s2.close();
      s3.close();
      s4.close();
  }
      
      
  public static Countries[] countryA(Countries[] name1,BufferedReader s1) throws IOException{
     int i = 0;
     String temp = s1.readLine();
     while(temp != null && i < name1.length){
     String[]data = temp.split(",");
     name1[i] = new Countries(data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),Double.parseDouble(data[5]),Integer.parseInt(data[6]));
     temp = s1.readLine();
     i++;
     }
         
          return name1;
     }
  
  
  public static Borders[] borderA(Borders[] name2,BufferedReader s2) throws IOException{
   int i = 0;
     String temp = s2.readLine();
     while(temp!=null && i <name2.length){
     String[] data = temp.split(",");
     name2[i] = new Borders(data[0],data[1]);
     temp = s2.readLine();
     i++;
     }
         

     return name2;
     }
     
   public static MyLL<Countries> CountryLL(MyLL<Countries>name3,BufferedReader s3)throws IOException{
     String temp = s3.readLine();
     while(temp != null){
     	   
        String[] data = temp.split(",");
        Countries NC = new Countries( data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),Double.parseDouble(data[5]),Integer.parseInt(data[6]));
        name3.addFirst(NC);
        temp = s3.readLine();
     }
     return name3;
     }

    public static MyLL<Borders> BordersLL(MyLL<Borders>name4,BufferedReader s4)throws IOException{
      String temp = s4.readLine();
     while(temp != null){
     	    
        String[]data = temp.split(",");
        Borders NB = new Borders( data[0],data[1]);
        name4.addFirst(NB);
        temp = s4.readLine();

     }
     return name4;
     }

    public static void Bording(Borders[] name2, MyLL<Borders> name4){
    
    String q = "Germany";

    for(int i = 0; i< name2.length; i++){
    if (name2[i].c1.equalsIgnoreCase(q)){
       System.out.println(name2[i].c2 + " ");
       
       }
      
     }  
       
    
    
   
           Iterator< Borders> itrA = name4.iterator();
       while(itrA.hasNext()){
          Borders boA = (Borders)itrA.next();
          if(boA.c1.equalsIgnoreCase(q)){
             System.out.println(boA.c2);
          }
          System.out.println(" ");
        }  
   }
   public static void Population(Countries[] name1,MyLL<Countries>name3){
   String q = "Germany";

    for(int i = 0; i< name1.length; i++){
    if (name1[i].countryPopulation>=35000000){
       System.out.println(name1[i].countryName + " ");
       
       }
      
     }  

   
   
            Iterator< Countries> itrA = name3.iterator();
      while(itrA.hasNext()) {
         Countries coA = (Countries)itrA.next();
         if(coA.countryPopulation >= 35000000){
            System.out.println(coA.countryName);
         }
      }
      System.out.println(" ");
   }
   
    public static void Comb(Countries[] name1, Borders[] name2,
                            MyLL<Countries> name3, MyLL<Borders> name4){
       String q = "Germany";
       for(int i = 0; i< name1.length; i++){          // Checks through countries array
         if (name1[i].countryPopulation >= 35000000){ // Checks if current country has a pop of 35mil
           for(int j = 0; j< name2.length; j++){      // Go through Borders array
              if (name2[j].c1.equalsIgnoreCase(q) &&  // Check if current border country 1 is germany
                  name1[i].countryName.equalsIgnoreCase(name2[j].c2)){ // Check is current border country 2 is same as country with pop >= 35 mil
                 System.out.println(name2[j].c2 + " ");      // Print countries that fulfill both queries
              }
           }
         }  
       }
      
       
       Iterator< Countries> citrA = name3.iterator();
       while(citrA.hasNext()){
          Countries coA = (Countries)citrA.next();
	       Iterator< Borders> bitrA = name4.iterator();
	       if(coA.countryPopulation>=35000000){
	          while(bitrA.hasNext()){
	             Borders boA = (Borders)bitrA.next();
	                if(boA.c1.equalsIgnoreCase(q) && coA.countryName.equalsIgnoreCase(boA.c2)){
	                   System.out.println(coA.countryName);
	                }
          }
       }
       }
       System.out.println(" ");
   }
 }

 


 
