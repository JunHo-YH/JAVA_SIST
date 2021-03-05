package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *  MNO      NOT NULL NUMBER(4)     
	TITLE             VARCHAR2(100) 
	GENRE             VARCHAR2(100) 
	POSTER            VARCHAR2(200) 
	ACTOR             VARCHAR2(300) 
	REGDATE           VARCHAR2(100) 
	GRADE             VARCHAR2(50)  
	DIRECTOR          VARCHAR2(100)
 */
@Setter
@Getter
public class MovieVO {
	private int mno;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	private int hit;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
