/*
 * << 왼쪽 이동
 * >> 오른쪽 이동
 * 
 * 10 <<2
 * ==
 *   1010(2)
 * 101000(2) = 40
 * 
 * 13 << 3
 *    1101 => 8+4+1 => 13
 * 1101000 => 104
 * 
 */
public class 연산자_비트이동연산자 {

	public static void main(String[] args) {
		/*
		 * **************************
		 * x << y
		 * ======> x * 2^y 
		 *
		 * x >> y
		 * ======> x / 2^y
		 * *************************
		 */
		System.out.println("10<<2 = " + (10<<2));
		System.out.println("13<<3 = " + (13<<3));
		System.out.println("7<<2 = " + (7<<2));
		System.out.println("10>>2 = " + (10>>2));
		System.out.println("25>>3 = " + (25>>3));
	}

}
