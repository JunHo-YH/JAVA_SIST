
/*
 * 변수
 *   = 멤버 변수
 *   = 공유 변수: static
 *   = 지역 변수
 * 메서드
 *   = 멤버 메서드
 *   = 공유 메서드(클래스메서드): static
 *   = 추상 메서드
 * ===================================
 * 1. 데이터를 묶어서 처리
 * 2. 명령문을 묶어서 처리
 * ================= + 클래스(변수 + 메서드)
 */
import java.util.Scanner;

public class 메서드활용_5 {

	// * 1. 메뉴
	static int menu() {
		Scanner scan = new Scanner(System.in); // 메뉴선택
		// 메뉴를 보여준다
		System.out.println("================ 메뉴 ================");
		System.out.println("1. 뮤직 Top50 전체 보기");
		System.out.println("2. 노래 검색");
		System.out.println("3. 가수명 검색");
		System.out.println("4. 상세 보기");
		System.out.println("5. 프로그램 종료");
		System.out.println("=====================================");

		int m = 0;
		while (true) {
			System.out.print("메뉴를 선택하세요(1 ~ 5): ");
			m = scan.nextInt();
			if (m < 1 || m > 5) {
				System.out.println("없는 메뉴입니다 !!");
				continue;
			}
			break; // while문을 종료합니다.
		}
		return m;

	}

	// * 2. 전체 목록
	static void musicAllData() {
		String[] title = 메서드활용_4.title;
		String[] singer = 메서드활용_4.singer;
		String[] album = 메서드활용_4.album;
		System.out.println("******************** 음악 전체 목록 ********************");
		for (int i = 0; i < 50; i++) {
			System.out.println("노래명: " + title[i]);
			System.out.println("가수명: " + singer[i]);
			System.out.println("앨범명: " + album[i]);
			System.out
					.println("***************************************************************************************");
		}

	}

	// * 3. 노래찾기
	static void musicFindData() {
		Scanner scan = new Scanner(System.in);
		System.out.print("노래 검색: ");
		String ss = scan.next();
		String[] title = 메서드활용_4.title;
		System.out.println("******************** 검색 결과 ********************");
		for (String s : title) {
			if (s.contains(ss)) {
				System.out.println(s);
			}
		}

	}

	// * 4. 가수명으로 노래 찾기
	static void singerFindData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("가수명 입력: ");
		String s = scan.next();
		String[] title = 메서드활용_4.title;
		String[] singer = 메서드활용_4.singer; // title과 인덱스 번호가 같다.
		System.out.println("================== 노래 목록 =======================");
		for (int i = 0; i < 50; i++) {
			if (singer[i].startsWith(s)) {
				System.out.println(title[i]);
			}
		}

	}

	// * 5. 상세보기
	static String[] detailData() {

		String[] result = new String[4];

		Scanner scan = new Scanner(System.in);
		String[] title = 메서드활용_4.title;
		System.out.println("==================== 선택 목록 =====================");
		for (int i = 0; i < 50; i++) {
			System.out.println((i + 1) + "." + title[i]);
		}
		System.out.print("번호를 선택하세요 (1 ~ 50): ");
		int selNum = scan.nextInt();
		// System.out.println("==================================================");
		String mTitle = 메서드활용_4.title[selNum - 1]; // 배열은 0부터 시작하기 때문에, 89번라인에서 선택한 번호 -1을 해서 인덱스 번호를 맞춘다.
		String singer = 메서드활용_4.singer[selNum - 1];
		String album = 메서드활용_4.album[selNum - 1];
		String state = 메서드활용_4.state[selNum - 1];
		int modify = 메서드활용_4.modify[selNum - 1];

		// System.out.println("노래명: " + mTitle);
		// System.out.println("가수명: " + singer);
		// System.out.println("앨범:" + albume);
		String ss = "";
		if (state.equals("상승")) {
			ss = "▲" + modify;
		} else if (state.equals("하강")) {
			ss = "▽" + modify;
		} else {
			ss = "-";
		}
		// System.out.println("등폭:" + ss);
		// System.out.println("==================================================");
		result[0] = mTitle;
		result[1] = singer;
		result[2] = album;
		result[3] = ss;
		return result;
	}
	// * 6. 종료
	// 조립
	static void process() {
		while (true) {
			int m = menu();
			switch (m) {
			case 1:
				musicAllData();
				break;
			case 2:
				musicFindData();
				break;
			case 3:
				singerFindData();
				break;
			case 4:
				String[] s = detailData();
				System.out.println("노래명: " + s[0]);
				System.out.println("가수명: " + s[1]);
				System.out.println("앨범: " + s[2]);
				System.out.println("등폭: " + s[3]);
				break;
			case 5:
				System.out.println("프로그램 종료");
				System.exit(0);// 프로그램 종료
//				break; ==> switch문만 빠져나간다.
			}
		}
	}
	

	public static void main(String[] args) {
		process();
	}

}
