package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardInfo_Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_client;
    private long password;

    public long getPassword(){

        return this.password;
    }
    public void setPassword(Long password){

        this.password= password;
    }
    public boolean login(String id_client, long password){

        if(this.id_client.equals(id_client) || this.password== password) {
            return true;
        }
        return false;
    }

}
