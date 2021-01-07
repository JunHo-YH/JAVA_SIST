// 숫자 야구게임
/*
 * UP DOWN
 * =======
 *     369 => 123 => 0S_1B
 *         => 345 => 1S_0B
 *         => 396 => 1S_2B
 *         => 369 => 3S-0B => GAME Over !!
 */
package solve;

public class 배열활용_10 {

	public static void main(String[] args) {
		int[] arr = new int[10];

		// 난수를 저장하는 변수
		int su = 0;

		// 중복여부를 확인하는 변수
		boolean bCheck;

		for (int i = 0; i < arr.length; i++) {
			bCheck = true;
			while (bCheck) {
				// 난수 발생 => 비교 (중복여부 확인)
				su = (int) (Math.random() * 10) + 1;
				bCheck = false;
				
				for (int k = 0; k < i; k++) {
					if (arr[k] == su) {
						bCheck = true;
						break; // break & continue ==> 자신의 반복문만 제어
					}
				}
			}
			arr[i] = su;
		}

		// 출력

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
