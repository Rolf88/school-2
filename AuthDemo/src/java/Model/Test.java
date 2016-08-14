/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthenticationIF;

/**
 *
 * @author RolfMoikjær
 */
public class Test {

    public static void main(String[] args) {
        
        AuthenticationIF as = new AuthService();
        
        //boolean test = as.authCheck("jens", "jp123");
        //System.out.println(test);
        
        as.addUser("id", "navn", "pwd");
        System.out.println(as.authCheck("id", "pwd"));
    }
}
