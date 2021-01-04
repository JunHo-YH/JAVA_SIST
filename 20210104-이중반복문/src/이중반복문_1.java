/*
 * 	★
 * 	★★
 * 	★★★
 * 	★★★★
 * =================================
 * 	i	j
 * 줄수	별표		i = j ==> j = i
 * 1	1
 * 2	2
 * 3	3
 * 4	4
 * 
 * 
 * 	★★★★
 * 	★★★
 * 	★★
 * 	★
 * ===========================
 * i	j
 * 줄수	별표		i + j = 5 ==> j = 5 - i		==> 수열
 * 1	4 = 5
 * 2	3 = 5
 * 3	2 = 5
 * 4	1 = 5	=> 역순 = 더한다.
 * 
 * ABCD
 * EFGH
 * IJKL
 * MNOP
 * 
 */
public class 이중반복문_1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println(); // 다음 줄로 이동
		}
		
		System.out.println();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("★");
			}
			System.out.println(); // 다음 줄로 이동
		}
		
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			for (int k = 1; k <= 10; k++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println();
		
		char c = 'A';
		for( int i = 1; i <= 4; i++) {
			for(int k = 1; k <= 4; k++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		System.out.println();
		
		for( int i = 1; i <= 4; i++) {
			for (char d = 'A'; d <= 'D'; d++) {
				System.out.print(d);
			}
			System.out.println();
		}
		System.out.println();
		
		for( int i = 1; i <= 4; i++) {
			c = 'A'; // 변수의 위치에 따라 값이 달라진다.
			for(int k = 1; k <= 4; k++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
	}

}
