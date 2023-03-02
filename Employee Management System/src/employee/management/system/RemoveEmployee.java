/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cempId;
    JButton delete, back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        
        //Dropdown of emp Id;[choose before deleting]
        cempId = new Choice();
        cempId.setBounds(200,50,150,30);
        add(cempId);
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while( rs.next() ){
                cempId.add(rs.getString("empId"));
            }            
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        
        
        //DETAILS OF SELECTED ID:
        //name:
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        //Phone:
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        //Email:
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        
        //Fetching values for selected Id from SQL database:
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + cempId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while( rs.next() ){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
            
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '" + cempId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while( rs.next() ){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
            
                }
                catch (Exception e ){
                    e.printStackTrace();
                }
           }
        });
        
        //Buttons:
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        //IMAGE:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, -20, 600, 400);
        add(image);
        
        //Frame property:
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == delete ){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '" + cempId.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!!");
                setVisible(false);
                new Home();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    
    //MAIN() : CALL CONSTRUCTOR OF REMOVEMPLOYEE()
    public static void main(String args[]){
        new RemoveEmployee();
    }
    
}
