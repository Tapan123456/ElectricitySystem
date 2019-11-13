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

class Consumer1 extends JPanel implements ActionListener {

 JButton back=new JButton("Back");
 JButton btnAdd = new JButton("Add"); 
 JButton btnDelete =new JButton("Delete");
 JButton btnUpdate =new JButton("Update");
 

 Consumer1() {
  setSize(600,600); 
  setLayout(null);                                                  
  setVisible(true);   
 
  add(btnAdd);
  add(btnDelete);
  add(btnUpdate);

  btnAdd.setBounds(10,10, 100, 20);
  btnDelete.setBounds(10,50,100,20);
  btnUpdate.setBounds(10,90,100,20);
  /*back.setBounds(130, 10, 30, 20);*/ 
 
    btnAdd.addActionListener(this); 
    btnDelete.addActionListener(this);
    btnUpdate.addActionListener(this);
}

 public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
     if(source==btnAdd) {
           Create c =new Create();
           c.setVisible(true);
     }
     if(source==btnDelete) {
         Delete de =new Delete();
         de.setVisible(true);        
      }
     if(source==btnUpdate) {
          Update u =new Update();
          u.setVisible(true);
     }
   }
}

