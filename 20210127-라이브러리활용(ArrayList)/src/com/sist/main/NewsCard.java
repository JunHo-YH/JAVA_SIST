package com.sist.main;

import java.awt.*;
import javax.swing.*;

import com.sist.news.NewsVO;

import java.net.*;

// JPanel ==> HTML  ==> <div>
public class NewsCard extends JPanel {
	JLabel poster = new JLabel();
	JLabel title = new JLabel();
	JTextPane tp = new JTextPane();
	JLabel author = new JLabel();

	public NewsCard() {
		setLayout(null);
		poster.setBounds(10, 5, 300, 150);
		add(poster);
		title.setBounds(315, 5, 900, 35);
		add(title);
		JScrollPane js = new JScrollPane(tp);
		js.setBounds(315, 45, 900, 120);
		add(js);
		author.setBounds(315, 170, 900, 35);
		add(author);
	}
	/*
	 * for(NewsVO vo : list) {
	 * 		newsCard c = NewsCArd();
	 * 		c.newsPrint(vo);
	 * }
	 */
	public void newsPrint(NewsVO vo) {
		try {
			URL url = new URL(vo.getPoster());
			ImageIcon ii = new ImageIcon(url);
			Image img = getImage(ii, poster.getWidth(), poster.HEIGHT);
			poster.setIcon(ii);// 이미지 올리는 메서드
			tp.setText(vo.getTitle());
			tp.setText(vo.getContent());
			author.setText(vo.getAuthor());
		}catch(Exception ex) {
			
		}
	}

	public static Image getImage(ImageIcon ii, int w, int h) {
		Image dimg = ii.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return dimg;
	}
}
