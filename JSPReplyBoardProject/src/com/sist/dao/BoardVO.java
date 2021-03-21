package com.sist.dao;
// 오라클 (row,record)

// DTO 

import java.util.*;

public class BoardVO {
	private int no, hit;
	private String name, subject, content, pwd;// 기본 게시물
	private int group_id, group_step, group_tab;// 답변표시
	private int root, depth; // 삭제용
	private Date regdate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getGroup_step() {
		return group_step;
	}

	public void setGroup_step(int group_step) {
		this.group_step = group_step;
	}

	public int getGroup_tab() {
		return group_tab;
	}

	public void setGroup_tab(int group_tab) {
		this.group_tab = group_tab;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
