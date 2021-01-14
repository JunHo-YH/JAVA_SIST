/*
 * 상속
 *  => 기존의 클래스의 모든 기능과 모든 데이터를 받아서 확장하는 클래스를 만든다.
 *  => 상속의 형식
 *     ========
 *     class A
 *     class B extends A
 *          ==        == 상속을 내리는 클래스
 *          상속을 받는 클래스
 *  => 자바 상속은 단일 상속이다.
 *  => 재사용: 있는 그대로 사용 : 포함클래스
 *  		  변경해서 사용: 상속
 *  
 *  => 사용법
 *   extends 
 *   
 *   class A
 *   class B extends A
 *   *** 상속을 받는 경우 (기본은 상속내리는 클래스의 모든 것을 받아온다)
 *       단, 예외 조건(static변수, static메서드, 생성자는 예외)
 *                  ====================== 상속받는 클래스는 사용이 가능
 *          private은 상속은 내려가는데 사용이 불가능하다 (private -> protected -> 사용가능)
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
