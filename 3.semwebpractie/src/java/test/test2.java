/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class test2 {

    public static void main(String[] args) {
        EntityManager en = Persistence.createEntityManagerFactory("3.semwebpractiePU").createEntityManager();
        Person p = new Person();
        p.setFirstName("Rolf");
        p.setLastName("Moikjær");
        en.getTransaction().begin();
        en.persist(p);
        en.getTransaction().commit();
    }
}
