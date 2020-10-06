package bo;

import db.ItemDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.ItemInfo;


public class ItemHandler {
    
    // Retrieve all items, return as an arraylist
    public static ArrayList<ItemInfo> getItemsWithGroup(){
        Collection c = Item.getItems();
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(), item.getDesc()));
        }
        return items;
    }
    
    //Add item to shopping cart
    public static void addToBasket(String item, String uname){
        ItemDB.addToBasket(item, uname);
    }
    
    // Remove item from shopping cart
    public static void removeFromBasket(String item, String uname){
        ItemDB.removeFromBasket(item, uname);
    }
    
    //Retrieve shopping cart
    public static ArrayList getBasket(String uname){
        return ItemDB.getBasket(uname);
    }

}
