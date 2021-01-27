package com.sist.main;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// 이름을 저장(여러 개) String[] names = new String[10];
		// 저장할 메모리 공간 생성
		ArrayList nameList = new ArrayList(); // Object 저장 공간 => 여러가지 데이터를 섞을 수 있다.
		//Vector nameList = new Vector();
		//LinkedList nameList = new LinkedList();
		//Stack nameList = new Stack();
		// Object name = "홍길동"; ==> "홍길동" => new String("홍길동");
		// 저장
		nameList.add("홍길동"); // 0
		nameList.add("심청이"); // 1
		nameList.add("이순신"); // 2
		nameList.add("강감찬"); // 3
		nameList.add("박문수"); // 4

		for (Object name : nameList) {
			System.out.println(name);
		}
		System.out.println("현재 저장된 이들:" + nameList.size());

		// 원하는 위치 데이터를 출력
		nameList.add(2, "호미걸이");
		
		for (int i = 0; i < nameList.size(); i++) {
			Object obj = nameList.get(i);
			System.out.println(i + ":" + obj);
		}
		
		nameList.set(2, "춘향이");
		
		for (int i = 0; i < nameList.size(); i++) {
			Object obj = nameList.get(i);
			System.out.println(obj);
			System.out.println(i + ":" + obj);
		}
		nameList.remove(2);

		for (int i = 0; i < nameList.size(); i++) {
			Object obj = nameList.get(i);
			System.out.println(obj);
			System.out.println(i + ":" + obj);
		}
		System.out.println("전체 삭제");
		nameList.clear();
		System.out.println("저장된 이름" + nameList.size());
	}

}
