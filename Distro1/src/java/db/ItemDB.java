package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDB extends bo.Item{
    
    //Return all items in the database
    public static ArrayList getItems(){
        ArrayList<Object> items = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fruitstock");
            
            while(rs.next()){
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                items.add(new ItemDB(i,name,desc));
            }
        }catch (SQLException e){ e.printStackTrace(); }
        return items;
    }
    
    // Increase quantity of an item
    public static void addToBasket(String item, String uname){
        try{
            Connection con = DBManager.getConnection();
            String query = "UPDATE shoppingcart SET "+item+" = "+item+" +1 WHERE username= ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, uname);
            System.out.println(st.toString());
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
        // Reduce quantity of an item
    public static void removeFromBasket(String item, String uname){
        try{
            Connection con = DBManager.getConnection();
            String query = "UPDATE shoppingcart SET "+item+" = "+item+" -1 WHERE username= ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, uname);
            System.out.println(st.toString());
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
    //Return a shopping cart for a user and its items 
    public static ArrayList getBasket(String uname){
        ArrayList<Integer> quantity = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM shoppingcart where username=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, uname);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int i = rs.getInt("apple");
                int j = rs.getInt("banana");
                int k = rs.getInt("pear"); 
                quantity.add(i);
                quantity.add(j);
                quantity.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Exception: "); e.printStackTrace();
        }
        return quantity;
    }
    
    private ItemDB(int id, String name, String desc){
       super(id, name, desc);
   }
}
