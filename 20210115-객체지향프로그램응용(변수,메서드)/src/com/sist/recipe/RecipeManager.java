package com.sist.recipe;

import java.util.Scanner;

/*
 * class에서 선언되는 모든 변수 => private
 * => method를 이용해서 보여준다.
 */
public class RecipeManager {
	private static String[] menu1 = { "밑반찬", "메인반찬", "찌개", "디저트", "만두", "	밥", "죽", "퓨전", "김치", "젓갈", "장류", "양념", "소스", "잼",
			"양식", "샐러드", "스프", "빵", "과자", "음료", "술" };
	private static String[] menu2 = { "일상", "초스피드", "손님접대", "술안주", "다이어트도시락", "영양식", "간식", "야식", "푸드스타일링", "해장", "명절",
			"이유식" };
	private static String[] menu3 = { "소고기", "돼지고기", "닭고기", "육류", "채소류", "해물류", "달걀", "유제품", "가공식품류", "쌀", "밀가루",
			"건어물류", "버섯류", "과일류", "콩", "견과류", "곡류" };
	private static String[] menu4 = { "볶음", "끓이기", "부침", "조림", "무침", "비빔", "찜", "절임", "튀김", "삶기", "굽기", "데치기", "회" };

	public int main_menu() {
		System.out.println("================ Main Menu ================");
		System.out.println("1. 종류별, 2. 상황별,  3. 재료별,  4. 방법별");
		Scanner scan = new Scanner(System.in);
		System.out.print("메인 메뉴를 선택하세요: ");
		int no = scan.nextInt();
		return no;
	}

	public String su_menu(int no) {
		String data ="";
		String[] menu = null;
		switch (no) {
		case 1:
			menu = menu1;
			break;
		case 2:
			menu = menu2;
			break;
		case 3:
			menu = menu3;
			break;
		case 4:
			menu = menu4;
			break;

		}
		System.out.println("==================== Sub Menu ====================");
		int i = 1;
		for (String s : menu) {
			System.out.println(i + ". " + s);
			i++;
		}	
		Scanner scan = new Scanner(System.in);
		System.out.print("레시피를 선택하세요: ");
		int r = scan.nextInt();
		data = menu[r -1];
		
		return data;
	}

	public static void main(String[] args) {

		RecipeManager rm = new RecipeManager();
		int no = rm.main_menu();
		String data = rm.su_menu(no);
		System.out.println("선택한 레시피는 " + data);
	}

}
