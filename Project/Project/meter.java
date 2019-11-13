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

class meter extends JPanel implements ActionListener {

 JTextField tmeter=new JTextField();
 JTextField tlocality=new JTextField();
 JTable table = new JTable(); 
 JLabel meter = new JLabel("Meter No");
 JLabel locality = new JLabel("Locality No");
 JButton btnsearch =new JButton("Search");
 DefaultTableModel model;
JScrollPane scrollPane = new JScrollPane(table);

 meter() {
  setSize(600,600); 
  setLayout(null);                                                  
  setVisible(true);   

  Object [] colomns={"Meter_No","C_Reading", "P_Reading", "C_Bill","status"};
  model = new DefaultTableModel();
  model.setColumnIdentifiers(colomns);
  table.setModel(model);
  
  
  add(tmeter);
  add(tlocality);
  add(meter);
  add(locality);
  add(btnsearch);
  add(scrollPane);
     
  meter.setBounds(10, 11, 100, 20);   
  tmeter.setBounds(120,11,100,20);
  locality.setBounds(10,36,100,20);
  tlocality.setBounds(120,36,100,20);
  btnsearch.setBounds(20, 64, 89, 23);
  scrollPane.setBounds(10, 135, 550, 130);

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

String textvalue = tmeter.getText();
String textvalue1 = tlocality.getText();
String Meter_No= "";
String C_Reading = "";
String P_Reading = "";
String C_Bill = "";
String status = "";

     if(source==btnsearch) {
                         
                try{
                 Connection con = getConnection();	         
                 String sql = "select * from Meter where Meter_No = "+textvalue;
                 PreparedStatement ps = con.prepareStatement(sql); 
                 ResultSet rs = ps.executeQuery();
                 int i =0;
                  while(rs.next())
                  { 
                   	Meter_No = rs.getString("Meter_No");
			C_Reading = rs.getString("C_Reading");
			P_Reading = rs.getString("P_Reading");
			C_Bill = rs.getString("C_Bill");
			status = rs.getString("status");
			model.addRow(new Object[]{Meter_No,C_Reading,P_Reading,C_Bill,status});
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
