/*
 * 1###
 * #2##
 * ##3#
 * ###4
 * =====
 * ����: 4�� => for (int i = 1; i <= 4; i++) => 1�� for��
 * ����: 4�� => for (int k = 1; k <= 4; k++) => 2�� for��
 * 
 * 
 * #234
 * 1#34
 * 12#4
 * 123#
 */
public class ���߹ݺ���_2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 4; k++) {
				if (i == k) {
					System.out.print(i);
				} else {
					System.out.print("#");
				}
			}
			// �����ٿ� ���
			System.out.println();
		}

		System.out.println();

		for (int i = 1; i <= 4; i++) {
			for (int k = 1; k <= 4; k++) {
				if (i == k) {
					System.out.print("#");
				} else {
					System.out.print(k);

				}
			}
			System.out.println();
		}
	}

}
