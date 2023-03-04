/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    //Global Declaration of textfields and button to use for actionListener:
    JButton update,back;
    JTextField tffname,tfsalary,tfaddress,tfphone,tfemail,tfeducation,tfdesignation;
    JLabel lblempId,lblaadhar,lblname,lbldob;
    String empId;
    
    UpdateEmployee( String empId ){
        
        this.empId = empId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);                             //removed default border layout
        
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sans serif", Font.BOLD, 25));
        add(heading);
        
        
        //LABELS && TEXTFields:
        
        //1.NAME:
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        //2. FATHER'S NAME:  [WILL NOT CHANGE]     
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
               
        tffname = new JTextField();
        tffname.setBounds(600,150,200,30);
        add(tffname);
        
        //3.DOB: [WILL NOT CHANGE]
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
               
        lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        //4.SALARY:
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);
               
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,200,30);
        add(tfsalary);
        
        //5. ADDRESS:
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
               
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //6.PHONE:
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
               
        tfphone = new JTextField();
        tfphone.setBounds(600,250,200,30);
        add(tfphone);
        
        //7. EMail:
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
               
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //8.Highest Education:[Created a dropdown using JComboBox()]
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
       
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,200,30);
        tfeducation.setBackground(Color.WHITE);
        add(tfeducation);
        
        //9.Designation:
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        //10.AADHAR NO:
        
        JLabel labelaadhar = new JLabel("Aadhar No");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,200,30);
        add(lblaadhar);
        
        
        //11.Employee ID:[The ID is a random number generated, will be displayed as label only]
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel();                                    // ID taken as random number.
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        
        
        //PUTTING VALUES IN FIELDS FOR THE SPECIFIC EMP ID:
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.s.executeQuery(query);
            
            while( rs.next() ){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
        
        
        
        //BUTTONS:[Added at the bottom of the window];
        
        update = new JButton("Update Details");
        update.setBounds(250,550, 150,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(450,550, 150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
                    
        
        //Frame Properties:
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == update ){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try{
                Conn c = new Conn(); 
                String query = "update employee set fname = '" + fname + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation + "' where empId = '" + empId + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully!!");
                setVisible(false);
                new Home();
            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new ViewEmployee();
        }
    }
    
    
    //MAIN CLASS: [CALLS CONSTRUCTOR]
    public static void main(String args[]){
        new UpdateEmployee("");
    }
}
