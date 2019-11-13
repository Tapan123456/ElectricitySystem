package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;

public class Emp extends JFrame implements ActionListener 
{  
public String user_type;
// Name
	JLabel personal=new JLabel("PERSONAL DETAILS");
        JLabel Userid =new JLabel("Enter Your UserId ");
        JTextField  Tuserid = new JTextField(20);
        JLabel Name = new JLabel("Name");
	JTextField  Tname = new JTextField(20);

  // contact details    
        JLabel Contact=new JLabel("Mobile No:");
        JTextField  Tcon = new JTextField(20);
        JLabel Email =new JLabel("Email Id:");
        JTextField  Temail = new JTextField(30);
        JLabel Gender=new JLabel("Gender:"); 
        JRadioButton Male=new JRadioButton ("Male");
        JRadioButton Female=new JRadioButton ("Female");
        ButtonGroup Bg=new ButtonGroup();
              
  // qualifications
        JLabel City=new JLabel("City");
        JTextField Tcity=new JTextField(60);

        JLabel Address=new JLabel("Full Address");
        JTextField Tadd=new JTextField(60);
  //id-pass
        JLabel Id=new JLabel("Login Id ");
        JTextField Tid =new JTextField(20);
        JLabel Pass=new JLabel("Password ");
        JTextField Tpass =new JTextField(20);

  // buttons
        JButton Save=new JButton("Save");  
        JButton New =new JButton("New");
        JButton Finish =new JButton("Finish");    
         
  //User type    
        JLabel Type =new JLabel("Employee Type");
        String utype[]={"","Manager","Employee","Clerk"};        
        JComboBox Cb=new JComboBox(utype);
    
  Emp()
  {   
  //add
        add(personal);
        add(Userid);
        add(Tuserid);
        add(Name);
	add(Tname); 
        add(Contact);
        add(Tcon);
        add(Email);
        add(Temail);
        add(Gender);
        add(Male);
        Bg.add(Male);
        Bg.add(Female);
        add(Female);
        add(City);
        add(Tcity);
        add(Address);
        add(Tadd);
        add(Id);
        add(Tid);
        add(Pass);
        add(Tpass);
        add(Save);
        add(New);
        add(Finish);
        add(Type);
        add(Cb);     
   
        setSize(600,600);
        setLayout(null);
        setVisible(true);

      // setting location
      personal.setBounds(200,15,250,25);
      Userid.setBounds(100,35,150,20);
      Tuserid.setBounds(275,35,150,20);
      Name.setBounds(125,60,150,25);
      Tname.setBounds(275,60,150,20);
     
      Contact.setBounds(100,85,150,20);
      Tcon.setBounds(250,85,150,20);
      Email.setBounds(100,110,150,20);
      Temail.setBounds(250,110,150,20);
      Gender.setBounds(100,135,150,20);
      Male.setBounds(250,135,65,20);
      Female.setBounds(340,135,150,20);

      City.setBounds(100,160,150,20);
      Tcity.setBounds(260,160,150,20);
      
      Address.setBounds(100,185,150,20);
      Tadd.setBounds(260,185,150,20);

      Id.setBounds(100,210,150,20);
      Tid.setBounds(250,210,150,20);
      Pass.setBounds(100,232,150,20);
      Tpass.setBounds(250,232,150,20);
      Type.setBounds(100,255,150,20);
      Cb.setBounds(250,255,150,20);
 
      New.setBounds(50,285,100,20);
      Save.setBounds(200,285,100,20);
      Finish.setBounds(350,285,100,20);

      Save.addActionListener(this);
      New.addActionListener(this);
      Finish.addActionListener(this);
      Cb.addActionListener(this);
      //tname.addActionListener(this);
      
 }
     
  public void close()
  {
    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
  }   
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        //JComboBox cb = (JComboBox)ae.getSource();
  if(source==New) {
		Tname.setText("");
		Tcon.setText("");
                Tcity.setText("");
                Tadd.setText("");
		Temail.setText("");
                Tpass.setText("");
                Cb.setSelectedIndex(0);
  }					
   else if(source==Save) {
                 
            if (Tname.getText().equals("")) {
		JOptionPane.showMessageDialog(Name, "Please enter name ");
	    } else if (Tcon.getText().equals("")) {
		JOptionPane.showMessageDialog(Name,"Please enter Contact Number ");
	    } else if (Male.isSelected() == false && Female.isSelected() == false) {
		JOptionPane.showMessageDialog(Name, "Please select gender");
            } else if (Temail.getText().equals("")) {
		JOptionPane.showMessageDialog(Name,"Please enter Email-Id ");
            } else if (Tid.getText().equals("")) {
		JOptionPane.showMessageDialog(Name,"Please enter Login Id ");
            } else if (Tpass.getText().equals("")) {
		JOptionPane.showMessageDialog(Name,"Please enter Password ");
            } else {
                 try {
                   String url ="jdbc:mysql://localhost:3306/Energy?useSSL=false";
                   String username="root";
                   String password="root";

                   Connection con=DriverManager.getConnection(url,username,password);
                   String Userid=Tuserid.getText();
                   String name = Tname.getText();
                   String contact = Tcon.getText();
                   String gender;
    					if (Male.isSelected()) {
						gender = "male";
					} else {
						gender = "female";
					}
                   String email = Temail.getText();
                   String id = Tid.getText();
                   String pass = Tpass.getText();
                   String city =Tcity.getText();
                   String add =Tadd.getText();
                   user_type = (String)Cb.getSelectedItem();
                    
                        System.out.println("inserting in employee");
                              PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO Employee VALUES('"
                                                                                + Userid
                                                                                + "' ,'"
										+ name
										+ "', '"
										+ contact
										+ "', '"
										+ city
										+ "', '"
                                                                                + id
                                                                                + "' ,'"
                                                                                + pass
                                                                                + "' ,'"
                                                                                + user_type
                                                                                + "', '"
                                                                                +  gender+"')");
                       ps.execute();
                        
                  } catch(Exception e){	
                         System.out.println(e.getMessage());
                  }
                 
                 Tname.setText("");
		 Tcon.setText("");
		 Temail.setText("");
		 Tcity.setText(""); 
                 Tadd.setText("");
                 Tid.setText("");
                 Tpass.setText("");  
                 Cb.setSelectedIndex(0);  
                 JOptionPane.showMessageDialog(null,"Saved Successfully");
              } //else closed for validation
      } //else closed for button	
      else if(source==Finish) {
                   close(); 
      }
  
}
       public static void main(String args[])
       {
          new Emp();
       }
}




