package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * <span class="cont_line">
					<strong class="tit_line"><a href="http://v.movie.daum.net/v/20210126113114427"
					 class="link_txt" data-tiara-layer="title"
					  data-tiara-ordnum="2" data-tiara-id="20210126113114427"
					   data-tiara-type="news">'미나리' 제목의 의미 "가족의 사랑"</a></strong>
					<a href="http://v.movie.daum.net/v/20210126113114427" class="desc_line" data-tiara-layer="desc_line" data-tiara-ordnum="2" data-tiara-id="20210126113114427" data-tiara-type="news" style="height: auto;">
						[티브이데일리 최하나 기자] '미나리'가 미국 영화협회와 시상식을 휩쓸며 세계적인 관심을 받는 가운데, 영화 제목에 대한 이목이 집중되면서 감독과 배우가 말하는 영화 제목의 진짜 의미를 공개했다. 희망을 찾아 낯선 미국으로 떠나온 한국 가족의아주 특별한 여정을 담은, 2021년 전 세계가 기다린 원더풀한 이야기 '미나리'(감독 정이삭·배급 판씨네마)가 미국
					</a>
					<span class="state_line">
						티브이데일리<span class="txt_dot"></span><span class="screen_out">발행일자</span>21.01.26
					</span>
				</span>
 */
public class MainClass2 {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://movie.daum.net/magazine/new").get();
//			System.out.println(doc);
			Elements title = doc.select("span strong.tit_line");
			Elements content = doc.select("span a.desc_line");
			Elements author = doc.select("span span.state_line");
			for (int i = 0; i < title.size(); i++) {
				System.out.println(title.get(i).text());
				System.out.println(content.get(i).text());
				System.out.println(author.get(i).text().replace("・", " "));
				System.out.println("==========================");
			}
		} catch (Exception ex) {

		}
	}

}
