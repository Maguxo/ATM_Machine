package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Print_Reciept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void export(){}
}
