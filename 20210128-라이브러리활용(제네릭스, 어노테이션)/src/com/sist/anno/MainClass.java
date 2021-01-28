package com.sist.anno;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("화면 선택:");
		String page = scan.next();
		
		MovieSystem ms = new MovieSystem();
		ms.movie(page);
		
		
		
		/*
		if(page.equals("홈")) {
			m.moiveHome();
		} else if (page.equals("목록")) {
			m.moiveList();
		} else if(page.equals("상세")) {
			m.moiveDetail();
		} else if(page.equals("예매")) {
			m.moiveReserve();
		} else if(page.equals("찾기")) {
			m.moiveFind();
		}
		*/
	}

}
