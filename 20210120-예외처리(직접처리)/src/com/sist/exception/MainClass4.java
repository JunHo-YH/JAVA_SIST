package com.sist.exception;
/*
 * 에러 메세지 확인
 * getMessage(): 에러 메세지
 * printStackTrace(): 
 */
public class MainClass4 {

	public static void main(String[] args) {
		
		try {
			System.out.println("연산처리");
			System.out.println(10 / 0);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		System.out.println("프로그램 종료");
		
		
	}

}
