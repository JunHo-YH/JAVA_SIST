/*
 * 		*
 *     **
 *    ***
 *   ****
 *    ==================
 *    i	   j   k                i,j                                i,k
 *    �ټ� ���� ��ǥ              i + j = 4, j = 4 - i                i = k => k = i
 *    1   3   1
 *    2   2   2
 *    3   1   3
 *    4   0   4
 *    
 *    
 *    ++++
 *     +++
 *      ++
 *       +
 *       =========
 *       i    j     k
 *       �ټ�  ����  ��ǥ
 *       1	  0		4                 ij, ik
 *       2	  1		3				i - j = 1 => j = i - 1
 *       3	  2		2				i + k = 5 => k = 5 - i
 *       4    3		1
 */
public class ���߹ݺ���_4 {

	public static void main(String[] args) {
		for ( int i = 1; i <= 4; i++) {
			// �������
			for (int j = 1; j <= 4 - i; j++) {
				System.out.print(" ");
			}
			
			// ��ǥ���
			for (int k = 1; k <= i; k++) {
				System.out.print("��");
			}
			System.out.println();
		}
		
		for( int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			
			for (int k = 1; k <= 5 - i; k++) {
				System.out.print("��");
			}
			System.out.println();
		}
		
		
		
	}

}
