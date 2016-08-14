/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.RegIF;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static javax.servlet.SessionTrackingMode.URL;

/**
 *
 * @author RolfMoikjær
 */
public class RegistratedUsers implements RegIF{
    
    private final String userName = "cphrh110";
    private final String passWord = "cphrh110";
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    private ResultSet rs;
    private Statement statement;
    private Connection connection;
    
    Map<String, User> users = new HashMap(); 
    
    public RegistratedUsers(){
        
    }
    
    @Override
    public boolean authCheck(String name, String id, String pwd, String gender, String age, String country){
        //users.put(id, new User(name, id, pwd, gender, age, country));
        return true;
    }
    
    @Override
    public boolean addUser(String name, String id, String pwd, String gender, String age, String country) {
        
        try {
            Class.forName(driver);
            connection = java.sql.DriverManager.getConnection(URL, userName, passWord);

            statement = connection.createStatement();
            String sql = "INSERT INTO users VALUES ('"+name+"', '"+id+"', '"+pwd+"', '"+gender+"', '"+age+"', '"+country+"')";
            statement.executeUpdate(sql);
            
        } catch (SQLException sqlE) {
            System.out.println(Arrays.toString(sqlE.getStackTrace()));
            connection = null;
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return true;
    }
}
