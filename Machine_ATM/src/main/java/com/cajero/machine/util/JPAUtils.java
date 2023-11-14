package com.cajero.machine.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static EntityManagerFactory FACTORY= Persistence.createEntityManagerFactory("machine_atm");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
