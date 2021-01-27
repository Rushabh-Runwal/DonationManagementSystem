# DonationManagementSystem

Donation Management System for an NGO using java AWT and swings


for reference mysql table;

login_info :
CREATE TABLE login_info(username varchar(10),password varchar(10));
(INSERT INTO login_info value('admin','admin')

Volunteer_table:
create table if not exists Volunteer_table(id int(10) auto_increment primary key,name varchar(40),phoneNo bigint(10),Email varchar(30),Address varchar(40));

Donor_info_table:
create table if not exists Donor_info_table(id int(10) auto_increment primary key,name varchar(40),phoneNo bigint(10),Email varchar(30),Address varchar(40),
referred_by int(10),total_donation int(100) DEFAULT 0);

Donation_table:
create table if not exists Donation_table(TimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTSMP,id int(10) auto_increment primary key,amount int(100),donor_id int(10),DonorName varchar(30),FOREIGN KEY (donor_id) REFERENCES Donor_info_table(id));
