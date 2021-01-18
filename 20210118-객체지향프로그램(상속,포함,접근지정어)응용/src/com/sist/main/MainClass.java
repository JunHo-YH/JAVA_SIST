package com.sist.main;

import com.sist.manager.*;

public class MainClass {

	public static void main(String[] args) {
		MovieManager m = new MovieManager();
		MovieVO[] movie = m.movieAllData();
		
		//출력
		System.out.println("========== 영화 목록 ==========");
		for (MovieVO vo: movie) { // for-Each
			System.out.println("순위:" + vo.getMno());
			System.out.println("영화명: " + vo.getTitle());
			System.out.println("감독명:" + vo.getDirector());
			System.out.println("출연: " + vo.getActor());
			System.out.println("등급: " + vo.getGrade());
			System.out.println("줄거리:" + vo.getStory());
			System.out.println("==================================");
		}
	
	
	}

}
