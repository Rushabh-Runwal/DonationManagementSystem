package donationmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class login implements ActionListener{   
    JFrame jf;
    JLabel l1,l2,l3;
    JButton jb1,jb2;
    JTextField jtf1;
    JPasswordField jpf1;
    
    public login() {
        jf = new JFrame("Login");
        
        Color yellow  = Color.decode("#fffbbe");
        jf.setBackground(yellow);
        jf.setLayout(null);
       
       l3 = new JLabel();
       l3.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i1= img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        l3.setIcon(new ImageIcon(i1));
       l3.setBounds(95,15,150,150);
       jf.add(l3);
       
       
       l1 = new JLabel("Username");
       l1.setBounds(40, 190, 100, 30);
       l1.setFont(new Font("serief",Font.BOLD,15));
       jf.add(l1);
       
       l2 = new JLabel("Password");
       l2.setBounds(40, 240, 100, 30);
       l2.setFont(new Font("serief",Font.BOLD,15));
       jf.add(l2);
       
       
       jtf1  = new JTextField();
       jtf1.setBounds(150, 190, 150, 30);
       jf.add(jtf1);
       
       jpf1 = new JPasswordField();
       jpf1.setBounds(150, 240, 150, 30);
       jf.add(jpf1);
       
       
       jb1 = new JButton("Login");
       jb1.setBounds(40,300,120,30);
       jb1.setFont(new Font("serif",Font.BOLD,15));
       jb1.setBackground(Color.black);
       jb1.setForeground(Color.white);
       jb1.addActionListener(this);
       jf.add(jb1);
       
       jb2 = new JButton("Cancle");
       jb2.setBounds(180,300,120,30);
       jb2.setFont(new Font("serif",Font.BOLD,15));
       jb2.setBackground(Color.black);
       jb2.setForeground(Color.white);
       jb2.addActionListener(this);
       jf.add(jb2);
       
       
       jf.setVisible(true);
       jf.setSize(340,400);
       jf.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==jb1){
           try{
                char ch[];
                conn cl = new conn();

                String ur = jtf1.getText();
                ch = jpf1.getPassword();
    System.out.print(ur+" "+new String(ch)+"\n");
    ResultSet rs1 = cl.s.executeQuery("select * from login_info");
    System.out.print(rs1);
    String q ="select * from login_info where username ='"+ur+"' and password = '"+(new String(ch))+"';";       
    ResultSet rs = cl.s.executeQuery(q);
                if(rs.next()){
                    new dashboard().jf.setVisible(true);
                    jf.setVisible(false);
                    System.out.print("\nLOGIN SUCCESSFUL !");       
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid login");
                }         
            }
           catch(Exception e){
                e.printStackTrace();
            }
    }// if button is login
    if(ae.getSource()==jb2){
        jf.setVisible(false);
        try {
            new dashboard();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    }

    public static void main(String[] args) {
        login g = new login();
    }
}

