/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String descr;
    private int id;
    
    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }
    
    protected Item(int id, String name, String desc){
        this.id = id;
        this.name = name;
        this.descr = desc;
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDesc(){
        return this.descr;
    }
    
    public void setDesc(String desc){
        this.descr = desc;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public String toString(){
        return this.name + this.descr;
    }
    
}
