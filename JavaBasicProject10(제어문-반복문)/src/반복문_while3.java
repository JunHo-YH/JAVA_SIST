// 1 ~ 100������ ��, ¦����, Ȧ����

/*
 * 		while ����
 * 		=========
 * 		�ʱⰪ ==> ����			==> int i = 1
 * 		while(���ǽ�)	==> ��  ==> i <= 10
 * 		{
 * 			�ݺ����� => ����, �� ������ ������ŭ ����
 * 			������ i++;
 * 			
 * 		}
 * 
 * 		�ʱⰪ ==> ���� 	==> int i = 10;
 * 		while(i >= 1)
 * 		{
 * 			�ݺ�����
 * 			������ i--;	2���� ==> i += 2;, 3���� ==> i += 3;
 * 		}
 * 
 * 
 * 		=======> while�� Ƚ���� ���� ��쿡 �ַ� ����Ѵ�.
 * 				while(true) => ���ѷ���
 * 				{
 * 					���� => break;
 * 				}
 * 		
 */
public class �ݺ���_while3 {

	public static void main(String[] args) {
		int i = 1;
		
		int sum = 0;
		int even = 0;
		int odd = 0;
		while(i <= 100) {
			sum += i; // 100������ ��
			if(i % 2 == 0) { // Ȧ���� ���ϰ� �ʹٸ� if(i % 2 == 1)
				even += i;
			}
			else {
				odd += i;
			}
			i++;
		}
		
		
		System.out.println("�� ���� = " + sum);
		System.out.println("¦�� ���� = " + even);
		System.out.println("Ȧ�� ���� = " + odd);

	
	
	
	}

}
