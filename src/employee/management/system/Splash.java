/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Splash extends JFrame implements ActionListener{
    //Default Consturctor: as soon as main creates the instance of Splash...it'll run this constructor
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);                    // getContentPane access the action area of JFrame
        setLayout(null);                                             // removed the default layout of JFrame[border]
        
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");      // heading label
        heading.setBounds(80,30,1200,60);                      //
        heading.setFont(new Font("serif", Font.PLAIN, 60));    // 
        heading.setForeground(Color.BLACK);                                     // Font color
        add(heading);                                                        // heading added to our JFrame 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        
        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBounds(400,400,300,70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);
        image.add(clickHere);                                            // Relative positioning
       
        
        setTitle("Employee Management System");
        setSize(1170, 650);             // sets the size <width, height>
        setLocation(200, 50);                  // <x,y> axis distance. default is (0,0) i.e left top origin
        setVisible(true);                         // makes the window visible
        
        
         
        //Function to give dipper effect to the heading:
        while( true ){
            heading.setVisible(false);        // Hide
            
            try{
                Thread.sleep(500);            // holds the time for mentioned milliseconds
            }catch (Exception e){
            }
            
            heading.setVisible(true);           //show
            
            try{
                Thread.sleep(1000);            // holds the time for mentioned milliseconds
            }catch (Exception e){
            }
        }
        
        
    }
    
    
    //clickHere button -> action listener method -> will take us to login page
    public void actionPerformed(ActionEvent a){
        setVisible(false);
        new Login();
    }
    
    //Main function:
    public static void main(String args[]){
        new Splash();                         //object created: Constructor called
    }
}
