/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Person;
import java.io.Closeable;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author RolfMoikjær
 */
public class Logic implements Closeable {

    private final EntityManager entityManager;

    public Logic(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    public <T extends Person> T add(T person) {
        this.entityManager.persist(person);

        return person;
    }

    public <T extends Person> T find(Class<T> type, int id) {
        return this.entityManager.find(type, new Long(id));
    }

    @Override
    public void close() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
}
