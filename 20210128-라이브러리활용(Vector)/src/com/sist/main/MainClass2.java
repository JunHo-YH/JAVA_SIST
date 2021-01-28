package com.sist.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
/*
 * T = Type          ArrayList<Integer>
 * E = Element       Vector<String>
 * K = Key           Map<String, Integer>
 * V = Value
 * 
 * 프로그램 (데이터를 모아서 관리)
 *         ==========
 *         같은 것끼리 != 관련된 것
 */
public class MainClass2 {

	public static void main(String[] args) {
		Vector vec = new Vector();
		// 추가 => Object
		// 영화 장르
		
		vec.add("액션	");
		vec.add("드라마");
		vec.add("멜로");
		vec.add("코미디");
		vec.add("판타지");
		vec.add("SF");
		vec.add("애니메이션");
		vec.add("멜로");
		vec.add("코미디");
		vec.add("판타지");
		
		HashSet set = new HashSet();
		for (int i = 0; i < vec.size(); i++) {
			String genre = (String)vec.get(i);
			set.add(genre);
			
		}
		System.out.println(set); // 중복X 
		
		
		/*
		System.out.println("============ 저장된 장르 ================");
		//출력
		for(int i = 0; i < vec.size(); i++) {
//			String genre = (String)vec.elementAt(i); // 값 가져오기
			String genre = (String)vec.get(i);
			System.out.println(genre);
		}
		
		// 수정
		System.out.println("============ 데이터 수정 ================");
		vec.setElementAt("공포", 9); // setElementAt == vec.set()
		for(int i = 0; i < vec.size(); i++) {
//			String genre = (String)vec.elementAt(i); // 값 가져오기
			String genre = (String)vec.get(i);
			System.out.println(genre);
		}
		
		// 삭제
		System.out.println("============ 데이터 삭제 ================");
		vec.removeElement(8);
		for(int i = 0; i < vec.size(); i++) {
//			String genre = (String)vec.elementAt(i); // 값 가져오기
			String genre = (String)vec.get(i);
			System.out.println(genre);
		}
		
		System.out.println("============ 전체 삭제 ================");
		System.out.println("갯수:" + vec.size());
		vec.removeAllElements(); // removeAllElements == clear()
		System.out.println("갯수:" + vec.size());
		*/
		
		
	}

}
