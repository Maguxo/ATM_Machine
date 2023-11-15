package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Print_Reciept {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void export(){}
}
