package com.sist.exception;
/*
 * ���� �޼��� Ȯ��
 * getMessage(): ���� �޼���
 * printStackTrace(): 
 */
public class MainClass4 {

	public static void main(String[] args) {
		
		try {
			System.out.println("����ó��");
			System.out.println(10 / 0);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		System.out.println("���α׷� ����");
		
		
	}

}
