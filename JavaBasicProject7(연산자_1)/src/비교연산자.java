/*
 * 	���ڸ� ���ؼ� ���� => true, ���� => false
 * 	6 == 9 => false
 * 	6 == 6 => true
 * ================== �񱳿������� ������� true / false
 * �񱳿������� ����
 * ==================
 * == ����
 * != ���� �ʴ�
 * < �۴�
 * > ũ��
 * <= �۰ų� ����
 * >= ũ�ų� ����
 * 
 * ==
 * 	10 == 10 true
 *  10 != 10 false
 *  10 < 11 true
 *  10 > 11 false
 *  10 <= 10 true (10 == 10 || 10 < 10)
 *  10 >= 10 true (10 == 10 || 10 > 10)
 *  			========================== ||�� �� �߿� �� ���� true => true (������ ������� �ʴ´�)
 *  
 *  => ���ϴ� �����͸� ����ϰ� ���� �� �񱳿����ڸ� ����Ѵ�.
 * 
 */
public class �񱳿����� {

	public static void main(String[] args) {
//		long l = (long)(27000000000);
		
		int a = 10;
		int b = 11;
		System.out.println("a == b? " + (a == b));
		System.out.println("a == b? " + (a != b));
		System.out.println("a < b? " + (a < b));
		System.out.println("a > b? " + (a > b));
		System.out.println("a <= b? " + (a <= b));
		System.out.println("a >= b? " + (a >= b));
//		System.out.println("a < b? " + (a < b));
		System.out.println();
		System.out.println(++a == b);
		System.out.println(a);
		// ��� ==> ���ǹ�, �ݺ���(����_���� �ַ� ���
		// �Ѿ� => �����ȿ� ��� ������ ����
		
		String dap = a % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println(dap);
		
	}

}
