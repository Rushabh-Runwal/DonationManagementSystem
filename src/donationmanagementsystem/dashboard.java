package donationmanagementsystem;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class dashboard implements ActionListener{
     public JFrame jf;
     JLabel l1,l2,total_needy_people_got_helped,total_money;
     JButton b1,b2,b3,add_donor,add_donation,add_valunteer,update_contactUs,send_donors_a_message;
     
     
     private static String get_result(String table_name) throws SQLException{
        String q = "select COUNT(*) from ";
        conn cl = new conn(); 
        ResultSet rs = cl.s.executeQuery(q + table_name);
        while(rs.next()){
            return rs.getString("count(*)");
        }
        return "0";
     }
     
     public dashboard() throws SQLException {
        String q = "select SUM(amount) from donation_table;";
        conn cl = new conn(); 
        ResultSet rs = cl.s.executeQuery(q);
        String total_amount = "0";
        while(rs.next()){
            total_amount = rs.getString("sum(amount)");
        }
        if(total_amount == null){
            total_amount = "0";
        }
        System.out.println("total_amount :"+total_amount);
        


        
        Color yellow  = Color.decode("#fffbbe");
        Color purple = Color.decode("#be97dc");
        jf = new JFrame("Dashboard");         
        jf.setBackground(Color.white);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.white); 
        
        ImageIcon Ii =  new ImageIcon(ClassLoader.getSystemResource("icons/dashboardbg.jpg"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Image I2 = Ii.getImage().getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel li = new JLabel(I3);
        li.setBounds(0,0,screenSize.width,screenSize.height);
        

        JPanel stats1 = new JPanel();                
        stats1.setBackground(new Color(255, 251, 190, 123));
        stats1.setLayout(null);
        stats1.setBounds(400,400,300,200);
        
        total_needy_people_got_helped = new JLabel();
        total_needy_people_got_helped.setBackground(purple);
        total_needy_people_got_helped.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/community.png"));
        Image i1= img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        total_needy_people_got_helped.setIcon(new ImageIcon(i1));
        total_needy_people_got_helped.setBounds(5,5,130,130);
        JLabel jl1 = new JLabel((Integer.parseInt(total_amount) / 500 ) + "");
        JLabel jl2 = new JLabel("Total Needy people got help");
        jl1.setFont(new Font("Roboto",Font.BOLD,40));
        jl1.setBounds(170,18,100,90);
        jl2.setFont(new Font("Roboto",Font.BOLD,20));
        jl2.setBounds(5,145,280,30);
        stats1.add(total_needy_people_got_helped);
        stats1.add(jl1);
        stats1.add(jl2);
       
        
        JPanel stats2 = new JPanel();                
        stats2.setBackground(new Color(255, 251, 190, 123));
        stats2.setLayout(null);
        stats2.setBounds(800,400,300,200);
        
        total_money = new JLabel();
        total_money.setBackground(purple);
        total_money.setLayout(null);
        img = new ImageIcon(ClassLoader.getSystemResource("icons/love.png"));
        i1= img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        total_money.setIcon(new ImageIcon(i1));
        total_money.setBounds(5,5,130,130);
        jl1 = new JLabel((Integer.parseInt(total_amount) / 1000 ) + "K");
        jl2 = new JLabel("Total Money Collected ($)");
        jl1.setFont(new Font("Roboto",Font.BOLD,30));
        jl1.setBounds(170,18,100,90);
        jl2.setFont(new Font("Roboto",Font.BOLD,20));
        jl2.setBounds(5,145,280,30);
        stats2.add(total_money);
        stats2.add(jl1);
        stats2.add(jl2);
        
//        
//        total_money = new JLabel();
//        total_money.setBackground(purple);
//        total_money.setLayout(null);
//        img = new ImageIcon(ClassLoader.getSystemResource("icons/love.png"));
//        i1= img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
//        total_money.setIcon(new ImageIcon(i1));
//        total_money.setBounds(800,400,150,150);

// Buttons        
        b1 = new JButton();
        b1.setBackground(purple);
        b1.setForeground(Color.black);
        b1.setLayout(null);
        JLabel number = new JLabel(get_result("donor_info_table"));
        JLabel desc = new JLabel("Donors");
        JLabel arrow = new JLabel(">>");
        number.setFont(new Font("Roboto",Font.BOLD,38));
        number.setBounds(100,18,50,30);
        desc.setFont(new Font("Roboto",Font.BOLD,20));
        desc.setBounds(86,70,150,30);
        arrow.setFont(new Font("Roboto",Font.BOLD,12));
        arrow.setBounds(220,100,20,20);
        b1.add(number);
        b1.add(desc);
        b1.add(arrow);
        b1.setBounds(400,140,240,120);
        b1.addActionListener(this);
        
        b2 = new JButton();
        b2.setBackground(purple);
        b2.setForeground(Color.black);
        b2.setLayout(null);
        
        number = new JLabel(get_result("donation_table"));
        desc = new JLabel("Donations");
        arrow = new JLabel(">>");
        number.setFont(new Font("Roboto",Font.BOLD,38));
        number.setBounds(100,18,50,30);
        desc.setFont(new Font("Roboto",Font.BOLD,20));
        desc.setBounds(79,70,150,30);
        arrow.setFont(new Font("Roboto",Font.BOLD,12));
        arrow.setBounds(220,100,20,20);
        b2.add(number);
        b2.add(desc);
        b2.add(arrow);
        b2.setBounds(700,140,240,120);
        b2.addActionListener(this);
        
        b3 = new JButton();
        b3.setBackground(purple);
        b3.setForeground(Color.black);
        b3.setLayout(null);
        number = new JLabel(get_result("volunteer_table"));
        desc = new JLabel("Volunteers");
        arrow = new JLabel(">>");
        number.setFont(new Font("Roboto",Font.BOLD,38));
        number.setBounds(100,18,50,30);
        desc.setFont(new Font("Roboto",Font.BOLD,20));
        desc.setBounds(78,70,150,30);
        arrow.setFont(new Font("Roboto",Font.BOLD,12));
        arrow.setBounds(220,100,20,20);
        b3.add(number);
        b3.add(desc);
        b3.add(arrow);
        b3.setBounds(1000,140,240,120);
        b3.addActionListener(this);
                
        add_donation = new JButton("Add New Donation");
        add_donation.setBackground(yellow);
        add_donation.setForeground(Color.black);
        add_donation.setLayout(null);
        add_donation.setBounds(20,100,200,60);
        add_donation.addActionListener(this);
        
        add_donor = new JButton("Add New donor");
        add_donor.setBackground(yellow);
        add_donor.setForeground(Color.black);
        add_donor.setLayout(null);
        add_donor.setBounds(20,160,200,60);
        add_donor.addActionListener(this);
        
        add_valunteer = new JButton("Add New Volunteer");
        add_valunteer.setBackground(yellow);
        add_valunteer.setForeground(Color.black);
        add_valunteer.setLayout(null);
        add_valunteer.setBounds(20,220,200,60);
        add_valunteer.addActionListener(this);

        update_contactUs = new JButton("Update Contact details");
        update_contactUs.setBackground(yellow);
        update_contactUs.setForeground(Color.black);
        update_contactUs.setLayout(null);
        update_contactUs.setBounds(20,280,200,60);
        update_contactUs.addActionListener(this);
        
        
        send_donors_a_message = new JButton("Send Donors a message");
        send_donors_a_message.setBackground(yellow);
        send_donors_a_message.setForeground(Color.black);
        send_donors_a_message.setLayout(null);
        send_donors_a_message.setBounds(20,340,200,60);
        send_donors_a_message.addActionListener(this);
        
        li.add(b1);
        li.add(b2);
        li.add(b3);
        li.add(add_donation);
        li.add(add_donor);
        li.add(add_valunteer);
        li.add(update_contactUs);
        li.add(send_donors_a_message);
//        li.add(total_needy_people_got_helped);        
//        li.add(total_money);  
        li.add(stats1);
        li.add(stats2);
        
        jf.add(li);
        
        jf.setVisible(true);
        jf.setSize(screenSize.width,screenSize.height);
        jf.setLocation(0,0);
         
     }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==b1){
               jf.setVisible(false);
                try {
                    new ViewData("donor_info_table");
                } catch (SQLException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
            if(ae.getSource()==b2){
               jf.setVisible(false);
                try {
                    new ViewData("donation_table");
                } catch (SQLException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }           
            }
            if(ae.getSource()==b3){
               jf.setVisible(false);
               try {
                    new ViewData("volunteer_table");
                } catch (SQLException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }           
           }
            if(ae.getSource()==add_donation){
               jf.setVisible(false);
                try {
                    new AddDonation();
                } catch (SQLException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex);
                }
           }
            if(ae.getSource()==add_donor){
               jf.setVisible(false);
               new AddDonor();
           }
            if(ae.getSource()==add_valunteer){
               jf.setVisible(false);
               new AddVolunteer();
           }
            if(ae.getSource()==update_contactUs){
               jf.setVisible(false);

           }
            if(ae.getSource()==send_donors_a_message){
               jf.setVisible(false);
           }
    }
        public static void main(String[] args) throws SQLException {
            new dashboard();
    }
}