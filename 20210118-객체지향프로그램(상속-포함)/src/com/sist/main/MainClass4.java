package com.sist.main;

class Sawon {
	private int sabun;
	private String name;
	private String dept;

	// ������
	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}

	public String toString() {
		return "���: " + sabun + ", �̸� " + name + ", �μ�: " + dept;
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
		return "�̸�: " + name + ", ����:" + sex;
	}

}

public class MainClass4 {

	public static void main(String[] args) {
		Sawon s = new Sawon(1, "ȫ�浿", "���ߺ�");
		s.toString();
		String res = s.toString();
		System.out.println(res);

		Human h = new Human("��û��", "����");
		h.toString();
		res = h.toString();
		System.out.println(res);

	}

}
