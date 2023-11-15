package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Entity
public class BankDB {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ig_client;
    private long password;
    private LocalDate date= LocalDate.now();
    private int balance;
    private String operation;

    public LocalDate getDate(){
       return this.date;
    }
}
