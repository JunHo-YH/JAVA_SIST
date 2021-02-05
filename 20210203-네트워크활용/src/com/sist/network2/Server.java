package com.sist.network2;
import java.io.*;// 네트워크(클라이언트와 서버의 입출력) 전송:OutputStream , 수신:BufferedReader
import java.net.*;// ServerSocket(접속을 받은 경우) , Socket(클라이언트 정보)=>IP,PORT(자동지정=중복없이)
import java.util.*;// Collection(클라이언트의 정보를 저장=>동기화 => Vector)
/*
 *    자바
 *    ***오라클 
 *    ====== 자바+오라클 (JDBC)
 *    HTML
 *    CSS
 *    JavaScript => Jquery , VueJs 
 *    =========== (자바: 디자인패턴 , XML ,ANNOTATION)
 *    JSP 
 *    =========== 자바+오라클 +HTML
 *    MVC 
 *    ***Spring
 *    ============================================
 *    
 *    Collection : 자료구조 (메모리에 저장하고 관리 => CURD) => 표준화 
 *    ===========
 *       List : 순서를 가지고 있다(인덱스번호) , 데이터를 중복해서 저장이 가능 
 *              **ArrayList : Vector를 보완한 클래스 (비동기화) => 데이터베이스 프로그램 (웹,ERP)
 *              **Vector : 동기화 => 네트워크 (게임,모바일)
 *              LinkedList : C언어 호환 
 *              Stack => coding test
 *       Set : 순서가 없다 , 데이터 중복(X)
 *             HashSet
 *       Map : 두개 저장(키,값) => 키를 가지고 값을 찾는다 
 *             키는 중복이 없다 , 값은 중복이 가능 
 *             => 웹 (session,cookie, request, response) => Spring,Mybatis (Map)
 */
public class Server implements Runnable{
    private Vector<Client> waitVc=new Vector<Client>();// 클라이언트 정보를 저장 
    private ServerSocket ss;
    private final int PORT=3355;
    /*
     *   역할 분담 
     *     = 접속만 담당 
     *     = 각 클라이언트마다 통신 담당
     *       ========== 쓰레드 => 내부클래스 
     */
    //1. 서버 가동
    public Server() 
    {
    	try
    	{
    		ss=new ServerSocket(PORT);// bind():개통,listen():대기상태 
    		System.out.println("Server Start...");
    	}catch(Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    }
    /*
     *    동작 
     *     1. 서버 가동 
     *     2. 접속시 처리 
     *        => 메모리에 저장(클라이언트의 정보를 저장)
     *        => 클라이언트와 통신 명령 
     */
    // 2. 접속시에 처리 => 클라이언트를 Vector에 저장 
    public void run()
    {
    	try
    	{
    		while(true)
    		{
    			Socket s=ss.accept();// 발신자 정보(ip+port=Socket)를 가지고 온다 
    			// 쓰레드와 통신이 가능하게 => 쓰레드 생성 => 해당 클라이언트의 Socket을 넘겨준다 
    			Client client=new Client(s); // 쓰레드마다 클라이언트를 담당한다
    			waitVc.add(client);// 클라이언트 정보를 저장 
    			client.start();// 클라이언트와 통신을 시작한다 
    		}
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();// 서버 가동 
        new Thread(server).start();// 접속시 처리 
	}
	// 통신을 담당하는 클래스 
	class Client extends Thread
	{
		// 각 클라이언트 마다 통신을 담당 
		//1. 클라이언트의 정보 (ip,port=>Socket)
		Socket s;
		//2. 클라이언트와 통신하기 위해서는 IO(입출력)
		BufferedReader in;// 클라이언트의 요청값을 받는 경우
		OutputStream out;// 요청 처리후에 응답할 때 사용 
		
		// 생성자를 이용해서 => Server클래스로 부터 Socket(ip)
		public Client(Socket s)
		{
			try
			{
				this.s=s;// s=클라이언트 
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			}catch(Exception ex) {}
		}
		// 통신 내용 
		public void run()
		{
			try
			{
				while(true)
				{
					// 사용자의 요청 내용을 받는다 
					String msg=in.readLine();
					messageAll(msg);
				}
			}catch(Exception ex){}
		}
		// 메세지 전송 메소드 
		//1. 개인적으로 전송 => 쪽지보내기,귓속말 
		/*
		 * transient String name; => name은 제외
		 * synchronized => 동기화
		 * => 쓰레드의 default (비동기화)
		 * 
		 *    sync function aaa(){}
		 *    async function bbb(){}
		 *    ajax => 실시간 
		 */
		
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex){}
		}
		//2. 전체적으로 전송 => 채팅 
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client client:waitVc)
				{
					client.messageTo(msg);
				}
			}catch(Exception ex){}
		}
	}

}







