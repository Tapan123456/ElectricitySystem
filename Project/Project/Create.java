package energy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

public class Create extends JFrame implements ActionListener 
{  
public String user_type;
public int meter1;
// Name
        JLabel id = new JLabel("User Id");
	JTextField  tid = new JTextField(20);
        JLabel pass=new JLabel("Password ");
        JPasswordField tpass = new JPasswordField();            
         
        JLabel name = new JLabel("First Name");
	JTextField  tname = new JTextField(20);
        JLabel name1 = new JLabel("Middle Name");
	JTextField  tmname = new JTextField(20);
        JLabel name2 = new JLabel("Last Name");
	JTextField  tlname = new JTextField(20);
  // contact details    
        JLabel contact=new JLabel("Mobile No:");
        JTextField  tcon = new JTextField(20);
        JLabel email =new JLabel("Email Id:");
        JTextField  temail = new JTextField(30);

        JLabel gender =new JLabel("Gender");
        String gtype[]={"","Male","Female","Other"};        
        JComboBox cb=new JComboBox(gtype);

        JLabel locality =new JLabel("Locality");
        String ltype[]={"","Hadapsar-10","Viman_Nagar-60","Camp-50","Pimpri-20","Aund-65","Wakad-25"};        
        JComboBox cb1=new JComboBox(ltype);

        JLabel meter =new JLabel("Meter Type");
        String mtype[]={"lt_resi","lt_comm","lt_agri","ht_comm","ht_indus"};        
        JComboBox cb2=new JComboBox(mtype);

        int locno[]={10,60,50,20,65,25};

  // buttons
        JButton Save=new JButton("Create");  
        JButton New =new JButton("New");
        JButton Back =new JButton("Back");    
         
  Create()
  {   
  //add
        add(id);
        add(tid);
        add(pass);
        add(tpass);
        add(name);
	add(tname);
        add(name1);
        add(tmname);
        add(name2);
	add(tlname); 
        add(contact);
        add(tcon);
        add(email);
        add(temail);
        add(gender);
        add(New);
        add(Save);
        add(Back);
        add(cb);     
        add(locality);
        add(cb1);
        add(meter);
        add(cb2);
        setSize(600,600);
        setLayout(null);
        setVisible(true);

      // setting location
      name.setBounds(10,10,100,20);
      tname.setBounds(120,10,100,20);
      name1.setBounds(10,50,100,20);
      tmname.setBounds(120,50,100,20); 
      name2.setBounds(10,90,100,20);
      tlname.setBounds(120,90,100,20);

      contact.setBounds(10,130,100,20);
      tcon.setBounds(120,130,100,20);
      email.setBounds(10,170,100,20);
      temail.setBounds(120,170,100,20);
      gender.setBounds(10,210,100,20);
      cb.setBounds(120,210,100,20);
      
      id.setBounds(10,250,100,20);
      tid.setBounds(120,250,100,20);
      pass.setBounds(10,290,100,20);
      tpass.setBounds(120,290,100,20);
      
      locality.setBounds(10,330,100,20); 
      cb1.setBounds(120,330,100,20);     
       
      meter.setBounds(10,370,100,20); 
      cb2.setBounds(120,370,100,20); 

      New.setBounds(50,390,100,20);
      Save.setBounds(180,390,100,20);
      Back.setBounds(300,390,100,20);

      Save.addActionListener(this);
      New.addActionListener(this);
      Back.addActionListener(this);
      cb.addActionListener(this);
      //tname.addActionListener(this);
      
 }
     
  public void close()
  {
    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
  }   
   
     public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
 
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        //JComboBox cb = (JComboBox)ae.getSource();
  if(source==New) {
		tname.setText("");
		tmname.setText("");
		tlname.setText("");
		tcon.setText("");
		temail.setText("");
                tid.setText("");
                tpass.setText("");
                cb.setSelectedIndex(0);
                cb1.setSelectedIndex(0);
  }					
   else if(source==Save) {
                 
            if (tname.getText().equals("") || tlname.getText().equals("")) {
		JOptionPane.showMessageDialog(name, "Please enter name and surname");
	    } else if (tcon.getText().equals("") || tcon.getText().length() != 10 ) {
		JOptionPane.showMessageDialog(name,"Please enter Valid Contact Number ");
	    } else if (temail.getText().equals("") || !isValid(temail.getText())) {
		JOptionPane.showMessageDialog(name,"Please enter valid Email-Id ");
            } else if (tid.getText().equals("")) {
		JOptionPane.showMessageDialog(name,"Please enter Id ");
            } else if (tpass.getText().equals("")) {
		JOptionPane.showMessageDialog(name,"Please enter Password ");
            }
               else {
                 try {
                   String url ="jdbc:mysql://localhost:3306/Energy?useSSL=false";
                   String username="root";
                   String password="root";

                   Connection con=DriverManager.getConnection(url,username,password);
                   String name = tname.getText();
                   String lname = tlname.getText();
                   String contact = tcon.getText();
                   String email = temail.getText();
                   String id = tid.getText();
                   String pass = tpass.getText();
                   user_type = (String)cb.getSelectedItem();
                   String type = (String)cb2.getSelectedItem();
                   int lno = locno[cb1.getSelectedIndex()-1];
                   String a ="UP";
                   Statement stmt=null;
                   System.out.println(lno);
                               
                              PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO create1 (name,lname,user_type,contact,email,id,pass) VALUES('"
										+ name
										+ "', '"
										+ lname
										+ "', '"
                                                                                + user_type
                                                                                + "' ,'"
                                                                                + contact 
										+ "', '"
                                                                                + email 
                                                                                + "', '"   
                                                                                + id
                                                                                + "', '"
                                                                                + pass +"')");
                          ps.execute();
                          System.out.println("data inserted");
                          
                          stmt=con.createStatement();
                          String query="Select Meter_No from create1 where id='"+tid.getText()+"'"; 
                          ResultSet rs = stmt.executeQuery(query);
                          if(rs.next()) {
                          meter1=rs.getInt("Meter_No");
                          System.out.println(meter1);  }    
                           
                          System.out.println("meter no retrived");
                             
                          PreparedStatement ps1 = (PreparedStatement) con.prepareStatement("INSERT INTO Meter VALUES('"
										+ lno
										+ "', '"
										+ meter1
										+ "', '"
                                                                                + type
                                                                                + "' ,'"
                                                                                + 0	 
										+ "', '"
                                                                                + 0 
                                                                                + "', '"   
                                                                                + 0
                                                                                + "', '"
                                                                                + a +"')"); /*+"')");  */                                                                                                      
                      ps1.execute();
		    } catch(Exception e){	
                         System.out.println(e.getMessage());
                  }
                 tname.setText("");
                 tmname.setText("");
		 tlname.setText("");
		 tcon.setText("");
		 temail.setText("");  
                 tid.setText("");
                 tpass.setText("");
                 cb.setSelectedIndex(0);  
                 cb1.setSelectedIndex(0);
                 JOptionPane.showMessageDialog(null,"Saved Successfully\nYour meter number is "+meter1);
              } //else closed for validation
      } //else closed for button	
      else if(source==Back) {
                   close(); 
      }
  
}
       public static void main(String args[])
       {
          new Create();
       }
}




