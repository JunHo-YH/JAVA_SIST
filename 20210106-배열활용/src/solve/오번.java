package solve;

import java.util.Scanner;

public class 오번 {

	public static void main(String[] args) {
		// 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int i;
		for (i = 0; i < 10; i++) {
//			System.out.println("정수입력: ");
			int num = (int)(Math.random() * 100) + 1;
			arr[i] = num;

		}
		System.out.print("3의 배수: ");
		for (i = 0; i < 10; i++) {

			if (arr[i] % 3 == 0) {
//				System.out.println("3의 배수: " + arr[i]);
				System.out.print(arr[i] + " ");
			}

		}
	}

}
