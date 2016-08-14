/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import Interfaces.AuthDBIF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RolfMoikjær
 */
public class AuthServiceDB implements AuthDBIF {

    private final String userName = "cphrh110";
    private final String passWord = "cphrh110";
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    private ResultSet rs;
    private Statement statement;
    private Connection connection;
    
    Map<String, User> users = new HashMap();

    List<User> userList = new ArrayList();

    public AuthServiceDB() {

        try {
            Class.forName(driver);
            connection = java.sql.DriverManager.getConnection(URL, userName, passWord);

            statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                users.put(rs.getString("id"), new User(rs.getString("name"), rs.getString("id"), rs.getString("pwd"), rs.getString("gender"), rs.getString("age"), rs.getString("country")));
            }
        } catch (SQLException sqlE) {
            System.out.println(Arrays.toString(sqlE.getStackTrace()));
            connection = null;
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
      return new ArrayList<User>(users.values());
    }

    @Override
    public boolean authCheck(String id, String pwd) {
        if (users.containsKey(id)) {
            if (getUser(id).getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
}
