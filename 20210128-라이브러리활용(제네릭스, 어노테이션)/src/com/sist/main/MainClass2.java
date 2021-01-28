package com.sist.main;

import java.util.ArrayList;

class A {
	
}
public class MainClass2 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		// 저장
		list.add("홍길동");
		list.add("이순신");
		
		// 값 읽기
		String name1 = list.get(0);
		String name2 = list.get(1);
		
		System.out.println(name1);
		System.out.println(name2);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		
		ArrayList<A> list5 = new ArrayList<A>();
		
		
	}

}
