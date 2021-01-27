package com.sist.main;

import com.sist.news.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class NewsForm extends JPanel implements ActionListener {
	JButton b1, b2;
	JLabel la;
	int curpage = 1;
	int totalpage = 0;
	JPanel p = new JPanel();

	NewsManager mgr = new NewsManager();

	public NewsForm() {
		setLayout(new BorderLayout());

		// p.setLayout(null);
		JScrollPane pp = new JScrollPane();
		Dimension size = new Dimension();
		size.setSize(1000, 1000);
		p.setPreferredSize(size);
		pp.setViewportView(p);

		p.setLayout(new GridLayout(5, 1));

		ArrayList list = mgr.newsListData(curpage);
		for (int i = 0; i < list.size(); i++) {
			NewsVO vo = (NewsVO) list.get(i);
			NewsCard nc = new NewsCard();
			nc.newsPrint(vo);
			p.add(nc);
		}

		add("Center", pp);
		b1 = new JButton("이전");
		b2 = new JButton("다음");
		totalpage = mgr.newsTotalPage();
		la = new JLabel(curpage + "1 page /" + totalpage + " pages");
		JPanel ppp = new JPanel();
		ppp.add(b1);
		ppp.add(la);
		ppp.add(b2);
		add("South", ppp);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) { // 이전
			if (curpage > 1) {
				curpage--;
				p.removeAll();
				ArrayList list = mgr.newsListData(curpage);
				for (int i = 0; i < list.size(); i++) {
					NewsVO vo = (NewsVO) list.get(i);
					NewsCard nc = new NewsCard();
					nc.newsPrint(vo);
					p.add(nc);
				}
				p.validate();
				la.setText(curpage + "1 page /" + totalpage + " pages");
			}
		}
		if (e.getSource() == b2) { // 다음
			if (curpage < totalpage) {
				curpage++;
				p.removeAll();
				ArrayList list = mgr.newsListData(curpage);
				for (int i = 0; i < list.size(); i++) {
					NewsVO vo = (NewsVO) list.get(i);
					NewsCard nc = new NewsCard();
					nc.newsPrint(vo);
					p.add(nc);
				}
				p.validate();
				la.setText(curpage + "1 page /" + totalpage + " pages");
			}
		}

	}

}
