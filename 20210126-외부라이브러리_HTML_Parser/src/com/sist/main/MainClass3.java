package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * </span>
 * <img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/858/755/81858755_1611302348643_1_140x140.JPG/dims/resize/Q_80,0"
 *  onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';"
 *   alt="이 밤을 빌려 말해요 (바른연애 길잡이 X 10CM)"></a></td>
    <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('92070716');return false;">곡 제목 정보 페이지</a></td>
    <td class="info">                            
   <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('92070716','1');return false;">
                                        
                    
    이 밤을 빌려 말해요 (바른연애 길잡이 X 10CM)</a>

    <a href="#" class="artist ellipsis" onclick="fnViewArtist('80044692');return false;">10CM</a>
                                        
    <div class="toggle-button-box">
 */
public class MainClass3 {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title = doc.select("div.ellipsis");
			
			for (int i = 0; i < title.size(); i++) {
				System.out.println("곡제목: " + title.get(i).text());
				
				System.out.println("==========================");
			}
		} catch (Exception ex) {}

	}

}
