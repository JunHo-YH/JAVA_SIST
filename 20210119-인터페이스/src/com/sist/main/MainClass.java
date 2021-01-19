package com.sist.main;

/*
 * JDK 1.0
 * JDK 1.2
 * JDK 1.5
 * JDK 1.8
 * �������̽�(interface)
 * 1) �߻� Ŭ������ ���� => �߻�Ŭ������ ������ ����
 *    # �ڹ��� Ŭ������ ������ ���� ��Ӹ� ����
 *    # �������̽��� Ŭ������ (���� ��� ����)
 *    
 * 2) ����
 *    ���������� interface �������̽��� {
 *        ====================
 *          ���� (�������(X)): ����� ����
 *        ====================
 *          �߻�޼��� (����� �޼���)
 *        ====================
 *          ������ �޼��� (JDK 1.8 �̻�)
 *          default
 *        ====================
 *          static
 *        ====================
 *    }
 *    
 * 3) �߻� Ŭ������ ���� => �������� �Ӽ��� ��Ƽ� ���� => �����ؼ� ���
 *    ** ���� �ٸ� Ŭ������ ������ �� ���
 *    ** ǥ��ȭ�� �����ϴ�
 *    
 *    *** �������̽��� ��� ������ �޼���� public�� ����� ����.
 *    public interface Cmmon {
 *        ***** int a; // ����� ���� ==> int a = 10; ===> public static final int a;
 *        void display(); // public abstract
 *        =====================
 *        default void aaa() {} // default public void aaa() {}
 *        								  ========
 *        
 *        static void bbb() {} // static public void bbb() {}
 *        								=======
 *    }
 *    
 *    public interface Common {
 *    
 *        (public abstract) void display();
 *    }
 *    public class A implements Common {
 *        void display() {} // ����
 *        => public void display() {}
 *        �������̵� => ��������� Ȯ��� ����, ��Ҵ� �Ұ���
 *    }
 *    
 *    ���
 *    class A
 *    class B               => Ŭ���� A�� Ŭ���� B�� ���
 *                             class B extends A
 *    interface A
 *    class B               => �������̽� A�� Ŭ���� B�� ���
 *                             class B implements A
 *    ====================================================
 *    interface A
 *    interface B           => �������̽� A�� �������̽�B�� ���
 *                             interface B implements A  (X)    => interface B extends A
 *                             
 *                             
 *    ==================================================== �������̽��� Ŭ�����κ��� ����� ���� �� ����)
 *                             
 *    class A
 *    interface B           => classA�� �������̽� B�� ���
 *                             interface B extends A      => �������� �ʴ´�.
 *   
 *   
 *    interface A
 *    interfac B extends A
 *    class C implements B ==> ���� ���
 *    
 *    interface A
 *    interface B
 *    class C implements A, B
 *    
 *    
 *    interface A
 *    interface B
 *    class C
 *    class D extends C implements A, B
 *    
 *    
 *    
 */
interface Common {
	int x = 10; // public static final ����
	void display(); // public abstract ����
	default void aaa() { // ������ ��� default | static�� �ٿ��� �����ؾ��Ѵ�.
						// default | static�� �ٿ��� ������ �޼��带 ���� �� �ִ�.
		
	}
	static void bbb() {
		
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
