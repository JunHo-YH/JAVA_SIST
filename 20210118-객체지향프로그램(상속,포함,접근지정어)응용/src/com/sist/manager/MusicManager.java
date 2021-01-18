package com.sist.manager;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 *   {"genie":[
 *       {"singer":"iKON",
 *        "movie":"vecSVX1QYbQ",
 *        "rank":"1",
 *        "title":"사랑을 했다 (LOVE SCENARIO)",
 *        "poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/019\/709\/81019709_1516862241098_1_140x140.JPG"
 *        },{"singer":"Red Velvet (레드벨벳)","movie":"J_CFBjAyPWE","rank":"2","title":"Bad Boy","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/027\/210\/81027210_1517290322253_1_140x140.JPG"},{"singer":"장덕철","movie":"v6_GwXU1lkg","rank":"3","title":"그날처럼","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/007\/399\/81007399_1511854441859_1_140x140.JPG"},{"singer":"MOMOLAND (모모랜드)","movie":"JQGRg8XBnB4","rank":"4","title":"뿜뿜","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/017\/733\/81017733_1514963221459_1_140x140.JPG"},{"singer":"정승환","movie":"8DtJe6ZFyE0","rank":"5","title":"눈사람","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/029\/121\/81029121_1517900755525_1_140x140.JPG"},{"singer":"청하","movie":"900X9fDFLc4","rank":"6","title":"Roller Coaster","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/022\/313\/81022313_1516159148701_1_140x140.JPG"},{"singer":"선미","movie":"F4qfN5UeFvQ","rank":"7","title":"주인공","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/024\/406\/81024406_1516261128225_1_140x140.JPG"},{"singer":"Camila Cabello","movie":"BQ0mxQXmLsk","rank":"8","title":"Havana (Feat. Young Thug)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/975\/396\/80975396_1515736227928_1_140x140.JPG"},{"singer":"멜로망스 (MeloMance)","movie":"qYYJqWsBb1U","rank":"9","title":"선물","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/964\/912\/80964912_1499671793637_1_140x140.JPG"},{"singer":"볼빨간사춘기","movie":"fag8nirMXgE","rank":"10","title":"#첫사랑","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/020\/527\/81020527_1515567844136_1_140x140.JPG"},{"singer":"문문 (MoonMoon)","movie":"FvOBwRWaGZg","rank":"11","title":"비행운","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/891\/933\/80891933_1478684039222_1_140x140.JPG"},{"singer":"펀치 (Punch)","movie":"WNU0JCOsliw","rank":"12","title":"오늘밤도","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/030\/946\/81030946_1517895836357_1_140x140.JPG"},{"singer":"DEAN","movie":"wKyMIrBClYw","rank":"13","title":"instagram","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/015\/028\/81015028_1514272554668_1_140x140.JPG"},{"singer":"다비치","movie":"_jzMDsYHktI","rank":"14","title":"너 없는 시간들","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/026\/197\/81026197_1516858012006_1_140x140.JPG"},{"singer":"에일리 (Ailee)","movie":"YbbP3aUXif0","rank":"15","title":"다시 쓰고 싶어","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/032\/667\/81032667_1518157805529_1_140x140.JPG"},{"singer":"TWICE (트와이스)","movie":"rRzxEiBLQCA","rank":"16","title":"Heart Shaker","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/009\/024\/81009024_1512973485015_1_140x140.JPG"},{"singer":"펀치 (Punch)","movie":"yQt3kLczJp4","rank":"17","title":"밤이 되니까","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/991\/767\/80991767_1506666565645_1_140x140.JPG"},{"singer":"Fitz & The Tantrums","movie":"Y2V6yjjPbX0","rank":"18","title":"HandClap","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/803\/449\/80803449_1458788251030_1_140x140.JPG"},{"singer":"수지 (SUZY)","movie":"eQ3gXtX3U7I","rank":"19","title":"다른사람을 사랑하고 있어","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/024\/958\/81024958_1517214826318_1_140x140.JPG"},{"singer":"윤종신","movie":"jy_UiIQn_d0","rank":"20","title":"좋니","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/959\/572\/80959572_1498096340350_1_140x140.JPG"},{"singer":"수지 (SUZY)","movie":"lpzJNwur6Zk","rank":"21","title":"HOLIDAY (Feat. DPR LIVE)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/024\/958\/81024958_1517214826318_1_140x140.JPG"},{"singer":"김동률","movie":"kMRLzSQorK0","rank":"22","title":"답장","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/021\/191\/81021191_1515653924081_1_140x140.JPG"},{"singer":"Red Velvet (레드벨벳)","movie":"6uJf2IT2Zh8","rank":"23","title":"피카부 (Peek-A-Boo)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/003\/854\/81003854_1510903454899_1_140x140.JPG"},{"singer":"TWICE (트와이스)","movie":"V2hlQkVJZhE","rank":"24","title":"LIKEY","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/995\/333\/80995333_1509345645050_1_140x140.JPG"},{"singer":"박원","movie":"CbNmRJCkwQs","rank":"25","title":"All Of My Life","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/970\/929\/80970929_1501141349151_1_140x140.JPG"},{"singer":"방탄소년단","movie":"MBdVXkSdhwU","rank":"26","title":"DNA","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/988\/228\/80988228_1505722039920_1_140x140.JPG"},{"singer":"길구봉구","movie":"kgspMLLZosE","rank":"27","title":"이 별","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/987\/812\/80987812_1505720691739_1_140x140.JPG"},{"singer":"EXO","movie":"leu-cTvMWTA","rank":"28","title":"Universe","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/014\/942\/81014942_1514269809677_1_140x140.JPG"},{"singer":"민서 & 윤종신","movie":"X29h0TrJfSM","rank":"29","title":"좋아","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/002\/774\/81002774_1510722333800_1_140x140.JPG"},{"singer":"오마이걸 (OH MY GIRL)","movie":"QIN5_tJRiyY","rank":"30","title":"비밀정원","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/020\/130\/81020130_1515483498408_1_140x140.JPG"},{"singer":"다이나믹 듀오 (Dynamic Duo)","movie":"LQfMqHSklYI","rank":"31","title":"봉제선 (Feat. 수란)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/031\/296\/81031296_1517984247856_1_140x140.JPG"},{"singer":"나얼","movie":"0wlXaHmmOVc","rank":"32","title":"기억의 빈자리","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/007\/536\/81007536_1511932813251_1_140x140.JPG"},{"singer":"비투비 (BTOB)","movie":"4bykFvnRzno","rank":"33","title":"그리워하다","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/993\/764\/80993764_1508139830937_1_140x140.JPG"},{"singer":"Ed Sheeran","movie":"JGwWNGJdvx8","rank":"34","title":"Shape Of You","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/911\/494\/80911494_1484644569534_1_140x140.JPG"},{"singer":"세븐틴 (Seventeen)","movie":"ShEU4Ab0zxU","rank":"35","title":"고맙다","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/030\/836\/81030836_1517816422092_1_140x140.JPG"},{"singer":"아이유 (IU)","movie":"BzYnNdJhZQw","rank":"36","title":"밤편지","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/933\/154\/80933154_1490341401069_1_140x140.JPG"},{"singer":"우원재","movie":"RsHq6Q-7NsU","rank":"37","title":"시차 (We Are) (Feat. 로꼬 & GRAY)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/983\/419\/80983419_1504509397625_1_140x140.JPG"},{"singer":"멜로망스 (MeloMance)","movie":"TCVQUBayskg","rank":"38","title":"짙어져","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/993\/182\/80993182_1507880649500_1_140x140.JPG"},{"singer":"Shawn Mendes","movie":"dT2owtxkU8k","rank":"39","title":"There's Nothing Holdin' Me Back","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/941\/542\/80941542_1492739775489_1_140x140.JPG"},{"singer":"볼빨간사춘기","movie":"hZmoMyFXDoI","rank":"40","title":"썸 탈꺼야","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/991\/315\/80991315_1506584021425_1_140x140.JPG"},{"singer":"어반 자카파 (Urban Zakapa)","movie":"O92yHB0MDZ8","rank":"41","title":"그때의 나, 그때의 우리","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/001\/046\/81001046_1510124290726_1_140x140.JPG"},{"singer":"종현 (JONGHYUN)","movie":"NpTpEsE9G8c","rank":"42","title":"Lonely (Feat. 태연)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/941\/882\/80941882_1493017191755_1_140x140.JPG"},{"singer":"박원","movie":"\/watch?v=nkkE0zNiFe0 ","rank":"43","title":"노력","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/893\/630\/80893630_1479290423741_1_140x140.JPG"},{"singer":"선미","movie":"ur0hCdne2-s","rank":"44","title":"가시나","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/979\/339\/80979339_1503365015435_1_140x140.JPG"},{"singer":"The Chainsmokers & Coldplay","movie":"FM7MFYoylVs","rank":"45","title":"Something Just Like This","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/913\/561\/80913561_1491533162795_1_140x140.JPG"},{"singer":"헤이즈 (Heize)","movie":"afxLaQiLu-o","rank":"46","title":"비도 오고 그래서 (Feat. 신용재)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/960\/357\/80960357_1498458172138_1_140x140.JPG"},{"singer":"에픽하이 (EPIK HIGH)","movie":"Z3INNjAEqHk","rank":"47","title":"연애소설 (Feat. 아이유)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/991\/334\/80991334_1508741715086_1_140x140.JPG"},{"singer":"에일리 (Ailee)","movie":"6rS7OUGXUik","rank":"48","title":"첫눈처럼 너에게 가겠다","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/911\/488\/80911488_1483696444510_1_140x140.JPG"},{"singer":"아이유 (IU)","movie":"d9IxdwEFk1c","rank":"49","title":"팔레트 (Feat. G-DRAGON)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/941\/594\/80941594_1492760375708_1_140x140.JPG"},{"singer":"Red Velvet (레드벨벳)","movie":"WyiIGEHQP8o","rank":"50","title":"빨간 맛 (Red Flavor)","poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/080\/964\/658\/80964658_1499421855077_1_140x140.JPG"}]}
 */
