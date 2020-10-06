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
    
    //Check if user exists
    public static boolean checkExistingUser(String uname){
        return userDB.checkExistingUser(uname);
    }
    
    //Check if password corresponds to username
    public static boolean checkCorrectPassword(String uname, String pass){
        return userDB.checkCorrectPassword(uname, pass);
    }
    
    // Create new user if user doesn't exist
    public static void createNewUser(String uname, String pass){
        userDB.createUser(uname, pass);
    }
    
    
}
