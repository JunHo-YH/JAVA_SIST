// char�� ���� => �빮��, �ҹ��ڸ� Ȯ���ϴ� ���α׷� ���� ==> �� ���� ������ �̿��ؼ� ����ó�� => ��������
// ��������� => char������ ������ �Ǹ� ���������� ����
/*
 *	char alpha = 'K'
 *	65 <= alpha && alpha <= 90
 *	'A' <= alpha && alpha <= 'Z'
 *	��� char���� => ����� ������ ���������� ����
 */
public class ��������_3 {

	public static void main(String[] args) {
		//System.out.println((int) 'Z');
		char alpha =(char)((Math.random()*26) + 65); //alpha���� �빮��? �ҹ���?
		/*
		 * 
		 */
		boolean bCheck = 'A' <= alpha && alpha  <= 'Z'; // 'A'�� 'Z' ���̿� �ִ��� Ȯ��
		String result = bCheck == true ? "�빮��" : "�ҹ���";
		System.out.println(alpha + "��(��): " + result);
		
		/*
		 * 	���� => �ʱ�ȭ
		 * 	1. ����� �ʱ�ȭ : int a = 10;
		 * 	2. �Է°� �ޱ� : int a = scan.nextInt()
		 * 	3. ������ �ʱ�ȭ : Math.random()
		 * 
		 */
	}

}
