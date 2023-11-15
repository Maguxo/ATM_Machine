package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ATM_Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int balance;
    private LocalDate date= LocalDate.now();

    public int getBalance(){

        return this.balance;
    }
    public boolean transfer(){

        return  false;
    }
    public boolean remove(){

        return false;
    }
    public boolean deposit(){

        return false;
    }
    public boolean printReciept(){

        return false;
    }


}
