/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author RolfMoikjær
 */
public interface RegIF {
    
    boolean authCheck(String name, String id, String pwd, String gender, String age, String country);
    boolean addUser(String name, String id, String pwd, String gender, String age, String country);
    
}
