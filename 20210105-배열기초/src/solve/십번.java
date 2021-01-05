/*
 * ����(ASC/DESC)
 * ASC: �ø�����
 * DESC: ��������
 * ==> ���� ó��
 * 		= ���� ����
 * 			31 55 85 63 96 => 96 85 63 55 31
 * 		= ���� ����
 */

package solve;

import java.util.Scanner;

public class �ʹ� {

	public static void main(String[] args) {

		int tmp = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("�� �ڸ� �迭�� ������? ");
		int n = scan.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 50) + 10;
		}
		System.out.println();
		System.out.print("(���� ��)������� �迭: ");

		for (int i : arr) {
			System.out.print(i + " ");
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] > arr[k]) {
					tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}

		System.out.println();
		System.out.print("(���� ��)������� �迭: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
