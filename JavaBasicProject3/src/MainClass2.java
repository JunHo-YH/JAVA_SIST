// 한 개의 파일 안에 여러 개의 클래스를 만들 수 있다.
// public class => 한 개만 존재해야한다.
// 저장명은 반드시 public이 있는 클래스 이름으로 한다.
/* 
 *  main() => 자동으로 인식하는 기능
 *  ======
 *   원형
 *    
 *    static public void main(String[] args)
 *    == public static  void main(String[] args)
 *    == public static  void main(String[] abcd)
 *    
 *    
 *    // 실행 과정
 *    java MainClass2
 *    	1. MainClass2.class 파일 찾기(javac)
 *    	2. 클래스검사 (오류)
 *    	3. main() => 출력한다.
 *    ================ main() 실행
 * 
 * */
class MainClass3 {

}

public class MainClass2 {

	public static void main(String[] args) {
		System.out.println("Hello Java");
	}

}
