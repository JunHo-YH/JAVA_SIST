/*
 * *
 * **
 * ***
 * ****
 * *****
 * ...
 * ...
 * n��° => ����ڰ� �Է��� ����
 * 
 * 		�ټ�		��ǥ       i = j => j = i
	   	1		1
		2		2
		3		3
		..
		..
		n		n
		
 */

import java.util.Scanner;

public class ���߹ݺ���_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���� ����Ͻðڽ��ϱ�? ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("��");
			}
			System.out.println();
		}

	}

}
