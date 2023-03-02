/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;



public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran = new Random();                 //class to generate random number[instance created]
    int num = ran.nextInt(999999);       //6-digit random number generated
    
    
    //Global Declaration of textfields and button to use for actionListener:
    JButton add,back;
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    
    AddEmployee(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);                             //removed default border layout
        
        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sans serif", Font.BOLD, 25));
        add(heading);
        
        
        //LABELS && TEXTFields:
        
        //1.NAME:
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //2. FATHER'S NAME:       
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
               
        tffname = new JTextField();
        tffname.setBounds(600,150,200,30);
        add(tffname);
        
        //3.DOB: [Used JCalender jar file to import calender input]
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
               
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
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
        
        String courses[] = {"BBA","BCA","B.COM","B.TECH","BSc","MSc","MCA","MBA","M.TECH"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600,300,200,30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);
        
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
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,200,30);
        add(tfaadhar);
        
        
        //11.Employee ID:[The ID is a random number generated, will be displayed as label only]
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel("" + num);                                    // ID taken as random number.
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        
        //BUTTONS:[Added at the bottom of the window];
        
        add = new JButton("Add Details");
        add.setBounds(250,550, 150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
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
    
    //ActionListener for ADD and BACK button:
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == add ){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into employee values( '" + name + "' , '" + fname + "' , '" + dob + "' , '" + salary + "' , '" + address + "' , '" + phone + "' , '" + email + "' , '" + education + "' , '" + designation + "' , '" + aadhar + "' , '" + empId + " ')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added Successfully!!");
                setVisible(false);
                new Home();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Home();
        }
    }
    
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
