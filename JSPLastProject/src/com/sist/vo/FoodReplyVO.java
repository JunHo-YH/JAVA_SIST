package com.sist.vo;
/*
 *  NO      NOT NULL NUMBER       
	CNO              NUMBER       
	ID               VARCHAR2(20) 
	NAME    NOT NULL VARCHAR2(34) 
	MSG     NOT NULL CLOB         
	REGDATE          DATE 
 */

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FoodReplyVO {
	private int no;
	private int cno;//foodVo => no
	private String id;
	private String name;
	private String msg;
	private Date regdate;
	private String dbday;
}
