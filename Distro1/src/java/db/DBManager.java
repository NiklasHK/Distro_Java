/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    
   private static DBManager instance = null;
   private Connection con = null;
   
   private static DBManager getInstance(){
       if(instance == null)
           instance = new DBManager();
       return instance;
   }
    
   private DBManager(){
       try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           con = DriverManager.getConnection("jdbc:mysql://localhost");
       }catch(Exception e){e.printStackTrace();}
   }
    
   public static Connection getConnection(){
       return getInstance().con;
   }
    
}
