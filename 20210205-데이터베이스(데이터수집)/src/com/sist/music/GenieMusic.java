package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *     Oracle 연결 (오라클 : 데이터베이스 (데이터를 저장하는 장소 => 데이터 공유)
 *     1. 데이터형 
 *        숫자형 
 *         NUMBER(10) , NUMBER(7,2)
 *         ==========   ===========
 *           int           double
 *        문자형
 *         CHAR , VARCHAR2 , CLOB => String 
 *        날짜형 
 *         DATE => Date
 *     ===> int , double , String , Date
 *     2. 데이터를 모아서 전송 
 *        ArrayList => 제네릭스 (데이터형 통일)
 *     3. Connection , Statement , ResultSet
 *     4. 예외처리 
 *    ========================================
 */
// 웹 크롤링 
public class GenieMusic {
    public void getGenieMusic()
    {
    	try
    	{
    		int k=1;
            for(int i=1;i<=2;i++)
            {
            	//Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210205&hh=17&rtm=Y&pg="+i).get();
            	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210204&genrecode=M0100&pg="+i).get();
            	// title , singer , album , poster , state , idcrement, rank
            	Elements title=doc.select("tr.list a.title");// <a class="title">
            	Elements singer=doc.select("tr.list a.artist");
            	Elements album=doc.select("tr.list a.albumtitle");
            	Elements poster=doc.select("tr.list a.cover img");
            	Elements etc=doc.select("tr.list span.rank");
            	for(int j=0;j<title.size();j++)
            	{
            		System.out.println("순위:"+k++);
            		System.out.println("제목:"+title.get(j).text());
            		System.out.println("가수:"+singer.get(j).text());
            		System.out.println("앨범:"+album.get(j).text());
            		System.out.println("포스터:"+poster.get(j).attr("src"));
            		String str=etc.get(j).text();
            		// 유지
            		// 2하강
            		// 1상승
            		String state=str.replaceAll("[^가-힣]", "");// 한글을 제외하고 나머지는 공백  
            		String id="";
            		if(state.equals("유지"))
            		{
            			id="0";
            		}
            		else
            		{
            			id=str.replaceAll("[^0-9]", ""); //1
            		}
            		
            		System.out.println("상태:"+state);
            		System.out.println("등폭:"+id);
            		//System.out.println("상태:"+etc.get(j).text());
            		System.out.println("=============================================");
            	}
            }
    	}catch(Exception ex){ex.printStackTrace();}
    }
	public static void main(String[] args) {
        GenieMusic gm=new GenieMusic();
        gm.getGenieMusic();
	}

}







