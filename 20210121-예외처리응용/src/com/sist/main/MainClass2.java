package com.sist.main;

/*
 * ���̺귯�� (API): ������ �� ����. Framwork: ������ ����
 */
/*
 * ��ü�� �����ֱ� A
 * 
 * => ���� (�޸� ����) ==> ��� Ȱ��(�޼��� ȣ��) ===> �޸� ����
 * 										          a = null => GC
 */
class A {
	public A() {
		System.out.println("A��ü ����");
	}

	public void display() {
		System.out.println("A��ü Ȱ��...");
	}

	@Override
	protected void finalize() throws Throwable {
		// ��ü�� �Ҹ�� �� �ڵ� ȣ��ȴ�
		System.out.println("A��ü �Ҹ�...");
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
		System.gc();// ��Ƽ�̵��
	}

}
