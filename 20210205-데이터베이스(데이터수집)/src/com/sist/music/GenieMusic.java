package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *     Oracle ø¨∞· (ø¿∂Û≈¨ : µ•¿Ã≈Õ∫£¿ÃΩ∫ (µ•¿Ã≈Õ∏¶ ¿˙¿Â«œ¥¬ ¿Âº“ => µ•¿Ã≈Õ ∞¯¿Ø)
 *     1. µ•¿Ã≈Õ«¸ 
 *        º˝¿⁄«¸ 
 *         NUMBER(10) , NUMBER(7,2)
 *         ==========   ===========
 *           int           double
 *        πÆ¿⁄«¸
 *         CHAR , VARCHAR2 , CLOB => String 
 *        ≥Ø¬•«¸ 
 *         DATE => Date
 *     ===> int , double , String , Date
 *     2. µ•¿Ã≈Õ∏¶ ∏æ∆º≠ ¿¸º€ 
 *        ArrayList => ¡¶≥◊∏ØΩ∫ (µ•¿Ã≈Õ«¸ ≈Î¿œ)
 *     3. Connection , Statement , ResultSet
 *     4. øπø‹√≥∏Æ 
 *    ========================================
 */
// ¿• ≈©∑—∏µ 
public class GenieMusic {
    public void getGenieMusic()
    {
    	try
    	{
    		MusicDAO dao = new MusicDAO();
    		int k=201;
            for(int i=1;i<=2;i++)
            {
//            	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210210&hh=17&rtm=Y&pg="+i).get();
            	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210210&genrecode=M0100&pg="+i).get();
            	// title , singer , album , poster , state , idcrement, rank
            	Elements title=doc.select("tr.list a.title");// <a class="title">
            	Elements singer=doc.select("tr.list a.artist");
            	Elements album=doc.select("tr.list a.albumtitle");
            	Elements poster=doc.select("tr.list a.cover img");
            	Elements etc=doc.select("tr.list span.rank");
            	for(int j=0;j<title.size();j++)
            	{
            		System.out.println("º¯¿ß:"+k);
            		System.out.println("¡¶∏Ò:"+title.get(j).text());
            		System.out.println("∞°ºˆ:"+singer.get(j).text());
            		System.out.println("æŸπ¸:"+album.get(j).text());
            		System.out.println("∆˜Ω∫≈Õ:"+poster.get(j).attr("src"));
            		String str=etc.get(j).text(); // ?
            		// ¿Ø¡ˆ
            		// 2«œ∞≠
            		// 1ªÛΩ¬
            		String id =""; // ?
            		
            		String state=str.replaceAll("[^∞°-∆R|^a-z]", "");// «—±€¿ª ¡¶ø‹«œ∞Ì ≥™∏”¡ˆ¥¬ ∞¯πÈ  
            		if(state.equals("¿Ø¡ˆ"))
            		{
            			id="0";
            		}else if (state.equals("new")) {
            			id = "0";
            		}
            		
            		else
            		{
            			id=str.replaceAll("[^0-9]", ""); //1
            		}
            		
            		System.out.println("ªÛ≈¬:"+state);
            		System.out.println("µÓ∆¯:"+id);
            		//System.out.println("ªÛ≈¬:"+etc.get(j).text());
            		System.out.println("=============================================");
            	
            		// µ•¿Ã≈Õ ∏æ∆º≠ MusicDAO∑Œ ¿¸º€ => ø¿∂Û≈¨ø° Insert
            		GenieMusicVO vo = new GenieMusicVO();
            		vo.setNo(k);
            		vo.setCno(2);   // 1 -> 2 ? º¯º≠ »Æ¿Œ«œ±‚
            		vo.setTitle(title.get(j).text());
            		vo.setSinger(singer.get(j).text());
            		vo.setAlbum(album.get(j).text());
            		vo.setPoster(poster.get(j).attr("src"));
            		vo.setState(state);
            		vo.setIdcrement(Integer.parseInt(id));
            		
            		dao.genieMusicInsert(vo);
            		
            		Thread.sleep(100);
            		k++;
            	}
            }
    	}catch(Exception ex){ex.printStackTrace();}
    }
	public static void main(String[] args) {
        GenieMusic gm=new GenieMusic();
        gm.getGenieMusic();
	}

}
