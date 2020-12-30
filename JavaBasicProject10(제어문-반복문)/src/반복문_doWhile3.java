/*
 * 		1 ~ 100까지 총합 3,5,7 배수의 합
 * 		1 -2 +3 -4 +5 -6 +7 -8 +9 -10
 */
public class 반복문_doWhile3 {

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
			sum += i; // 100까지 총합
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
		System.out.println("총합:" + sum);
		System.out.println("3의 배수의 합: " + sum3);
		System.out.println("5의 배수의 합: " + sum5);
		System.out.println("7의 배수의 합: " + sum7);
		System.out.println("마지막 답:" + sum_k_total);

	}

}
