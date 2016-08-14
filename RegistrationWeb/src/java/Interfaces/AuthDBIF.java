/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.User;
import java.util.List;

/**
 *
 * @author RolfMoikjær
 */
public interface AuthDBIF {
    
    void addUser(User user);
    User getUser(String id);
    List<User> getAllUsers();
    boolean authCheck(String id, String pwd);
    
}
