package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class MovieController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping(value="movie/list.do",produces="text/plain;charset=UTF-8")
   public String movie_list(String page,String type,String ss)
   {
	   String json="";
	   try
	   {
		   System.out.println("페이지:"+page);
		   System.out.println("컴럼명:"+type);
		   System.out.println("검색어:"+ss);
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   Map map=new HashMap();
		   int rowSize=12;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   
		   map.put("start", start);
		   map.put("end", end);
		   map.put("type", type);//<select> : column (title , genre , actor , all)
		   map.put("ss", ss);//<input type=text>
		   
		   List<MovieVO> list=dao.movieListData(map);
		   JSONArray arr=new JSONArray();
		   // VO=JSONObject {}
		   // [{mno: , title:},{}...]
		   /*
		    *    let a={} => a는 객체  ==> JSONObject
		    *    let a=[] => 배열 ==> JSONArray
		    */
		   for(MovieVO vo:list)
		   {
			  JSONObject obj=new JSONObject();
			  obj.put("mno", vo.getMno());
			  obj.put("title", vo.getTitle());
			  obj.put("poster", vo.getPoster());
			  obj.put("genre", vo.getGenre());
			  obj.put("actor", vo.getActor());
			  arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   return json; //[] => JSONArray  [{VO},{VO},{VO}..]
   }
   /*
    *   [
    *      {"no":541,"chef":"lemonsatelier","title":"누가 만들어도 순삭-꽃빵과잡채",
    *       "poster":"1eff0940f52778103111_m.jpg"
    *      },
    *      {"no":542,"chef":"행복한윤블리네","title":"♥[신혼밥상] 속 풀이 북엇국",
    *       "poster":"\9789246961e258b4c431_m.jpg"
    *      },{"no":543,"chef":"배고픈엄마","title":"콩나물무침 봄 부추 넣고 팍팍 무쳤습니다.","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/7090b7805eb860ab5288296163b2da331_m.jpg"},{"no":544,"chef":"815요리사랑","title":"매콤 코다리조림 만드는 법","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/0db5013ff0f25871765d477598a4673b1_m.jpg"},{"no":545,"chef":"요리하는러라","title":"렌틸콩 샐러드와 요거트 드레싱 만들기","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/38556a03a869cb5ec3701c6d2e08e8d41_m.jpg"},{"no":546,"chef":"이웃사슴","title":"모닝빵 시카고피자 만들기, 에어프라이어와 전...","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/d3bdf4ab21720292fe59d4cb6634b3eb1_m.jpg"},{"no":547,"chef":"밥차리라","title":"고추장 진미채볶음","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/c9b9355c3f3637b96626e7ac0f3057211_m.jpg"},{"no":548,"chef":"밥차리라","title":"진미채볶음","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/deecde018aa9f0880e3bc97bb967d4431_m.jpg"},{"no":549,"chef":"(주)오쿠","title":"항암&면역력 향상에 좋은 오쿠[야채수\/채소수...","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/95e385aff1c045843b595bef4ec1d9ce1_m.jpg"},{"no":550,"chef":"감성식탁","title":"진한맛 쵸코 다쿠아즈 만들기","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/14\/bd19618f560c0602c48c1b545d6f7a311_m.jpg"},{"no":551,"chef":"여사장","title":"에어프라이 후라이드치킨 ㅣ다이어트 후라이드치...","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/a4234b9d17086116ac07372796441b541_m.jpg"},{"no":552,"chef":"solsolbarama","title":"[ 짜장 ] 매우 간단하지만 아주 맛난 짜장...","poster":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2021\/03\/15\/5b8848c649fea3c36ff04edfff535cef1_m.jpg"}]

    */
   @GetMapping("movie/total.do")
   public String movie_total(String type,String ss)
   {
	   Map map=new HashMap();
	   map.put("type", type);
	   map.put("ss", ss);
	   int total=dao.movieTotalPage(map);
	   return String.valueOf(total);
   }
   
   @GetMapping(value="movie/detail.do",produces="text/plain;charset=UTF-8")
   public String movie_detail(int mno)
   {
	   String json="";
	   try
	   {
		   // MovieVO => JSONObject
		   MovieVO vo=dao.movieDetailData(mno);
		   JSONObject obj=new JSONObject();
		   obj.put("director", vo.getDirector());
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   obj.put("genre", vo.getGenre());
		   obj.put("actor", vo.getActor());
		   obj.put("story", vo.getStory());
		   
		   json=obj.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
   
}

















