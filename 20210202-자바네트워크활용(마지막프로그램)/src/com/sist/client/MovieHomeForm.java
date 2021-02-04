package com.sist.client;
import javax.swing.*;

import com.sist.data.MovieManager;
import com.sist.data.MovieVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.net.*;
public class MovieHomeForm extends JPanel implements ActionListener{
	JLabel[] poster=new JLabel[20];
	JPanel pan=new JPanel();
	JButton b1=new JButton("이전");
	JButton b2=new JButton("다음");
	JLabel pageLa=new JLabel("0 page / 0 pages");
	int curpage=1;
	int totalpage=11;
	MovieManager mgr=new MovieManager();
	public MovieHomeForm()
	{
		pan.setLayout(new GridLayout(4,5,5,5));
		for(int i=0;i<poster.length;i++)
		{
			poster[i]=new JLabel();
			pan.add(poster[i]);
		}
		setLayout(new BorderLayout());
		add("Center",pan);
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		
		add("South",p);
		moviePrint(curpage);
		
		// 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void moviePrint(int page)
	{
		try
		{
			// 데이터 받기 
			ArrayList<MovieVO> list=mgr.movieListData(page);
			int total=mgr.movieTotalPage();
			pageLa.setText(page+" page / "+total+" pages");
			
			for(int i=0;i<list.size();i++)
			{
				MovieVO vo=list.get(i);
				URL url=new URL(vo.getPoster());
				ImageIcon ii=new ImageIcon(url);
				Image img=getImage(ii, 300, 200);
				poster[i].setIcon(new ImageIcon(img));
				// <img src="vo.getPoster()" width=350 height=350>
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static Image getImage(ImageIcon ii,int w,int h)
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(curpage>1)
			{
				curpage--;
				moviePrint(curpage);
			}
		}
		if(e.getSource()==b2)
		{
			if(curpage<totalpage)
			{
				curpage++;
				moviePrint(curpage);
			}
		}
	} 
}






