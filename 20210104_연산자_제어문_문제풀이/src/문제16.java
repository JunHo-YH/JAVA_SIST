import java.util.Scanner;

public class ����16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		System.out.println("=====�޴�=====");
		while (true) {

			System.out.print("��ġ� - 5000��? ");
			a = scan.nextInt();
			System.out.print("�������� - 6000��? ");
			b = scan.nextInt();
			System.out.print("����� - 4000��? ");
			c = scan.nextInt();

			if (a + b + c == 5) {
				int res = (a * 5000) + (b * 6000) + (c * 4000);
				int d = res / 5;
				System.out.println("1�δ� ���ݾ�: " + d + "���Դϴ�.");
				break;
			} else {
				System.out.println("�߸��� �ֹ��Դϴ�.");
				continue;
			}
		}
	}

}
