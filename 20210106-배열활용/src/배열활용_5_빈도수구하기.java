// 빈도수 구하기
// word cloud
/*
 * 정수: 0 ~ 9 사이의 난수 ==> 100개 발생
 */
public class 배열활용_5_빈도수구하기 {

	public static void main(String[] args) {
		// 100개를 저장할 수 있는 저장 공간 생성
		int[] arr = new int[100];
		int[] count = new int[10];

		// 값을 입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}

		// 빈도수 확인
		for (int i : arr) {
			count[i]++;
		}
		// 출력
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println("\n======최종결과======");
		for (int i = 0; i < count.length; i++) {
			System.out.println(i + ": " + count[i]);
		}

		System.out.println("===== 추천 =====");
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i])
				max = count[i];
		}
		for (int i = 0; i < count.length; i++) {
			if (max == count[i])
				System.out.println(i + ":" + count[i]);

		}

	}

}
