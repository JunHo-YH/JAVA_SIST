package com.sist.movie;

// 파일에 ArrayList를 저장 
import java.io.*;
import java.util.*;

public class ObjectSaveClass {
	/*
	 * private int mno,cno; private String title; private String score; private
	 * String genre; private String regdate; private String time; private String
	 * grade; private String director; private String actor; private String poster;
	 * private String showUser; private String story;
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 파일 읽기
			FileInputStream fis = new FileInputStream("c:\\javaDev\\daum_movie.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			// 파일의 내용전체 => 메모리에 저장
			ArrayList<MovieVO> list = new ArrayList<MovieVO>();
			while (true) {
				String movie_data = br.readLine(); // readLine() => \n
				if (movie_data == null)
					break; // 더이상 읽을 값이 없는 경우=>종료
				StringTokenizer st = new StringTokenizer(movie_data, "|");
				MovieVO vo = new MovieVO();
				vo.setMno(Integer.parseInt(st.nextToken()));
				vo.setCno(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setScore(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setTime(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setPoster("http:" + st.nextToken());
				vo.setShowUser(st.nextToken());
				vo.setStory(st.nextToken());
				list.add(vo);
			}
			fis.close();
			// ArrayList
			FileOutputStream fos = new FileOutputStream("c:\\download\\movie.txt");
			// Create , true=> append
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			// 객체 단위 저장
			System.out.println("객체 저장 완료!!");
		} catch (Exception ex) {
		}
	}

}
