package bo;

import db.ItemDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.ItemInfo;


public class ItemHandler {
    
    public static Collection<ItemInfo> getItemsWithGroup(String s){
        Collection c = Item.getItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(), item.getDesc()));
        }
        return items;
    }
    
    public static void addToBasket(String s){
        ItemDB.addToBasket(s);
    }
    
    public static ArrayList getBasket(String s){
        return ItemDB.getBasket(s);
    }

}
