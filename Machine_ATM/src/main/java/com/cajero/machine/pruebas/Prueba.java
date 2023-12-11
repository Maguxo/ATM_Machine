package com.cajero.machine.pruebas;

import com.cajero.machine.dao.BankDBDao;
import com.cajero.machine.model.BankDB;
import com.cajero.machine.util.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Locale;

public class Prueba {

    public static void main(String[] args){

        System.out.println("Esto es una prueba.");
        //JPAUtils jpa= new JPAUtils();

        //jpa.getEntityManager().close();
     registerbanck();
    }

    private static void registerbanck(){

        BankDB b= new BankDB();
        BankDB bankDB= new BankDB("1024530183",12345, b.getDate(), 600, "transaction");

        EntityManager entityManager = JPAUtils.getEntityManager();

        BankDBDao dao= new BankDBDao(entityManager);

        entityManager.getTransaction().begin();
        //entityManager.persist(bankDB);
        dao.save(bankDB);

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
