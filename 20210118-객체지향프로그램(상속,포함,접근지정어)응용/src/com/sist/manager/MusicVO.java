package com.sist.manager;

// ĸ��ȭ �ڵ�
/*
 * �������
 *  �ʱ�ȭ
 *  ==================================
 *  1. ������
 *  2. �ʱ�ȭ��
 *  ================================== ������ �Ұ��� (�ѹ��� ȣ���ϱ� ������)
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

	// ���� => �б� / ���� => getter / setter
}
