package com.sist.lib;
/*
 * toString(): 객체를 문자열로 변환
 */

class A {
	int a = 100;
	// toString, clone, equals 
	public String toString() {
		return "Hello";
	}

}

public class MainClass3 {

	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		System.out.println(a);// toString 자동 호출
		System.out.println(b.toString());
	}

}
