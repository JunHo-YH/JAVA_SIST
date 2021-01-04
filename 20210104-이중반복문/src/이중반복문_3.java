/*
 * *
 * **
 * ***
 * ****
 * *****
 * ...
 * ...
 * n번째 => 사용자가 입력한 정수
 * 
 * 		줄수		별표       i = j => j = i
	   	1		1
		2		2
		3		3
		..
		..
		n		n
		
 */

import java.util.Scanner;

public class 이중반복문_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("몇 줄을 출력하시겠습니까? ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("★");
			}
			System.out.println();
		}

	}

}
