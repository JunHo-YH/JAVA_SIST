
/*
 * ����ڰ� ���� �Է�
 */
import java.util.Scanner;

public class �ݺ���_while {

	public static void main(String[] args) {
		int dan;
		Scanner scan = new Scanner(System.in);
		System.out.println("��(2 ~ 9) �Է�: ");
		dan = scan.nextInt();
		
		//�Էµ� ���� �������� ���
		// while���� ������� �ʰ� ���
		System.out.println(dan + "��");
		//���
		System.out.printf("%d * %d = %d\n", dan, 1, dan * 1);
		System.out.printf("%d * %d = %d\n", dan, 2, dan * 2);
		System.out.printf("%d * %d = %d\n", dan, 3, dan * 3);
		System.out.printf("%d * %d = %d\n", dan, 4, dan * 4);
		System.out.printf("%d * %d = %d\n", dan, 5, dan * 5);
		System.out.printf("%d * %d = %d\n", dan, 6, dan * 6);
		System.out.printf("%d * %d = %d\n", dan, 7, dan * 7);
		System.out.printf("%d * %d = %d\n", dan, 8, dan * 8);
		System.out.printf("%d * %d = %d\n", dan, 9, dan * 9);
		System.out.println("******* �ݺ���(while) ��� *******");
		int i = 1;
		while(i <= 9) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			i++; // i <= 9 i = 10 => false�� �Ǹ鼭 ����
		}
	}

}
