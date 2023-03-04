/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;


import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;



public class Register extends JFrame implements ActionListener{
    
    
    
    //Global Declaration of textfields and button to use for actionListener:
    JButton register,back;
    JTextField tfloginid,tfname,tfdesignation,tfusername,tfpassword;
    
    
    
    Register(){
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);                             //removed default border layout
        
        JLabel heading = new JLabel("REGISTER TO DATABASE");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sans serif", Font.BOLD, 25));
        add(heading);
        
        
        //LABELS && TEXTFields:
        
        //loginID:
        
        JLabel labelloginid = new JLabel("Login Id");
        labelloginid.setBounds(50,150,150,30);
        labelloginid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelloginid);
        
        tfloginid = new JTextField();
        tfloginid.setBounds(200,150,150,30);
        add(tfloginid);
        
        //Name:   
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,200,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
               
        tfname = new JTextField();
        tfname.setBounds(200,200,150,30);
        add(tfname);
        
        //Designation:
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,250,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,250,150,30);
        add(tfdesignation);
               
        
        // username:
        
        JLabel labelusername = new JLabel("Username");
        labelusername.setBounds(50,300,150,30);
        labelusername.setFont(new Font("serif",Font.PLAIN,20));
        add(labelusername);
               
        tfusername = new JTextField();
        tfusername.setBounds(200,300,150,30);
        add(tfusername);
        
        // password:
        JLabel labelpassword = new JLabel("Password");
        labelpassword.setBounds(50,350,150,30);
        labelpassword.setFont(new Font("serif",Font.PLAIN,20));
        add(labelpassword);
               
        tfpassword = new JTextField();
        tfpassword.setBounds(200,350,150,30);
        add(tfpassword);       
            
        
        //BUTTONS:[Added at the bottom of the window];
        
        register = new JButton("Register");
        register.setBounds(250,550, 150,40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);
        
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
    
    //Password Hashing Function:
    public byte[] getSha(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes(StandardCharsets.UTF_8));           
        }catch ( NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String hash(String password){
        try{
            BigInteger num = new BigInteger(1,getSha(password));
            StringBuilder sb = new StringBuilder(num.toString(16));
            return sb.toString();
        }catch ( Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == register ){
            try{
                String loginId = tfloginid.getText();
                String name = tfname.getText();
                String desig = tfdesignation.getText();
                String username = tfusername.getText();
                String password = tfpassword.getText();
                
                String hashedpassword = hash(password);
                
                Conn c = new Conn();
                String query = "Insert into login values ('" + loginId + "', '" + name + "', '" + desig + "', '" + username + "', '" + hashedpassword + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Registered Successfully!!");
                setVisible(false);
                new Login();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new Register();
    }
}
