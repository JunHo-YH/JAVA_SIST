/*
 * 	���������
 * 	=======
 *   / , %
 *   ������(/)
 *   	1. 0���� ���� �� ����. ex) 10 / 0 => error
 *   	2. ���� / ���� = ����
 *   	   5 / 2 => 2.5(X)   5 / 2 = 2 ======> 5 / 2.0 = 2.5(O)
 *   	   double d = 5 / 2 ==> 2.0
 *   
 *   ������ ��������(%)
 *   	1. ������ : ������� �������� ��ȣ�� ���󰣴�.
 *   		5 % 2 ===> 1      1 + 4/2
 *   	   -5 % 2 ===> -1     -1 -4/2
 *   		5 % -2  => 1	  1+ 4/-2
 *   	   -5 % -2  => -1	  -1 -4/-2
 *			
 *
 *   	
 */
public class ������_���������2 {

	public static void main(String[] args) {
		int a1 = 5;
		int a2 = 2;
		int a3 = -5;
		int a4 = -2;
		byte a = 10;
		byte b = 20;
		int c = a + b;
		System.out.println(c);
		long l = (long)(3000 * 3000 * 3000);
		System.out.println(l);
		System.out.println(a1 % a2);
		System.out.println(a1 % a4);
		System.out.println(a3 % a2);
		System.out.println(a3 % a4);
	}
}
