/*
 * 정렬(ASC/DESC)
 * ASC: 올림차순
 * DESC: 내림차순
 * ==> 정렬 처리
 * 		= 선택 정렬
 * 			31 55 85 63 96 => 96 85 63 55 31
 * 		= 버블 정렬
 */

package solve;

import java.util.Scanner;

public class 십번 {

	public static void main(String[] args) {

		int tmp = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("몇 자리 배열을 만들까요? ");
		int n = scan.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 50) + 10;
		}
		System.out.println();
		System.out.print("(정렬 전)만들어진 배열: ");

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
		System.out.print("(정렬 후)만들어진 배열: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
