package com.sist.main;

// page 375
/*
 * �߻� Ŭ����
 * 1. ����
 *    ���������� Ÿ�� class className {}
 *    ======= ===(final | abstract)
 *    public | default
 *    
 *    public abstract class className {
 *        ==========
 *         ����
 *          =�������
 *          =���뺯��
 *        ==========
 *         �޼���
 *           =========== �Դ´� (��, ��, ����, ���)
 *          = ������ �޼��� ==> ���� O
 *          = ����� �޼��� ==> ���� X
 *            ����� ���� => ������ �ٸ���
 *    }  
 *        Ư¡
 *        ===
 *        1) �ڽ��� �޸��Ҵ��� �� �� ���� (�̿ϼ��� Ŭ����) => new�� ����� �� ����.
 *           abstract class A
 *           A a = new A(); (X)
 *        2) ����� ���� Ŭ�������� �̿ϼ� �޼��带 �����ؼ� ���
 *        3) �߻� Ŭ������ ����
 *        4) ���������� ������ �Ǵ� ��ɸ� ����
 *           �Խ��� (�۾���, ����, ����, ���� ����, ã��)
 *           = �Ϲ� �Խ���
 *           = ����� �Խ���
 *           = ������ �Խ���
 *           = ���� ���ϱ�
 *           = �ڷ��
 * 2. ���ó
 *    = �䱸���� �м� (��ġ��ŷ) => ������ ����
 *      �Ƿ� => �䱸���� �м� => �ʿ��� ������ ���� => UI =>  ����   => �׽���
 *            ===========    ==============   ===    ====     =====
 *              ��Ű����            DBA        �ۺ��� �����α׷���  �׽���  
 *    = ����� ���� => �������°� �������� 
 *      ======== ���α׷��� �°� �����ؼ� ���
 *      ======== �������� ���� Ŭ������ ��Ƽ� ó�� (Ŭ������ ��Ƽ� �� ���� �̸����� ����)
 *      ======== ǥ��ȭ�� �ȴ�. (���̺귯��)
 */
abstract class Print {
	public abstract void list();

	public abstract void detail();
	/////////////////////////////// ������ �����ؼ� ����Ѵ�.

	public void reserve() {
		System.out.println("������ �����մϴ�."); // �ʿ��� Ŭ���������� �����ؼ� ����� ����
	}

}

class ��ȭ extends Print {

	@Override
	public void list() {
		System.out.println("��ȭ ������ ���");

	}

	@Override
	public void detail() {
		System.out.println("��ȭ ���õ����� ���");

	}
	/*
	 * public void reserve() { System.out.println("������ �����մϴ�."); // �ʿ��� Ŭ���������� �����ؼ�
	 * ����� ���� }
	 */

}

class ���� extends Print {

	@Override
	public void list() {
		System.out.println("���� �޴� ��� ���");
	}

	@Override
	public void detail() {
		System.out.println("���� ������ �޴��� ���");
	}

}

class �װ��� extends Print {

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("������ ���� ���̺� ���·� ���");
		/*
		 * class final System {
		 *     static OutputStream out;
		 *     static InputStream in;
		 * }
		 */
	}

	@Override
	public void detail() {
		System.out.println("�ð��� ����Ѵ�.");
	}

	public void reserve() {
		System.out.println("�װ� �ð��� �����մϴ�."); // �ʿ��� Ŭ���������� �����ؼ� ����� ����
	}

}

/*
 * �޼��� {} => ����
 */

public class �߻�Ŭ���� {
/*
 * ���α׷� => ��Ƽ� �� ���� ����
 * �����Ͱ� ���� �� => �迭
 * Ŭ������ ���� �� => �߻�Ŭ����, �������̽� 
 */
	public static void main(String[] args) {
		Print p = new ��ȭ();
		p.list();
		p.detail();
		p.reserve();

		p = new ����();
		p.list();
		p.detail();
		p.reserve();

		p = new �װ���();
		p.list();
		p.detail();
		p.reserve();
	}

}
