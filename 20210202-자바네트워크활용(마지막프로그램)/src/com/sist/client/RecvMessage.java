package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class RecvMessage extends JFrame{
    JLabel la;
    JTextField tf;
    JTextArea ta;
    JButton b1,b2;
    public RecvMessage()
    {
    	la=new JLabel("보낸 사람");
    	tf=new JTextField(10);
    	tf.setEnabled(false);
    	ta=new JTextArea();
    	ta.setEnabled(false);
    	JScrollPane js=new JScrollPane(ta);
    	b1=new JButton("답장하기");
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
        new RecvMessage();
	}

}
