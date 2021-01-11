
public class FoodHouse {
	String name;
	double score;
	String address1;
	String address2;
	String tel;
	String type;
	String price;
	String parkPlace;
	String busineeHours;
	String breakTime;
	String[] menu;
	int good;
	int soso;
	int bad;
	static String title = "망고플레이트";
	// poster

	public static void main(String[] args) {
		FoodHouse f = new FoodHouse();
		f.name = "";
		f.score = 4.3;
		f.address1 = "서울특별시 강동구 올림픽로60길 5 한스빌딩 1F";
		f.address2 = "서울시 강동구 성내동 111-55 한스빌딩 1F";
		f.tel = "02-474-3520";
		f.type = "태국 음식";
		f.price = "만원-2만원";
		f.parkPlace = "주차공간없음";
		f.busineeHours = "11:30 - 21:30";
		f.breakTime = "14:30 - 17:00";
		f.menu = new String[4]; // 배열이 있는 경우 => 반드시 크기 설정
		f.menu[0] = "팟타이 10,000원";
		f.menu[1] = "뿌팟퐁커리 (2마리) 18,000원";
		f.menu[2] = "똠양꿍 12,000원";
		f.menu[3] = "꾸웨이띠오 9,000원";
		f.good = 58;
		f.bad = 10;
		f.soso = 9;
		
		System.out.println("===== 상세보기 =====");
		System.out.println(f.name + " " + f.score);
		System.out.println("주소: " + f.address1);
		System.out.println("     지번:" + f.address2);
		System.out.println("전화번호: " + f.tel);
		System.out.println("음식종류" + f.type); 
		System.out.println("가격대: " + f.price);
		System.out.println("주차: " + f.parkPlace);
		System.out.println("영업시간: " + f.busineeHours);
		System.out.println("쉬는시간: " + f.breakTime);
		System.out.println("메뉴:");
		for (String s : f.menu) {
			System.out.println(s);
		}
		System.out.println("리뷰(" + (f.good + f.soso + f.bad) + ")");
		System.out.println("맛있다: " + f.good);
		System.out.println("괜찮다:" + f.soso);
		System.out.println("별로다:" + f.bad);
		System.out.println("\n데이터참조 업체: " + f.title);
		
	}

}
