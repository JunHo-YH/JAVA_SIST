package com.sist.recipe;

// 사용자 정의 데이터형 => ~VO, ~DTO
// 기능 수행 => ~DAO, ~Manager, ~Service
/*
 * 댓글형 게시판
 * ==========
 * 댓글 / 게시판
 * 댓글DAO / 게시판 DAO => 게시판 Service
 */
public class RecipeVO {
	private int no;
	private String title;
	private String chef;
	private String hit;
	private String link;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public static void main(String[] args) {

	}

}
