package com.sist.solve;

class Tv {
	private String com;
	private int year;
	private int inch;

	Tv(String com, int year, int inch) {
		this.com = com;
		this.year = year;
		this.inch = inch;
	}
	public void show() {
		System.out.println(com + "���� ���� " + year + "��" + inch + "��ġ TV");
	}
}

public class _6 {

	public static void main(String[] args) {
		Tv myTV = new Tv("LG", 2017, 32); // LG���� ���� 2017�� 32��ġ myTV.show();
		myTV.show();
	}

}
