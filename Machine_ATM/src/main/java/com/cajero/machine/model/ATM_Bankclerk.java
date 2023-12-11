package com.cajero.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ATM_Bankclerk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date= LocalDate.now();
    private String count;

    public void maintenance(){}
    public void record(){}
}
