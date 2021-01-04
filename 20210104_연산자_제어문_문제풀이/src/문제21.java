/*
 * 주사위 2개를 던져서 합이 6일 경우의 갯수를 출력하고 총 갯수는 몇개인지 출력하시오.
 */
public class 문제21 {

	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 1; i <= 6; i++) {
			for(int k = 1; k <= 6; k++) {
				if(i + k == 6) {
					System.out.println("[" + i + "," + k + "]");
					count++;
				}
			}
		}
		System.out.println("합이 6일 경우의 갯수의 총 합은: " + count + "개입니다.");
	}

}
