package com.sist.lib;

class B {
	String name;
	String addr;

	public B(String name) {
		this.name = name;
	}

//		@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof B)
//			return name.equals(((B)obj).name);
//		else
//			return false;
//	}

}

public class MainClass4 {

	public static void main(String[] args) {
		String s = "Hello";
		boolean bo = s.equals("Hello");
		boolean boo = s.equals("hello");
		
		B b1 = new B("ȫ�浿");
		B b2 = new B("ȫ�浿");
		B b3 = b1;

		if (b1.equals(b2)) {
			System.out.println("b1�� b2�� �ּҰ��� ����.");
		} else {
			System.out.println("b1�� b2�� �ּҰ��� �ٸ���");
		}

		if (b1 == b3) {
			System.out.println("b1�� b3�� �ּҰ��� ����.");
		} else {
			System.out.println("b1�� b3�� �ּҰ��� �ٸ���");
		}
	}

}
