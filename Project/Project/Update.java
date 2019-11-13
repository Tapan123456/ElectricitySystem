package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

public class Update extends JFrame implements ActionListener 
{  

        /*JLabel choice =new JLabel("What do you want to update ,Select Below ");
        String gtype[]={"name ","lname" ,"user_type" ,"contact", "email id" ,"pass"};        
        JComboBox cb=new JComboBox(gtype);*/
// Name            
        JLabel meterno = new JLabel("Enter Meter No to update details");
	JTextField  tm = new JTextField(20);
 
        JLabel name = new JLabel("First Name");
	JTextField  tname = new JTextField(25);
        JLabel name2 = new JLabel("Last Name");
	JTextField  tlname = new JTextField(20);
  // contact details    
        JLabel contact=new JLabel("Mobile No:");
        JTextField  tcon = new JTextField(20);
        JLabel email =new JLabel("Email Id:");
        JTextField  temail = new JTextField(30);

        JLabel id = new JLabel("User Id");
	JTextField  tid = new JTextField(20);
        JLabel pass=new JLabel("Password ");
        JPasswordField tpass = new JPasswordField();
        
        // buttons
        JButton find=new JButton("Find");  
        JButton save=new JButton("Save");
        JButton Back =new JButton("Back");    
        
  Update()
  {   
  //add
        add(id);
        add(tid);
        add(pass);
        add(tpass);
        add(name);
	add(tname);;
        add(name2);
	add(tlname); 
        add(contact);
        add(tcon);
        add(email);
        add(temail);
        add(find);
        add(save);
        add(Back);
        add(meterno);
        add(tm);
        setSize(600,600);
        setLayout(null);
        setVisible(true);

      ///setting location
      meterno.setBounds(10,10,100,20);
      tm.setBounds(120,10,100,20);

      name.setBounds(10,50,100,20);
      tname.setBounds(120,50,100,20);
  
      name2.setBounds(10,90,100,20);
      tlname.setBounds(120,90,100,20);

      contact.setBounds(10,130,100,20);
      tcon.setBounds(120,130,100,20);
      email.setBounds(10,170,100,20);
      temail.setBounds(120,170,100,20);

      
      id.setBounds(10,210,100,20);
      tid.setBounds(120,210,100,20);
      pass.setBounds(10,250,100,20);
      tpass.setBounds(120,250,100,20);

      find.setBounds(50,290,100,20);
      save.setBounds(180,290,100,20);
      Back.setBounds(300,290,100,20);

      find.addActionListener(this);
      save.addActionListener(this);
      Back.addActionListener(this);
       
 }
     
  public void close()
  {
    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
  }   
   
   protected static Connection getConnection() throws Exception {
		try {
			//String driver = "com.mysql.jdbc.Driver";
			//String databaseName = "Student";
			String url = "jdbc:mysql://localhost:3306/Energy?useSSL=false";
			String db_username = "root";
			String db_pass = "root";

			//Class.forName(driver);

			Connection con = DriverManager.getConnection(url,
					db_username, db_pass);
			return con;

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

 
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source==find) {                 
                 try {

                   Connection con = getConnection();
                   Statement st =con.createStatement();
                   
                   ResultSet rs=st.executeQuery("Select name,lname,contact,email,id,pass from create1 where Meter_No="+tm.getText());
                   while(rs.next())
                   {
                      tname.setText(rs.getString("name"));
                      tlname.setText(rs.getString("lname"));
                      tcon.setText(rs.getString("contact"));
                      temail.setText(rs.getString("email"));
                      tid.setText(rs.getString("id"));
                      tpass.setText(rs.getString("pass"));
                   }
                 }
                 catch(Exception e){	
                         System.out.println(e.getMessage());
                  }  
          }
          if(source==save) {                 
                 try {
                   Connection con = getConnection();
                   String name = tname.getText();
                   String lname = tlname.getText();
                   String contact = tcon.getText();
                   String email = temail.getText();
                   String id = tid.getText();
                   String pass = tpass.getText();
                   
                   PreparedStatement post;   
                   String sql = "UPDATE create1 SET name ='"+name+"',lname ='"+lname+"',contact ='"+contact+"',email ='"+email+"',id ='"+id+"',pass ='"+pass+"'where Meter_No='"+tm.getText()+"'";
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
          new Update();
       }
}




