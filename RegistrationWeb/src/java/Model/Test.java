/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthDBIF;

/**
 *
 * @author RolfMoikjær
 */
public class Test {
    
    public static void main(String[] args) {
        
        AuthDBIF auth = new AuthServiceDB();
        
        for(User user : auth.getAllUsers()){
            System.out.println(user.getName());
        }
    }
    
    
    
    
}
