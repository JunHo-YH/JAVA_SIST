// ������ ���ڿ��� �����Ŀ� a,A�� �� ������ ���θ� Ȯ��

import java.util.Scanner;

public class ����22 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("��� �Է��غ�����: ");
		String s = scan.next();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'A') {
				count++;
			}
		}
		System.out.println("a�� A�� �� ������: " + count + "���Դϴ�.");
	}

}
