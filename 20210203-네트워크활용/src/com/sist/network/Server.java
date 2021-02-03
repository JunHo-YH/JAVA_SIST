package com.sist.network;
import java.io.*; // 네트워크 입출력 (C/S => Client : 요청 , 응답을 받아서 출력 , Server:요청을 받아서 처리후에 응답)
import java.net.*;
/*
 *   본인 => 서버 
 *          ===
 *          localhost , 127.0.0.1 , 211.238.142.181
 *          ======================  
 */
public class Server implements Runnable{
    // 접속 받는 클래스 
	ServerSocket ss;
	final int PORT=3355;// 0~65535(0~1023) => 화상(30000) , 음성(20000)  
	// 초기화 
	// 한개의 컴퓨타에서는 서버는 반드시 한번만 수행 
	// 여러번 수행도 가능 => PORT를 변경
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);// 컴퓨터 IP는 자동 인식
			/*
			 *    => ip,port
			 *    => 개통 bind(ip,port) => 셋팅 완료 
			 *    => 클라이언트가 접근 대기 => listen()
			 */
			System.out.println("Server Start...");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 클라이언트가 접속시 처리 => 정보 저장 
	public void run()
	{
		while(true)
		{
			try
			{
				Socket s=ss.accept(); // 접속이 된 샹태에서만 호출  ==> 발신자 정보 (ip,port=>Socket)
				System.out.println("Client IP:"+s.getInetAddress().getHostAddress());
				System.out.println("Client PORT:"+s.getPort());
				/*
				 *   서버  =======> port(고정)
				 *   클라이언트 ====> port(가변) => 자동 생성 
				 */
				// 클라이언트 메세지 전송 
				OutputStream out=s.getOutputStream();
				// s=> 클라이언트 
				out.write("안녕하세요!! 서버에 연결되었습니다\n".getBytes());//인코딩
			}catch(Exception ex){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();// server가 가지고 있는 run()을 호출 
	}

}











