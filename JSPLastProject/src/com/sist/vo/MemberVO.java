package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  ID       NOT NULL VARCHAR2(20)  
	PWD      NOT NULL VARCHAR2(10)  
	NAME     NOT NULL VARCHAR2(34)  
	SEX               VARCHAR2(10)  
	BIRTHDAY NOT NULL VARCHAR2(20)  
	EMAIL             VARCHAR2(100) 
	POST     NOT NULL VARCHAR2(10)  
	ADDR1    NOT NULL VARCHAR2(200) 
	ADDR2             VARCHAR2(200) 
	TEL               VARCHAR2(20)  
	CONTENT           CLOB          
	ADMIN             CHAR(1)  
 * 
 */
@Getter
@Setter
public class MemberVO {
	private String id, pwd, name, sex, birthday, email, post, addr1, addr2, tel, content, admin;
	
}
