package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
import java.sql.*;

public class Loginkibaad extends JFrame {

       public static void main(String args[]) {
           new Loginkibaad();
       }

       Division1 d;
       meter m;
       Consumer1 cu;
       Billing b;
          
       Loginkibaad()
       {
        d =new Division1();
        m =new meter();
        cu=new Consumer1();
        b =new Billing();
        
        /*wel =new JLabel("WELCOME");
        name=new JLabel(" ");*/
   //add Tabs
        JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);        
        jtp.addTab("Divsion",d);
        jtp.addTab("Meter",m);
        jtp.addTab("Consumer",cu);
        jtp.addTab("Billing",b);
       	
        add(jtp); 
   // jdbc connection
       
   /*try {
                   String url ="jdbc:mysql://localhost:3306/Student?useSSL=false";
                   String username="root";
                   String password="root";
                   Connection con=DriverManager.getConnection(url,username,password);
                   //Statement myStmt = con.createStatement();
                   PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT Name from student WHERE Id='lakshita'");
                   ResultSet rs = ps.executeQuery();
                   while (rs.next()) {     
                   name.setText(rs.getString(1));
                   }
    }
    catch (Exception e) {
        e.printStackTrace();
    }*/
       
   //setting size
        setSize(600, 600);
        setVisible(true);
       }

}


class Meter extends JPanel {  
      public static void main(String[] args) { 
         
      }
}

class Consumer extends JPanel {  
      public static void main(String[] args) { 
         
      }
}


class Logout extends JPanel {  
      public static void main(String[] args) { 
         
      }
}
