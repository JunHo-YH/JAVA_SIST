package com.sist.manager;

/*
 * "actor":"���� �����þ� ������ , �ؼ��� ���߷��� , ���ڹ� �귧",
"director":"�� ��ũ��ġ",
"grade":"��ü","title":"����",
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
