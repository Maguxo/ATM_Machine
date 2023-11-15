package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client_CardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_client;
    private long password;

    public long getPassword(){

        return this.password;
    }
    public void setPassword(long password){
        this.password=password;
    }
}
