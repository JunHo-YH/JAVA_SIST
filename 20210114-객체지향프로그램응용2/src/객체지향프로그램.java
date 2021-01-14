/*
 * 1. static => instance메서드(변수) 호출
 *    => 다른 클래스에서 불러서 사용
 *    
 * 2. instance메서드 => static
 *    => 다른 클래스에서 불러서 사용
 *    
 *    class A {
 *        int a;
 *        static b;
 *        
 *        pubilc void disp1() {
 *            기능 처리
 *        }
 *        
 *        public static void disp2() {
 *            기능 처리
 *        }
 *        
 *        // main
 *        public static void main(String[] args) {
 *            //1. static 메서드 호출, static 변수 호출
 *             => 같은 클래스 안에 있는 경우
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


public class 객체지향프로그램 {
	static int a = 10;
	public static void disp() {
		System.out.println("Disp:Call...");
	}
	public static void main(String[] args) {
		System.out.println("a=" + a);
		System.out.println("b=" + A.b);
		disp();
		A.display(); // 다른 클래스의 static메서드를 부르려면, 클래스 이름을 붙이고 사용해야한다.
		
		// 인스턴스는 항상 메모리에 저장하는 공간을 만들고 저장후에 사용
//		               ======================== 동적 메모리 할당 (new)
		A a = new A();
		a.disp();
		System.out.println("a.c=" + a.c);
	}

}
