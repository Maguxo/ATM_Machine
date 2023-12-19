package cajeroDiseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class DisenoCajero extends JFrame{

    private JPanel panel;
    private JLabel bLoguin,photo, title,user, pWord, button,lProncipal;
    private JTextField pass;
    private JPasswordField passw;
    public DisenoCajero(){

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

        bLoguin = new JLabel();
        bLoguin.setLayout(null);
        bLoguin.setBounds(-120, 50, 900, 700);
        bLoguin.setIcon(pImage("/image/fondo.png",bLoguin.getWidth()+250,bLoguin.getWidth(),Image.SCALE_SMOOTH));
        bLoguin.setBackground(new Color(64, 61, 71));
        bLoguin.setOpaque(true);
        panel.add(bLoguin);

        lProncipal= new JLabel("hola");
        lProncipal.setBounds(150,-20,150,100);
        lProncipal.setBackground(Color.yellow);
        lProncipal.setIcon(pImage("/image/logop.png",150,100,Image.SCALE_FAST));
        lProncipal.setVisible(true);
        bLoguin.add(lProncipal);

        photo = new JLabel();
        photo.setLayout(null);
        photo.setBounds(500, 10, 150, 150);
        photo.setBackground(new Color(64, 61, 71));
        photo.setIcon(pImage("/image/credito.gif",150,150,Image.SCALE_FAST));
        photo.setOpaque(true);
        bLoguin.add(photo);

        title = new JLabel("Sign In");
        title.setBounds(476, 161, 200, 80);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Calibri", Font.PLAIN, 38));
        title.setBackground(new Color(236, 28, 36));
        title.setOpaque(true);
        bLoguin.add(title);

        user= new JLabel();
        user.setLayout(null);
        user.setBounds(426,200,300,180);
        user.setBackground(new Color(236,28,36));
        user.setIcon(pImage("/image/usuario.png",300,180,Image.SCALE_FAST));
        user.setVisible(true);
        bLoguin.add(user);

        pass= new JTextField(" Username");
        pass.setBounds(473,263,240,50);
        pass.setBorder(BorderFactory.createEmptyBorder());
        pass.setFont(new Font("Roboto", Font.PLAIN, 16));
        pass.setForeground(SystemColor.activeCaptionBorder);
        pass.setBackground(new Color(216,237,230));
        pass.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(pass.getText().equals(" Username")){
                    pass.setText("");
                    pass.setForeground(Color.black);
                }if(String.valueOf(passw.getPassword()).isEmpty()){
                    passw.setText("********");
                    passw.setForeground(Color.gray);
                }}});
        bLoguin.add(pass);

        pWord= new JLabel();
        pWord.setBounds(426,260,300,180);
        pWord.setLayout(null);
        pWord.setBackground(Color.yellow);
        pWord.setIcon(pImage("/image/clave.png",300,180,Image.SCALE_FAST));
        pWord.setVisible(true);
        bLoguin.add(pWord);

        passw= new JPasswordField("********");
        passw.setBounds(473,326,210,50);
        passw.setBorder(BorderFactory.createEmptyBorder());
        passw.setFont(new Font("Roboto", Font.PLAIN, 16));
        passw.setForeground(SystemColor.activeCaptionBorder);
        passw.setBackground(new Color(216,237,230));
        passw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                 if(String.valueOf(passw.getPassword()).equals("********")){
                     passw.setText("");
                     passw.setForeground(Color.black);
                 }if(pass.getText().isEmpty()){
                     pass.setText(" Username");
                     pass.setForeground(Color.gray);
                }}});
        bLoguin.add(passw);

        button= new JLabel("LOGIN");
        button.setOpaque(true);
        button.setBounds(473, 420,210,60);
        button.setFont(new Font("Roboto", Font.PLAIN, 20));
        button.setIcon(pImage("/image/botton2.png",210,134,Image.SCALE_FAST));
        button.setBackground(new Color(236,28,36));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //accionar
                if(pass.getText().equals("Magucho") || String.valueOf(passw.getPassword()).equals("magu123456")){
                    photo.setIcon(pImage("/image/correct.gif",150,150,Image.SCALE_FAST));
                }else{
                    photo.setIcon(pImage("/image/error.gif",150,150,Image.SCALE_FAST));
                }}
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(pImage("/image/botton.png",210,134,Image.SCALE_FAST));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            button.setIcon(pImage("/image/botton2.png",210,134,Image.SCALE_FAST));
            }});
        bLoguin.add(button);
    }
    private ImageIcon pImage(String ima, int width, int height, int scale){
        ImageIcon imag= new ImageIcon(Objects.requireNonNull(getClass().getResource(ima)));
        ImageIcon image= new ImageIcon(imag.getImage().getScaledInstance(width,height,scale));
        return image;
    }
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("image/logo.png")).getScaledInstance(100,100,20);
    }
}
