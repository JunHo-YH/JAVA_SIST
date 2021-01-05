
public class 배열생성_1 {

	public static void main(String[] args) {
		// 5개의 값을 설정하고 최대값을 출력하는 프로그램

		
		// 비교해서 최대값을 찾는다.
		
		// 데이터를 모아서 저장
		int[] arr = {80, 85, 75, 88, 90};
		
		/*
		 * arr               arr[0]  arr[1] arr[2] arr[3] arr[4]
		 *                     a       b      c      d      e
		 * =====               =======================================
		 * 100                  80     85   75     88     90
		 * =====               =======================================
		 *               100번지
		 */
		
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
	

}
