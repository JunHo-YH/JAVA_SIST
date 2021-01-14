
// 파일 읽기 => recipe.jason
import java.io.*; // io는 파일 입출력, 메모리 입출력, 네트워크 입출력시 사용한다.

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * 1. 요구사항 분석
 * 2. 프로그램을 제작하기 전에 에러 발생에 대한 예측을 해야한다.
 */

public class RecipeSite {
	public Recipe[] recipeAllData() { // 메서드는 public으로 주로 사용한다. // 인스턴스메서드

		Recipe[] recipe = new Recipe[146854];
		StringBuffer data = new StringBuffer();

		// IO => 예외처리
		try {
			// 정상수행문장
			// 파일을 읽어서 문자열로 저장
			FileReader fr = new FileReader("c:\\javaDev\\recipe.json");
			int i = 0; // 단점 => 1글자를 읽는다 => 문자번호

			while ((i = fr.read()) != -1) {// -1은 파일의 끝 (EOF, BOF
				data.append(String.valueOf((char) i));
			}
			fr.close();

			String json = data.toString();

			JSONParser parser = new JSONParser();
			JSONObject re = (JSONObject) parser.parse(json);
			JSONArray arr = (JSONArray)re.get("recipe");
			System.out.println("arr=" + arr);
			System.out.println(arr.size());
			for (i = 0; i < arr.size(); i++) {
				
				/*
				 *  "no": 146854,
					  "title": "댑땅커서... 한개 먹으면 배부른 점보 바나나 초코렛칩 머핀",
					  "poster": "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/09/340ad2b10d86eb75698a1f7f6637545a_m.jpg",
					  "chef": "June",
					  "link": "/recipe/340368",
					  "hit": "조회수 1,647"
				 */
				JSONObject obj = (JSONObject) arr.get(i);
				recipe[i] = new Recipe();
				
				long a = (long)obj.get("no");
				recipe[i].setNo((int)a);
				recipe[i].setTitle((String)obj.get("title"));
				// 1. 클래스 형변환, 예외처리, 라이브러리(최적화)
				recipe[i].setChef((String)obj.get("chef"));
				recipe[i].setPoster((String)obj.get("poster"));
				recipe[i].setLink((String)obj.get("link"));// setxxx() 쓰기: 메모리에 저장
				
				
			}
		} catch (Exception ex) {
			// 에러가 날 경우를 대비하는 프로그램
		}
		return recipe;
	}

	public static void main(String[] args) {
		RecipeSite rs = new RecipeSite(); // recipeAllData를 저장한다.
		Recipe[] recipe = rs.recipeAllData();
		System.out.println("========== 레시피 목록 ==========");
		for (Recipe r : recipe) {
			System.out.println("번호: " + r.getNo());// getXxx() 읽기: 메모리에서 값을 읽어올 때 
													// 메서드를 이용해서 통신
			System.out.println("제목: " + r.getTitle());
			System.out.println("쉐프: " + r.getChef());
			System.out.println(r.getHit());
			System.out.println("===============================");
			
		}

	}


}
