package com.sist.data;

import java.io.Serializable;

/*
 *  1|1|소울(2020)|
 *  8.6|애니메이션/판타지|
 *  2021.01.20 |
 *  107분|전체관람가|
 *  피트 닥터|
 *  켐프 파워스|
 *  //img1.daumcdn.net/thumb/C155x225/?fname=
 *  https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F71454256ae63506a
 *  7fee5e03cf929b9b65a4f433|
 *  1|
 *  나는 어떻게 ‘나’로 태어나게 되었을까?
 *   지구에 오기 전 영혼들이 머무는 ‘태어나기 전 세상’이 있다면? 
 *   뉴욕에서 음악 선생님으로 일하던 ‘조’는 꿈에 그리던 최고의 밴드와 재즈
 *    클럽에서 연주하게 된 그 날, 예기치 못한 사고로 영혼이 되어 ‘태어나기 전 세상’에 
 *    떨어진다. 탄생 전 영혼들이 멘토와 함께 자신의 관심사를 발견하면 
 *    지구 통행증을 발급하는 ‘태어나기 전 세상’ ‘조’는 그 곳에서 유일하게 
 *    지구에 가고 싶어하지 않는 시니컬한 영혼 ‘22’의 멘토가 된다. 
 *    링컨, 간디, 테레사 수녀도 멘토되길 포기한 영혼 ‘22’ 꿈의 무대에 
 *    서려면 ‘22’의 지구 통행증이 필요한 ‘조’ 그는 다시 지구로 
 *    돌아가 꿈의 무대에 설 수 있을까?

 */
public class MovieVO implements Serializable{
    private int mno,cno;
    private String title;
    private String score;
    private String genre;
    private String regdate;
    private String time;
    private String grade;
    private String director;
    private String actor;
    private String poster;
    private String showUser;
    private String story;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getShowUser() {
		return showUser;
	}
	public void setShowUser(String showUser) {
		this.showUser = showUser;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story; 
	}
   
   
}








