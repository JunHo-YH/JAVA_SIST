// ���� 3,4,5: �� / 6,7,8: ���� / 9,10,11: ����/ 12,1,2: �ܿ�
// ����ڰ� ���� �Է�

import java.util.Scanner;

public class ���ù�_2 {

	public static void main(String[] args) {
		int month;
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		month = scan.nextInt();
		
		//ó��
		/*
		 * 	case 3: case 4: case5:
		 * 	if(month == 3 || month == 4 || month == 5)
		 */
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("���Դϴ�.");
			break;
		case 6: case 7: case 8:
			System.out.println("�����Դϴ�.");
			break;
		case 9: case 10: case 11:
			System.out.println("�����Դϴ�.");
			break;
		case 12: case 1: case 2:
			System.out.println("�ܿ��Դϴ�.");
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
	}

}
