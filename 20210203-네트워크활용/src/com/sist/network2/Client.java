package com.sist.network2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 네트워크 관련 
import java.net.*;// Socket => 연결(서버)
import java.io.*;// 서버로 보내기 (OutputStream), 서버로부터 받기(BufferedReader) 
public class Client extends JFrame implements ActionListener,Runnable{
    JTextField tf; // 채팅 입력 
    JTextArea ta; // 채팅 출력 
    JButton b1,b2;// 접속 , 종료 
    // 네트워크 관련 클래스
    Socket s;
    OutputStream out;
    BufferedReader in;
    String name;
    JScrollBar bar;
    /*
     *   1. 서버에 접속 : 접속버튼 
     *   2. 채팅 문자열을 보낸다 : JTextField => Enter시에 데이터 전송 
     *   3. 서버로부터 채팅문자열을 받아서 출력 => 실시간 (쓰레드) => 서버 감시 
     *   ==================== Output , Input 
     *                       ========  =====
     *                         송신      수신 ==> 송신/수신(양방향을 할 수 없다)
     */
    // 초기화 
    public Client()
    {
    	tf=new JTextField(20);
    	tf.setEnabled(false);
    	b1=new JButton("접속");
    	b2=new JButton("종료");
    	ta=new JTextArea();
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta); // V , H
    	bar=js.getVerticalScrollBar();
    	// 배치
    	add("Center",js);
    	JPanel p=new JPanel();
    	p.add(tf);p.add(b1);p.add(b2);
    	add("South",p);
    	
    	// 윈도우 크기
    	setSize(400, 450);
    	setVisible(true);
    	
    	// 버튼을 누르면 actionPerformed를 호출 해라(이벤트 처리:사건)
    	b1.addActionListener(this);
    	// Client가 가지고 있는 actionPerformed(ActionEvent e) 호출
    	// ====== Client의 자신 : this
    	b2.addActionListener(this);
    	tf.addActionListener(this);
    	/*
    	 *   ActionListener => actionPerformed(ActionEvent e)
    	 *   ==============
    	 *     button종류 (JButton,JRadioButton)
    	 *     textfield => Enter
    	 *     menuItem
    	 */
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자
		new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			System.exit(0);// 프로그램 종료
		}
		else if(e.getSource()==b1)//접속
		{
			name=JOptionPane.showInputDialog("대화명 입력:");// [홍길동] Hi
			// 연결
			try
			{
				s=new Socket("211.238.142.181",3355);
				// 서버로부터 읽어오는 위치 확인 => in
				in=new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				// 서버에 값을 보내는 위치 확인  => out
				out=s.getOutputStream();
			}catch(Exception ex){}
			
			//연결이 되면 => 통신을 시작해라 
			new Thread(this).start();
			tf.setEnabled(true);
			tf.requestFocus();
			b1.setEnabled(false);// 접속 버튼 비활성화 
			
		}
		else if(e.getSource()==tf)// 문자를 입력하고 Enter시 => 입력한 값을 읽어서 서버로 전송 
		{
			try
			{
				// 입력된 문자열을 읽어 온다 
				String msg=tf.getText();
				if(msg.length()<1)
					return;
				// 서버로 전송 
				out.write(("["+name+"] "+msg+"\n").getBytes());
				tf.setText("");
			}catch(Exception ex) {}
		}
	}
	// 서버로부터 들어오는 데이터를 읽어서(실시간) JTextArea에 출력 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				String msg=in.readLine();
				ta.append(msg+"\n");
				bar.setValue(bar.getMaximum());
			}
		}catch(Exception ex){}
	}

}






