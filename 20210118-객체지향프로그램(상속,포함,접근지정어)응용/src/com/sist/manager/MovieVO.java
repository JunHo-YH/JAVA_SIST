package com.sist.manager;

/*
 * "actor":"가엘 가르시아 베르날 , 앤서니 곤잘레스 , 벤자민 브랫",
"director":"리 언크리치",
"grade":"전체","title":"코코",
"poster":"http:\/\/img.cgv.co.kr\/Movie\/Thumbnail\/Poster\/000080\/80397\/80397_185.jpg",
"mno":1,
"story
 */
public class MovieVO {
	private int mno;
	private String actor;
	private String director;
	private String grade;
	private String title;
	private String poster;
	private String story;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

}
