package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDB extends bo.Item{
    public static ArrayList getItems(String item_group){
        ArrayList<Object> items = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(item_group);
            
            while(rs.next()){
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                items.add(new ItemDB(i,name,desc));
            }
        }catch (SQLException e){ e.printStackTrace(); }
        return items;
    }
    public static void addToBasket(String s){
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(s);
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
    public static ArrayList getBasket(String s){
        ArrayList<Integer> quantity = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            
            while(rs.next()){
                int i = rs.getInt("applequantity");
                int j = rs.getInt("bananaquantity");
                int k = rs.getInt("pearquantity"); 
                quantity.add(i);
                quantity.add(j);
                quantity.add(k);
            }
        } catch (SQLException e) {
        }
        return quantity;
    }
    
    private ItemDB(int id, String name, String desc){
       super(id, name, desc);
   }

}
