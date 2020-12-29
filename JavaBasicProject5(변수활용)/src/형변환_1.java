/*
 * 형변환 : 변수의 데이터를 다른 데이터형으로 변환
 * 1. 가장 많이 변경
 * 		Web, 윈도우 프로그래, 모바일 프로그램 : 정수가 없다(문자열)
 * 		문자열 => 정수형으로 변경
 * 		===================
 * 1-1  문자=> 정수  or  정수 => 문자로 변환
 * 		정수 => 실수 or  실수 => 정수로 변환
 * 
 * 1-2 
 * 		1. 자동 형변환 (Up Casting) =====> 작은 데이터형이 큰 데이터형으로 변환
 * 			int a = 'A'
 * 					=== int로 변경
 * 			long a = 100
 * 					=====
 * 					int => long(100L)로 변경
 * 			double d = 100
 * 					   ====
 * 						int ===> double(100.0)로 변경
 * 			데이터형의 크기 (숫자(정수, 실수), 문자)
 * 			==========================================
 * 			byte < short < int < long < float < double
 * 				   char
 * 			===========================================
 * 			double a = 'A'
 * 					  =====char ==> double(65.0)
 * 		2. 강제 형변환 (Down Casting) ===> 큰 데이터형을 작은 데이터형으로 변환
 * 
 */
public class 형변환_1 {

	public static void main(String[] args) {
		int a ='A'; // 'A' => (int변경 => 65)
		System.out.println("a= " + a);
		
		double d = 'A'; // 'A' => (double로 변경 => 65.0)
		System.out.println("d= " + d);
		
		double d1 = 100;
		System.out.println("d1 = " + d1);
		// 작은 데이터형 값을 첨부 => 큰데이터형으로 변환
		// int a = 100;  char c = 'a';
		
		int a1 =(int) 10.5; // 실수 => 정수 (소수점은 인식하지 않는다) => a1 = 10
		System.out.println("a1 = " + a1);
		// 강제 형변환 ==> (변경할 데이터형) 값
		
		int a2 = Integer.parseInt("100");
		System.out.println(a2);
		
		
		/*
		 * 	숫자와 관련된 내용만 가능
		 *  int 	=> char		(char)65  	=> 'A'
		 *  char 	=> int		(int)'A'  	=> 65
		 *  double	=> int		(int)10.5	=> 10
		 *  int		=> double	(double)10	=> 10.0
		 *  
		 *  
		 *  형변환 : 	큰 데이터형에 작은 데이터를 대입할 경우에는 자동변환이 된다.
		 *  		double d = 'A';
		 *  		
		 *  		작은 데이터형을 큰 데이터형에 대입할 경우에는 반드시 지정된 데이터형을 설정해야한다.
		 *  		int a1 = (int)10.5;
		 *  
		 */
		
		// 형변환 주의점 ==> 오버플로우
		byte b1 = (byte)350;	// 범위를 벗어남
		/*
		 * 1 0101 1110
		 * => byte => 0000 0000
		 * 			  0101 1110(8bit만 가져옮)
		 */
		System.out.println(Integer.toBinaryString(350));
		System.out.println(0b01011110);
		System.out.println("b1 = " + b1);
		
		
		
		
	}

}
