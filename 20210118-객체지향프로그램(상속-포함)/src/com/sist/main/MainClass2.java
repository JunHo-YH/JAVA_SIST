package com.sist.main;

class Member {
	private int no;
	private String name;
	private String sex;

	public Member() {
		sex = "남자"; // this.sex
	}

	public Member(int no, String name) {
		this(); // 자신의 생성자 호출이 가능하다
		this.no = no;
		this.name = name;
	}

	public Member(int no, String name, String sex) {
		this.no = no;
		this.name = name;
		this.sex = sex;
	}

	public void print() {
		System.out.println("번호:" + no);
		System.out.println("이름: " + name);
		System.out.println("성별: " + sex);
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.print();
		
		Member m2 = new Member(1, "홍길동");
		m2.print();
		
		Member m3 = new Member(1, "심청이", "여자");
		m3.print();
	}

}
