/*
 * 	���ù�: �� �� ���� ������ �� ��쿡 ó��(�������ǹ�) => ����, ������ ���۽� �ַ� ����Ѵ�.
 * 	1-10
 * 	11-20
 * 	21-30
 * 	31-40
 * 	41-50 ==> case 1:
 * 	����)
 * 		switch(����, ����, ���ڿ�)
 * 				���� => 3
 * 		switch(����)
 * 		{
 * 			case1:
 * 				���๮�� 1;
 * 				���� �����Ŀ� ����: break;
 * 			case 2:
 * 				���๮�� 2;
 * 				���� �����Ŀ� ����: break;
 * 			case 3:
 * 				���๮�� 3;
 * 				���� �����Ŀ� ����: break;
 * 			default: ================> ��������
 * 				���๮�� 4;
 * 		}
 * 		
 * 		switch(����)
 * 		{ ���� = 'A'
 * 			case 'A':
 * 				���๮�� 1;
 * 				���� �����Ŀ� ����: break;
 * 			case 'B':
 * 				���๮�� 2;
 * 				���� �����Ŀ� ����: break;
 * 			case 'C':
 * 				���๮�� 3;
 * 				���� �����Ŀ� ����: break;
 * 			default: ================> ��������
 * 				���๮�� 4;
 * 		}
 * 		switch(���ڿ�)
 * 		{ 
 * 			case "�α���";
 * 			case "ȸ������";
 * 			case "��ȭ���";
 * 			case "�󼼺���";
 * 		}
 * 		final int LOGIN = 1;
 * 
 * 		case LOGIN:
 * 		
 */
public class ���ù� {

	public static void main(String[] args) {
		int no = (int) (Math.random() * 5) + 1; // 1 ~ 5
		// ====== =================== ====
//					2	       1			3

		switch (no) {
		case 1:	//(if i == 1)
				System.out.println("1�� ���õƽ��ϴ�.");
				break; // ���� ������ �����ϰ� switch�� ����
		case 2:
			System.out.println("2�� ���õƽ��ϴ�.");
			break;
		case 3:
			System.out.println("3�� ���õƽ��ϴ�.");
			break;
		case 4:
			System.out.println("4�� ���õƽ��ϴ�.");
			break;
		case 5:
			System.out.println("5�� ���õƽ��ϴ�.");
		}
	}

}
