package solve;

import java.util.Scanner;

public class ���� {

	public static void main(String[] args) {
		// ���� ���� 10�� �Է¹޾� �迭�� �����ϰ�, �迭�� �ִ� ���� �߿��� 3�� ����� ����ϴ� ���α׷��� �ۼ��϶�
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int i;
		for (i = 0; i < 10; i++) {
//			System.out.println("�����Է�: ");
			int num = (int)(Math.random() * 100) + 1;
			arr[i] = num;

		}
		System.out.print("3�� ���: ");
		for (i = 0; i < 10; i++) {

			if (arr[i] % 3 == 0) {
//				System.out.println("3�� ���: " + arr[i]);
				System.out.print(arr[i] + " ");
			}

		}
	}

}
