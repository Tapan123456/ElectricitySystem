package energy;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;	

class Division1 extends JPanel implements ActionListener {

 private JTextField division=new JTextField();
 JTable table = new JTable(); 
 JLabel tdivision = new JLabel("Division No");
 JButton btnsearch =new JButton("Search");
 DefaultTableModel model;
JScrollPane scrollPane = new JScrollPane(table);

 Division1() {
  setSize(600,600); 
  setLayout(null);                                                  
  setVisible(true);   

  Object [] colomns={"Division_No","Locality_No", "Locality_Name", "LT_Resi", "LT_Comm","LT_Agri", "HT_Indus","HT_Comm"};
  model = new DefaultTableModel();
  model.setColumnIdentifiers(colomns);
  table.setModel(model);
  
  
  add(division);
  add(tdivision);
  add(btnsearch);
  add(scrollPane);
     
  tdivision.setBounds(10, 11, 133, 20);   
  scrollPane.setBounds(10, 135, 550, 130);
  division.setBounds(150,11,133,20);
  btnsearch.setBounds(10, 72, 89, 23);


    // get selected row data From table to textfields 
  /*table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            .setText(model.getValueAt(i, 0).toString());
            marks.setText(model.getValueAt(i, 1).toString());
        }
        });
 */
    btnsearch.addActionListener(this); 
    }

  protected static Connection getConnection() throws Exception {
		try {
			//String driver = "com.mysql.jdbc.Driver";
			//String databaseName = "Student";
			String url = "jdbc:mysql://127.0.0.1:3306/Energy?useSSL=false";
			String db_username = "root";
			String db_pass = "root";

			//Class.forName(driver);

			Connection connection = DriverManager.getConnection(url,db_username, db_pass);
			return connection;

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

  public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
    System.out.println("Showing Table Data.......");

String textvalue = division.getText();
String Division_No= "";
String Locality_No= "";
String Locality_Name = "";
String LT_Resi = "";
String LT_Comm = "";
String LT_Agri = "";
String HT_Indus = "";
String HT_Comm = "";

     if(source==btnsearch) {
                         
                try{
                 Connection con = getConnection();	         
                 String sql = "select * from Division where Division_No = "+textvalue;
                 PreparedStatement ps = con.prepareStatement(sql); 
                 ResultSet rs = ps.executeQuery();
                 int i =0;
                  while(rs.next())
                  { 
                   	Division_No = rs.getString("Division_No");
			Locality_No = rs.getString("Locality_No");
			Locality_Name = rs.getString("Locality_Name");
			LT_Resi = rs.getString("LT_Resi"); 
			LT_Comm = rs.getString("LT_Comm");
			LT_Agri = rs.getString("LT_Agri");
			HT_Comm = rs.getString("HT_Comm");
			HT_Indus = rs.getString("HT_Indus");
			model.addRow(new Object[]{Division_No,Locality_No,Locality_Name,LT_Resi,LT_Comm,LT_Agri,HT_Indus,HT_Comm});
			i++; 
		  }
		  if(i <1)
		  {
			JOptionPane.showMessageDialog(null, "No Record Found","Error",
			JOptionPane.ERROR_MESSAGE);
		  }
		  if(i ==1)
		  {
			System.out.println(i+" Record Found");
		  }
		  else
		  {
                        System.out.println(i+" Records Found");
                  }
                }
                catch(Exception ex)
		{
                  JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

        
   }  
 }
}
