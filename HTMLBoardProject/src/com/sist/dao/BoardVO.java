package com.sist.dao;

/*
 *   NO      NOT NULL NUMBER    =======> int        
	NAME    NOT NULL VARCHAR2(34)  ====> String
	SUBJECT NOT NULL VARCHAR2(2000) ===> String
	CONTENT NOT NULL CLOB           ===> String
	PWD     NOT NULL VARCHAR2(10)   ===> String
	REGDATE          DATE           ===> java.util.Date
	HIT              NUMBER       =====> int 
	
	오라클     =====   자바
	문자
	  CHAR
	  VARCHAR2
	  CLOB   =====   String
	숫자
	  NUMBER =====> 저장된 데이터 판단 int , double
	  NUMBER(7,2) 
	날짜 
	  DATE 
	  TIMESTAMP ===> java.util.Date
	기타
	  BFILE
	  BLOB      ===> java.io.InputStream 
	  바이너리 파일 
	  
	 =====================================> 오라클의 컬럼명과 자바의 변수명 일치
 */
import java.util.Date;
import java.sql.*;

public class BoardVO {
	// java.util.Date date=new java.util.Date();
	// Date date=new Date();
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;
	private int hit;

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

}
