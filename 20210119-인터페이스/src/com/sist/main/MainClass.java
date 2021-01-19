package com.sist.main;

/*
 * JDK 1.0
 * JDK 1.2
 * JDK 1.5
 * JDK 1.8
 * 인터페이스(interface)
 * 1) 추상 클래스의 일종 => 추상클래스이 단점을 보완
 *    # 자바의 클래스는 무조건 단일 상속만 가능
 *    # 인터페이스도 클래스다 (다중 상속 가능)
 *    
 * 2) 형식
 *    접근지정어 interface 인터페이스명 {
 *        ====================
 *          변수 (멤버변수(X)): 상수형 변수
 *        ====================
 *          추상메서드 (선언된 메서드)
 *        ====================
 *          구현된 메서드 (JDK 1.8 이상)
 *          default
 *        ====================
 *          static
 *        ====================
 *    }
 *    
 * 3) 추상 클래스와 동일 => 공통적인 속성을 모아서 저장 => 구현해서 사용
 *    ** 서로 다른 클래스를 연결할 때 사용
 *    ** 표준화가 가능하다
 *    
 *    *** 인터페이스는 모든 변수와 메서드는 public만 사용이 가능.
 *    public interface Cmmon {
 *        ***** int a; // 상수형 변수 ==> int a = 10; ===> public static final int a;
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
 *        void display() {} // 오류
 *        => public void display() {}
 *        오버라이딩 => 접근지정어가 확대는 가능, 축소는 불가능
 *    }
 *    
 *    상속
 *    class A
 *    class B               => 클래스 A가 클래스 B에 상속
 *                             class B extends A
 *    interface A
 *    class B               => 인터페이스 A가 클래스 B에 상속
 *                             class B implements A
 *    ====================================================
 *    interface A
 *    interface B           => 인터페이스 A가 인터페이스B에 상속
 *                             interface B implements A  (X)    => interface B extends A
 *                             
 *                             
 *    ==================================================== 인터페이스는 클래스로부터 상속을 받을 수 없다)
 *                             
 *    class A
 *    interface B           => classA가 인터페이스 B에 상속
 *                             interface B extends A      => 존재하지 않는다.
 *   
 *   
 *    interface A
 *    interfac B extends A
 *    class C implements B ==> 단일 상속
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
	int x = 10; // public static final 생략
	void display(); // public abstract 생략
	default void aaa() { // 구현할 경우 default | static을 붙여서 구현해야한다.
						// default | static을 붙여야 구현된 메서드를 만들 수 있다.
		
	}
	static void bbb() {
		
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
