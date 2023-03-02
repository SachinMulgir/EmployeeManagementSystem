/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 


public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword;                   // globally declared so that we can fetch the input data in action listener
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //USERNAME Label && TextField:
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,80,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        //PASSWORD Label && TextField:
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,80,30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        //LOGIN button:
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        //IMAGE ICON:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        //Frame property:
        setTitle("Login");
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent a){
        
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
            
            ResultSet rs = c.s.executeQuery(query);
            if( rs.next() ){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                setVisible(false);
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
