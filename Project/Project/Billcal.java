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

public class Billcal extends JPanel implements ActionListener {
public int creading;
 JLabel meterno = new JLabel("Meter No");
 JTextField  tno = new JTextField(20);
 
 JLabel meter =new JLabel("Meter Type");
 String mtype[]={"lt_resi","lt_comm","lt_agri","ht_comm","ht_indus"};        
 JComboBox cb1=new JComboBox(mtype);
 
 JLabel units = new JLabel("Enter units");
 JTextField  tu = new JTextField(20);

 JLabel bill = new JLabel("Total Bill ");
 JLabel amt = new JLabel(" ");

 JButton cal = new JButton("Calculate");
 int basefare;
 int addfare;
 Billcal() {
  setSize(600,600); 
  setLayout(null);                                                  
  setVisible(true);   
 
  add(cal);
  add(meterno);
  add(tno); 
  add(meter);
  add(cb1);
  add(units);
  add(tu);
  add(bill);
  add(amt);

  meterno.setBounds(10,10,100,20);
  tno.setBounds(120,10,100,20);
  meter.setBounds(10,50,100,20); 
  cb1.setBounds(120,50,100,20);
  units.setBounds(10,90,100,20);
  tu.setBounds(120,90,100,20);
  bill.setBounds(10,120,100,20);
  amt.setBounds(120,120,100,20);
  cal.setBounds(10,150,100,20); 

  cal.addActionListener(this); 
    
 }
  public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
     
     int units = Integer.parseInt(tu.getText());
     System.out.println(units); 
	int type = cb1.getSelectedIndex();
        System.out.println(type); 
     Statement stmt=null;
     if(source==cal) {
	
		switch(type)
		{
			case 0 : {
				    basefare = 65;
				    if(units>=1 && units<=100)
				        addfare = units * 4;
				    else if(units>=101 && units<=300)
					addfare = units * 7;
				    else if(units>=301 && units<=500)
					addfare = units * 10;
                                    else if(units>=501 && units<=1000)
					addfare = units * 12;
				    else
					addfare = units * 13;
				}
  				 break;

			case 1 : {
				    basefare = 270;
 				    if(units>=1 && units<=200)
					addfare = units * 7;
				    else 
					addfare = units * 10; 
				 }
  				 break;


			case 2 : {
				    basefare = 65;
				    addfare = units * 4;
				 }
  				 break;

			case 3 : {
				    basefare = 270;
				    addfare = units * 11;
				 }
  				 break;

                        case 4 : {
				    basefare = 270;
				    addfare = units * 6;
				 }
  				 break;

			default : JOptionPane.showMessageDialog(meter,"Please enter valid meter type");
				  break;
	     }
		int tamt = (basefare + addfare);
		String str = Integer.toString(tamt);
		amt.setText(str); 
             
            if (tno.getText().equals("")) {
		JOptionPane.showMessageDialog(meterno,"Please enter Meter Number ");
	    } else if (tu.getText().equals("")) {
		JOptionPane.showMessageDialog(meterno,"Please enter Units ");
            } 
     }
  }		
}
 
