package com.sist.exception;

public class MainClass2 {

	public static void main(String[] args) {
		System.out.println("1�� ����");
		System.out.println("2�� ����"); // ���� ����
		try {
			System.out.println("3�� ����");
			System.out.println(10 / 0); // �����߻� ==> catch�� �̵�
			System.out.println("5�� ����"); // ������ �߻����� ������ catch�� �ǳʶڴ�.
			
			// �������� ������ �� �ִ� ���� => ���� ������ �߻��ϸ� ó���ϴ� ���� => catch
		}catch (Exception ex) {
			System.out.println("6�� ����"); // ���� ���� ��ġ => catch�� ������ ����� ����
			// ������ ������ ��ŭ ����� ����
		}
		System.out.println("7�� ����");
		
	}

}
