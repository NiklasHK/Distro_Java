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
    
   //Connection to the database
   private DBManager(){
       try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/distroDB?UseClientEnc=UTF8?useTimezone=true&serverTimezone=UTC", "userboi", "passboi");
       }catch(Exception e){e.printStackTrace();}
   }
    
   //Return existing connection
   public static Connection getConnection(){
       return getInstance().con;
   }
   

    
}
