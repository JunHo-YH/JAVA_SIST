/*
 * 	|| ������
 * 	����)
 * 		���� || ����
 * 		==	   ==	������ �׻� true / false ==> ���� �����: true / false
 * 		������ ���� �� : ����� �� �ִ� ������ (����������, �񱳿�����)
 * 										!(boolean), ==, !=, <, >, <=, >=
 * 										
 * 		���� || ����
 * 		==     ==
 * 		true	true	=> true
 * 		true	false	=> true
 * 		false	true	=> true
 * 		false	false	=> false
 * 		=====	=====		
 * 		  1	 ||   2
 * 			====
 * 			 3 ===========> �����
 * 		*** ȿ������ ����
 * 			= �������� ������ true�� ���
 * 
 * 		*** ������ �� �ִ� �Ⱓ�� ��Ÿ�� �� ����� �� �ִ�.
 */
public class ��������_2 {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		boolean bCheck =  (a % 2 == 0 || ++b == a);
		//								==========> ������ �˻� X
		
		System.out.println(bCheck);
		System.out.println(a);
		System.out.println(b);
		
		bCheck = (a % 2 != 0 || ++b == a);
		/*
		 * 	a % 2 != 0 => false
		 * 	++b == a => true ==> ������ �˻�
		 * 	false || true
		 */
		
		System.out.println("a % 2 != 0 ?" + bCheck);
		System.out.println(a);
		System.out.println(b);
	}

}
