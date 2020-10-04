/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Emil
 */
public class userDB {

       public static boolean checkUser(String s){
       try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            
            if(!rs.first()){ return false; }
            
        }catch (SQLException e){ return false; }

       return true;
   }
       
    public static void createUser(String s, String name){
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(s);
            st.executeUpdate("Insert into shoppingcart (username, applequantity, bananaquantity, pearquantity) values ('" + name + "', '0', '0', '0')");
 
        }catch (SQLException e){  }

    }
       
       
}
