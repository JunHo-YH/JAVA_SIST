/*
 * 1. static => instance�޼���(����) ȣ��
 *    => �ٸ� Ŭ�������� �ҷ��� ���
 *    
 * 2. instance�޼��� => static
 *    => �ٸ� Ŭ�������� �ҷ��� ���
 *    
 *    class A {
 *        int a;
 *        static b;
 *        
 *        pubilc void disp1() {
 *            ��� ó��
 *        }
 *        
 *        public static void disp2() {
 *            ��� ó��
 *        }
 *        
 *        // main
 *        public static void main(String[] args) {
 *            //1. static �޼��� ȣ��, static ���� ȣ��
 *             => ���� Ŭ���� �ȿ� �ִ� ���
 *                System.out.println(b);
 *                disp2();
 *                
 *        }
 *    }
 */
class A {


	
	static int b = 100;
	int c = 200;
	public void disp() {
		System.out.println("A: disp() Call");
	}
	
	public static void display() {
		System.out.println("A: disp() Call");
	}
}


public class ��ü�������α׷� {
	static int a = 10;
	public static void disp() {
		System.out.println("Disp:Call...");
	}
	public static void main(String[] args) {
		System.out.println("a=" + a);
		System.out.println("b=" + A.b);
		disp();
		A.display(); // �ٸ� Ŭ������ static�޼��带 �θ�����, Ŭ���� �̸��� ���̰� ����ؾ��Ѵ�.
		
		// �ν��Ͻ��� �׻� �޸𸮿� �����ϴ� ������ ����� �����Ŀ� ���
//		               ======================== ���� �޸� �Ҵ� (new)
		A a = new A();
		a.disp();
		System.out.println("a.c=" + a.c);
	}

}
