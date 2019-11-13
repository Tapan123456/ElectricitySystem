package energy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
import java.sql.*;

public class BeforeLogin extends JFrame {

       public static void main(String args[]) {
           new BeforeLogin();
       }
       JFrame f;
       Login2 l;
       Home h; 
       About ab;       
       New n;
       Paybill p;
       Billcal c;
       BeforeLogin()
       {
        f=new JFrame();  
        l =new Login2();
        h = new Home();
        ab =new About();
        n =new  New();
        p =new Paybill();
        c =new Billcal();
     
   //add Tabs
        JTabbedPane jtp = new JTabbedPane(JTabbedPane.LEFT); 
        jtp.setBounds(0,150,800,550);       
        jtp.add("Home",h);
        jtp.add("Account",l);
        jtp.add("New Connection Request",n);
        jtp.add("View/Pay Bill",p);
        jtp.add("Energy Bill Calculator",c);
        jtp.add("About Us",ab);
        f.add(jtp); 

   //setting size
        f.setSize(800,800); 
        f.setLayout(null);
        f.setVisible(true);
       }

}





