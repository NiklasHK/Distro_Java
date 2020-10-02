/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import ui.ItemInfo;

/**
 *
 * @author Emil
 */
public class ShoppingCart {
    
    private ArrayList<ItemInfo> items;
    
    public ShoppingCart(){
        this.items = new ArrayList<ItemInfo>();
    }

    /**
     * Kanske göra en deepcopy?
     * @return the items
     */
    public ArrayList<ItemInfo> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ItemInfo item) {
        this.items.add(item);
    }
    
    public void remove(){
        this.items.clear();
    }

    public String toString(){
        String s = "";
        for(int i=0; i<items.size(); i++){
            s += items.get(i) + " ";
        }
        return s;
    }
    
    
}
//sc.setItems(item); session.setAttribute("ShoppingCart", sc);