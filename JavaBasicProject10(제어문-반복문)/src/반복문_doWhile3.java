/*
 * 		1 ~ 100���� ���� 3,5,7 ����� ��
 * 		1 -2 +3 -4 +5 -6 +7 -8 +9 -10
 */
public class �ݺ���_doWhile3 {

	public static void main(String[] args) {
		int i = 1;
		int k = 1;
		int sum_k = 0;
		int sum_k_total = 0;
		int sum = 0;
		int sum3 = 0;
		int sum5 = 0;
		int sum7 = 0;
		int s = 1;
		do {
			sum += i; // 100���� ����
			if (i % 3 == 0) {
				sum3 += i;
			}
			if (i % 5 == 0) {
				sum5 += i;
			}
			if (i % 7 == 0) {
				sum7 += i;
			}
			i++;
		} while (i <= 100);

//		1 -2 +3 -4 +5 -6 +7 -8 +9 -10
		do {
			sum_k = k * s;
			sum_k_total += sum_k;
			s = -s;
			k++;
		} while (k <= 10);
		System.out.println("����:" + sum);
		System.out.println("3�� ����� ��: " + sum3);
		System.out.println("5�� ����� ��: " + sum5);
		System.out.println("7�� ����� ��: " + sum7);
		System.out.println("������ ��:" + sum_k_total);

	}

}
