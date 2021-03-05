package com.sist.dao;
/*
 *      NO      NOT NULL NUMBER       
		MNO              NUMBER       
		ID               VARCHAR2(20) 
		NAME             VARCHAR2(30) 
		MSG     NOT NULL CLOB         
		REGDATE          DATE  
 */

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {
	private int no;
	private int mno;
	private String id;
	private String name;
	private String msg;
	private Date regdate;// 시간을 가지고 올 수 없다 => TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS')

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDbday() {
		return dbday;
	}

	public void setDbday(String dbday) {
		this.dbday = dbday;
	}

	private String dbday;
}
