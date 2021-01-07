import java.util.Random;
import java.util.Scanner;

public class �ζǸ����_�ߺ������ʴ³��� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("�ζǹ�ȣ �� ���� ����ðڽ��ϱ�? ");
		int n = scan.nextInt(); // �ζǹ�ȣ �� �� �����Ұ���
		int[] lotto = new int[n]; // �ζǹ�ȣ n�� ����
		int k = 0;

		for (int i = 0; i < lotto.length; i++) {
			do {
				lotto[i] = rand.nextInt(45) + 1; // 1 ~ 45 ���� ����

				for (k = 0; k < i; k++) { 		 // �ߺ�üũ
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
