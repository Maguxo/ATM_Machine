package cajeroDiseño;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class DisenoCajeroServicio extends JFrame {

    private JPanel panel;
    private JLabel lProncipal, tService,tFashCash,menu, menuD,cash,transfer,balance,deposit,save,service,cost, costT,chooseM, chooseMD;
    public DisenoCajeroServicio(){

        panel= new JPanel();
        this.setIconImage(getIconImage());
        this.setUndecorated(true);
        this.setSize(900,700);
        panel.setLayout(null);
        panel.setBackground(new Color(64,61,71));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        design();
    }
    private void design() {

        lProncipal = new JLabel();
        lProncipal.setBounds(20, 20, 150, 100);
        lProncipal.setIcon(logoPrincipal("/image/logop.png"));
        lProncipal.setVisible(true);
        panel.add(lProncipal);

        tService = new JLabel("Service");
        tService.setBounds(50, 140, 150, 30);
        tService.setFont(new Font("Roboto", Font.PLAIN, 26));
        tService.setForeground(Color.white);
        panel.add(tService);

        tFashCash = new JLabel("Fast Cash");
        tFashCash.setForeground(Color.white);
        tFashCash.setBounds(550, 140, 150, 30);
        tFashCash.setFont(new Font("Roboto", Font.PLAIN, 26));
        panel.add(tFashCash);

        menuATM(50, 200, 220, 150, 90,"/image/cash.png"); //position Menu
        menuATM(266, 200, 220, 150, 90,"/image/transfer.png");
        menuATM(50, 348, 220, 150, 60,"/image/balance1.png");
        menuATM(266, 348, 220, 150,90, "/image/deposit.png");
        menuATM(50, 496, 220, 150, 90,"/image/save.png");
        menuATM(266, 496, 220, 150, 90,"/image/service.png");

        costMoney(550,200,40,"$50"); //Position cash
        costMoney(720,200,40,"$100");
        costMoney(550,300,40,"$150");
        costMoney(720,300,40,"$200");
        costMoney(550,400,40,"$300");
        costMoney(720,400,40,"$400");
        costMoney(550,500,40,"$500");
        costMoney(720,500,40,"$600");

        chooseM= new JLabel(); //Boton
        chooseM.setBounds(550,580,310,70);
        chooseM.setBorder(new LineBorder(Color.red,40,true));
        panel.add(chooseM);

        chooseMD=new JLabel("choose other amount"); //Tutle button
        chooseMD.setBounds(40,10,230,50);
        chooseMD.setForeground(Color.white);
        chooseMD.setFont(new Font("Arial",Font.BOLD,22));
        chooseM.add(chooseMD);
    }
    private JLabel costMoney(int bX, int bY, int tX,String money){

        cost= new JLabel();
        cost.setBounds(bX,bY,140,60);
        cost.setBorder(new LineBorder(Color.black,30,true));
        panel.add(cost);
        costT= new JLabel();
        costT.setText(money);
        costT.setFont(new Font("Arial",Font.BOLD,22));
        costT.setBounds(tX,8,60,40);
        costT.setHorizontalAlignment(SwingConstants.CENTER);
        costT.setForeground(Color.white);
        cost.add(costT);
        return cost;
    }
    private JLabel menuATM(int pX, int pY, int anIma, int alIma, int tImge,String imagen){

        menu= new JLabel();
        menu.setBounds(pX, pY, anIma, alIma);
        menu.setIcon(base1("/image/base.png", anIma, alIma));
        //cash.setBorder(new LineBorder(Color.black,12,true));
        panel.add(menu);
        menuD= new JLabel();
        menuD.setBounds(66, 20, tImge, tImge);
        menuD.setIcon(base1(imagen, tImge, tImge));
        menu.add(menuD);
        return menu;
    }
    private ImageIcon base1(String ima, int with,int height) {
        ImageIcon imag= new ImageIcon(Objects.requireNonNull(getClass().getResource(ima)));
        ImageIcon im= new ImageIcon(imag.getImage().getScaledInstance(with,height,Image.SCALE_FAST));
        return im;
    }
    private ImageIcon logoPrincipal(String image) {
        ImageIcon imag= new ImageIcon(Objects.requireNonNull(getClass().getResource(image)));
        ImageIcon im= new ImageIcon(imag.getImage().getScaledInstance(lProncipal.getWidth(),lProncipal.getHeight(),Image.SCALE_FAST));
        return im;
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/logo.png")).getScaledInstance(100,100,20);
    }
}
