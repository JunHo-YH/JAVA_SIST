package com.sist.main;

class Member {
	private int no;
	private String name;
	private String sex;

	public Member() {
		sex = "����"; // this.sex
	}

	public Member(int no, String name) {
		this(); // �ڽ��� ������ ȣ���� �����ϴ�
		this.no = no;
		this.name = name;
	}

	public Member(int no, String name, String sex) {
		this.no = no;
		this.name = name;
		this.sex = sex;
	}

	public void print() {
		System.out.println("��ȣ:" + no);
		System.out.println("�̸�: " + name);
		System.out.println("����: " + sex);
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.print();
		
		Member m2 = new Member(1, "ȫ�浿");
		m2.print();
		
		Member m3 = new Member(1, "��û��", "����");
		m3.print();
	}

}
