/*
 * 18) ������ �Է¹޾� �������� �ƴ����� �Ǻ��ϴ� ���α׷�( ������ 4�⸶�� �ѹ��� �ְ� 100���� ����������� ������ �ƴ�����, 100���� ����������� �⵵�� 400���� ����������� �⵵�� ����)


 */

import java.util.Scanner;

public class ����18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է�: ");
		int year = scan.nextInt();

		// ���� ���� Ȯ��
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "�⵵�� �����Դϴ�.");
		} else {
			System.out.println(year + "�⵵�� ������ �ƴմϴ�.");
		}
	}

}
