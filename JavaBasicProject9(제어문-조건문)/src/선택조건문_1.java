/*
 * 	����)
 * 		if(���ǹ�) => ���ǹ�(������, ����, ��, ��)
 * 		{
 * 			���ǹ��� true�� ��, ó���ϴ� ����
 * 			(���� ������ ������ �� �ִ�)
 * 		}
 * 		else
 * 		{
 * 			���ǹ��� false�� ��쿡 ó���Ǵ� ����
 * 			(���� ������ ������ �� �ִ�)
 * 		}
 * 
 * 	����)
 * 		if(���ǹ�)
 * 			���๮�� 1
 * 			���๮�� 2 << if�� else�� ���踦 ���������.
 * 		else =================================> if �ؿ��� ó�� (else�� �ܵ� ���๮���� ���� �� ����)
 * 			���๮�� 3
 * 		
 *		�ڹ�
 * 		if(���ǹ�) {
 * 			
 * 		}
 * 
 * 		C���
 * 		if(���ǹ�)
 * 		{
 * 
 * 		}
 */
// 3���� ������ �Է� => ��� ==> 60�̻��̸� Pass �ƴϸ� Non-Pass
import java.util.Scanner;

public class �������ǹ�_1 {

	public static void main(String[] args) {
		// �Է¹��� �����͸� ������ ���� => ���� 4��
		Scanner scan = new Scanner(System.in);
		int kor, eng, math, avg;
		System.out.print("���� ���� ���� ���� �Է� >> "); // enter, space
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		/*
		System.out.print("������ ������ �Է��ϼ��� >> ");
		kor = scan.nextInt();
		
		System.out.print("������ ������ �Է��ϼ��� >> ");
		eng = scan.nextInt();

		System.out.print("������ ������ �Է��ϼ��� >> ");
		math = scan.nextInt();
		*/
		
		avg = (kor + eng + math) / 3;
		
		System.out.println("��������� " + avg + "���Դϴ�.");
		if(avg >= 60)
			System.out.println("Pass !");
		else
			System.out.println("Non-Pass");
		
	}

}



















