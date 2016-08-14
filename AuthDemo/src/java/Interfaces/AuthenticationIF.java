/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.User;

/**
 *
 * @author RolfMoikjær
 */
public interface AuthenticationIF {
    boolean authCheck(String id, String pwd);
    User getUser(String id);
    boolean addUser(String id, String name, String pwd);
    
}
