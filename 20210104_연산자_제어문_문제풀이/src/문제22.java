// ������ ���ڿ��� �����Ŀ� a,A�� �� ������ ���θ� Ȯ��

import java.util.Scanner;

public class ����22 {

	public static void main(String[] args) {

		while (true) {
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
			if (count == 0) {
				System.out.println("a�� A�� ���ԵǴ� ���ڰ� �����ϴ�. �ٽ� �Է��ϼ���");
				continue;
			} else {
				System.out.println("a�� A�� �� ������: " + count + "���Դϴ�.");
			}
		}
	}

}
