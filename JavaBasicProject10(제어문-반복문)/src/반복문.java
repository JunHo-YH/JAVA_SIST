/*
 * 	�ڹٿ��� �����ϴ� �ݺ���
 * 	=> ���� �ҽ��� ���� �� �ڵ��� �� ��쿡 ���
 * 	1.while: �ݺ� Ƚ���� �������� ���� ���(�����ͺ��̽�_����Ŭ)
 * 		�Խù�, ������ ���, ��ȭ ��� ... => web
 * 	2.do~while: �� �� �̻��� �ݺ��ϴ� ���
 * 				============ ���ǰ˻� (���߿�)
 * 	3.for: �ݺ� Ƚ���� ������ ���
 * 		1)����: while, for => ������ �˻� / do~while => ������ �˻�
 * 		2)����
 * 			1-1 while
 * 				�ʱⰪ int i = 1; ========================= ��
 * 				while(���ǹ�) => i <= 10 ================== ��
 * 				{
 * 					�ݺ����� System.out.println("i = " + i); ��
 * 					������   i++ ========================== �� =====> 2������ �̵�
 * 				}
 * 			1(�ʱⰪ) => 2(�ʱⰪ�� ���� ���� �˻�) => 3(�ݺ����� ����) => 4(������)
 * 					=> ������ ���� ���� ���� �˻� => 3(�ݺ����� ����) => 4(������)
 * 					   ===================
 * 						true: 3 => 4
 * 						false : ����
 * 
 * 
 * 				
 * 		3)���ó
 */
public class �ݺ��� {

	public static void main(String[] args) {
		System.out.println("==================�ݺ����� ������� ���� ���==================");
		System.out.println("i = 1");
		System.out.println("i = 2");
		System.out.println("i = 3");
		System.out.println("i = 4");
		System.out.println("i = 5");
		System.out.println("i = 6");
		System.out.println("i = 7");
		System.out.println("i = 8");
		System.out.println("i = 9");
		System.out.println("i = 10");
		System.out.println("=======�ݺ����� ���� =======");
		int i = 1;
		while(i <= 10) {
			System.out.println("i = " + i );
			i++;
		}
	}

}
