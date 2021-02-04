package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class Login extends JFrame{
    JLabel la1,la2,la3;
    JTextField tf1,tf2;
    JRadioButton rb1,rb2;
    JButton b1,b2;
    public Login()
    {
    	la1=new JLabel("ID",JLabel.RIGHT);
    	la2=new JLabel("대화명",JLabel.RIGHT);
    	la3=new JLabel("성별",JLabel.RIGHT);
    	
    	tf1=new JTextField();
    	tf2=new JTextField();
    	
    	rb1=new JRadioButton("남자");
    	rb2=new JRadioButton("여자");
    	ButtonGroup bg=new ButtonGroup();
    	bg.add(rb1); bg.add(rb2);
    	rb1.setSelected(true);
    	
    	b1=new JButton("로그인");
    	b2=new JButton("취소");
    	
    	setLayout(null);
    	la1.setBounds(10, 15, 60, 30);
    	tf1.setBounds(75, 15, 150, 30);
    	
    	la2.setBounds(10, 50, 60, 30);
    	tf2.setBounds(75, 50, 150, 30);
    	
    	la3.setBounds(10, 85, 60, 30);
    	rb1.setBounds(75, 85, 70, 30);
    	rb2.setBounds(150, 85, 70, 30);
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	
    	p.setBounds(10, 120, 215, 35);
    	

    	add(la1);add(tf1);
    	add(la2);add(tf2);
    	add(la3);add(rb1);add(rb2);
    	add(p);
    	
    	setSize(250, 200);
    	setVisible(true);
    }
	public static void main(String[] args) 
	{ 
		new Login();
	}
	
}








