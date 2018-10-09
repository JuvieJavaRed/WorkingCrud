/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.ac.nust.erp.test.crudjpatest.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hp
 */
public class PersistenceUnit {
    private static PersistenceUnit pu;
    public static PersistenceUnit getInstance(){
        if(pu == null){
            return new PersistenceUnit();
        }
        return pu;
    }
     public EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CRUDJPATEST_PU");
}
