
// 3�ڸ� ������ �Է��ϰ� �����.
/*
 * 		1. ���ǹ�
 * 			���� ���ǹ�
 * 			���� ���ǹ�
 * 			���� ���ǹ�
 * 		2. �ݺ���
 * 			while
 * 			for
 * 		3. �ݺ� ���
 * 			break;
 * ========================> Web
 * 		switch-case, do~while, continue ==> �� ~~~~~~~~~~~~~ �� ����Ѵ�.
 */
import java.util.Scanner;

public class �ݺ���_for4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.print("���ڸ� ������ �Է��ϼ���: ");
			int user = scan.nextInt();
			if (user < 100 || user > 999) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
				// continue�� break �ؿ��� �ڵ��� �Ұ����ϴ�.
			}
			
			int a = user / 100;
			int b = (user % 100) / 10;
			int c = (user % 10);
			System.out.println("����� : " + a);
			System.out.println("�ʴ��� : " + b);
			System.out.println("�ܴ��� : " + c);
			
			break; // ����
		}

	}

}
