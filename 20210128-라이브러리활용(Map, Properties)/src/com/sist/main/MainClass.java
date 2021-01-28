package com.sist.main;

import java.util.HashMap;

/*
 * Map, Properties
 * ===============
 * Map => 두 가지 저장 (key, value): 클래스를 저장, SQL문장 저장, 웹과 관련된 클래스
 * ===
 *  1. 저장 => put()
 *  2. 읽기 => get(key) => value를 얻어온다.
 *  
 *  java.util.*
 *  Map => interface
 *  === HashMap
 */
public class MainClass {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("id", "admin");
		map.put("pwd", 1234);
		map.put("name", "홍길동");
		map.put("sex", "남자"); // 키(중복X), 값(중복O)
		map.put("sex", "여자"); // 키가 중복되면 마지막 값으로 덮어진다.
		
		// 값을 읽어 온다
		System.out.println("ID:" + map.get("id"));
		System.out.println("Password:" + map.get("pwd"));
		System.out.println("name:" + map.get("name"));
		System.out.println("sex:" + map.get("sex")); 
	}

}
