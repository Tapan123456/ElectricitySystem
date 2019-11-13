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

public class Division extends JPanel implements ActionListener{
JTextField textbox;
JLabel label;
JButton button;
JTable table;
DefaultTableModel model;
JScrollPane scroll = new JScrollPane(table);

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/Energy?useSSL=false";
String userName = "root";
String password = "root";

Division()
{
 setSize(600,600);
 setLayout(null);                                                  
 setVisible(true); 

 table = new JTable(); 
 model = new DefaultTableModel();
 
 String[] columnNames = {"Division_No","Locality_No", "Locality_Name", "LT_Resi", "LT_Comm","LT_Agri", "HT_Indus","HT_Comm"};
 model.setColumnIdentifiers(columnNames);
 table.setModel(model); 
 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
 table.setFillsViewportHeight(true);


 scroll.setHorizontalScrollBarPolicy(
 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 scroll.setVerticalScrollBarPolicy(
 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 


 textbox = new JTextField();
 label = new JLabel("Enter your Division no");
 button = new JButton("search");

 scroll.setBounds(10,140,464,115);
 textbox.setBounds(200,30,150,20); 
 label.setBounds(10, 30, 300, 20);
 button.setBounds(120,130,150,20);

 button.addActionListener(this);

 add(scroll);
 add(textbox);
 add(label);
 add(button);
} 

public void actionPerformed(ActionEvent ae)
{
button = (JButton)ae.getSource();
System.out.println("Showing Table Data.......");

String textvalue = textbox.getText();
String Division_No= "";
String Locality_No= "";
String Locality_Name = "";
String LT_Resi = "";
String LT_Comm = "";
String LT_Agri = "";
String HT_Indus = "";
String HT_Comm = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
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
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}


}


}

