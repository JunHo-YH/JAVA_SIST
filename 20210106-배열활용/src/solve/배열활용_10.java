// ���� �߱�����
/*
 * UP DOWN
 * =======
 *     369 => 123 => 0S_1B
 *         => 345 => 1S_0B
 *         => 396 => 1S_2B
 *         => 369 => 3S-0B => GAME Over !!
 */
package solve;

public class �迭Ȱ��_10 {

	public static void main(String[] args) {
		int[] arr = new int[10];

		// ������ �����ϴ� ����
		int su = 0;

		// �ߺ����θ� Ȯ���ϴ� ����
		boolean bCheck;

		for (int i = 0; i < arr.length; i++) {
			bCheck = true;
			while (bCheck) {
				// ���� �߻� => �� (�ߺ����� Ȯ��)
				su = (int) (Math.random() * 10) + 1;
				bCheck = false;
				
				for (int k = 0; k < i; k++) {
					if (arr[k] == su) {
						bCheck = true;
						break; // break & continue ==> �ڽ��� �ݺ����� ����
					}
				}
			}
			arr[i] = su;
		}

		// ���

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
