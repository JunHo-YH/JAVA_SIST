package com.sist.manager;

// 캡슐화 코딩
/*
 * 멤버변수
 *  초기화
 *  ==================================
 *  1. 생성자
 *  2. 초기화블럭
 *  ================================== 변경이 불가능 (한번만 호출하기 때문에)
 *  3. getter / setter
 *  
 *  class A {
 *  	private int a,b,c;
 *  	public A(int a, int b, int c) {
 *  		this.a = a;
 *  		this.b = b;
 *  		this.c = c;
 *          
 *  	}
 *  }
 */
public class MusicVO {
	private int rank;
	private String title;
	private String singer;
	private String poster;
	private String movie;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	// 변수 => 읽기 / 쓰기 => getter / setter
}
