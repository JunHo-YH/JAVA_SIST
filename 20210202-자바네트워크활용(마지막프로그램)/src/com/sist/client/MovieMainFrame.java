package com.sist.client;
// 윈도우
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.sist.common.Function;

import java.awt.*;
import java.awt.event.*;
/*
 *    오라클 : 데이터 수집해서 저장하는 장소 
 *    자바 : 오라클 연결 => 데이터를 브라우저에 전송 
 *    자바스크립트 : 브라우저에서 이벤트 처리(버튼,검색,애니메이션)
 *    HTML:화면 출력 
 *          \n => <br>
 *    CSS: 화면 디자인 (Layout)
 *    
 *    ==> JSP
 */
// 네트워크 관련 클래스 : Socket , BufferedReader , OutputStream , StringTokenizer
import java.net.*;
import java.util.*;
import java.io.*;
/*
 *    class 유형 
 *    = 단일 상속  ==> 키워드(class)
 *    = 다중 상속  ==> 키워드(interface)
 *         상속 
 *    class ==> class
 *        extends
 *    interface ===> interfece
 *          extends 
 *    interfece ====> class
 *           implements 
 *           
 *    인터페이스 여러개 ==> A,B,C
 *    ========
 *     주로 => 관련된 여러개의 클래스를 한개의 이름으로 제어 
 */
public class MovieMainFrame extends JFrame implements ActionListener,Runnable{
	
	// Menu
	JMenuItem home=new JMenuItem("홈");
	JMenuItem rmovie=new JMenuItem("현재상영영화");
	JMenuItem smovie=new JMenuItem("개봉예정영화");
	
	JMenuItem wbox=new JMenuItem("주간");
	JMenuItem mbox=new JMenuItem("월간");
	JMenuItem ybox=new JMenuItem("연간");
	
	JMenuItem chat=new JMenuItem("채팅");
	
