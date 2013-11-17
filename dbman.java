/*
 * This class manages the database and connection
 */
package proekt1;

import java.sql.*;

/**
 *
 * @author evlogimi
 */
public class dbman {
    
    // JDBC driver name and database URL & credentials
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost/proekt1";
    private static final String DB_USER = "proekt1";
    private static final String DB_PASS = "proekt1";
    
    private Connection conn = null;
    private Statement stmt = null;   
    
    public dbman(){
        
         try{
            Connect();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
   
    public void Connect() throws Exception {
        
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        System.out.println("Connected to database...");
    } 
   
    public void Disconnect() throws Exception {
       conn.close();
       stmt.close();
   }
   
    public ResultSet Select(String sql) throws Exception {
        
       
        //STEP 4: Execute a query
        System.out.println("Selecting from Mysql...");
        System.out.println(sql);
        stmt = conn.createStatement();
  
        //sql = "SELECT user_id,username FROM users WHERE `username`='" + potrebitel + "' AND `password`='" + parolka + "'";
        ResultSet rs = stmt.executeQuery(sql);
/*
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("user_id");
         String usera = rs.getString("username");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", First: " + usera + test2.test1());
      }
      */      
        return rs;
    }
    
    
    /*
     * This function can INSERT, UPDATE && DELETE in Mysql
     */
    public void Execute(String sql){
       try {           
           stmt = conn.createStatement();
           System.out.println(sql);
           stmt.executeUpdate(sql);       
       } catch (SQLException e) { 
           System.out.println(e.getMessage());
       }       
    }
   
}
