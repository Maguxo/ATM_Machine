package cajeroDiseño;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DisenoCajero extends JPanel {

    @Override
    public void paint(Graphics g){
        super.paint(g);

        int [] puntoX={600,300,150,300,600,760};
        int [] puntoY= {100,100,349,600,600,346};

        g.setColor(new Color(217,29,0));
         g.fillPolygon(puntoX, puntoY, 6);

      
       /*g.setColor(Color.BLUE);
        g.fillRoundRect(600,100,200,200,50,50);*/



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


    /*public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/logo.png")).getScaledInstance(100,100,20);
    }*/
}
