package com.sist.network;
import java.net.*;
import java.io.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Socket s=new Socket("localhost",3355);
        	BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        	// s=서버
        	String msg=in.readLine();
        	System.out.println(msg);
        }catch(Exception ex) {}
	}

}
