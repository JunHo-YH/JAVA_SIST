
/*
 * 13) ����ڷκ��� �� ���� ������ �Է¹��� ������ ���� ���� ������� �����ؼ� �� ����� ����ϴ� ���α׷��� �ۼ��� �� ��.
 *  ���� ��� ����ڷκ��� ������� �Է¹��� �� ���� ������ 1, 2, 3 �̶�� 1 * 2 + 3�� ��� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

 */
import java.util.Scanner;

public class ����13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ ���� �Է�(num1, num2, num3): ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int result = num1 * num2 + num3;
		System.out.println("�����: " + result);

	}

}
