package energy;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
import java.sql.*;

public class Fpage{

       public static void main(String args[]) {
           new Fpage();
       }
       JFrame f;
       JLabel l1;
       Login2 l;
       Home h; 
       //Create321 c1;
       About ab;       
       New n;
       Paybill p;
       Billcal c;

       Fpage()
       {
       f =new JFrame(); 
       ImageIcon img1 = new ImageIcon("energy/img1.jpg");
       l1=new JLabel(img1);
       l1.setBounds(0,0,1000,120);
       f.add(l1);
       //c1=new Create321();
        l =new Login2();
        h = new Home();
        ab =new About();
        n =new  New();
        //p =new Paybill();
        c =new Billcal();
        
   //add Tabs
        JTabbedPane jtp = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT); 
        jtp.setBounds(0,120,800,650);       
        jtp.addTab("Home",h);
        jtp.addTab("Account",l);
        jtp.addTab("New Connection Request",n);
        //jtp.addTab("View/Pay Bill",p);
        jtp.addTab("Energy Bill Calculator",c);
        jtp.addTab("About Us",ab);
        f.add(jtp); 

   //setting size
        //f.setLocationRelativeTo(null);
        //f.pack();
        f.setSize(800, 800);
        f.setLayout(null);
        f.setVisible(true);
       }

}




class Newconn extends JPanel {  
      public static void main(String[] args) { 
         
      }
}

class Cal extends JPanel {  
      public static void main(String[] args) { 
         
      }
}

class Complaint extends JPanel {  
      public static void main(String[] args) { 
         
      }
}

class Paybill extends JPanel {  
      public static void main(String[] args) { 
         
      }


}


