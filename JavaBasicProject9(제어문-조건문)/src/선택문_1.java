/*
 * 		switch(���ǽ�) => ����, ����, ���ڿ�
 * 		switch(avg / 10)
 * 		1) ���ǽ��� ��� => ����, ����
 * 		2) ���� ������ case�� ã�´�.
 * 		3) case�ؿ� �ִ� ������ ����
 * 		4) break;�� �ִ� ��쿡�� switch�� ���� => break�� ���� ��쿡�� �ؿ� �ִ� case�� ����
 * 		***** ������ �������, ���� ���� ����� �� ����.
 * 		***** ������ break;�� ����ϴ� ���� �ƴϴ�.
 * 	
 * 
 * 		page 148
 * 		���ڿ� : JDK1.7�̻� ��밡��
 * 		** char�� �������
 * 		byte < char < int < long < float < double
 * 			  ======
 * 		
 * 		** case�� ���� �ߺ��Ǹ� �ȵȴ�.
 * 
 * 
 * 
 * 		switch(����)
 * 		{
 * 			case 1:
 * 			case 1:
 * 			===========> ����
 * 		}
 */

// ��Ģ����( + - * /)

import java.util.Scanner; // ����ڷκ��� Ű���� �Է°��� �޴´�.
/*
 * 	���α׷� ����
 * 	=========
 * 		����(�迭, Ŭ����)
 * 		������
 * 		���
 * 		==============
 * 			����(�޼��� => ������ + ���)
 * 			�޼��� ���� �� => Ŭ����
 */

public class ���ù�_1 {

	public static void main(String[] args) {
		// ��� ������ => ���׿�����(�ǿ����� 2�� �ʿ�)
		int num1, num2;
		String op;
		// ����ڷκ��� ������ �ޱ�
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� �Է�:");
		num1 = scan.nextInt();
		System.out.print("�ι�° ���� �Է�: ");
		num2 = scan.nextInt();
		
		System.out.println("������ �Է�(+ - * /): ");
		// Scanner => char�� ���� ���ϰ�=> ���ڿ��θ� �޴´� => ���ڿ� �������� String
		op = scan.next();
		char c = op.charAt(0); // ���ڿ����� ù��° ���ڸ� �о�´�.
		
		// ������ó�� => �ܿ��� �� => 5
		switch(c) {
		case '+':
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
			break;
		case '-':
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			break;
		case '*':
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
			break;
		case '/':
			if(num2 == 0)
				System.out.println("0���� ���� �� �����ϴ�.");
			else
				System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			break;
		default:
			System.out.println("�߸��� �������Դϴ�.");
		}

	}

}
