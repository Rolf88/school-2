/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaentitymappings.pkg3;

import javax.persistence.Persistence;

/**
 *
 * @author RolfMoikjær
 */
public class JPAEntityMappings3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persistence.generateSchema("JPAEntityMappings-3PU", null);
    }

}
