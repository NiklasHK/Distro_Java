/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.userDB;

/**
 *
 * @author Emil
 */
public class userHandler {
    
    public static boolean checkUser(String s){
        return userDB.checkUser(s);
    }
    
    
    public static void createNewUser(String s, String name){
        userDB.createUser(s, name);
    }
    
    
}
