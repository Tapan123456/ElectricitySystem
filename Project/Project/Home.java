package energy;

import java.awt.*;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;  
import java.sql.*;

public class Home extends JPanel {
	
	Color col = new Color(204,255,153);
	JLabel topic = new JLabel("ENERGY BILLING SYSTEM",JLabel.CENTER);
	//topic.setBackground(Color.WHITE);
	//topic.setForeground(Color.BLUE);
	Font f = new Font("Serif",Font.BOLD,30);
	//topic.setFont(f);
	//Color col = new Color(204,255,153);
	

	//JLabel iconlbl = new JLabel("");
	
	
	//JLabel img = new JLabel(new ImageIcon("logo.jpg");
 
       Home()
       { 
       ImageIcon img1 = new ImageIcon("energy/logo.jpg");
       JLabel l1=new JLabel(img1);
       //l1.setBounds(0,0,1000,120);
       //f.add(l1);

	     setSize(800,800); 
             setLayout(null);                                                  
             setVisible(true); 
             add(topic);
	     topic.setForeground(Color.RED);
             topic.setBackground(Color.WHITE);
	     topic.setFont(f);
	     topic.setBounds(0,0,500,200);
	     add(l1);
             l1.setBounds(0,0,500,800);			
             //iconlbl.setIcon(img);
       }
       
}
