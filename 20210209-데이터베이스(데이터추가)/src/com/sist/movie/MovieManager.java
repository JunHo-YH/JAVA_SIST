package com.sist.movie;

// 파일을 읽어서 VO에 값을 채운다 
import java.io.*;
import java.util.*;

/*
 *   MNO         NUMBER(4)     
	TITLE       VARCHAR2(100) 
	GENRE       VARCHAR2(100) 
	POSTER      VARCHAR2(200) 
	ACTOR       VARCHAR2(300) 
	REGDATE     VARCHAR2(100) 
	GRADE       VARCHAR2(50)  
	DIRECTOR    VARCHAR2(50) 
 */
// JDBC ===> DBCP ===> ORM(Mybatis,hibernate)
public class MovieManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MovieDAO dao = new MovieDAO();
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i = 0;
			while ((i = fr.read()) != -1) {
				sb.append(String.valueOf((char) i)); // (String) i => 불가능     ==> (char) i => 문자형 => String.valueOf((char)i) => 문자로 변환
			}
			fr.close();
//			 System.out.println(sb); // 왜 sb로만 해도 출력이 되나요?            sb.toString을 해주는 이유: StringBuffer에서 String형으로 바꿔주기 위해서?
			String data = sb.toString();
			String[] movie = data.split("\n");
			for (String s : movie) {
//				System.out.println(s);
				StringTokenizer st = new StringTokenizer(s, "|");
				// VO에 저장 => 오라클로 전송
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.valueOf(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				// 오라클 열기
				dao.movieInsert(vo);// 오라클에 데이터 추가
				// 오라클 닫기
				Thread.sleep(100);
				dao.disConnection();
			}
		} catch (Exception ex) {
		}
	}

}
