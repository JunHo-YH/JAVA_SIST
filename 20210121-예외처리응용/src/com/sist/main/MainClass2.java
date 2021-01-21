package com.sist.main;

/*
 * 라이브러리 (API): 변경할 수 없다. Framwork: 변경이 가능
 */
/*
 * 객체의 생명주기 A
 * 
 * => 생성 (메모리 저장) ==> 기능 활용(메서드 호출) ===> 메모리 해제
 * 										          a = null => GC
 */
class A {
	public A() {
		System.out.println("A객체 생성");
	}

	public void display() {
		System.out.println("A객체 활용...");
	}

	@Override
	protected void finalize() throws Throwable {
		// 객체가 소멸될 때 자동 호출된다
		System.out.println("A객체 소멸...");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}

public class MainClass2 {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.toString());
		System.out.println(a);
		a.display();
		a = null;
		System.gc();// 멀티미디어
	}

}
