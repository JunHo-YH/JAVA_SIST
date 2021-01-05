// for-each
public class 배열출력 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		//초기화 => index번호 이용
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100)  + 1; // 1 ~ 100 사이의 난수 생성
		}
		//출력 => for-each구문
		for (int i : arr) {
			System.out.println(i + " ");
		}
	}

}
