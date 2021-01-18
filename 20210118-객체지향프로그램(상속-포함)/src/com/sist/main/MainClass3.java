package com.sist.main;

// 오버라이딩 (재정의)
// 모든 클래스는 Object로부터 상속받는다.
/*
 * 자바에서는 지원하는 라이브러리의 리턴형은 Object => 필요시마다 형변환을 시킨다.
 *                                          ====================== 제네릭스
 *                                          List<String>
 * 
 * 
 */
public class MainClass3 {
	// Object가 가지고 있는 메서드를 재정의
	private String name, addr, tel;
	// 시작할 때 사용자로부터 값을 받아서 멤버변수에 초기화
	public MainClass3(String n, String a, String t) { // 매개변수가 있는 생성자가 있기 때문에 default 생성자는 추가X
		this.name = n;
		addr = a;
		tel = t;
	}
/*
	public String toString() {
		return "이름:" + name + ", 주소: " + addr + ", 전화: " + tel;
	}
*/
	public static void main(String[] args) {
		Object m = new MainClass3("홍길동", "서울", "010-0000-0000");
		MainClass3 m2 = (MainClass3) m;
		/*
		 * 상위클래스로 객체 주소를 받는 경우 => 오버라이딩된 메서드만 호출이 가능
		 */
		String result = m.toString();
		System.out.println(result);
	}

}
