/* 
 *  �ڹ� ǥ����
 *  ========
 *  	1. ����
 *  		 = 10, 20, 30 ==> 10����
 *    		 = 012, 013, 011 ==> 8����
 *      	 = 0xFF ==> 16����
 *        	 = 0b0001010 ==> 2����
 *  		==================	
 *  			0 => 8����
 *  			0x => 16����
 *  			0b => 2����
 *  		==================
 *  	2. ���� : ���� �� ��	'A' 'ȫ'
 *  	3. ���ڿ� : ���� ���� ��  "ABC" "ȫ�浿"
 *  	4. �� : True / False
 * 
 * 
 * */

// �� �� �ּ� => ������(���� ��ȯ) => �����Ͽ��� ���ܰ� �Ǵ� �κ�
// �ּ�: ���� => �ҽ� �м�

/*
 *  < ���α׷� >
 *  =================================
 *  1. ��ҹ��� ����
 *  2. ��ɹ��� ���� �Ǹ� ';' (�� ���� ���)
 *  ================================= 1,2���� ��Ŭ�������� ������ �ٷ� ��ƺд�.
 *  3. �鿩���� (����ó���� �ȵ�)
 *  
 *  4. ���
 *  ====================== �ѱ۵� ����
 *   1) Ŭ������ : �빮�� ����
 *   2) ������ : �ҹ��� ����
 *   3) �޼ҵ�� : �ҹ��� ����
 *  
 *  
 *  
 *  class A
 *  {
	 *  public void main()
	 *  {
	 *  System.out.println("ABCD");
	 *  System.out.println("ABCD");
	 *  System.out.println("ABCD");
	 *  }
 *  }
 * 
 * */
public class MainClass {
	// �ڵ����� ù��°�� �о ó�� (main => ��� ���α׷��� �� �� �̻��� �����ؾ��Ѵ�)
	// ����
	public static void main(String[] args) {
		// �ҽ��� �ڵ��ϴ� ��ġ
		System.out.println("Hello Java"); // ��ɹ�
		// ln => new Line
		System.out.println("ABCD");
		System.out.println('A');
		System.out.println(true);
		System.out.println(false);
		System.out.println(011);
		System.out.println(0b01111);
		System.out.println(0xFB);
		System.out.println(10);
		// ��� ��� 3����
		System.out.print("Hello");
		System.out.print("Java");

		// ����� ������. => ������ ó�� (�˰���) : ������
		              // =========
	}
	/*
	 * MainClass.java ==========> MainClass.class ======> "Hello" javac java
	 * 
	 */
}
