package com.sist.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

/*
 *      NO     NOT NULL NUMBER           
		TITLE   NOT NULL VARCHAR2(300) 
		SUBJECT NOT NULL VARCHAR2(300) 
		POSTER  NOT NULL VARCHAR2(260) 
		LINK    NOT NULL VARCHAR2(260) 
 */
public class FoodManager {
	private FoodDAO dao=new FoodDAO();
    public void foodCategoryData()
    {
    	try
    	{
    		int k=1;
    		// 연결 => 소스읽기 
    		Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
    		//System.out.println(doc);
    		Elements title=doc.select("div.top_list_slide span.title"); // CSS 선택자
    		Elements poster=doc.select("div.top_list_slide img.center-croping");
    		Elements subject=doc.select("div.top_list_slide p.desc");
    		Elements link=doc.select("div.top_list_slide a");
    		for(int i=0;i<title.size();i++)
    		{
    			System.out.println("번호:"+k);
    			System.out.println("제목:"+title.get(i).text());
    			System.out.println("부제목:"+subject.get(i).text());
    			System.out.println("이미지:"+poster.get(i).attr("data-lazy"));
    			System.out.println("링크:https://www.mangoplate.com"+link.get(i).attr("href"));
    			FoodCategoryVO vo=new FoodCategoryVO();
    			vo.setTitle(title.get(i).text());
    			vo.setSubject(subject.get(i).text());
    			vo.setPoster(poster.get(i).attr("data-lazy"));
    			vo.setLink("https://www.mangoplate.com"+link.get(i).attr("href"));
    			dao.foodCategoryInsert(vo);
    			
    			k++;
    		}
    	}catch(Exception ex){}
    }
    /*
     *   <div class="info">
                        
                        <span class="title ">
                          <a href="/restaurants/9qHLgnJtje"
                             onclick="trackEvent('CLICK_RESTAURANT', {&quot;position&quot;:0,&quot;restaurant_key&quot;:&quot;9qHLgnJtje&quot;})">
                            1.<h3> 영양족발순대국</h3>
                          </a>
                        </span>
     */
    public void foodDetailData()
    {
    	List<FoodCategoryVO> list=dao.foodCategoryLinkData();
    	try
    	{
    		/*
    		 *  <span class="title"> <h1 class="restaurant_name">온정</h1> 
    		 *  <strong class="rate-point "> <span>4.7</span> </strong>
    		 */
    		for(FoodCategoryVO vo:list)
    		{
    		 
    			Document doc=Jsoup.connect(vo.getLink()).get();
    			Elements link=doc.select("div.info span.title a");
    			for(int i=0;i<link.size();i++)
    			{
    				//figure class="restaurant-photos-item
    			try {
    				FoodHouseVO fvo=new FoodHouseVO();
    				System.out.println("https://www.mangoplate.com"+link.get(i).attr("href"));
    				Document doc2=Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
    				fvo.setCno(vo.getNo());
    				System.out.println("Category NO:"+fvo.getCno());
    				Elements poster=doc2.select("figure.restaurant-photos-item img.center-croping");
    				String str="";
    				for(int j=0;j<poster.size();j++)
    				{
    					String s=poster.get(j).attr("src");
    					str+=s+"^";
    				}
    				// a.jpg^b.jpg^c.jpg
    				str=str.substring(0,str.lastIndexOf("^"));
    				System.out.println(str);
    				// 이미지 출력 
    				fvo.setPoster(str);
    				Element title=doc2.selectFirst("span.title h1.restaurant_name");
    				System.out.println("이름:"+title.text());
    				fvo.setTitle(title.text());
    				Element score=doc2.selectFirst("strong.rate-point span");
    				System.out.println("평점:"+score.text());
    				fvo.setScore(Double.parseDouble(score.text()));
    				Element review=doc2.selectFirst("script#reviewCountInfo");
    				//[""{"action_value":1,"count":0},{"action_value":2,"count":1},{"action_value":3,"count":35}]
    				System.out.println("리뷰:"+review.data());
    				// JSON파싱 
    				/*
    				 *   [] => 배열 JSONArray
    				 *   {} => 객체 JSONObject
    				 */
    				JSONParser jp=new JSONParser();
    				//int a=(int)10.5;
    				/*
    				 *   A[] arr={new A(),new A()...};
    				 *   for(int i=0;i<arr.length;i++)
    				 *   {
    				 *      A a=arr[i]
    				 *   }
    				 *   ["",""]
    				 *   [1,2,3,]
    				 */
    				JSONArray arr=(JSONArray)jp.parse(review.data());
    				long[] re=new long[3];
    				for(int j=0;j<arr.size();j++)
    				{
    					 JSONObject obj=(JSONObject)arr.get(j);
    					 System.out.println(obj.get("count"));
    					 re[j]=(Long)obj.get("count");//good,soso,bad
    				}
    				
    				fvo.setGood((int)re[2]);
    				fvo.setSoso((int)re[1]);
    				fvo.setBad((int)re[0]);
    				
    				Elements info=doc2.select("table.info tr th");
    				Elements data=doc2.select("table.info tr td");
    				for(int j=0;j<info.size();j++)
    				{
    					//System.out.println(info.get(j).text());
    					String label=info.get(j).text();
    					if(label.equals("주소"))
    					{
    						System.out.println("주소:"+data.get(j).text());
    						fvo.setAddress(data.get(j).text());
    					}
    					else if(label.equals("전화번호"))
    					{
    						System.out.println("전화번호:"+data.get(j).text());
    						fvo.setTel(data.get(j).text());
    					}
    					else if(label.equals("음식 종류"))
    					{
    						System.out.println("음식 종류:"+data.get(j).text());
    						fvo.setType(data.get(j).text());
    					}
    					else if(label.equals("가격대"))
    					{
    						System.out.println("가격대:"+data.get(j).text());
    						fvo.setPrice(data.get(j).text());
    					}
    					else if(label.equals("주차"))
    					{
    						System.out.println("주차:"+data.get(j).text());
    						fvo.setParking(data.get(j).text());
    					}
    					else if(label.equals("영업시간"))
    					{
    						System.out.println("영업시간:"+data.get(j).text());
    						fvo.setTime(data.get(j).text());
    					}
    					else if(label.equals("메뉴"))
    					{
    						System.out.println("메뉴:"+data.get(j).text());
    						fvo.setMenu(data.get(j).text());
    					}
    				}
    				
    				dao.foodInsert(fvo);
    				Thread.sleep(50);
    			 }catch(Exception ex) {}
    			}
    			System.out.println("==========="+vo.getNo()+"번 end=================");
    		}
    	}catch(Exception ex){}
    }
    public static void main(String[] args) {
		FoodManager fm=new FoodManager();
		//fm.foodCategoryData();
		fm.foodDetailData();
		/*
		 * int[] arr={1,2,3,4,5,0,9,6,7,8}; for(int a:arr) { try {
		 * System.out.println(10/a); }catch(Exception ex) {} }
		 */
		
	}
}








