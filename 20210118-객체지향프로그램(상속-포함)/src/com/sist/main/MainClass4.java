package com.sist.main;

class Sawon {
	private int sabun;
	private String name;
	private String dept;

	// 생성자
	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}

	public String toString() {
		return "사번: " + sabun + ", 이름 " + name + ", 부서: " + dept;
	}

}

class Human {
	private String name;
	private String sex;

	public Human(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String toString() {
		return "이름: " + name + ", 성별:" + sex;
	}

}

public class MainClass4 {

	public static void main(String[] args) {
		Sawon s = new Sawon(1, "홍길동", "개발부");
		s.toString();
		String res = s.toString();
		System.out.println(res);

		Human h = new Human("심청이", "여자");
		h.toString();
		res = h.toString();
		System.out.println(res);

	}

}
