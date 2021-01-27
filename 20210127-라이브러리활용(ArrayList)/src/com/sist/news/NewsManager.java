package com.sist.news;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewsManager {

	// 데이터 공유(static)
	private static ArrayList newsList = new ArrayList();

	static {
		try {
			// 파일 읽기
			FileReader fr = new FileReader("c:\\javaDev\\daum_news.txt");
			int i = 0;
			StringBuffer sb = new StringBuffer();
			while ((i = fr.read()) != -1) {
				sb.append(String.valueOf((char) i));

			}
			fr.close();
			// 분리
			String data = sb.toString();
			String[] news_data = sb.toString().split("\n");

			for (String news : news_data) {
				NewsVO vo = new NewsVO(); // 객체 생성할 때 마다 새로운 주소를 준다.
				StringTokenizer st = new StringTokenizer(news, "|");
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setAuthor(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setLink(st.nextToken());
				newsList.add(vo);
			}
			System.out.println(sb); // sb, sb.toString()

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 목록 출력
			public ArrayList newsListData(int page) {
				ArrayList list = new ArrayList();
				int j = 0; // 10개씩 나눠주는 변수 j<10
				int pagecnt = (page * 5) - 5;
				/*
				 * 1page: 0 ~ 9
				 * 2page: 10 ~ 19
				 * 3page: 20 ~ 29
				 */
				for(int i = 0; i < newsList.size(); i++) {
					if(j < 5 && i >= pagecnt) {
						NewsVO vo = (NewsVO) newsList.get(i);
						list.add(vo);
						j++;
					}
				}
				return list;
			
			}
			// 총 페이지
			public int newsTotalPage() {
				return (int) (Math.ceil(newsList.size() / 5.0));
			}

	public static void main(String[] args) {
		NewsManager m = new NewsManager();
		/*
		String msg = "aaa| |bbb|ccc|ddd";
		StringTokenizer st = new StringTokenizer(msg, "|");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		*/
//		for (int i = 0; i < newsList.size(); i++) {
//			NewsVO vo = (NewsVO) newsList.get(i);
//			System.out.println(vo.getTitle());
//		}
		ArrayList list = m.newsListData(30);
		for (int i = 0; i < list.size(); i++) {
			NewsVO vo = (NewsVO)list.get(i);
			System.out.println(vo.getNo() + "." + vo.getTitle());
			
		}
		System.out.println("총페이지:" + m.newsTotalPage());
		

	}

}
