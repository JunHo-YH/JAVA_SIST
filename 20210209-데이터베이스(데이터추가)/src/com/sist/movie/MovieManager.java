package com.sist.movie;

import java.io.FileReader;
import java.util.StringTokenizer;

/*
 *  MNO         NUMBER(4)     
	TITLE       VARCHAR2(100) 
	GENRE       VARCHAR2(100) 
	POSTER      VARCHAR2(200) 
	ACTOR       VARCHAR2(300) 
	REGDATE     VARCHAR2(100) 
	GRADE       VARCHAR2(50)  
	DIRECTOR    VARCHAR2(50)  
 */

public class MovieManager {

	public static void main(String[] args) {
		try {
			MovieDAO dao = new MovieDAO();
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i = 0;
			while ((i = fr.read()) != -1) {
				sb.append(String.valueOf((char) i));
			}
			fr.close();
//			System.out.println(sb.toString());
			String data = sb.toString();
			String[] movie = data.split("\n");
			for (String s : movie) {
//				System.out.println(s);
				StringTokenizer st = new StringTokenizer(s, "|");
				// VO�� ���� => ����Ŭ�� ����
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				dao.movieInsert(vo);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
