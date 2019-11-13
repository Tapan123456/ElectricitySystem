package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

public class Delete extends JFrame implements ActionListener 
{  

// Name
        JLabel mno = new JLabel("Meter No");
	JTextField  tmno= new JTextField(20);
        JLabel l=new JLabel("Enter meter no whose records you want to delete");
        JButton delete =new JButton("delete");    
         
  Delete()
  {   
  //add
        add(mno);
        add(tmno);
        add(l);
        add(delete);
        
        setSize(600,600);
        setLayout(null);
        setVisible(true);

      // setting location
      mno.setBounds(10,50,100,20);
      tmno.setBounds(120,50,100,20);
      l.setBounds(10,10,100,20);
      delete.setBounds(10,90,100,20); 
      
      delete.addActionListener(this);
         
 }
     
  public void close()
  {
    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
  }   
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        //JComboBox cb = (JComboBox)ae.getSource();
        if(source==delete) {
     	                  try {
                           String url ="jdbc:mysql://localhost:3306/Energy?useSSL=false";
                           String username="root";
                           String password="root";

                           Connection con=DriverManager.getConnection(url,username,password);
                           PreparedStatement post;
                           System.out.println(tmno.getText());
                           String sql = "DELETE from Meter WHERE Meter_No= "+tmno.getText(); 
                           post = con.prepareStatement(sql);
                       
                           post.executeUpdate();
                           post.close();
                           }
	                   catch(Exception e){	
                            System.out.println(e.getMessage());
                           }
                          
        }					
  }   

       public static void main(String args[])
       {
          new Delete();
       }
}




