package com.sist.string;

import java.util.Scanner;

/* 서제스트(검색기)를 만들 경우
 * startsWith: 시작하는 문자열이 같은 경우 true
 * 리턴형: boolean
 * 매개변수: 시작하는 문자열 String
 * 원형: public boolean startsWith(String str)
 * 
 * endsWith: 끝나는 문자열이 같은 경우 true
 * 리턴형: boolean
 * 매개변수: 끝 문자열 String
 *  원형: public boolean endsWith(String str)
 *  
 *  contains: 문자열에 포함된 경우: true
 *  리턴형: boolean
 *  매개변수: 포함된 단어 String
 *  원형: public boolean contains(String str)
 */
public class MainClass7 {
	public static void main(String[] args) {
		String[] menu= { "자바와 오라클", "자바프로그래밍", "혼자 배우는 자바", "자바 200제", "오라클과 Ajax", "Jquery and 자바", "HTML5 & CSS3",
				"자바와 파이썬 융합", "스프링5와 제이썬", "자바 기초" };
		Scanner scan = new Scanner(System.in);
//		System.out.print("검색어 입력: ");
//		String find_data = scan.next();
		String find_data = "  자바";
		// 검색어가 포함된 데이터를 보여준다
		for (String s : menu) {
			
			if (s.startsWith(find_data.trim())) {
//			if (s.endsWith(find_data)) {
//			if (s.contains(find_data)) {
				System.out.println(s);
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				}

			}
		}
	}
}
