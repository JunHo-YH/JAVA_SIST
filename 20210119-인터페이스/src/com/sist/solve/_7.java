package com.sist.solve;

import java.util.Scanner;

class Grade {
	private int math;
	private int science;
	private int english;
	
	Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	int average() {
		return (math + science + english) / 3;
	}
}


public class _7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����, ����, ���� ������ 3���� ���� �Է� >>");
		
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		
		Grade me = new Grade(math, science, english);
		System.out.println("�����: " + me.average());
	}

}
