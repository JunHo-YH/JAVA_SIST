/*
 * ��������
 * =====
 */
public class �迭Ȱ��_3_�������� {

	public static void main(String[] args) {
		int[] arr = { 30, 20, 50, 10, 40 }; // ����
		System.out.println("=====���� ��=====");
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
		System.out.println("=====���� ���=====");
		for (int i : arr)
			System.out.print(i + " ");

	}

}
