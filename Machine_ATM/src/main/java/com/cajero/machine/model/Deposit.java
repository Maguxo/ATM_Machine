package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Deposit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int balance;

    public void openentry(){}
    public void depositMoney(){}
    public void record(){}

}
