package donationmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddDonation implements ActionListener{
    JFrame jf;
    JLabel id,donor_name,donor_id,amount,referred_by,l1,l2,l3;
    JTextField id1,donor_name1,donor_id1,amount1,referred_by1;
    JButton jb1,jb2;
    
    public AddDonation() throws SQLException {
        
        conn cl = new conn();        
        
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

        JLabel title = new JLabel("New Donation Details");
        title.setBounds(200,20,330,50);
        title.setFont(new Font("Roboto",Font.BOLD,30));
        title.setForeground(Color.black);
        l1.add(title);
        jf.add(l1);

        amount = new JLabel("Amount");
        amount.setBounds(60,120,100,30);
        amount.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(amount);

        amount1 = new JTextField();
        amount1.setBounds(200,120,200,30);
        amount1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(amount1);        
        
        donor_name = new JLabel("Donor Name");
        donor_name.setBounds(60,170,120,30);
        donor_name.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(donor_name);

        donor_name1 = new JTextField();
        donor_name1.setBounds(200,170,200,30);
        donor_name1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(donor_name1);
        
        donor_id = new JLabel("Donor Id");
        donor_id.setBounds(60,220,200,30);
        donor_id.setFont(new Font("Roboto",Font.BOLD,20));
        l1.add(donor_id);

        donor_id1 = new JTextField();
        donor_id1.setBounds(200,220,200,30);
        donor_id1.setFont(new Font("Roboto",Font.BOLD,18));
        l1.add(donor_id1);
        
        ResultSet rs1 = cl.s.executeQuery("SELECT COUNT(*) FROM donor_info_table ");
        String columnsNumber = "";
        if(rs1.next()){
            columnsNumber = rs1.getString("count(*)");
        }
        
        String[] s1 = new String[Integer.parseInt(columnsNumber) + 1];
        rs1 = cl.s.executeQuery("select * from donor_info_table");
//        s1[0] = "Seaach Id";
        int i = 0;
        while(rs1.next()){
            s1[i] = rs1.getString("id");
            i += 1;
        }
        JComboBox search_id = new JComboBox(s1);
        search_id.setBounds(420,170,100,30);
        search_id.setFont(new Font("Roboto",Font.PLAIN,14));
        search_id.setBackground(yellow);
        search_id.setForeground(Color.black);
        search_id.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = (String) search_id.getSelectedItem();//get the selected item
                String q = "select * from donor_info_table where id = "+id+";";
                try {
                    ResultSet rs = cl.s.executeQuery(q);
                    String name1 = "";
                    while(rs.next()){   
                       name1= rs.getString("name");             
                    }
                    donor_name1.setText(name1);
                    donor_id1.setText(id);
                } catch (SQLException ex) {
                    Logger.getLogger(AddDonation.class.getName()).log(Level.SEVERE, null, ex);
//                    donor_name1.setText("Search A Valid Id");
                }

                }
        });
        search_id.setSelectedItem(s1[0]);   
        
        l1.add(search_id);
        


//        referred_by = new JLabel("referred by");
//        referred_by.setBounds(60,270,100,30);
//        referred_by.setFont(new Font("Roboto",Font.BOLD,20));
//        l1.add(referred_by);
//        JLabel vol = new JLabel("(volunteer id)");
//        vol.setBounds(60,290,100,30);
//        vol.setFont(new Font("Roboto",Font.BOLD,12));
//        l1.add(vol);
//        
//        
//        referred_by1 = new JTextField();
//        referred_by1.setBounds(200,270,200,30);
//        referred_by1.setFont(new Font("Roboto",Font.BOLD,18));
//        l1.add(referred_by1);

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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == jb2){
            jf.setVisible(false);
            try {
                new dashboard();
            } catch (SQLException ex) {
                Logger.getLogger(AddDonation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource()==jb1){
//create table if not exists Donation_table(id int(10) auto_increment primary key,amount int(100),donor_id int(10),DonorName varchar(30),
//total_donation int(100) DEFAULT 0,FOREIGN KEY (donor_id) REFERENCES donor_info_table(id));
            
//            String id2 = "1001";
            String amount2 = this.amount1.getText();
            String donors_id2 = this.donor_id1.getText();
            String donor_name2 = this.donor_name1.getText();
//            String referred_by2 = this.referred_by1.getText();
            
String q = "insert into Donation_table(amount,donor_id,DonorName) value('"+amount2+"','"+donors_id2+"','"+donor_name2+"');";
//String q = "insert into Donation_table(id,amount,donor_id,DonorName) value('"+id2+"','"+amount2+"','"+donors_id2+"','"+donor_name2+"');";

            conn con = new conn();
            try {
                con.s.executeUpdate(q);
                System.out.println(q);     
                JOptionPane.showMessageDialog(null,"Data Entered Successfully");
                jf.setVisible(false);
                new dashboard();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error while registering data\n");
                System.out.println(ex);     
            }
        q = "select total_donation from donor_info_table where id="+donors_id2+";";
            try {
                ResultSet rs = con.s.executeQuery(q);
                String tot_amount = "";
//                Integer.parseInt(amount2)
                while(rs.next()){   
                       tot_amount= rs.getString("total_donation");             
                    }
                String amt = ( Integer.parseInt(tot_amount)+Integer.parseInt(amount2))+"";
                q = "UPDATE donor_info_table SET total_donation = '"+ amt +"' WHERE id = "+donors_id2+";";
                try {
                con.s.executeUpdate(q);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error while registering data\n");
                    System.out.println(ex);     
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddDonation.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
       
    public static void main(String[] args) throws SQLException {
        AddDonation obj = new AddDonation();
    }
}
