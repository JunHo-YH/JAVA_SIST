/*
 * �����Ϸ� �ڵ����� ÷��
 * 1. import java.lang.*;
 *          ==============
 *          String, System, Math
 * 2. �޼��� => void => return ÷��
 * 3. ��� Ŭ������ �����ڸ� ������ �ִ�.
 *    ���� ��쿡 ����Ʈ �����ڸ� ÷��
 * 4. ��� Ŭ���� ����
 *    class A extends Object
 *            ===============
 * 5. ��� Ŭ������ ����ó���� ������ �ִ�: ������ �� �ִ� �κ�...
 * 
 */
// Super => a, display(), Object
class Super {
	protected int a = 10;
	public static int c = 20;

	public void display() {
		System.out.println("Super:display() Call...");
	}
	public void display1() {
		System.out.println("Super:display() Call...");
	}
	public void display2() {
		System.out.println("Super:display() Call...");
	}
	public Super() {
		System.out.println("Super: �������Լ�()...");
	}
}
class Sub extends Super {
	private int b = 10;
	public Sub() {
		System.out.println("Sub : ������ () Call...");
	}
	
	// �������̵�: ����Ŀ� ����
	/*
	 * �������̵�(������): �޼����� ���� ����(������) => ������ �����ϴ�. : ���, �޼����, �Ű�����	
	 *   1) ����� �޴´�
	 *   2) �޼������ �����ؾ��Ѵ�.
	 *   3) �Ű������� �����ؾ��Ѵ�.
	 *   4) �������� �����ؾ��Ѵ�.
	 *   5) ����������: Ȯ���� ����������, ��Ҵ� �Ұ����ϴ�.
	 */
	public void display() {
		System.out.println("sub__:display() Call...");
	}
	public void display1() {
		System.out.println("Sub1:display() Call...");
	}
	public void display2() {
		System.out.println("Sub2:display() Call...");
	}

}


public class MainClass {

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.display();
		System.out.println("sub.a = " + sub.a);
		sub.a = 100;
		System.out.println("sub.a = " + sub.a);
		sub.display1();
		sub.display2();
	}

}
