package Principal;

import Presentacion.presenta3D;

import javax.swing.*;

public class principal {


    public static void main(String[] args){
        System.out.println("la concha de la lora");
        System.setProperty("sun.awt.noerasebackground","true");
        JFrame ventana= new JFrame("Mi ventana 3D ");
        presenta3D prncipal =  new presenta3D();
        ventana.add(prncipal);
        ventana.setUndecorated(true);
        ventana.setSize(900,700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
