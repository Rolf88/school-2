/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthIF;

/**
 *
 * @author RolfMoikjær
 */
public class AuthService implements AuthIF{
    
    RegistratedUsers users = new RegistratedUsers();
    
    public AuthService(){}

    @Override
    public boolean authCheck(String id, String pwd) {
        if(users.users.containsKey(id)){
            if(getUser(id).getPwd().equals(pwd)){
            return true;
            }
        }
        return false;
    }

    @Override
    public User getUser(String id) {
        return users.users.get(id);
    }
    
}
