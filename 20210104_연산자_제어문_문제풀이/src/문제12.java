
/*
 * 12) ����ڷκ��� �� ���� ������ �Է� �޾Ƽ� ������ ���� ������ ����� ����ϴ� ���α׷��� �ۼ�
 */
import java.util.Scanner;

public class ����12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���� ������ �Է�( num1, num2) ");

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
	}

}
