// Scanner : Ű���� �Է°��� �޾Ƽ� �޸𸮿� ����
// BufferedReader : ����ó��
// Scanner�� ����ϱ� ���ؼ� �ݵ�� Ŭ������ �ҷ��;� �Ѵ�.
// �̹� ������� Ŭ������ �о�� �� ��� : import
import java.util.Scanner;
/*
 * 	import : �ڹ�, ��Ʋ��
 * 	include : C
 * 	using : C#
 *
 * 	
 */
public class ����_4 {

	public static void main(String[] args) {
	// Scanner�� ����ϴ� ���
		Scanner scan = new Scanner(System.in);
		// new => �޸� �Ҵ�, System.in => Ű���� �Է°�
//		System.out.print("���� �Է�: ");
		// Ű����� �Է��� ������ �����Ѵ�.
//		int input = scan.nextInt();
//		System.out.println("Ű���� �Է°� : " + input);
		int kor, eng, math;
		
		System.out.print("���� ���� �Է� >> ");
		kor = scan.nextInt();
		System.out.print("���� ���� �Է� >> ");
		eng = scan.nextInt();
		System.out.print("���� ���� �Է� >> ");
		math = scan.nextInt();
		int total = kor + eng + math;
		double avg = (total) / 3.0;
		// ������� ���
		System.out.println("���� : " + total);
		System.out.printf("%.2f", avg );
		
		// ����ڷκ��� �Է°��� �޾Ƽ� ó�� Scanner
		/*
		 * �Է�
		 * 	Scanner => Ű���� �Է°��� �޴� ��쿡 �ַ� ���
		 * 	// Scanner => Ŭ����
		 * 	= import java.util.Scanner
		 * 	= Scanner�� ����
		 * 	  *** Ŭ������ ������ �ÿ��� �ݵ�� new�� ����ؼ� ����
		 * 	  Scanner scan = new Scanner(System.in);
		 * 	= �Է��� �Ǹ�
		 * 	  *** scan.nextInt() =>  ������ �Է� �� ��
		 * 	  ** scan.next(); => ���ڿ��� �Է��� ��
		 * 	  scan.nextDouble(); => �Ǽ��� �Է��� ��
		 * 	  scan.nextBoolean(); => ������ �Է��� ��
		*/		
		
	}

}
