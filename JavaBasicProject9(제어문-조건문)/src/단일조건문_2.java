
// ���� ���� �� ����
/*
 * 	����� �Է� : 0(����), 1(����), 2(��)
 * 	��ǻ�� �Է� : ���� (0, 1, 2)
 * 	================================
 * 	��� : ��ø if
 * if()
 * {
 * 	if()
 * 	{
 * 
 * 	}
 * }
 */
import java.util.Scanner; // �Է��� �޴� ��쿡 ����ϴ� Ŭ����(����)

public class �������ǹ�_2 {

	public static void main(String[] args) {
		//����ڰ� �Է��� �� �� �ְ� ó��
		Scanner scan = new Scanner(System.in);
		// ����ڰ� �Է��� ���� �޴´� (0,1,2)		
		System.out.print("����(0), ����(1), ��(2) �Է�: ");
		int user = scan.nextInt();
		int com = (int)(Math.random() * 3);
		/*
		// Ȯ�� => ����ڰ� �� �´���
		if(user == 0) // ����ڰ� �Է��� ���� 0�̸�
			System.out.println("�����: ����");
		if(user == 1)
			System.out.println("�����: ����");
		if(user == 2)
			System.out.println("�����: ��");
		
		/// ��ǻ��
		int com = (int)(Math.random() * 3);
		
		if(com == 0)
			System.out.println("��ǻ��: ����");
		if(com == 1)
			System.out.println("��ǻ��: ����");
		if(com == 2)
			System.out.println("��ǻ��: ��");
		
		/// ������� ���
		System.out.println("**********�����**********");
		if(com == 0 && user == 0)
			System.out.println("�����ϴ�.");
		if(com == 0 && user == 1)
			System.out.println("����� Win !!");
		if(com == 0 && user == 2)
			System.out.println("��ǻ�� Win !!");
		
		if(com == 1 && user == 0)
			System.out.println("��ǻ�� Win !!.");
		if(com == 1 && user == 1)
			System.out.println("�����ϴ�.");
		if(com == 1 && user == 2)
			System.out.println("����� Win !!");
		
		if(com == 2 && user == 0)
			System.out.println("����� Win !!.");
		if(com == 2 && user == 1)
			System.out.println("��ǻ�� Win !!");
		if(com == 2 && user == 2)
			System.out.println("�����ϴ�.");
		*/
		
		int res = com - user;
		if(res == - 1|| res == 2)
			System.out.println("����� Win !!");
		if(res == -2 || res == 1)
			System.out.println("��ǻ�� Win !!");
		if(res == 0)
			System.out.println("����!!");
		
	}

}




















