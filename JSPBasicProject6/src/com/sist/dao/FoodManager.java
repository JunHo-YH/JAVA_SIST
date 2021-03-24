package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.*;

public class FoodManager {
	private FoodDAO dao=new FoodDAO();
	public void foodCategoryData()
	{
		try
		{
			int k=1; // 카테고리 번호
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
		}catch(Exception ex) {}
	}
	/*
	 * <div class="info">
                        
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
			for(FoodCategoryVO vo:list)
			{
				Document doc=Jsoup.connect(vo.getLink()).get();
				Elements link=doc.select("div.info span.title a");
				for(int i=0;i<link.size();i++)
				{
					System.out.println("https://www.mangoplate.com"+link.get(i).attr("href"));
				}
				System.out.println("============"+vo.getNo()+"번 end=============");
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		FoodManager fm=new FoodManager();
//		fm.foodCategoryData();
		fm.foodDetailData();
	}

}
