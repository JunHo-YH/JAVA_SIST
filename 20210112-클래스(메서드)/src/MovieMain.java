import java.util.Scanner;
public class MovieMain {
	public static void main(String[] args) {
		// 데이터 받기
		MovieSystem ms = new MovieSystem(); // movieAllData() 저장
		Movie[]  m = ms.movieAllData();
		
		// 출력
		int i = 1;
		for (Movie movie : m) {
			System.out.println(i + "." + movie.title);
			//System.out.println("가수명:" + movie.singer);
			//System.out.println("앨범: " + movie.album);
			//System.out.println("============================================");
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("번호를 입력: ");
		int no = scan.nextInt();
		Movie mm = ms.movieDetailData(no);
		// 출력
		System.out.println("노래명: " + mm.title);
		System.out.println("가수명:" + mm.singer);
		System.out.println("앨범: " + mm.album);
		System.out.println("상태: " + mm.state + "(" + mm.modify + ")");
		
		/*
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력: ");
		String ss = scan.next();
		Movie[] mm = ms.movieFindData(ss);
		
		// 출력
		for (Movie movie : mm) {
			System.out.println("노래명: " + movie.title);
			System.out.println("가수명:" + movie.singer);
			System.out.println("앨범: " + movie.album);
			System.out.println("============================================");
		}
		
		
		System.out.println("가수명 입력: ");
		String singer = scan.next();
		String[] s = ms.singerFindData(singer);
		for (String sss: s) {
			System.out.println(sss);
			System.out.println("======================================");
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
	}
}
