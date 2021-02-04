package com.sist.server;
/*
 *     서버
 *     class Server
 *     {
 *         접속자를 저장 (변수) => Server , Client => 공유
 *         ==> 저장 
 *         class Client
 *         {
 *            ==> 퇴장 (제거) ==> 여러개 데이터 , 메소드를 동시에 공유 (쓰레드)
 *         }
 *     }
 *     
 *     공유 : 내부 클래스 , static (저장 공간 1)
 *     
 *     class Server
 *     {
 *         static Vector waitvc=new Vector();
 *     }
 *     class Client
 *     {
 *     }
 *     
 *     class DAO
 *     {
 *        Connection conn;
 *        Statement stmt;
 *     }
 */
import java.net.*;
import java.io.*;
import java.util.*;

import com.sist.common.Function;
// LOGIN => id,대화명,성별  ==> 로그인 버튼 클릭 => 100|id|대화명|성별 ==> Server (StringTokenizer)
public class Server implements Runnable{
    // 접속을 담당 
	private ServerSocket ss;
	private Vector<Client> waitVc=new Vector<Client>();// 접속자 정보 저장 (동기화)
	public Server()
	{
		try
		{
			ss=new ServerSocket(3355); // 접속자가 50명 , ServerSocket(3355,1000)
			// ss.bind("localhost",3355) => 개통
			// ip(전화번호), port(연결선)
			// 대기 => listen() 
			/*
			 *    class ServerSocket
			 *    {
			 *        public ServerSocket(int port)
			 *        {
			 *            this.bind("localhost",port);
			 *            this.listen();
			 *        }
			 *    }
			 */
			System.out.println("Server Start...");
		}catch(Exception ex){}
	}
	// 클라이언트가 접속시마다 처리 
	/*
	 *    클라이언트 접속을 하면 => 클라이언트 정보(IP,PORT=>SCOKET) 받아서 쓰레드에 전송 
	 *                                                           ======
	 *                                                           전송받은 클라이언트와 통신 
	 *                      => 정보를 저장 
	 *                      
	 *    while(true)
	 *    {
	 *        ss=getClient();
	 *        System.out.println(ss);
	 *    }
	 */
	public void run()
	{
		// 접속시 처리 
		try
		{
			while(true) // 서버 종료시까지 접속을 받는다 
			{
				Socket s=ss.accept(); // 멈춤 (특수한 메소드) => 조건 (클라이언트가 접속시에만 호출이 가능) => 대기
				// 접속 (핸드폰 => 발신자정보(이름,전화번호)) => IP,PORT(IP+PORT=Socket)
				// 한명이 여러개 실행 => IP동일 ,PORT 다르다 
				// 각자 통신 => 쓰레드를 생성 
				// ======= 쓰레드가 IP를 가지고 있어야 한다 
				Client client=new Client(s);
				// 통신을 시작한다 
				client.start();
				// 저장을 하지 않는다 
				/*
				 *   통신 기능  
				 *     1. 로그인 처리 
				 *     2. 채팅 처리
				 *     3. 쪽지 보내기 
				 *     4. 나가기 
				 */
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	
	// 통신만 담당하는 클래스 => 접속자마다 따로 생성 => 여러개가 동시에 동작 (쓰레드)
	class Client extends Thread
	{
		// 클라이언트의 모든 정보를 가지고 있다 
		// ip,port
		Socket s;
		// 클라이언트와 입출력 (저장 공간 확인)
		OutputStream out;
		BufferedReader in;
		// 일반 변수 
		String id,name,sex;
		// 소켓을 받아 온다 
		// Client client=new Client(s);
		public Client(Socket s)
		{
			try
			{
				this.s=s; // 나가기 => Socket을 닫는다  s.close()
				// 위치 확인 => 클라이언트가 데이터를 읽어가는 위치 ==> out
				out=s.getOutputStream();
				//            클라이언트로부터 데이터를 읽어오는 위치 ==> in
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 서버 => 클라이언트 
				// 클라이언트 => 서버
			}catch(Exception ex) {}
		}
		// 통신 처리 
		public void run()
		{
			try
			{
				while(true)
				{
					// 클라이언트로부터 요청값 받기 
					String msg=in.readLine(); // 100|id|name|sex
					System.out.println("Client=>"+msg);// 서버 디버깅 
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
					// 로그인 처리   id|name|sex
					   case Function.LOGIN://100
					   {
						   // 변수값 저장 
						   id=st.nextToken();
						   name=st.nextToken();
						   sex=st.nextToken();
						   
						   // 현재 접속중인 사람에게 전송 
						   messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex);
						   
						   // waitVc에 저장
						   waitVc.add(this);
						   
						   // 현재 접속중인 사람들의 정보 읽어온다 (접속한 사람에게 보낸다)
						   messageTo(Function.MYLOG+"|"+name);
						   for(Client client:waitVc)
						   {
							   messageTo(Function.LOGIN+"|"+client.id+"|"+client.name+"|"+client.sex);
						   }
						   messageAll(Function.CHAT+"|[알림 ☞] "+name+"님이 입장하셨습니다|red");
						   
					   }
					   break;
					   case Function.SENDMESSAGE://200  200|sid|rid|messge
					   {
						   String strMsg=st.nextToken();
						   String youId=st.nextToken();
						   
						   for(Client client:waitVc)
						   {
							   if(youId.equals(client.id))
							   {
								   client.messageTo(Function.SENDMESSAGE+"|"+id+"|"+strMsg);
								   break;
							   }
						   }
					   }
					   break;
					   case Function.CHAT://300  300|message
					   {
						  String strMsg=st.nextToken();
						  String color=st.nextToken();
						  
						  // 접속한 모든 사람에게 보낸다 
						  messageAll(Function.CHAT+"|["+name+"]"+strMsg+"|"+color);
					   }
					   break;
					   case Function.EXIT:
					   {
						   // 1. 접속된 모든 사람에게 나간다는 메세지 전송 
						   for(Client client:waitVc)// 접속한 사람의 정보 : waitVc
						   {
							   // id => 나가는 사람 => this
							   if(!id.equals(client.id))
							   {
								   client.messageTo(Function.CHAT+"|[알림 ☞] "+name+"님이 퇴장하셨습니다|red");
								   client.messageTo(Function.EXIT+"|"+id);//테이블에 출력된 명단에 제거
							   }
						   }
						   // => 남아 있는 사람 , 나가는 사람 처리 
						   for(int i=0;i<waitVc.size();i++)
						   {
							   Client client=waitVc.get(i);
							   if(id.equals(client.id))
							   {
								   // 윈도우 종료해라 
								   messageTo(Function.MYEXIT+"|");
								   // waitVc에서 제거 
								   waitVc.remove(i);
								   // in,out.close()
								   in.close();
								   out.close();
								   break;// 종료 
							   }
						   }
					   }
					   break;
					}
					
				}
			}catch(Exception ex){}
		}
		// 동일한 기능 
		// 한사람에게 전송
		public void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex){}
		}
		// 접속자 모두에게 보내는 기능 
		public void messageAll(String msg)
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
/*
 *     서버 프로그램
 *       = 접속시 처리 (클래스) : 교환소켓 (메니저) => 클라이언트 정보(ip,port) 저장 
 *       = 각 클라이언트마다 통신을 담당 (쓰레드) => 저장된 클라이언트 정보를 사용
 *         ==========
 *          여러개를 동시에 실행 
 *          *** 두개이상의 클래스에서 같은 데이터를 공유할 경우 : static,멤버클래스(내부클래스)
 *                                                            =================
 *                                                            모든 내용(변수,메소드) 공유
 *          *** 내부 클래스 : 하둡(데이터를 수집,분석,공유)
 *                             ========== === MapReduce (채봇)
 *                             
 *       = 한개의 프로그램안에서 여러개 메소드가 동시 실행 => 쓰레드 (실시간 구현) : 금융권 , 증권 , 예매
 *       = 네트워크 : 클라이언트 , 서버 
 *         서버 
 *          1) 요청 받기 => readLine() => Decodingm => InputStreamReader()(필터스트림)
 *          2) 요청 처리 , 찾기 => get() => Collection (Vector,ArrayList)
 *          3) 삭제 (remove()) , 추가 (add()) 
 *          4) 전송 => write => Encoding => getBytes()
 *         클라이언트 
 *          1) 요청 => write()
 *          2) 결과 받기 => readLine()
 *          3) 결과 출력 => 윈도우,브라우저 
 *         *** 웹 , 오라클 => TCP를 이용하는 프로그램 
 *            ========== 처리과정,결과값 추출 
 */
















