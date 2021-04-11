package com.sist.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO         NOT NULL NUMBER         
	NAME       NOT NULL VARCHAR2(34)   
	SUBJECT    NOT NULL VARCHAR2(2000) 
	CONTENT    NOT NULL CLOB           
	PWD                 VARCHAR2(10)   
	REGDATE             DATE           
	HIT                 NUMBER         
	GROUP_ID            NUMBER         
	GROUP_STEP          NUMBER         
	GROUP_TAB           NUMBER  
 * 
 */
@Getter
@Setter
public class BoardReplyVO {
	private int no, hit, group_id, group_step, group_tab;
	private String name, subject, content, pwd;
	private Date regdate;
}