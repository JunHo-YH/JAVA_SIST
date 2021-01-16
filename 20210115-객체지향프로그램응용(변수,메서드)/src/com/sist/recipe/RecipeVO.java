package com.sist.recipe;

// ����� ���� �������� => ~VO, ~DTO
// ��� ���� => ~DAO, ~Manager, ~Service
/*
 * ����� �Խ���
 * ==========
 * ��� / �Խ���
 * ���DAO / �Խ��� DAO => �Խ��� Service
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
