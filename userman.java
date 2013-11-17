/*
 * This class will manage users
 */
package proekt1;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.security.*;
import java.text.DateFormat;

/**
 *
 * @author evlogimi
 */
public class userman {
    
    //Connect to the database
    private dbman database = new dbman();
    

    public static String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
    
    
    public static String hashpass(String password){
             String SALT_BEGIN = "n@,k4gj@.@";
             String SALT_END = "4!ok^|</`c";
             return md5(md5(SALT_BEGIN + password + SALT_END));
    }
       
    public boolean login(String username, String password){
        
        password = hashpass(password);

        try{
           // database.Connect();
            ResultSet rs = database.Select("SELECT user_id,username FROM users WHERE `username`='" + username + "' AND `password`='" + password + "'");
   
            if(rs.next()) return true;
            else return false;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        
        return false;
    }
       
    public void createUser(){ 
        
        String username	= "test2";
        String password	= hashpass("test3");
        String name = "Pesho";	
        String sirname = "Petrov";	
        String familyname = "Kirilov";
        String egn = "1234567890";	
        String address = "Sofia, 1000";	
        String phone = "+359 12345";		
        String email = "pesho@elubank.com";
        String usertype	= "0";
        String pin_code	= "1234";
        String isactive	= "0";

    try{
       

    database.Execute("INSERT INTO `users` ( `username`, `password`, `name`, `sirname`, `familyname`, `egn`, `address`, `phone`, `email`, `usertype`, `pin_code`, `isactive`)"
            + "VALUES ( '" + username + "', '" + password + "', '" + name + "', '" + sirname + "', '" + familyname + "', '" + egn + "', '" + address + "', '" + phone + "', '" + email + "', '0', '" + pin_code + "', '0');");
           
     }catch(Exception e){
      //Handle errors for Class.forName

       e.printStackTrace();
   }
       }
}
