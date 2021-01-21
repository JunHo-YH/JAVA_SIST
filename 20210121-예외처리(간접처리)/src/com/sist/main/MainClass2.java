package com.sist.main;
/*
 * 예외 회피: 시스템에서 처리 => throws
 * 형식)
 *     접근지정어 리턴형 메서드명(매개변수...) throws 예상되는 에러 등록
 *     ex)
 *        public void display() throws NumberFormatException, NullPointerException
 *        								, ClassCastingException, Exception
 *                                     ==================================== 순서가 없다.
 *                                     
 */
import java.io.*;
public class MainClass2 {
	public void display() throws Exception, NumberFormatException, ArithmeticException, ArrayIndexOutOfBoundsException {
		
	}
	public static void main(String[] args) throws Exception{ //main은 누가 호출하나? 함수처럼 호출이 가능한가?
		MainClass2 m = new MainClass2();
		m.display();
		FileReader fr = new FileReader("c:\\javaDev\\movie.json");
	}

}