class Human /* extends Object */
{
	public void display() {
		System.out.println("Human:display() Call...");
	}

	public void print() {
		System.out.println("Human:print() Call...");
	}
}

class Student extends Human {
	/*
	 * public void display() { System.out.println("Human:display() Call..."); }
	 * public void print() { System.out.println("Human:print() Call..."); }
	 */
	// 상속으로 받은 메소드를 재정의 할 수 있다 : 오버라이딩은 필요한 메소드만 변경
	public void display() {
		System.out.println("Student:display() Call...");
	}

	// 확장 => 기능 추가
	public void studentAllData() {
		System.out.println("Student:studentAllData() Call...");
	}
}

/*
 * Object = Object | Object o=new Object() Human = Human , Object | Human h=new
 * Human() Object o=new Human() Student = Human , Object , Student
 */
/*
 * class A { void aaa(){} void bbb(){} void ccc(){} -- -- -- void zzz(){} }
 * 
 * class B { void aaa(){} void bbb(){} void ccc(){} -- -- -- void zzz(){} }
 * 
 * class C extends A { void bbb(){} void ccc(){} }
 */
public class MusicManager {
	public MusicVO[] musicAllData() {
		MusicVO[] music = new MusicVO[50]; // {null.....} music[0]=new MusicVO()
		try {
			FileReader fr = new FileReader("c:\\javaDev\\genie.json");
			String data = "";
			int i = 0;
			while ((i = fr.read()) != -1) // -1 파일끝 read()=>한글자씩 읽어온다
			{
				data += String.valueOf((char) i);
			}
			fr.close();
			// System.out.println(data);

			// 파싱 (파일에서 관련된 데이터 읽기)
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject) jp.parse(data);
			System.out.println(root.toJSONString());// 문자열 변환

			JSONArray arr = (JSONArray) root.get("genie");
			System.out.println(arr.toJSONString());

			// System.out.println(arr.size());
			for (i = 0; i < 50; i++) {
				music[i] = new MusicVO();// 객체 배열
				System.out.println("music[" + i + "]:" + music[i]);
				JSONObject obj = (JSONObject) arr.get(i);
				System.out.println(obj.toJSONString());
				music[i].setRank(Integer.parseInt((String) obj.get("rank")));
				// Integer.parseInt => String을 int변환
				music[i].setTitle((String) obj.get("title"));
				music[i].setSinger((String) obj.get("singer"));
				music[i].setPoster((String) obj.get("poster"));
				music[i].setMovie((String) obj.get("movie"));
			}
		} catch (Exception ex) {
		}
		/*
		 * try { 정상수행을 하는 소스코딩 = = = = 에러발생 }catch(Exception ex) { 에러처리 } == == ==
		 */
		return music;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicManager m = new MusicManager();
		MusicVO[] data = m.musicAllData();
		System.out.println("================= 뮤직 목록 =================");
		for (MusicVO vo : data) {

			System.out.println("순위:" + vo.getRank());
			System.out.println("노래명:" + vo.getTitle());
			System.out.println("가수명:" + vo.getSinger());
			System.out.println("이미지:" + vo.getPoster());
			System.out.println("동영상:" + vo.getMovie());
			System.out.println("===========================================");
		}
		/*
		 * Human h=new Human(); h.display(); h.print();// Student s=new Student();
		 * s.display(); s.print();// s.studentAllData();
		 * 
		 * Human h2=new Student(); h2.display(); h2.print();
		 * 
		 * Student s2=(Student)h2; s2.studentAllData();
		 */
		// 클래스에서 형변환 => 상속,포함

		// instanceof
		/*
		 * String str=new String("Hello"); StringBuffer sb=new StringBuffer(); Object
		 * obj=new Object();
		 * 
		 * if(str instanceof Object) { System.out.println("정상수행"); } if(sb instanceof
		 * Object) { System.out.println("정상수행"); } if(obj instanceof String) {
		 * System.out.println("정상수행"); }
		 */

	}

}
