/*
 * 	��������� = ���׿����� (�������� 2���� �ʿ��ϴ�)
 * 	=======
 * 	+(����), -(����), *(����), /(������), %(������)
 * 	1) �켱���� 
 * 	   a. *, /, %
 * 	   b. +, -
 * 
 * 	2) �ٸ� ���������� ����� ��� (���� ū ������������ �����˿� ����)
 * 		int + double
 * 	  	===
 * 		double + double (������ �׻� ���� ���������� ����ó���ȴ�) => �ڵ� ����ȯ
 * 
 * 		char + int
 * 		====
 * 		int + int
 * 	
 * 		int + long
 * 		====
 * 		long + long
 * 		
 * 		char + byte (�����) int
 * 		===========
 * 		int + int
 * 		
 * 		short + short
 * 		=============
 * 		int + int
 */
public class ������_��������� {

	public static void main(String[] args) {
		byte b1 = 10;
		byte b2 = 20;
		int b3 = b1 + b2;
		System.out.println("b3 = " + b3);
		
		/*
		 * byte b3 = (byte)(b1 + b2);
		 * int b3 = b1 + b2;
		 */
		
		int a = 10;
		double d = 10.5;
		// a + d�� ����� ����ض�
		int res = (int)(a + d);
		System.out.println(res);
		
		double d1 = 10.5;
		double d2 = 10.5;
//		int res1 = (int)(d1 + d2);
		int res1 = (int)d1 + (int)d2;
		System.out.println(res1);
		
		// ���� ==> (-)
		int i = 10;
		int j = 6;
		// i, j�� ����� �򰥸��� ������ ����� �����Ѵ�.
		int z = i - j;
		System.out.println("z = " + z);
		
		// ���� => (*)
		i = 10;
		j = 6;
		z = i * j;
		System.out.println("z = " + z);
		
		
		
	}

}
