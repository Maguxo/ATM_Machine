package com.cajero.machine.dao;

import com.cajero.machine.model.BankDB;

import javax.persistence.EntityManager;

public class BankDBDao {

    private EntityManager entityManager;

    public BankDBDao(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save(BankDB bankDB){ //guardar datos
        this.entityManager.persist(bankDB);
    }


}
