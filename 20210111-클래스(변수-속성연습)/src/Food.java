
public class Food {
	static String title = "만개의 레시피";
	String writer;
	String name;
	String story;
	int people;
	int time;
	String level;
	String[] material;
	String[] flow;
	String warning;

	public static void main(String[] args) {
		Food f = new Food();
		f.writer = "요리하는러라";
		f.name = "닭봉간장조림~ 십년째 만들어 먹는 양념 공유해요!";
		f.story = "초간단 조리과정과 집에 있는 착한 양념에 비해 미친 비주얼을 자랑하는 닭봉조림~ 언제 어디에서 누구에게 해줘도 인기만점 레시피예요";
		f.people = 2;
		f.time = 60;
		f.level = "아무나";
		f.material = new String[10];
		f.material[0] = "닭봉 20개";
		f.material[1] = "우유 적당히";
		f.material[2] = "대파 1/2대";
		f.material[3] = "소주 1/2컵";
		f.material[4] = "간장 5숟가락";
		f.material[5] = "설탕 2숟가락";
		f.material[6] = "식초 2숟가락";
		f.material[7] = "청주 2숟가락";
		f.material[8] = "케첩 1숟가락";
		f.material[9] = "물엿 1숟가락";

		f.flow = new String[13];
		f.flow[0] = "1. 닭봉 2팩, 갯수로는 20개를 준비해요";
		f.flow[1] = "2. 닭봉이 잠기게 우유를 부은 후 30분간 재워 잡내를 제거해줍니다";
		f.flow[2] = "3. 30분 후, 우유를 헹궈내고 체에 밭쳐 물기를 빼주세요(일반적인 냉장닭 밑손질은 여기서 마무리하고 Step6으로 가세요~)";
		f.flow[3] = "4. 냉동닭이나 잡내가 심한 냉장닭은 데치는 과정을 추가해주세요(선택사항)";
		f.flow[4] = "5. 팔팔 끓는 물에 닭과 소주 반컵을 넣고 3분간 데친 후 하나하나 씻어줍니다 ^^";
		f.flow[5] = "6. 오목한 조림팬에 간장 5, 설탕 2, 식초 2, 청주 2, 케첩 1, 물엿 1을 넣어 섞은 다음";
		f.flow[6] = "7. 닭을 담고 대파 반대를 큼직하게 잘라 넣고";
		f.flow[7] = "8. 양념과 재료를 고루 섞어 뚜껑을 덮고 중불로 20분간 조려줍니다 (중불)";
		f.flow[8] = "9. 중강중간 뚜껑을 열고 위아래 위치를 고루 바꿔가며 조려주세요~ 물을 넣지 않았지만 자박자박 수분이 나오면서 타지 않아요 ^^";
		f.flow[9] = "10. 중불로 20분 졸여낸 모습입니다~ 색이 많이 달라졌죠? 이제 뚜껑을 열고 국물이 졸아들도록 중강불로 10분 정도 더 조려주면 윤기가 반짝반짝 나면서 완성됩니다!! (중간불)";
		f.flow[10] = "대파는 건져내고 담아주세요~ 양념, 닭, 대파 섞어 뚜껑덮고 중불 20분, 뚜껑열고 중강불 10분, 중간중간 섞어주기~ 간단하죠 :)";
		f.flow[11] = "한입에 쏙쏙 집어먹기도 좋고 무엇보다 양념이 진짜 찐으로 맛있으니까 꼭 한번 만들어보세요~ 다진 땅콩이나 쪽파를 올려도 좋습니다";
		f.flow[12] = "단짠단짠으로는 표현하기 부족한 닭봉간장조림~ 딱 한번만 만들어 보면 자주 만나고 싶은 단골메뉴가 될거예요 :D";

		f.warning = "1)이 양념레시피에 채소를 함께 졸여 내는 건 어울리지 않아요~ 오로지 닭봉만 조려주세요 ^^ (닭날개도 좋습니다!)";

		System.out.println(
				"===============================================================================================");
		System.out.println("제목:	" + f.name);
		System.out.println("소개: " + f.story);
		System.out.print("           " + f.people + "인분 \t");
		System.out.print(f.time + "이내 \t");
		System.out.print(f.level);
		System.out.println("\n===== 재료 =====");
		System.out.println(f.material[0]);
		System.out.println(f.material[1]);
		System.out.println(f.material[2]);
		System.out.println(f.material[3]);
		System.out.println(f.material[4]);
		System.out.println(f.material[5]);
		System.out.println(f.material[6]);
		System.out.println(f.material[7]);
		System.out.println(f.material[8]);
		System.out.println(f.material[9]);

		System.out.println("===== 조리 순서 =====");
		System.out.println(f.flow[0]);
		System.out.println(f.flow[1]);
		System.out.println(f.flow[2]);
		System.out.println(f.flow[3]);
		System.out.println(f.flow[4]);
		System.out.println(f.flow[5]);
		System.out.println(f.flow[6]);
		System.out.println(f.flow[7]);
		System.out.println(f.flow[8]);
		System.out.println(f.flow[9]);
		System.out.println(f.flow[10]);
		System.out.println(f.flow[11]);
		System.out.println(f.flow[12]);
		System.out.println("===== 주의 사항 ======");
		System.out.println(f.warning);

	}

}
