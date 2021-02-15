package com.sist.movie_;

// 파일을 읽어서VO에 값을 채운다.
import java.io.*;
import java.util.*;

import com.sist.movie.MovieVO;

public class MovieManager {

	public static void main(String[] args) {
		try {
			MovieDAO dao = new MovieDAO();
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader("c:\\javaDev\\movietxt");
			int i = 0;
			while ((fr.read()) != -1) {
				sb.append(String.valueOf((char) i));
			}
			fr.close();
			String data = sb.toString();
			String[] movie = data.split("\n");
			for (String s : movie) {
				StringTokenizer st = new StringTokenizer(s, "|");
				
				// VO에 저장 => 오라클로 전송
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.valueOf(st.nextToken()));
				vo.setTitle(st.nextToken());
				
				// 오라클 열기
				dao.moiveInsert(vo); // 오라클에 데이터 추가
				
				Thread.sleep(100);
				
				// 오라클 닫기
				dao.disConnection();
				
			}
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
