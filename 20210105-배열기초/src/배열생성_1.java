
public class �迭����_1 {

	public static void main(String[] args) {
		// 5���� ���� �����ϰ� �ִ밪�� ����ϴ� ���α׷�

		
		// ���ؼ� �ִ밪�� ã�´�.
		
		// �����͸� ��Ƽ� ����
		int[] arr = {80, 85, 75, 88, 90};
		
		/*
		 * arr               arr[0]  arr[1] arr[2] arr[3] arr[4]
		 *                     a       b      c      d      e
		 * =====               =======================================
		 * 100                  80     85   75     88     90
		 * =====               =======================================
		 *               100����
		 */
		
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}
		
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
	}
	

}
