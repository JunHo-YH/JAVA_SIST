package com.sist.lib;
/*
 * toString(): ��ü�� ���ڿ��� ��ȯ
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
		System.out.println(a);// toString �ڵ� ȣ��
		System.out.println(b.toString());
	}

}
