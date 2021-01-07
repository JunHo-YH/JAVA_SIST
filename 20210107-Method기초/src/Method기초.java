
//		String find(String title);
/*
 * 라이브러리에서 제공하는 메서드명은 키워드가 아니다.
 * 리턴형: 
 * 매개변수:
 * ======================= 기본데이터형 + 참조데이터형(배열,클래스(String)) 
 * 메서드 만드는 이유: 분리 => 소스를 나눠서 처리 (관련된 내용을 모아서 만든다): 가독성, 수정, 유지보수에 유리하다.
 * 
 *  메서드가 종료될 때 return을 사용
 *  void => return을 생략할 수 있다.
 *  
 *  https://www.genie.co.kr/chart/top200
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Method기초 {
	static void genie() {
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title = doc.select("td.info a.title");
			for (int i = 0; i < title.size(); i++) {
				System.out.println(title.get(i).text());
			}
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		genie();
	}

}
