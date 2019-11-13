package energy;

import java.awt.*;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.*;
import javax.swing.*;  
import java.sql.*;

public class About extends JPanel {
	
	JLabel topic =new JLabel("ENERGY BILLING SYSTEM",JLabel.CENTER);
	Font f1 = new Font("Serif",Font.BOLD,20);
        

	JLabel quote = new JLabel("'Electricity can transform people's lives, not just economically but \nalso socially.'");
	Font f2 = new Font("Forte",Font.ITALIC | Font.BOLD,11);    
	Font f4 = new Font("Times New Roman",Font.BOLD,12);   
	
	Font f3 = new Font("Classic",Font.BOLD,15);    
	
	JLabel  desc1 = new JLabel("Electricity is the basic neccesity of every person on this world");
	JLabel  desc2 = new JLabel("People should demand and we are here to provide it.This System"); 	
	JLabel  desc3 = new JLabel("can help you to calculate your energy bill monthly or whenever");
	JLabel  desc4 = new JLabel("you want.You can get request for a new connection or for a new");
	JLabel  desc5 = new JLabel(" user account .We follow the Tariff provided by MSEB which was");
	JLabel  desc6 = new JLabel("effective from April 2018.");
        
	//ImageIcon iicon = new ImageIcon("energy/bill11.jpg");
	
	//JLabel iconlbl = new JLabel("",iicon,JLabel.CENTER);
	
                
	JLabel cont = new JLabel("Mail us at : energybillsys@gmail.com");
	JLabel phn = new JLabel("Call us at : 7485961234");
 
       About()
       {
	     /*EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                   String s = "Welcome to Energy BIlling System!";
                   MarqueePanel mp = new MarqueePanel(s, 24);
               }
            });*/
	     setSize(800,800); 
             setLayout(null);                                                  
             setVisible(true); 
		add(topic);
		//add(mp);
		add(quote);
		add(desc1);
		add(desc2);
		add(desc3);
		add(desc4);
		add(desc5);
		add(desc6);
		//add(iconlbl);	     
                add(cont);
		add(phn);

		topic.setFont(f1);
		quote.setFont(f2);
		desc1.setFont(f3);
		desc2.setFont(f3);
                desc3.setFont(f3);
		desc4.setFont(f3);
		desc5.setFont(f3);
		desc6.setFont(f3);
		cont.setFont(f4);
		phn.setFont(f4);
		
		//iconlbl.setIcon(iicon);
		topic.setBounds(20,100,500,30);
		//mp.setBounds(5,130,300,24);
		quote.setBounds(20,160,600,20);

                desc1.setBounds(10,190,600,100);
		desc2.setBounds(10,225,600,100);
		desc3.setBounds(10,260,600,100);
		desc4.setBounds(10,295,600,100);
		desc5.setBounds(10,330,600,100);
		desc6.setBounds(10,365,600,100);

	        //iconlbl.setBounds(20,400,400,300);
		cont.setBounds(10,470,450,25);
		phn.setBounds(10,500,450,25);
	         
       }
       
}
