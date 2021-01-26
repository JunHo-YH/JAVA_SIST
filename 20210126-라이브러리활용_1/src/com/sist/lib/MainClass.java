package com.sist.lib;

/*
 * java.util.*
 * ===========
 * 목적: 웹 (Spring(Java,Kotline), Django(Python))
 *      ==
 *      데이터베이스 (오라클) : 문자열,숫자날짜
 *                         =====
 *                         String, int(Integer), double, Date(Calendar)
 * 1. StringTokenizer: split(배열) => 빅데이터(분석)
 *    = hasMoreTokens(): boolean
 *    = NextToken(): 실제 데이터를 가지고 온다. : return String
 *    = counterTokens(): 갯수: return int
 *    = 데이터베이스, 네트워크
 * 2. Date: 시스템의 시간을 읽는다., 날짜 제어: Calendar (달력: 일정표, 예매)
 * 3. 변환
 *    = SimpleDateFormat: 날짜를 변환해서 출력
 *                        년도: yyyy (yy)
 *                        월: MM(M) => 01(1) => 08부터는 8진법 표기법에 걸린다.=> 되도록이면 M을 사용하자
 *                        일: dd(d)
 *                        시간: hh(h)
 *                        분: mm(m)
 *                        초: ss(s)
 *    = ChoiceFormat
 *    = MessageFormat
 * 
 */

import java.util.*;
import java.text.*; //변환(Format)

class A {
	int aa = 10;
	public void dispaly() {
		System.out.println("A: display Call");
	}
}

// TO_CHAR('123456789', '99,999,999') => 12,345,678 숫자 변환은 오라클에서, 문자는 자바에서 변환하는게 편하다.
public class MainClass {

	public static void main(String[] args) {
		// 1. 시스템의 시간 읽기
		Date date = new Date();

		// 2. 날짜를 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		String today = sdf.format(date);

		// 3. 실행
		System.out.println(today);
		
		// 분리
		StringTokenizer st = new StringTokenizer(today, "-");
		String strYear = st.nextToken();
		String strMonth = st.nextToken();
		String strDay = st.nextToken();
		
//		strMonth = "08";
		System.out.println("년도: " + strYear);
		System.out.println("월: " + strMonth);
		System.out.println("일: " + strDay);
		
		// 5. 정수형으로 변환
		int year = Integer.parseInt(strYear);
		int month = Integer.parseInt(strMonth);
		int day = Integer.parseInt(strDay);
		System.out.println("정수로 변환 후 출력");
		System.out.println("년도: " + year);
		System.out.println("월: " + month);
		System.out.println("일: " + day);
		/*
		String today2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		System.out.println(today2);

		A a = new A();
		a.dispaly();
		a.aa = 10;
	
		new A().dispaly();
		new A().aa = 30;
		*/
	}

}
