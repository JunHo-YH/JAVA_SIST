/*
 * 컴파일러 자동으로 첨부
 * 1. import java.lang.*;
 *          ==============
 *          String, System, Math
 * 2. 메서드 => void => return 첨부
 * 3. 모든 클래스는 생성자를 가지고 있다.
 *    없는 경우에 디폴트 생성자를 첨부
 * 4. 모든 클래스 생성
 *    class A extends Object
 *            ===============
 * 5. 모든 클래스는 예외처리를 가지고 있다: 생략할 수 있는 부분...
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
		System.out.println("Super: 생성자함수()...");
	}
}
class Sub extends Super {
	private int b = 10;
	public Sub() {
		System.out.println("Sub : 생성자 () Call...");
	}
	
	// 오버라이딩: 상속후에 변경
	/*
	 * 오버라이딩(재정의): 메서드의 내용 변경(재정의) => 수정이 용이하다. : 기능, 메서드명, 매개변수	
	 *   1) 상속을 받는다
	 *   2) 메서드명이 동일해야한다.
	 *   3) 매개변수가 동일해야한다.
	 *   4) 리턴형이 동일해야한다.
	 *   5) 접근지정어: 확장은 가능하지만, 축소는 불가능하다.
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
