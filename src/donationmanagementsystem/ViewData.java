package donationmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ViewData implements ActionListener {
    JFrame jf;
    JTable jt;
    JScrollPane sp;
    JButton b1 ;
    
    public ViewData(String table_name) throws SQLException{
        
        Color yellow  = Color.decode("#fffbbe");
        Color purple = Color.decode("#be97dc");
        
        conn c1 = new conn();
//        String table_name = "donor_info_table";
        String q = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = 'dms' AND table_name ='"+ table_name +"';"; //to get no. of rows in table
        ResultSet rs = c1.s.executeQuery(q);
        int columns =  0;
        while(rs.next()){
            columns = Integer.parseInt(rs.getString("count(*)"));
        }
         
        q = "SELECT count(*) FROM "+ table_name +";";
        rs = c1.s.executeQuery(q);
        int rows =  0;
        while(rs.next()){
            rows = Integer.parseInt(rs.getString("count(*)"));
        }
        q = "SELECT * FROM "+ table_name +";";
        rs = c1.s.executeQuery(q);
        ResultSetMetaData metadata = rs.getMetaData();
//        int columns = metadata.getColumnCount();   //to get no. of column in table
        String[][] data = new String[rows][columns]; // [rows][columns]
        
	System.out.println(rows+" "+columns);

        int i=0;
	while(rs.next())  {
	 for(int j=0;j<columns;j++) {
//	 System.out.print(rs.getString(j+1)+" - ");
	 data[i][j]=rs.getString(j+1);
	 }
//	 System.out.println();
	 i=i+1;
	}
  
        String[] heading =  new String[columns];
        for (i=1; i<=columns; i++) {            
            String columnName = metadata.getColumnName(i);
            System.out.println(columnName);
            heading[i-1] = columnName;
        }

        
        jf = new JFrame("View Data");
        jf.setBackground(Color.white);
        jf.setLayout(null); 
        
        jt=new JTable(data,heading);    
        jt.setBounds(0,0,760,460);          
        sp = new JScrollPane(jt);    
        sp.setBounds(10,0,760,460);          
        jf.add(sp);          
        
        b1 = new JButton("Go Back");
        b1.setBounds(650,470,120,30);
        b1.setBackground(yellow);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        jf.add(b1); 
        
        jf.setSize(800,540);    
        jf.setVisible(true);   
        jf.setLocation(300,30);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
               jf.setVisible(false);
            try {
                new dashboard();
            } catch (SQLException ex) {
                Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
    }
    
    public static void main(String[] args) throws SQLException{
        String test1 = "donor_info_table";
        String test2 = "donation_table";
        String test3 = "Volunteer_table";
        new ViewData(test2);
    }
    
}
