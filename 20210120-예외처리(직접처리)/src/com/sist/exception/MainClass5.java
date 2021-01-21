package com.sist.exception;

public class MainClass5 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 20, 0, 10, 20, 30, 40, 50 };
		int a = 100;
		try {
			for (int b : arr) {
//				try {
				System.out.println(a / b);
//				}catch(Exception e) {
//					System.out.println("0----");
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
