package cajeroDiseño;

import javax.swing.*;
import java.awt.*;

public class DiseñoCajero extends JPanel {

    @Override
    public void paint(Graphics2D g){
        super.paint(g);
    }


    //private JPanel panel;
    /*public DiseñoCajero(){

        /*panel= new JPanel();
        this.setIconImage(getIconImage());
        this.setUndecorated(true);
        this.setSize(900,700);
        panel.setLayout(null);
        panel.setBackground(new Color(64,61,71));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/


    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/logo.png")).getScaledInstance(100,100,20);
    }
}
