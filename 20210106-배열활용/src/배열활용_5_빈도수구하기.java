// �󵵼� ���ϱ�
// word cloud
/*
 * ����: 0 ~ 9 ������ ���� ==> 100�� �߻�
 */
public class �迭Ȱ��_5_�󵵼����ϱ� {

	public static void main(String[] args) {
		// 100���� ������ �� �ִ� ���� ���� ����
		int[] arr = new int[100];
		int[] count = new int[10];

		// ���� �Է�
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}

		// �󵵼� Ȯ��
		for (int i : arr) {
			count[i]++;
		}
		// ���
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println("\n======�������======");
		for (int i = 0; i < count.length; i++) {
			System.out.println(i + ": " + count[i]);
		}

		System.out.println("===== ��õ =====");
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
