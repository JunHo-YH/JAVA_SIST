/*
 * 	���� ������ ( = )
 * 	���� ���Կ����� ( +=, -=, *=, /=, %=, <<=, >>=, &=, |=, ^=)
 * 				=> ��������, �񱳿����ڴ� ����
 * 
 * 	���ڿ� �� -> equals 
 * 	===============================================================
 * 	���Կ����� : ���� ����
 * 				1. �ʱ�ȭ
 * 					int a = 10; 10�� a��� �޸� ������ �����ض�.
 * 					
 * 				2. �������� ����
 * 					int a = 10 + 20;
 * 							======= ����ó�� (����� � ������������?)
 * 							double d = int + double
 * 
 * 	���� ���Կ����� :  ������ �� ���� ���ļ� �� ���� �����ڸ� �������.
 * 					+=, -=, x=, /= ...  op = 
 */
public class ���Կ�����_1 {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		boolean bCheck = s1.equals(s2);
		String result = bCheck == true ? "s1==s2" : "s1 != s2";
		System.out.println(result);
		
		byte a = 1;
		byte b = 2;
		byte c = (byte) (a + b);
	}

}
