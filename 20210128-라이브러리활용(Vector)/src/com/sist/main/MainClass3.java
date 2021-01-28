package com.sist.main;

/*
 * LinkedList
 * 
 * List로부터 상속
 * public class LinkedList implements List
 * 
 * => class, interface(class)(다중)
 *           클래스를 확장 => 상위 클래스
 *           
 * 추가 => add()
 * 읽기 => get()
 * 삭제 => remove()
 * 수정 => set()
 * 갯수: size()
 */
import java.util.*;

public class MainClass3 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// 데이터 추가
		list.add("사과");
		list.add("배");
		list.add("포도");
		list.add("오렌지");
		list.add("수박");
		list.add("감");

		// 출력
		for (int i = 0; i < list.size(); i++) {
			String s = (String) list.get(i);
			System.out.println(s);
		}

		System.out.println("============= 데이터 수정 ============");
		list.set(5, "귤");
		for (int i = 0; i < list.size(); i++) {
			String s = (String) list.get(i);
			System.out.println(s);
		}

		System.out.println("============= 데이터 부분 삭제 ============");
		list.remove(5);
		for (int i = 0; i < list.size(); i++) {
			String s = (String) list.get(i);
			System.out.println(s);
		}
		System.out.println("============= 데이터 전체 삭제 ============");
		list.clear();
		System.out.println("갯수 확인:" + list.size());
		

	}

}
