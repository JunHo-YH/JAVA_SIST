/*
 * 선택정렬
 * =====
 */
public class 배열활용_3_선택정렬 {

	public static void main(String[] args) {
		int[] arr = { 30, 20, 50, 10, 40 }; // 정렬
		System.out.println("=====정렬 전=====");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] < arr[k]) {
					int tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
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
