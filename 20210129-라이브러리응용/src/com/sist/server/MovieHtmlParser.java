package com.sist.server;
// 파일에 저장 =>
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *    자바에서 제공하는 IO(Input,Output)
 *    Input : 파일, 메모리,네트워크에서 데이터 읽기
 *    Output : 파일 , 메모리 , 네트워크 데이터 전송 
 *                   =====
 *                   System.out
 *                   System.in
 *    =======================================
 *    InputStream , OutputStream => 바이트 스트림(1byte씩 읽어 온다) => Upload,Download
 *    Reader , Writer => 문자 스트림 (2byte씩 읽어온다)
 *      *** 한글 (한글자당 => 2byte)
 */
public class MovieHtmlParser {
    // 상영 => 개봉 => 주간 => 월간 => 연간 ===> 저장은 한개의 파일에 저장 
	public void movieAllData()
	{
		/*
		 *   <div class="wrap_desc">
									<a href="/moviedb/main?movieId=135111"
		 */
		StringBuffer sb = new StringBuffer();
		// for안에 try => 오류가 발생 => 제외하고 다시 for을 수행
		// web사이트 => 모든 정보를 출력하지 않는다.
		try
		{
			int mno=138;// 영화 고유 번호 
			int cno=3;// 카테고리 번호 
			for(int i=1;i<=7;i++)
			{
				Document doc=Jsoup.connect("https://movie.daum.net/boxoffice/weekly"+i).get();
			    Elements link=doc.select("div.wrap_desc a.desc_movie");
			    for(int j=0;j<link.size();j++)
			    {
			    	try {
			    	System.out.println(link.get(j).attr("href"));
			    	Document doc2=Jsoup.connect("https://movie.daum.net"+link.get(j).attr("href")).get();
			    	// <span class="txt_name">소울(2020)</span>
			    	Element title=doc2.selectFirst("span.txt_name");
			    	System.out.println(title.text());
			    	Element score=doc2.selectFirst("div.info_origin a");
			    	String s=score.text();
			    	// 평점 07 . 8
			    	// 01 234
			    	// s.indexOf("점") => 1+2
			    	s=s.substring(s.indexOf("점")+3);
			    	System.out.println(s.replace(" ", ""));
			    	String ss = s.replace(" ", "");
			    	// trim() : 공백문자 (좌우) => 중간에 있는 공백을 제거 => replace
			    	Element genre=doc2.selectFirst("dd.txt_main");
			    	System.out.println(genre.text());
			    	
			    	Element etc=doc2.select("dl.list_movie").get(1);
			    	s=etc.text();
			    	s=s.substring(s.indexOf("라")+2);
			    	String regdate=s.substring(0,s.indexOf(",")-5);
			    	//1999.11.20  2020.12.23 
			    	System.out.println(regdate.replaceAll("[가-힣]", "").
			    			replace("(","").replace(")", ""));
			    	regdate = regdate.replaceAll("[가-힣]", "").
			    			replace("(","").replace(")", "");
			    	String time=s.substring(0,s.indexOf(","));
			    	time=time.substring(time.lastIndexOf(" ")+1);
			    	// substring(int begin) => 해당위치
			    	// substring(int begin,int end) => end-1
			    	System.out.println(time);
			    	String grade=s.substring(s.lastIndexOf(",")+2);
			    	System.out.println(grade);
			    	Element director=doc2.select("a.link_person").get(0);
			    	System.out.println(director.text());
			    	Element actor=doc2.select("a.link_person").get(1);
			    	System.out.println(actor.text());
			    	
			    	Element story=doc2.selectFirst("div.desc_movie p");
			    	System.out.println(story.text());
			    	
			    	Element poster=doc2.selectFirst("span.thumb_img img");
			    	System.out.println(poster.attr("src"));
			    	
			    	Element showUser=doc2.selectFirst("em.emph_g");
			    	System.out.println(showUser.text());
			    	
			    	String msg = mno + "|" + cno + "|"
			    				+ title.text() + "|"
			    				+ ss.replace(" ", "") + "|"
			    				+ genre.text() + "|"
			    				+ regdate + "|"
			    				+ time + "|"
			    				+ grade + "|"
			    				+ director.text() + "|"
			    				+ actor.text() + "|"
			    				+ poster.attr("src") + "|"
			    				+ showUser.text() + "|"
			    				+ story.text() + "\r\n";
			    	sb.append(msg);
			    	mno++;
			    	}catch(Exception ex) {ex.printStackTrace();}
			    	// 1999.11.20 개봉 2020.12.23 (재개봉) 116분, 전체관람가
			    	// 2021.01.07 개봉 105분, 15세이상관람가
			    	/*
			    	 *    <div class="aaa">
			    	 *      <a href="http://~">link</a>
			    	 *    </div>
			    	 *    
			    	 *    HTML은 데이터 저장 (태그,속성)
			    	 *    <span>aaa</span>  ==> select("span") ==> text()
			    	 *    <a href="http://~" class="">link</a> ==> ("a") ==> text():link attr("href"):http://~
			    	 *    
			    	 *    <div class="aaa">  select("div.bbb span")
			    	 *      <span>aaa</span>
			    	 *    </div>
			    	 *    <div class="bbb">
			    	 *      <span>bbb</span>
			    	 *    </div>
			    	 *    <div class="ccc">
			    	 *      <span>ccc</span>
			    	 *    </div>
			    	 *    
			    	 *    <a> => link 주소 
			    	 *    <img src="">
			    	 */
			    	
			    }
			}
			FileWriter fw = new FileWriter("c:\\javaDev\\daum_movie.txt",true); // 밑에다 추가해서 적으려면 true를 넣어준다.
			fw.write(sb.toString());
			fw.close();
		}catch(Exception ex)
		{
			// 에러 메세지 출력 
			ex.printStackTrace();// 복구 
		}
		/*
		 *  예외처리 
		 *    CheckException : IO(경로), 네트워크(서버IP),Thread(비동기화=>충돌),Web(URL=>site)
		 *                     SQL(sql문장)
		 *                     => 사전에 오류를 방지하는 프로그램 
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MovieHtmlParser m=new MovieHtmlParser();
        m.movieAllData();
	}

}









