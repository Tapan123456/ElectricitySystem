package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  
import java.sql.*;

public class Login2 extends JPanel implements ActionListener	
{  
   public static String uname;        
             JLabel l=new JLabel("UserName ");
             JTextField tuname = new JTextField(15);
             JLabel l1=new JLabel("Password ");
             JPasswordField tpass = new JPasswordField();   
             JButton Login=new JButton("Login ");   
             JButton Forgot=new JButton("Forgot ");
//             JButton Register=new JButton("Register");

      Login2()
      {        
             setSize(300,300); 
             setLayout(null);                                                  
             setVisible(true);   

  //           add(Register);
             add(Login);
             add(Forgot);
             add(l);
             add(l1);
             add(tpass);
             add(tuname);

    //         Register.setBounds(100,280,120,20);
             l.setBounds(50,100,150,20);
             tuname.setBounds(200,100,150,20);
             l1.setBounds(50,140,150,20); 
             tpass.setBounds(200,140,150,20); 
             Login.setBounds(100,200,120,20);
             Forgot.setBounds(100,240,120,20); 
             
             Login.addActionListener(this);
             Forgot.addActionListener(this); 
             Register.addActionListener(this);                                                                
      }  
      
 public void actionPerformed(ActionEvent ae)
 {
    Object source =ae.getSource();
    //uname = txt.getText();
    //String paswd = txt1.getText();     
    if(source==Login)
    {
        try {
                   String url ="jdbc:mysql://localhost:3306/Energy?useSSL=false";
                   String username="root";
                   String password="root";
                   Connection con=DriverManager.getConnection(url,username,password);
PreparedStatement ps = (PreparedStatement) con.prepareStatement("Select Loginid,Pass from Employee where Pass ='"+tpass.getText()+"' AND Loginid='"+tuname.getText()+"' UNION Select Loginid ,Pass from Users where Pass ='"+tpass.getText()+"'AND Loginid='"+tuname.getText()+"'");
                   ResultSet rs =ps.executeQuery();
                   //String u = rs.getString("Login");
                   if(rs.next()){                                      
                     if(tpass.getText().equals(rs.getString("Pass")) && tuname.getText().equals(rs.getString("Loginid"))) 
                     { 
                        /*JOptionPane.showMessageDialog(null,"Successful");*/
                       Loginkibaad l =new Loginkibaad();
                       l.setVisible(true);
                       
                      }  
                   }          
                   else 
                   {
                       JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                       tuname.setText("");
                       tpass.setText("");
                       tuname.requestFocus();
                  }    
          }
          catch(Exception e){	
                         System.out.println(e.getMessage());
          }   
    } 

     /*else if(source==b1) 
     {
      Forgot f =new Forgot();
      f.setVisible(true);
     }*/
 }
}

