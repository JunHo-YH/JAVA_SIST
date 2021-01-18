package com.sist.manager;
// 다른 패키지에 있는 클래스 읽기 => 자바에서 제공하는 라이브러리, 사용자 정의
import java.io.FileReader;
/*
 * public String[] aaa()
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieManager {
	public MovieVO[] movieAllData() {
		MovieVO[] movie = new MovieVO[7]; // 데이터를 7개 모아서 main으로 전송
		try {
			FileReader fr = new FileReader("c:\\javaDev\\movie.json"); // movie.json파일안에 7개의 영화데이터
			String data = "";
			int i = 0; // 문자 번호 => 'A' => 65
			while ((i = fr.read()) != -1) // -1 파일끝 read()=>한글자씩 읽어온다
			{
				data += String.valueOf((char) i); // 문자열 결합
				                    // 문자 번호를 문자로 변환 => String에 저장
				                    // 데이터가 많은 경우에는 String => StringBuffer사용
				/*
				 *  + => 산술연산자, 문자열 결합
				 */
			}
			fr.close();// 파일 닫기
			 System.out.println(data); // 전체가 파일에 묶였는지 확인

			// 파싱 (파일에서 관련된 데이터 읽기)
			 /*
			  *  {} => JSONObject
			  *  [] => JSONArray
			  */
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject) jp.parse(data);
			System.out.println(root.toJSONString());// 문자열 변환
			// {datas
			JSONArray arr = (JSONArray) root.get("datas");
			System.out.println(arr.toJSONString());
			// [
			// System.out.println(arr.size());
			for (i = 0; i < 50; i++) {
				movie[i] = new MovieVO();// 객체 배열
				System.out.println("movie[" + i + "]:" + movie[i]);
				JSONObject obj = (JSONObject) arr.get(i);
				System.out.println(obj.toJSONString());
				// JSON => 데이터 (int => long)
//				int mno = (int) obj.get("mno");
//				movie[i].setMno(mno);	
				// Integer.parseInt => String을 int변환
				movie[i].setTitle((String) obj.get("title")); // 데이터를 한개씩 읽어온다.
				movie[i].setActor((String) obj.get("actor"));
				movie[i].setPoster((String) obj.get("poster"));
				movie[i].setDirector((String) obj.get("director"));
				movie[i].setGrade((String) obj.get("grade"));
				movie[i].setStory((String) obj.get("story"));
				// 변수의 초기값을 설정
			}
		} catch (Exception ex) {
			return movie;
		}
		return movie;
	}
}
