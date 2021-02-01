package com.sist.io;

import java.util.*;
import java.io.*;

public class MainClass4 {

	public static void main(String[] args) {
		try {
			String msg = "(서울=뉴스1) 김태환 기자,음상준 기자,이영성 기자 = 신종 코로나바이러스 감염증(코로나19) 지역발생 확진자가 70일 만에 200명대로 떨어졌다. 주말 진단검사 감소 효과가 반영됐지만 앞선 '월요일' 확진자 수치와 비교해도 눈에 띄게 감소했다. 최근 코로나19 재확산에 대한 우려가 커졌으나 IM선교회 등 일부 집단감염 발생에 따른 일시적인 현상일 가능성도 제기된다.";
			FileOutputStream fos = new FileOutputStream("c:\\javaDev\\student.txt");
			fos.write(msg.getBytes());
			fos.close();
			System.out.println("첫번째 파일 저장 완료!!");
			/*
				fos = new FileOutputStream("c:\\javaDev\\student.txt", true);
				fos.write("안녕하세요".getBytes());
				fos.close();
				System.out.println("두번째 파일 저장 완료!!");
			*/
			// 파일 읽기
			FileInputStream fis = new FileInputStream("c:\\javaDev\\student.txt");
			int i = 0;
			while((i = fis.read())!=-1) {
				System.out.print((char)i);
			}
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
