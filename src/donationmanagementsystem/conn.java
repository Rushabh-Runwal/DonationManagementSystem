package donationmanagementsystem;

import java.sql.*;

// download and mysql-command-prompt setup
// connect mysqlJDBC driver through libraries
// create database dbm; use dms
// create table login

// fffbbe eec1ea be97dc a374d5       color scheme used

public class conn {
           public Connection c;
           public Statement s;
           
           String username,password;
           
    public conn() {
        try{	
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/DMS","root","admin");
            s = c.createStatement();
            if(c == null) {
                System.out.println("Connection failed \n");
                return;
            }
            s =c.createStatement(); 
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
}
