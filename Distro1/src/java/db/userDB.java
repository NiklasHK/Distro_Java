/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Emil
 */
public class userDB {

    //Check if a user exists in the database
    public static boolean checkExistingUser(String uname){
       try{
            Connection con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement("Select * from users where username=?");
            st.setString(1, uname);
            ResultSet rs = st.executeQuery();
            
            if(!rs.first()){ return false; }
            
        }catch (SQLException e){ return false; }

       return true;
   }

    //check if the password corresponding to the username is correct in the database
    public static boolean checkCorrectPassword(String uname, String pass){
       try{
            Connection con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement("Select * from users where username=? and password=?");
            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            
            if(!rs.first()){ return false; }
            
        }catch (SQLException e){ return false; }

       return true;
   }
       
    // Create a user in the database
    public static void createUser(String uname, String pass){
        try{
            Connection con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement("Insert into users (username, password) values(?, ?)");
            PreparedStatement st2 = con.prepareStatement("Insert into shoppingcart (username, apple, banana, pear) values (?, '0', '0', '0')");
            st.setString(1, uname);
            st.setString(2, pass);
            st2.setString(1, uname);  
            st.executeUpdate();
            st2.executeUpdate();
 
        }catch (SQLException e){ 
            System.out.println("Exception: "); e.printStackTrace();
        }
          
    }
       
}
