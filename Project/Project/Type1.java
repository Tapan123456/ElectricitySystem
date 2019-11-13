package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

class Type1 extends JFrame implements ActionListener { 

  public static void main(String args[])
       {
          new Type1();
       }
   
  JLabel Utype=new JLabel("Select Your User Type :");
  JButton Customer=new JButton("CUSTOMER");  
  JButton Employee =new JButton("MSEB EMPLOYEE");
 
  Type1(){

    add(Utype);
    add(Customer);
    add(Employee);
    
    setSize(600,600);
    setLayout(null);
    setVisible(true);

    Utype.setBounds(100,100,300,20);
    Customer.setBounds(100,140,200,20);
    Employee.setBounds(100,180,200,20);

    Customer.addActionListener(this);
    Employee.addActionListener(this);
  }
 
  public void close(){

    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
  }
   
  public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
    if(source==Customer) {
        Customer c=new Customer();
        c.setVisible(true);
    }
    else if(source==Employee) {
     Emp e =new Emp();
      e.setVisible(true);
    }
  }
   
}
 
 
