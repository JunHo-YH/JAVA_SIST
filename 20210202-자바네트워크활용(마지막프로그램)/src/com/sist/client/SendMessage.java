package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class SendMessage extends JFrame{
    JLabel la;
    JComboBox tf;
    JTextArea ta;
    JButton b1,b2;
    public SendMessage()
    {
    	la=new JLabel("받는 사람");
    	tf=new JComboBox();
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	b1=new JButton("쪽지보내기");
    	b2=new JButton("취소");
    	
    	JPanel p1=new JPanel();
    	p1.add(la);p1.add(tf);
    	JPanel p2=new JPanel();
    	p2.add(b1);p2.add(b2);
    	
    	// 윈도우 첨부
    	add("North",p1);
    	add("Center",js);
    	add("South",p2);
    	
    	setSize(350,350);
    	//setVisible(true);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new SendMessage();
	}

}
