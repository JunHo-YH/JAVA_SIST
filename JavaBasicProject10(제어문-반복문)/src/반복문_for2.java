/*
 * page 156p
 *  for�� �ַ� �ݺ�Ƚ���� �˰� �ִ� ��쿡 ����
 *  
 *  1. �ʱ�ȭ
 *  	for(int i = 0;
 *  		==========> ���α׷��� �°� �ʱ�ȭ�� �Ѵ�. (�⺻�� 0, 1)
 *  		==========> �ڹٴ� ���� 0
 *  2. ���ǽ�
 *  	for(int i = 0; i <= 10;
 *  				  ==========
 *  				  �ݺ� Ƚ�� ����
 *  3. ������
 *  	for(int i = 0; i < 10; i++)
 *  						  =====
 *  						i--, i+=2, i*=3 ...
 * 
 */
public class �ݺ���_for2 {

	public static void main(String[] args) {
		
		// A ~ Z
		for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
			System.out.print(alpha);
		}
		System.out.println();
	
		// z ~ a���� ���
		
		for (char alpha_ = 'z'; alpha_ >= 'a'; alpha_--) {
			System.out.print(alpha_);
		}
		
	}

}
