// while: �ݺ�Ƚ���� �������� ���� ��쿡 �ַ� ���
// UP - DOWN ����
/*
 * 		����: ���� (1 ~ 100 ������ ���� �߻�)
 * 				===================== ���ߴ� ����
 * 				HINT: UP, DOWN
 * 				����: 70
 * 				�����: 80 ==> DOWN
 * 				�����: 65 ==> UP
 * 
 * 		���� ����
 * 		======
 * 		1. ���� �߻� => �޸� ����
 * 		2. ����� �Է�
 * 		3. ������ ����� �Է°��� ��
 * 		4. HINT
 * 		5. ���Ῡ�� Ȯ�� => true => ����
 * 						false => 2������ �̵�
 */

import java.util.Scanner;

public class �ݺ���_while4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int com = (int) (Math.random() * 100) + 1;

		while (true) {
			// 1. ����� �Է°��� �޴´�.
			System.out.println("1 ~ 100 ������ ���� �Է�: ");
			
			// ����
			int user = scan.nextInt();
			
			if(com > user) {
				System.out.print("�Է°����� ū ���� �Է����ּ���."); // UP
			}
			else if(com < user) {
				System.out.print("�Է°����� ���� ���� �Է����ּ���."); // DOWN
			}
			else {
				System.out.println("�����Դϴ� !");
				System.exit(0); // ���α׷� ���� ����
				//break;
			}
			
			
		}
		//System.out.println("���α׷� ����");
	}

}
