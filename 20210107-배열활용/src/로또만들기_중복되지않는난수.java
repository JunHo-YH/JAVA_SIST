import java.util.Random;
import java.util.Scanner;

public class 로또만들기_중복되지않는난수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("로또번호 몇 개를 만드시겠습니까? ");
		int n = scan.nextInt(); // 로또번호 몇 개 생성할건지
		int[] lotto = new int[n]; // 로또번호 n개 생성
		int k = 0;

		for (int i = 0; i < lotto.length; i++) {
			do {
				lotto[i] = rand.nextInt(45) + 1; // 1 ~ 45 난수 생성

				for (k = 0; k < i; k++) { 		 // 중복체크
					if (lotto[k] == lotto[i]) {
						break;
					}
				}
			} while (k < i);
		}

		for (int result : lotto) {
			System.out.print(result + " ");
		}
	}

}
