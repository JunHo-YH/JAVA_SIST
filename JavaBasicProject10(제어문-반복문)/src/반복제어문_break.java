/*
 * 		break: 반복문(while, do~while, for), switch ==> 반복문을 종료
 * 				break => 무한루프(while)
 */
public class 반복제어문_break {

	public static void main(String[] args) {
		// i값을 출력 => 1에서부터 100까지
		for(int i = 1; i<= 100; i++) {
			if (i == 10)
				break;
			System.out.println("i= " + i);
		}
	}

}
