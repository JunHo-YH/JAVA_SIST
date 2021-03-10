package com.sist.dao;
// => 게시물 한개에 대한 전체 => 오라클에 있는 컬럼과 동일 

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

// 오라클 => %ROWTYPE
@Setter
@Getter
/*
 * 오라클 자바 CHAR VARCHAR2 CLOB String ==================== Number (정수 : int , 실수 :
 * double) 4.5 ================================================= DATE
 * java.util.Date ================================================= BLOB BFILE
 * java.io.InputStream =================================================
 */
public class BoardVO {
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getLike1() {
		return like1;
	}

	public void setLike1(int like1) {
		this.like1 = like1;
	}

	private int hit;
	private int like1;
}
