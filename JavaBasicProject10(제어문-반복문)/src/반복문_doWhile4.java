// 1 ~ 10 => 1. ¦���� ���, 2. Ȧ���� ���
/*
 * 645 ==>  ����� 6
 * 	 		�ʴ��� 4
 * 			�ܴ��� 5
 * 
 * int a = 645;
 * int b = 0, c = 0, d = 0;
 * 
 * b = a / 100 ==> 6
 * c = (a % 100) / 10 ==> 4
 * d = 645 % 10 ==> 5
 * 	
 */
public class �ݺ���_doWhile4 {

	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("Ȧ�� :" + i);
			i += 2;
		} while (i <= 10);
		
		System.out.println("¦�� ���");
		i = 1;
		do {
			if(i % 2 == 0)
				System.out.println("¦��: " + i);
			i++;
		} while(i <= 10);
	}

}
