/*
 * 	����
 * 	===
 * 	(��������)�� => ���������� ������ �� ���
 * 	��)	=> �����ϴ� �������� (boolean)
 * 		������ ���ڷ� ����
 * 		(char)68 ==> 'D'
 * 		�Ǽ��� ������ ����
 * 		(int)10.8
 * 		
 */
public class ������_����ȯ������ {

	public static void main(String[] args) {
		double d = 100.99;
		float f = (float) 100.99;
		
		System.out.println("d = " + d);
		System.out.println("f = " + f);
		// ��ɾ� => double => ���� (int)
		int a = (int)d; // 100
		System.out.println("a= " + a);
		
		// ��ɾ� float => ����
		char c = (char)f;
		System.out.println("c = " + c);
	}
}
