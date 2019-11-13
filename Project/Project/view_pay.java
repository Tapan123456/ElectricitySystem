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

class view_pay extends JPanel implements ActionListener {

 JLabel meter = new JLabel("Meter No");
 JTextField tmeter=new JTextField();
 
 JLabel transc = new JLabel("Transcation Id");
 JTextField ttransc=new JTextField();
  
 JLabel month =new JLabel("Month");
 String mtype[]={"","Jan","Feb","March","April","May","June","July","Aug","sep","Nov","Dec"};        
 JComboBox cb=new JComboBox(mtype);
 JButton btnsearch =new JButton("Search");
 
 meter() {
  setSize(600,600); 
  setLayout(null);                                                  
  setVisible(true);   

  add(meter);
  add(tmeter);
  add(transc);
  add(ttransc);
  add(month);
  add(cb);
  add(btnsearch);

  meter.setBounds(10,10,100,20);   
  tmeter.setBounds(120,10,100,20);
  transc.setBounds(10,50,100,20);
  ttransc.setBounds(120,50,100,20);
  month.setBounds(
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
