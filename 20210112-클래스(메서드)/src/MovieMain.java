import java.util.Scanner;
public class MovieMain {
	public static void main(String[] args) {
		// ������ �ޱ�
		MovieSystem ms = new MovieSystem(); // movieAllData() ����
		Movie[]  m = ms.movieAllData();
		
		// ���
		int i = 1;
		for (Movie movie : m) {
			System.out.println(i + "." + movie.title);
			//System.out.println("������:" + movie.singer);
			//System.out.println("�ٹ�: " + movie.album);
			//System.out.println("============================================");
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("��ȣ�� �Է�: ");
		int no = scan.nextInt();
		Movie mm = ms.movieDetailData(no);
		// ���
		System.out.println("�뷡��: " + mm.title);
		System.out.println("������:" + mm.singer);
		System.out.println("�ٹ�: " + mm.album);
		System.out.println("����: " + mm.state + "(" + mm.modify + ")");
		
		/*
		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �Է�: ");
		String ss = scan.next();
		Movie[] mm = ms.movieFindData(ss);
		
		// ���
		for (Movie movie : mm) {
			System.out.println("�뷡��: " + movie.title);
			System.out.println("������:" + movie.singer);
			System.out.println("�ٹ�: " + movie.album);
			System.out.println("============================================");
		}
		
		
		System.out.println("������ �Է�: ");
		String singer = scan.next();
		String[] s = ms.singerFindData(singer);
		for (String sss: s) {
			System.out.println(sss);
			System.out.println("======================================");
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
	}
}
