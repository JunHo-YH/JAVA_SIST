package com.sist.string;

public class MainClass {

	public static void main(String[] args) {
		String str = "Hello";
		String s = str.toUpperCase();
		String s1 = str.toLowerCase();
		System.out.println(str);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(str);
		String s2 = str.concat("Java");
		System.out.println(s2);
		System.out.println(str);
	}

}
