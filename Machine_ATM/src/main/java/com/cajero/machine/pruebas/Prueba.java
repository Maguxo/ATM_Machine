package com.cajero.machine.pruebas;

import com.cajero.machine.util.JPAUtils;

public class Prueba {

    public static void main(String[] args){

        System.out.println("Esto es una prueba.");
        JPAUtils jpa= new JPAUtils();

        jpa.getEntityManager().close();

    }
}
