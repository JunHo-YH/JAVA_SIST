package com.sist.server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 자바에서 제공하는IO(Input, Output)
 * Input: 파일, 메모리, 네트워크에서 데이터 읽기
 * Output: 파일, 메모리, 네트워크 데이터 전송
 *             ======
 *             System.in
 *             System.out
 * =====================================
 * InputStream, OutputStream => 바이트 스트림(1byte씩 읽어온다) => Upload, Download
 * Reader, Writer => 문자 스트림 (2byte씩 읽어온다)
 *   *** 한글 (한 글자당 2byte)
 */
public class MovieManagerParser {
	// 상영 => 개봉 => 주간 => 월간 => 연간 ===> 저장은 한 개의 파일에 저장
	public void movieAllData() {
		/*
		 * <div class="wrap_desc">
		 * <a href="/moviedb/mainmovieId=135111">
		 */
		try {
			
			int mno = 1;
			int cno = 1;
			for(int i = 1; i <= 3; i++) {
				Document doc = Jsoup.connect("https://movie.daum.net/premovie/released?reservationOnly=N&sort=reservation&page="+i).get();
				Elements link = doc.select("div.wrap_desc a.desc_movie");
				for (int j = 0; j < link.size(); j++) {
					System.out.println(link.get(j).attr("href"));
					Document doc2 = Jsoup.connect("https://movie.daum.net" + link.get(j).attr("href")).get();
					Element title = doc2.selectFirst("span.txt_name"); // 하나만 가져올 때는 Element + selectFirst사용
					//<span class="txt_name">소울(2020)</span>
					System.out.println(title.text());
					Element score = doc2.selectFirst("div.info_origin a");
					String s = score.text();
					// 평점 07 . 8
					s = s.substring(s.indexOf("점") + 3); // "점"을 찾아서 숫자부터 출력하기
					System.out.println(s.replace(" ",  "")); // 공백 없애기
					// trim(): 공백문자(좌우) => 중간에 있는 공백을 제거는 replace 사용해서 제거
					
					Element genre = doc2.selectFirst("dd.txt_main");
					// selectFirst => 같은 class가 있다면 그 중에 첫번째를 가져와라
					System.out.println(genre.text());
					
					Element etc = doc2.select("dl.list_movie").get(1); 
					s = etc.text();
					s = s.substring(s.indexOf("라") + 2);
					String regdata = s.substring(0,s.indexOf(",", -5));
					System.out.println(regdata.replaceAll("[가-힣]", "").replace("(", "").replace(")", ""));
					// select().get(n) => 같은 클래스 중에 n번째를 가져와라 n = 0부터 시작
					String time = s.substring(0,s.indexOf(","));
					time.substring(time.lastIndexOf(" ")+1);
					// substring(int begin) => 해당위치까지 자르기
					// substring(int begin, int end) => end-1까지 자르기
					System.out.println(time);
					String grade = s.substring(s.lastIndexOf(",") + 2);
					System.out.println(grade);
					Element director = doc2.select("a.link_person").get(0);
					System.out.println(director.text());
					Element actor = doc2.select("a.link_person").get(1);
					System.out.println(actor.text());
					
					Element story = doc2.selectFirst("div.desc_movie p");
					System.out.println(story.text());
					
					Element poster = doc2.selectFirst("span.thumb_img img");
					System.out.println(poster.attr("src"));
					
					Element showUser = doc2.selectFirst("em.emph_g");
					System.out.println(showUser.text());
					
					
					
					/*
					 * <div class="aaa">
					 *  <a href = "http://~">link</a>
					 * <div>
					 * 
					 * HTML은 데이터 저장(태그, 속성)
					 * <sapn>aaa</span> ==> select("span") ==> text()
					 * <a href = "http://~">link</a> ==> ("a") ==> text(): link, attr(): http://~
					 * 
					 * 
					 */
				}

			}
		} catch (Exception ex) {
			// 에러 메세지 출력
			ex.printStackTrace();

			/*
			 * 예외처리 CheckException: IO(경로), 네트워크(서버IP), Thread(비동기화=>충돌), Web(URL=>site),
			 * SQL(sql문장)
			 */
		}
	}

	public static void main(String[] args) {
		MovieManagerParser m = new MovieManagerParser();
		m.movieAllData();
	}
}
