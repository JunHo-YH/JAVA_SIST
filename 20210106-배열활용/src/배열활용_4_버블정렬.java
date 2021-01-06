/*
 * 	버블정렬: 인접한 수끼리 비교해서 변경
 * 	30
 */
public class 배열활용_4_버블정렬 {

	public static void main(String[] args) {
		int[] arr = { 30, 20, 50, 10, 40 }; // 정렬

		System.out.println("=====정렬 전=====");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = 0; k < arr.length - 1 - i; k++) {
				if (arr[k] > arr[k + 1]) {
					int tmp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = tmp;
				}
				for (int p : arr) {
					System.out.print(p + " ");
				}
				System.out.println();
			}
			System.out.println("=====" + (i + 1) + " Round End=====");
		}

		System.out.println("=====최종 결과=====");
		for (int i : arr)
			System.out.print(i + " ");
	}

}
