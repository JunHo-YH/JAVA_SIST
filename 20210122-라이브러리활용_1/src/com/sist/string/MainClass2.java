package com.sist.string;

/*
 * String �޼���
 * int length()
 * char charAt(int no)
 */
import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {
		/*
		 * Scanner scan = new Scanner(System.in); System.out.println("���ڿ� �Է�"); String
		 * msg = scan.next(); System.out.println("msg=" + msg);
		 * System.out.println("���� ����: " + msg.length());
		 */
		// ���ڿ��� �¿� ��Ī����? => Google
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ� �Է�: ");
//		String msg = scan.next();
//		for (int i = msg.length() - 1; i >= 0; i--) {
//			System.out.print(msg.charAt(i));
//		}

		String msg = "";
		while (true) {
			System.out.print("���ڿ� �Է�: ");
			msg = scan.next();
			if (msg.length() % 2 != 0) {
				System.out.println("¦������ ���ڰ� �ʿ��մϴ�.");
				// while ó������ �̵�
				continue;
			}
			break; // while�� ����
		}

		// ���� => ������ => {}

		boolean bCheck = true;
		for (int i = 0; i < msg.length() / 2; i++) {
			char s = msg.charAt(i);
			char e = msg.charAt(msg.length() - 1 - i);
			if (s != e) {
				bCheck = false;
				break;
			}
		}

		// �����
		if (bCheck) {
			System.out.println("�¿� ��Ī�Դϴ�.");
		} else {
			System.out.println("�¿� ��Ī�� �ƴմϴ�.");
		}

		// if�� ��� ���� => ���� ó��
	}

}
