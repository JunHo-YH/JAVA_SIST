/*
 * 17) ���� �ϳ��� �Է¹޾� �빮������ �ҹ��������� �Ǻ��ϴ� ���α׷�
 */

import java.util.Scanner;

public class ����17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��ϼ���: ");
		String s = scan.next();
//		char c = s.charAt(0);
		// s.length() => �Էµ� ������ ����
		/*
		 * 
		 */
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				System.out.println(c + "��(��) �빮���Դϴ� !");
			} else if ( c >= 'a' && c <= 'z') {
				System.out.println(c + "��(��) �ҹ����Դϴ�.");
			} else {
				System.out.println(c + "��(��) ���ĺ��� �ƴմϴ�.");
			}
		}
	}

}
