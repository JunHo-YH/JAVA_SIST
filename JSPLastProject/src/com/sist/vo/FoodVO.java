package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO      NOT NULL NUMBER         
	CNO              NUMBER         
	POSTER  NOT NULL VARCHAR2(4000) 
	TITLE   NOT NULL VARCHAR2(200)  
	SCORE   NOT NULL NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(300)  
	TEL     NOT NULL VARCHAR2(30)   
	TYPE    NOT NULL VARCHAR2(100)  
	PRICE   NOT NULL VARCHAR2(50)   
	PARKING          VARCHAR2(500)  
	TIME             VARCHAR2(500)  
	MENU             VARCHAR2(2000) 
	GOOD             NUMBER         
	SOSO             NUMBER         
	BAD              NUMBER 
 */
@Getter
@Setter
public class FoodVO {
   private int no;
   private int cno;
   private String poster,title,address,tel,type,price,parking,time,menu;
   private double score;
   private int good,soso,bad;
}





