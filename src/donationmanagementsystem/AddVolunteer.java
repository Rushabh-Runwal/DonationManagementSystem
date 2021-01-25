package donationmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddVolunteer implements ActionListener{
    JFrame jf;
    JLabel volunteer_id,volunteer_name,email,phone,address,l1,l2,l3;
    JTextField volunteer_id1,volunteer_name1,email1,phone1,address1;
    JButton jb1,jb2;
    
    public AddVolunteer() {
        Color yellow  = Color.decode("#fffbbe");
        Color purple = Color.decode("#be97dc");
        jf = new JFrame("Add New Donation");
        jf.setLayout(null);
        jf.setBackground(Color.white);

        l1 = new JLabel();
        l1.setBounds(0,0, 600,600);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/add_donation.jpg"));
        Image I2 = img.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        l1.setIcon(I3);   

        JLabel title = new JLabel("New Volunteer's Details");
        title.setBounds(150,20,360,50);
        title.setFont(new Font("Roboto",Font.BOLD,30));
        title.setForeground(Color.black);
        l1.add(title);
        jf.add(l1);    

//        volunteer_id = new JLabel("Id");
//        volunteer_id.setBounds(60,120,200,30);
//        volunteer_id.setFont(new Font("Roboto",Font.BOLD,20));
//        l1.add(volunteer_id);

//        volunteer_id1 = new JTextField();
//        volunteer_id1.setBounds(200,120,200,30);
//        volunteer_id1.setFont(new Font("Roboto",Font.BOLD,18));
//        l1.add(volunteer_id1);
        
        volunteer_name = new JLabel("Name");
        volunteer_name.setBounds(60,170,120,30);
        volunteer_name.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(volunteer_name);

        volunteer_name1 = new JTextField();
        volunteer_name1.setBounds(200,170,200,30);
        volunteer_name1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(volunteer_name1);
                
        phone = new JLabel("Phone No.");
        phone.setBounds(60,220,200,30);
        phone.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(phone);

        phone1 = new JTextField();
        phone1.setBounds(200,220,200,30);
        phone1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(phone1);
        
        email = new JLabel("Email Id");
        email.setBounds(60,270,200,30);
        email.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(email);

        email1 = new JTextField();
        email1.setBounds(200,270,200,30);
        email1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(email1);
        
        address = new JLabel("Address ");
        address.setBounds(60,320,200,30);
        address.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(address);

        address1 = new JTextField();
        address1.setBounds(200,320,200,30);
        address1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(address1);

        l2 = new JLabel();
        l2.setBounds(200,450,250,200);
        l1.add(l2);

        l2 = new JLabel("");
        l2.setBounds(600,450,250,200);
        l1.add(l2);

        jb1= new JButton("Submit");
        jb1.setBounds(150,450,150,40);
        jb1.setBackground(Color.black);
        jb1.setForeground(yellow);
        jb1.addActionListener(this);
        l1.add(jb1);

        jb2= new JButton("Cancle");
        jb2.setBounds(350,450,150,40);
        jb2.setBackground(purple);
        jb2.setForeground(yellow);
        jb2.addActionListener(this);
        l1.add(jb2);

        jf.setVisible(true);
        jf.setSize(600,600);
        jf.setLocation(360,40);
    }

    @Override
    public void actionPerformed(ActionEvent ae)  {
        if(ae.getSource() == jb2){
            jf.setVisible(false);
            try {
                new dashboard();
            } catch (SQLException ex) {
                Logger.getLogger(AddVolunteer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource()==jb1){
//"create table if not exists Volunteer_table(id int(10) auto_increment primary key,name varchar(40),
// phoneNo int(10),Email varchar(30),Address varchar(40));
            
//            String id2 = this.volunteer_id1.getText();
            String name2 = this.volunteer_name1.getText();
            String phone2 = this.phone1.getText();
            String email2 = this.email1.getText();
            String address2 = this.address1.getText();
            

//String q = "insert into Volunteer_table value('"+id2+"','"+name2+"','"+phone2+"','"+email2+"','"+address2+"');";
String q = "insert into Volunteer_table(name,phoneNo,Email,Address) value('"+name2+"','"+phone2+"','"+email2+"','"+address2+"');";
            conn con = new conn();
            try {
                con.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Data Entered Successfully");
                jf.setVisible(false);
                new dashboard();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error while registering data");
                System.out.print(ex);     
            }
          
        }
    }
    
    public static void main(String[] args) {
        AddVolunteer obj = new AddVolunteer();
    }
}