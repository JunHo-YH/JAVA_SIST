import java.util.Scanner;

/*
 * ����ó���ϴ� �޼��带 ����� ==> 1���� (�Ű����� O, ������ O)
 *  +
 *  -
 *  *
 *  /
 *  ===> ����ȭ
 *  ȸ������
 *    ����, ���̵� �ߺ�üũ, �����ȣ
 */
public class ��Ģ����޼������� {
	// ���ϱ�
	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	static int mul(int a, int b) {
		return a * b;
	}

	static double div(int a, int b) {
		return (double) a / b;
	}

	public static void main(String[] args) {
		// �޼��� ȣ��
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� �Է�:");
		int a = scan.nextInt();
		System.out.print("�ι�° ���� �Է�:");
		int b = scan.nextInt();
		System.out.print("������ �Է�(+ - * /): ");
		String op = scan.next();

		int c;

		switch (op) {
		case "+":
			c = plus(a, b);
			System.out.printf("%d + %d = %d\n", a, b, c);
			break;
		case "-":
			c = minus(a, b);
			System.out.printf("%d - %d = %d\n", a, b, c);
			break;
		case "*":
			c = mul(a, b);
			System.out.printf("%d * %d = %d\n", a, b, c);
			break;
		case "/":
			if (b == 0)
				System.out.println("0���� ���� �� �����ϴ�.");
			else {
				double d = div(a,b);
				System.out.printf("%d / %d = %.2f\n", a, b, d);
			}
			break;
		default:
			System.out.println("�߸��� �������Դϴ�.");
		}

	}

}
