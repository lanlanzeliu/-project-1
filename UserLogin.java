/*
The name of program is User Login.
This program uses Java I/O and While loop to evaluate User Logins for valid requirements.
09/06/2017
Program #1, CS 2050
*/

import java.util.*;
import java.io.*;
class UserLogin {
   boolean hasUpper, hasLower, hasDigit, hasSpec, longEnough, invalidSpec;
   int startingPoint = 0;
   
   public static void main (String [] args)throws Exception {
      UserLogin u = new UserLogin();
      String loop;
      StringBuffer end = new StringBuffer("");
      String userValidity = "";
 
      // Add do while loop to look for next login
      u.greetUser();
      do {
      u.startingPoint = end.length();
      String login = u.readUserLogin();
      end = u.checkCase(login, end);
      
      u.longEnough = u.checkLength(login);
      if(!u.longEnough){
         end = end.append("-- too short \n");
      }
      
         boolean isValid = u.checkValidity(login);
         
         // printUser, addToReport, printReport
         userValidity = u.printUser(login, isValid);
         u.addToReport(end, userValidity);
         System.out.println("Would you like to go again?");
         loop = new Scanner(System.in).nextLine();
         //would you like to go again yes or no?
         //read response
      } while(loop.equals("yes"));
      printReport(end);
   }
      
   public void greetUser() {
      System.out.println("This program uses Java I/O and While loop to evaluate User Logins for valid requirements");
   }

   public String readUserLogin(){
      Scanner input = new Scanner(System.in);
      System.out.println("Login: " );
      String inputLogin = input.nextLine();
      System.out.println();
      return inputLogin;
   }
   
   public StringBuffer checkCase(String Login, StringBuffer end){
      int numCount = 0, upperCount = 0,lowerCount = 0, specialCount = 0;
      hasDigit = true;
      hasUpper = true;
      hasLower = true;
      hasSpec = true;
      invalidSpec = false;
      
      for (int i = 0; i < Login.length(); i++){
         if ((Login.charAt(i) > 47 && Login.charAt(i) < 58)){
            numCount++;
         }
  
         if (Login.charAt(i) >= 65 && Login.charAt(i) <=90){
            upperCount++;
         }
         if (Login.charAt(i) >= 97 && Login.charAt(i) <=122){
            lowerCount++;
         }
         if (Login.charAt(i) == 33 || Login.charAt(i) == 64 
         || Login.charAt(i) == 35 || Login.charAt(i) == 36){
            specialCount++;
         }
      }
      System.out.println("numCount was " + numCount);
      System.out.println("upperCount was " + upperCount);
      System.out.println("lowerCount was " + lowerCount);
      System.out.println("specialCount was " + specialCount);
      if (numCount < 1){
         hasDigit = false;
         end.append("-- No digit\n");
      }
      if (upperCount < 1){
         hasUpper = false;
         end.append ("-- No uppercase letter\n");
      }
      if (lowerCount < 1){
         hasLower = false;
         end.append( "-- No lowercase letter\n");
      }
      if (specialCount < 1){
         hasSpec = false;
         end.append("-- No special character\n");
      }
      
      for(int i =0; i<Login.length(); i++){     
         if ( Login.charAt(i) == 32 || Login.charAt(i) == 9 ||
         Login.charAt(i) == 13 ){
            invalidSpec = true;
         }
      }
      if(invalidSpec){
         end.append("-- Invalid special character\n");
      }
      
      System.out.println("End:" + end);
      return end;
   }
  
   public boolean checkLength(String login){       
      int length = login.length();
      if (length < 5) {
         return false;
      }
      return true;
   }
   
   public boolean checkValidity(String Login){
      return (hasUpper && hasLower && hasDigit && hasSpec && !invalidSpec && longEnough);
   }
   
   public String printUser(String login, boolean v){
      String validity = v?"valid":"invalid";
      String result = "Login: " + login + "    (" + validity + ")\n";
      return result; 
   } // End LoginValidity
 
   public StringBuffer addToReport(StringBuffer end, String userValidity){
      end.insert(startingPoint, userValidity);
      return end;
   }
   
   public static void printReport(StringBuffer end)throws Exception{
      final String OUTPUT_FILE = "UserLoginOutput.txt";
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter (outputDataFile);
      outputFile.println(end);
      outputFile.close();
   }
}