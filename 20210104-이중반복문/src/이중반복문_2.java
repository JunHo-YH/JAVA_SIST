/*
 * 1###
 * #2##
 * ##3#
 * ###4
 * =====
 * 세로: 4줄 => for (int i = 1; i <= 4; i++) => 1차 for문
 * 가로: 4개 => for (int k = 1; k <= 4; k++) => 2차 for문
 * 
 * 
 * #234
 * 1#34
 * 12#4
 * 123#
 */
public class 이중반복문_2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 4; k++) {
				if (i == k) {
					System.out.print(i);
				} else {
					System.out.print("#");
				}
			}
			// 다음줄에 출력
			System.out.println();
		}

		System.out.println();

		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 4; k++) {
				if (i == k) {
					System.out.print("#");
				} else {
					System.out.print(k);

				}
			}
			System.out.println();
		}
	}

}
