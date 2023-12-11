package cajeroDiseño;

import javax.swing.*;
import java.awt.*;

public class PruebaDiseño {

    public static void main(String args[]){
        JFrame ventana= new JFrame();
        ventana.setUndecorated(true);
        DisenoCajero cajero= new DisenoCajero();
        ventana.add(cajero);
        cajero.setBackground(new Color(64,61,71));
        ventana.setSize(900,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setIconImage(getIconImage());


        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/logo.png")).getScaledInstance(100,100,20);
    }
}
