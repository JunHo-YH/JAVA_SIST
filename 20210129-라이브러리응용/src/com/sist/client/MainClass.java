package com.sist.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainClass extends JFrame implements ActionListener {
	JButton b1, b2;
	JTextField tf;
	JTextArea ta;

	Manager m = new Manager();

	public MainClass() {
		b1 = new JButton("등록");
		b2 = new JButton("목록");
		tf = new JTextField(10);
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);

		// 윈도우
		add("North", p);
		add("Center", js);
		setSize(350, 450);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public static void main(String[] args) {
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String name = tf.getText();
			m.insert(name);
			tf.setText("");
		}
		if (e.getSource() == b2) {
			ArrayList<String> list = m.allData();
			ta.setText("");
			for (String name : list) {
				ta.append(name + "\n");

			}
		}
	}

}
