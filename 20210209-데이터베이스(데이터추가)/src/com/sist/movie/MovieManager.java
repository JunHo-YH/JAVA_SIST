package com.sist.movie;

// ������ �о VO�� ���� ä��� 
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
				sb.append(String.valueOf((char) i)); // (String) i => �Ұ���     ==> (char) i => ������ => String.valueOf((char)i) => ���ڷ� ��ȯ
			}
			fr.close();
//			 System.out.println(sb); // �� sb�θ� �ص� ����� �ǳ���?            sb.toString�� ���ִ� ����: StringBuffer���� String������ �ٲ��ֱ� ���ؼ�?
			String data = sb.toString();
			String[] movie = data.split("\n");
			for (String s : movie) {
//				System.out.println(s);
				StringTokenizer st = new StringTokenizer(s, "|");
				// VO�� ���� => ����Ŭ�� ����
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.valueOf(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				// ����Ŭ ����
				dao.movieInsert(vo);// ����Ŭ�� ������ �߰�
				// ����Ŭ �ݱ�
				Thread.sleep(100);
				dao.disConnection();
			}
		} catch (Exception ex) {
		}
	}

}
