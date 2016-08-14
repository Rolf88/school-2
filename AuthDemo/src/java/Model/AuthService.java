/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthenticationIF;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RolfMoikjær
 */
public class AuthService implements AuthenticationIF {

    Map<String, User> users = new HashMap();

    @Override
    public boolean authCheck(String id, String pwd) {
        if (users.containsKey(id)) {
            if (getUser(id).getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    public AuthService() {
        addUser("jens", "Jens Petersen", "jp123");
        addUser("holger", "Holger Andersen", "ha123");
        addUser("karen", "Karen Ibsen", "ki123");
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public boolean addUser(String id, String name, String pwd) {
        users.put(id, new User(id, name, pwd));
        return true;
    }

}
