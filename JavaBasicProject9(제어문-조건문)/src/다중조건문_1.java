// ����ڰ� �Է�
/*
 * 	1�Է� => Home
 * 	2�Է� => Join
 * 	3�Է� => ��ȭ ���
 * 	4�Է� => ��ȭ ��õ
 * 	5�Է� => ��ȭ ����
 * 	6�Է� => ���α׷� ����
 */
import java.util.Scanner;

public class �������ǹ�_1 {

	public static void main(String[] args) {
		int no;
		Scanner scan = new Scanner(System.in);
		System.out.print("�޴��� �����ϼ���(1.Ȩ 2.ȸ������ 3.��ȭ��� 4.��ȭ��õ 5.��ȭ���� 6.����): ");
		no = scan.nextInt();
		
		//�����
		if(no == 1)
			System.out.println("��ȭ Ȩ�Դϴ�.");
		else if(no == 2)
			System.out.println("ȸ������ �������Դϴ�.");
		else if(no == 3)
			System.out.println("��ȭ����� �����ݴϴ�.");
		else if(no == 4)
			System.out.println("��ȭ�� ��õ�մϴ�.");
		else if(no == 5)
			System.out.println("��ȭ���� �������Դϴ�.");
		else
			System.exit(0); // ���α׷� ����� (0 => ��������, 1=> ������ ����)
	}

}





















