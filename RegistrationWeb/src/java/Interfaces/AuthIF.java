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
public interface AuthIF {
    
    boolean authCheck(String id, String pwd);
    User getUser(String id);
    //boolean addUser(String name, String id, String pwd, String gender, String age, String country);
}