	CardLayout card=new CardLayout();
	// 화면 UI
	MovieHomeForm mhf=new MovieHomeForm();
	ChatForm cf=new ChatForm();
	// Login
	Login login=new Login();
	// 쪽지보내기
	SendMessage sm=new SendMessage();
	RecvMessage rm=new RecvMessage();
	// 네트워크 
	Socket s;
	BufferedReader in;
	OutputStream out;
	String name;
    public MovieMainFrame()
    {
    	setLayout(card);
    	JMenuBar bar=new JMenuBar();
    	JMenu menu1=new JMenu("홈");
    	menu1.add(home);
    	
    	JMenu menu2=new JMenu("영화");
    	menu2.add(rmovie);
    	menu2.add(smovie);
    	
    	JMenu menu3=new JMenu("박스오피스");
    	menu3.add(wbox);
    	menu3.add(mbox);
    	menu3.add(ybox);
    	
    	JMenu menu4=new JMenu("네트워크");
    	menu4.add(chat);
    	
    	bar.add(menu1);
    	bar.add(menu2);
    	bar.add(menu3);
    	bar.add(menu4);
    	// 윈도우 추가
    	setJMenuBar(bar);
    	
    	// 화면 추가
    	add("CHAT",cf);
    	add("HOME",mhf);
    	
    	
    	setSize(1024, 768);
    	//setVisible(true);
    	setResizable(false);
    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    	
    	home.addActionListener(this);
    	chat.addActionListener(this);
    	
    	// 로그인 
    	login.b1.addActionListener(this);
    	login.b2.addActionListener(this);
    	
    	// 채팅 
    	cf.tf.addActionListener(this);//Enter
    	// 쪽지보내기 
    	cf.b1.addActionListener(this);
    	sm.b1.addActionListener(this);
    	sm.b2.addActionListener(this);
    	rm.b1.addActionListener(this);
    	rm.b2.addActionListener(this);
    	// 로또 (멀티쓰레드)
    	// 나가기
        cf.b3.addActionListener(this);
        
		/*
		 * int temp=cf.model.getRowCount(); if(temp>1) { cf.b1.setEnabled(true); } else
		 * { cf.b1.setEnabled(false); }
		 */
    }
    // 서버 연결 => 호출시기 (로그인 버튼 클릭시)
    public void connection(String id,String name,String sex)
    {
    	try
    	{
    		// 서버 연결 
    		s=new Socket("localhost",3355);
    		// s=> 서버정보 
    		// 서버가 보내준 데이터를 읽을 위치 확인  => in
    		in=new BufferedReader(new InputStreamReader(s.getInputStream()));
    		// 서버로 보내는 위치 확인 => out 
    		out=s.getOutputStream();
    		
    		// 로그인 요청 
    		out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
    	}catch(Exception ex){}
    	// 서버로부터 값을 읽어 와라 => 실시간으로 읽는다 => 쓰레드 
    	new Thread(this).start(); //run호출 
    	/*
    	 *   쓰레드 사용법 
    	 *    1) 상속 => 멀티쓰레드 
    	 *       class A extends Thread
    	 *    2) 구현 => 싱글쓰레드 
    	 *       class A implements Runnable
    	 *    *** 자바는 단일 상속 
    	 */
    }
    // 서버로부터 응답을 받아서 출력하는 기능 
    /*
     *    switch()
     *    {
     *       case 1:
     *       {
     *         String name="";
     *       }
     *         break;
     *       case 2:
     *          String name="";
     *          break;
     *    }
     */
    public void run()
    {
    	try
    	{
    		while(true)
    		{
    			// 1. 서버에서 응답한 데이터를 받는다
    			String msg=in.readLine();
    			StringTokenizer st=new StringTokenizer(msg,"|");
    			// split=> 정규식  "\\|"
    			// Function.LOGIN+"|"+id+"|"+name+"|"+sex => 테이블에 출력 
    			// Function.MYLOG => 윈도우 변경 (로그인=>채팅창)
    			// Function.CHAT => ta=> 출력 
    			int protocol=Integer.parseInt(st.nextToken());
    			switch(protocol)
    			{
    			  case Function.LOGIN:
    			  {
    				  // 테이블에 출력 
    				  String[] data= {
    					st.nextToken(), // id
    					st.nextToken(), // name
    					st.nextToken()  // sex
    				  };
    				  cf.model.addRow(data);
    			  }
    			  break;
    			  case Function.MYLOG:
    			  {
    				  name=st.nextToken();
    				  setTitle(name);
    				  login.setVisible(false);//로그인창 종료
    				  setVisible(true);// 채팅창 
    			  }
    			  break;
    			  case Function.CHAT:
    			  {
    				  initStyle();
    				  append(st.nextToken(),st.nextToken());
    			  }
    			  break;
    			  case Function.EXIT:
    			  {
    				  String id=st.nextToken();
    				  String str="";
    				  for(int i=0;i<cf.model.getRowCount();i++)
    				  {
    					  str=cf.model.getValueAt(i, 0).toString();
    					  if(id.equals(str))
    					  {
    						  cf.model.removeRow(i);
    						  break;
    					  }
    				  }
    			  }
    			  break;
    			  case Function.MYEXIT:
    			  {
    				  System.exit(0);
    			  }
    			  break;
    			  case Function.SENDMESSAGE:
    			  {
    				  String youId=st.nextToken();
    				  String strMsg=st.nextToken();
    				  rm.tf.setText(youId);
    				  rm.ta.setText(strMsg.replace("\t", "\n"));
    				  rm.setVisible(true);
    			  }
    			  break;
    			}
    			
    		}
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		
		 new MovieMainFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			card.show(getContentPane(), "HOME");
		}
		else if(e.getSource()==chat)
		{
			card.show(getContentPane(), "CHAT");
		}
		else if(e.getSource()==login.b1)
		{
			//1. id를 읽는다 
			String id=login.tf1.getText();
			if(id.length()<1)
			{
				login.tf1.requestFocus();
				return;
			}
			String name=login.tf2.getText();
			if(name.length()<1)
			{
				login.tf2.requestFocus();
				return;
			}
			
			String sex="";
			if(login.rb1.isSelected())
				sex="남자";
			else
				sex="여자";
			
			connection(id, name, sex);//로그인 요청
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==cf.tf)
		{
			//1. 입력한 채팅문자열 읽기 
			String msg=cf.tf.getText();
			if(msg.length()<1)
				return;
			
			String color=cf.box.getSelectedItem().toString();
			// Object => String형변경 toString()
			// (String)
			try
			{
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());// 서버로 전송 
				
			}catch(Exception ex) {}
			cf.tf.setText("");
			cf.box.setSelectedIndex(0);
		}
		else if(e.getSource()==cf.b3)// 나가기 버튼 
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());// 서버로 전송 (서버에서 처리)
				// readLine() => 패킷을 받을때 \n
				// 클라이언트 ===>                   서버  ====> 클라이언트 
				//       요청(Enter,버튼클릭,메뉴클릭)  요청 처리(결과값)   결과값을 출력 
			}catch(Exception ex){}
		}
		else if(e.getSource()==cf.b1)
		{
			sm.tf.removeAllItems();
			String str="";
			for(int i=0;i<cf.model.getRowCount();i++)
			{
				String id=cf.model.getValueAt(i, 0).toString();
				String yname=cf.model.getValueAt(i, 1).toString();
				if(!name.equals(yname))
				{
					sm.tf.addItem(id);
				}
			}
			sm.setVisible(true);
		}
		
		else if(e.getSource()==sm.b1)
		{
			// 서버로 전송 
			String strMsg=sm.ta.getText();
			String youId=sm.tf.getSelectedItem().toString();
			try
			{
				out.write((Function.SENDMESSAGE+"|"+strMsg.replace("\n", "\t")+"|"+youId+"\n").getBytes());
			}catch(Exception ex) {}
			sm.setVisible(false);
		}
		else if(e.getSource()==sm.b2)
		{
			sm.setVisible(false);
		}
		else if(e.getSource()==rm.b1)
		{
			sm.ta.setText("");
			sm.tf.removeAllItems();
			String str="";
			for(int i=0;i<cf.model.getRowCount();i++)
			{
				String id=cf.model.getValueAt(i, 0).toString();
				String yname=cf.model.getValueAt(i, 1).toString();
				if(!name.equals(yname))
				{
					sm.tf.addItem(id);
				}
			}
			sm.setVisible(true);
			rm.setVisible(false);
			
		}
		else if(e.getSource()==rm.b2)
		{
			rm.setVisible(false);
		}
	}
	
	public void append(String msg,String color)
	{
		try
		{
			Document doc=cf.pane.getDocument();
			doc.insertString(doc.getLength(), msg+"\n", cf.pane.getStyle(color));
			// 문자열 결합 
		}catch(Exception ex){}
	}
	public void initStyle()
	{
		Style def=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style red=cf.pane.addStyle("red", def);
		StyleConstants.setForeground(red, Color.red);
		
		Style yellow=cf.pane.addStyle("yellow", def);
		StyleConstants.setForeground(yellow, Color.yellow);
		
		Style blue=cf.pane.addStyle("blue", def);
		StyleConstants.setForeground(blue, Color.blue);
		
		Style cyan=cf.pane.addStyle("cyan", def);
		StyleConstants.setForeground(cyan, Color.cyan);
		
		Style green=cf.pane.addStyle("green", def);
		StyleConstants.setForeground(green, Color.green);
	}

}















