package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Remove {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int balance;

    public void ifenough(){}
    public void removeMoney(){}
    public void record(){}
}
