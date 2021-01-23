package com.sist.string;

/*
 * equals(): 문자열이 같은지 확인 (대소문자 구분)
 * 리턴형: boolean
 * 매개변수: String
 * 원형: public boolean equals(String str)
 * 
 * equalsIgnoreCase(): 문자열이 같은지 확인 (대소문자 구분 x)
 * 리턴형: boolean
 * 매개변수: String
 * 원형: public boolean equals(String str)
 * 
 * ### 자바에서는 문자열("") 자체가 주소
 * String s = "Hello";
 * s.equals("Hello")
 * "Hello".equasl(s) // 매개변수로 String 타입의 값이 있는 변수를 받을 수 있다.
 * 
 * ### 문자열 생성
 * String s = "Hello"; => {'H','e','l','l','o'}
 * String s = new String("Hello");
 * 
 * => 찾기, 오버라이딩, 조립
 * 
 * 
 * 
 */
public class MainClass9 {

	public static void main(String[] args) {
		// 같은 문자열이면 같은 주소를 가진다.
		String s1 = "Java";
		String s2 = "Java";
		String s3 = new String("JAVA"); // 새로운 메모리에 저장
		if (s1 == s2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		if (s1 == s3)
			System.out.println("같다");
		else
			System.out.println("다르다");
		System.out.println();
		// 주소를 비교하는 것이 아니라 실제 값이 값을 비교
		if (s1.equals(s2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		System.out.println();
		if (s1.equals(s3))
			System.out.println("같다");
		else
			System.out.println("다르다");
		System.out.println("=================");
		if (s1.equalsIgnoreCase(s3))
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		// equals를 오버라이딩을 해서 사용할 때와 단지 문자열을 비교하기 위해서 사용할 때를 정확히 구분하자.
		// 조금 헷갈리는데 여러번 반복해서 용도를 파악해야겠다.

	}

}
