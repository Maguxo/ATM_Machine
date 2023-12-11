package com.cajero.machine.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bankdb")
public class BankDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_client;
    private long password;
    private LocalDate date= LocalDate.now();
    private int balance;
    private String operation;

    public BankDB(){}
    public BankDB(String id_client, long password, LocalDate date, int balance, String operation){
        this.id_client=id_client;
        this.password=password;
        this.date=date;
        this.balance=balance;
        this.operation= operation;
    }
    public LocalDate getDate(){
       return this.date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
