package bo;

import db.ItemDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.ItemInfo;

public class ShoppingCartHandler {
    
    private static ShoppingCart sc = new ShoppingCart();
        
    public static ShoppingCart getShoppingCart(String s){
        Collection c = Item.searchItems(s);
        
        //ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            sc.setItems(new ItemInfo(item.getName(), item.getDesc()));
        }
        return sc;
    }
    
    public static ShoppingCart addItemToShoppingCart(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            sc.setItems(new ItemInfo(item.getName(), item.getDesc()));
        }
        return sc;
    }
    public static void updateDBShoppingCart(String s){
        ItemDB.addToBasket(s);
    }
    
}




//sc.setItems(item); session.setAttribute("ShoppingCart", sc); 