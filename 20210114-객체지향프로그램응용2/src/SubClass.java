/*
 * ���
 *  => ������ Ŭ������ ��� ��ɰ� ��� �����͸� �޾Ƽ� Ȯ���ϴ� Ŭ������ �����.
 *  => ����� ����
 *     ========
 *     class A
 *     class B extends A
 *          ==        == ����� ������ Ŭ����
 *          ����� �޴� Ŭ����
 *  => �ڹ� ����� ���� ����̴�.
 *  => ����: �ִ� �״�� ��� : ����Ŭ����
 *  		  �����ؼ� ���: ���
 *  
 *  => ����
 *   extends 
 *   
 *   class A
 *   class B extends A
 *   *** ����� �޴� ��� (�⺻�� ��ӳ����� Ŭ������ ��� ���� �޾ƿ´�)
 *       ��, ���� ����(static����, static�޼���, �����ڴ� ����)
 *                  ====================== ��ӹ޴� Ŭ������ ����� ����
 *          private�� ����� �������µ� ����� �Ұ����ϴ� (private -> protected -> ��밡��)
 *          
 */

class SuperClass {
	int a = 10;
	int b = 20;

	SuperClass() {
	}
}

public class SubClass extends SuperClass {
//	int a = 10;
//	int b = 20;
	SubClass sc = new SubClass();

	public static void main(String[] args) {
		SubClass s = new SubClass();
		System.out.println(s.sc.a);
		
	}

}
