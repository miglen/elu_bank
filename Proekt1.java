/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proekt1;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;


/**
 *
 * @author evlogimi
 */


public class Proekt1 {



   public static void main(String[] args) {

   
   userman test2 = new userman();
   //dbman database = new dbman();
   

   
   
   //Scanner scanner = new Scanner(System.in);
  // System.out.print("Enter a username:\t");
   //String potrebitel = scanner.nextLine();
  // System.out.print("Enter a password:\t");
   //String parolka = scanner.nextLine();  
   
   
   
  // if(test2.login("test","parola")){
  //     System.out.print("Great success!");
  // }
   
  bnbparser bnb = new bnbparser();
  bnb.parseXML();
   //test2.createUser();
   //database.Execute("UPDATE `proekt1`.`users` SET `password` = '25a39180ce46732895ac7e190ef71cce' WHERE `users`.`user_id` =1;");
   
     
   
   
  // System.out.println("MD5 hash generated using Java : " + md5Java("password"));
   
   

   /*
   try{
      

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT user_id,username FROM users WHERE `username`='" + potrebitel + "' AND `password`='" + parolka + "'";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("user_id");
         String usera = rs.getString("username");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", First: " + usera + test2.test1());
      }
      
      
      //stmt.executeQuery("INSERT INTO `users` VALUES('2','vasko','parola');");
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   * */
   
   
   /*
   
   try{
    database.Disconnect();
   }catch(Exception e){}
   */
}//end main
   
   

  
}//end FirstExample