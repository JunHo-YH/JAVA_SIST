package solve;

import java.util.Scanner;

public class ���������� {

	public static void main(String[] args) {
		String[] course = { "Java", "C++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�" };
		int[] score = { 95, 88, 76, 62, 55 };
		String subject;
		int i = 0;

		while (true) {
//			boolean bCheck = false;
			Scanner scan = new Scanner(System.in);
			System.out.println("������ �˰� ���� ������ �Է��ϼ���: (java, c++, HTML5, ��ǻ�ͱ���, �ȵ���̵�)");
			subject = scan.next();

			if (subject.equals("�׸�")) {
				System.out.println("���α׷��� ����ƽ��ϴ�.");
				break;
			}

			for (i = 0; i < course.length; i++) {
				if (course[i].equalsIgnoreCase(subject)) {
//					bCheck = true;
					System.out.print(course[i] + "�� ������: " + score[i] + "���Դϴ�.");
					System.out.println();
					break;
				}
			}
//			if(bCheck == false)
			if (i == course.length) {
				System.out.print("���� �����Դϴ�.");
				System.out.println();
			}

		}

	}

}
