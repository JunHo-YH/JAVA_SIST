package solve;

public class ��� {

	public static void main(String[] args) {
		// 1) 10���� ���ڸ� ������ �迭 c�� �����ϴ� �ڵ带 �� �ٷ� ����.
		char[] c = new char[10];

		// 2) 0���� 5���� ���� ������ �ʱ�ȭ�� ���� �迭 n�� �����϶�.
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		// 3) '��', '��', 'ȭ', '��', '��', '��', '��'�� �ʱ�ȭ�� �迭 day�� �����϶�.
		char[] day = {'��', '��', 'ȭ', '��', '��', '��', '��'};
		
		// 4) 4���� �� ���� ���� �迭 bool�� �����ϰ� true, false, false, true�� �����϶�.
		boolean[] b = {true, false, false, true};
	}

}
