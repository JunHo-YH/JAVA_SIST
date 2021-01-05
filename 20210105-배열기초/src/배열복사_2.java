// 라이브러리 이용
public class 배열복사_2 {

	public static void main(String[] args) {
		String[] names = {"홍길동", "이순신", "강감찬", "을지문덕", "박문수"};
		String[] members = new String[10];
		String s;
//		System.arraycopy(복사대상, 시작번호, 받을대상, 시작번호, 몇개);
		
		// 실행
		System.arraycopy(names, 0, members, 0, 5);
		for(String name : members) {
			System.out.println(name);
		}
		System.out.println();
		System.arraycopy(names, 0, members, 5, 5);
		for(String name : members) {
			System.out.println(name);
		}
		System.out.println();
		
		
	}

}
