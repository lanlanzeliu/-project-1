

import java.util.*;
import java.io.*;
public class HW3 {
   public static void main (String [] args) throws IOException {
   Scanner input = new Scanner(System.in);
   Scanner s1 = new Scanner (new FileReader ("Countries.txt"));
   Scanner s2 = new Scanner (new FileReader ("Borders.txt"));
   Scanner s3 = new Scanner (new FileReader ("Countries.txt"));
   Scanner s4 = new Scanner (new FileReader ("Borders.txt"));
   List<Countries> name1 = new ArrayList<Countries>();
   List<Borders> name2 = new ArrayList<Borders>();
   LinkedList<Countries> name3 = new LinkedList<Countries>();
   LinkedList<Borders> name4 = new LinkedList<Borders>();
   int choose = 0;
   
   choose = input.nextInt();
   
   while(choose!=5){
      switch (choose) {
     	 case 1:
		      name1 = CountryAL(name1, s1);
		      name2 = BordersAL(name2, s2);
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
      
      
  public static List<Countries> CountryAL(List<Countries>name1,Scanner s1){
 
     while(s1.hasNext()){
        String temp = s1.nextLine();
        String[]data = temp.split(",");
        Countries NC = new Countries( data[0],data[1],data[2],
     		   Integer.parseInt(data[3]),Integer.parseInt(data[4]),
     		   Double.parseDouble(data[5]),
     		   Integer.parseInt(data[6]));
        name1.add(NC);

     }
     return name1;
     }
  
  
  public static List<Borders> BordersAL(List<Borders>name2,Scanner s2){
  
     while(s2.hasNext()){
     	String temp = s2.nextLine();
        String[]data = temp.split(",");
        Borders NC = new Borders(data[0],data[1]);
        name2.add(NC);
     }
     return name2;
     }
     
   public static LinkedList<Countries> CountryLL(LinkedList<Countries>name3,Scanner s3){

     while(s3.hasNext()){
     	   String temp = s3.nextLine();
        String[]data = temp.split(",");
        Countries NC = new Countries( data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),Double.parseDouble(data[5]),Integer.parseInt(data[6]));
        name3.add(NC);
     }
     return name3;
     }

    public static LinkedList<Borders> BordersLL(LinkedList<Borders>name4,Scanner s4){

     while(s4.hasNext()){
     	    String temp = s4.nextLine();
        String[]data = temp.split(",");
        Borders NC = new Borders( data[0],data[1]);
        name4.add(NC);

     }
     return name4;
     }

    public static void Bording(List<Borders>name2, LinkedList<Borders> name4){
    String q = "Germany";
    Iterator< Borders> itr = name2.iterator();
       while(itr.hasNext()){
          Borders bo = (Borders)itr.next();
          if(bo.c1.equalsIgnoreCase(q)){
             System.out.println(bo.c2);
          }
          System.out.println(" ");
       } 
       Iterator< Borders> itrA = name2.iterator();
       while(itrA.hasNext()){
          Borders boA = (Borders)itrA.next();
          if(boA.c1.equalsIgnoreCase(q)){
             System.out.println(boA.c2);
          }
          System.out.println(" ");
        }  
   }
   public static void Population(List<Countries>name1,LinkedList<Countries>name3){
      Iterator< Countries> itr = name1.iterator();
      while(itr.hasNext()) {
         Countries co = (Countries)itr.next();
         if(co.countryPopulation >= 35000000){
            System.out.println(co.countryName);
         }
      }
      System.out.println(" ");
      
      Iterator< Countries> itrA = name1.iterator();
      while(itrA.hasNext()) {
         Countries coA = (Countries)itrA.next();
         if(coA.countryPopulation >= 35000000){
            System.out.println(coA.countryName);
         }
      }
      System.out.println(" ");
   }
   
    public static void Comb(List<Countries> name1, List<Borders> name2,
                            LinkedList<Countries> name3, LinkedList<Borders> name4){
       String q = "Germany";
       Iterator< Countries> citr = name1.iterator();
       while(citr.hasNext()){
          Countries co = (Countries)citr.next();
       Iterator< Borders> bitr = name2.iterator();
       if(co.countryPopulation>=35000000){
          while(bitr.hasNext()){
             Borders bo = (Borders)bitr.next();
                if(bo.c1.equalsIgnoreCase(q) && co.countryName.equalsIgnoreCase(bo.c2)){
                   System.out.println(co.countryName);
                   break;
                }
          }
       }
       }
       System.out.println(" ");
       
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

 


 
