// ���� (4Ģ����)
// ���� => ���� 2��, ������ 1��
// �Է� Scanner

import java.util.Scanner;

public class �������ǹ�_2 {

	public static void main(String[] args) {
		// ���� ���� �����
		int num1 ,num2;
		char op; // ������ => +,-,*,/
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� �Է�: ");
		num1 = scan.nextInt();
		
		System.out.print("�ι�° ���� �Է�: ");
		num2 = scan.nextInt();
		
		System.out.print("�����ڸ� �Է�(+,-,*,/): ");
		String s = scan.next();
		op = s.charAt(0);
		
		// ��Ģ���� ó��
		if(op == '+') {
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		}
		else if(op == '-') {
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		}
		else if(op == '*') {
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		}
		else if(op == '/') {
			if(num2 == 0)
				System.out.println("0���� ���� �� �����ϴ�.");
			else
				System.out.printf("%d / %d = %.2f\n", num1, num2, num1 / (float)num2);
		}
		else {
			System.out.println("�����ڸ� �߸� �Է��ϼ̽��ϴ�.");
		}
	}

}
