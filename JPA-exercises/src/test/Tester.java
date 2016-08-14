/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Adress;
import entity.Customer;
import enums.CustomerType;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class Tester {

    public static void main(String[] args) {
        Persistence.generateSchema("JPA-exercisesPU", null);

        EntityManagerFactory em = Persistence.createEntityManagerFactory("JPA-exercisesPU");
        EntityManager emf = em.createEntityManager();

        Customer kasperCustomer = new Customer();
        kasperCustomer.setFirstName("kasper");
        kasperCustomer.setLastName("Lassen");
        kasperCustomer.setCustomertype(CustomerType.GOLD);
        kasperCustomer.addHobbies("højdespringning");
        kasperCustomer.addHobbies("NavleFnullerFletning");
        kasperCustomer.addHobbies("LommeBilliard");
        kasperCustomer.addPhone("44554455", "Home");
        kasperCustomer.addPhone("21554455", "Mobile");

        Customer larsCustomer = new Customer();
        larsCustomer.setFirstName("lars");
        larsCustomer.setLastName("Larsen");
        larsCustomer.setCustomertype(CustomerType.IRON);
        larsCustomer.addHobbies("NavleFnullerFletning");
        larsCustomer.addHobbies("LommeBilliard");
        larsCustomer.addPhone("44668866", "Home");
        larsCustomer.addPhone("21668866", "Mobile");

        Adress adress1 = new Adress("Vesterbrogade", "Vesterbro");
        Adress adress2 = new Adress("Østerbrogade", "Østerbro");
//        kasperCustomer.addAdress(adress1);
//        kasperCustomer.addAdress(adress2);

        Random random = new Random();

        EntityTransaction transaction = emf.getTransaction();
        transaction.begin();

//            emf.persist(adress1);
//            emf.persist(adress2);
        emf.persist(kasperCustomer);
        emf.persist(larsCustomer);

        transaction.commit();
        emf.close();
    }
}
