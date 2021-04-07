package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO          NOT NULL NUMBER         
RNO                  NUMBER         
POSTER      NOT NULL VARCHAR2(260)  
CHEF        NOT NULL VARCHAR2(200)  
CHEF_POSTER NOT NULL VARCHAR2(260)  
TITLE       NOT NULL VARCHAR2(2000) 
CONTENT     NOT NULL VARCHAR2(4000) 
INFO1       NOT NULL VARCHAR2(20)   
INFO2       NOT NULL VARCHAR2(20)   
INFO3       NOT NULL VARCHAR2(20)   
FOOD_MAKE   NOT NULL CLOB           
CHEF_INFO   NOT NULL VARCHAR2(1000) 
 */
@Getter
@Setter
public class RecipeMakeVO {
   private int no,rno;
   private String poster,chef,chef_poster,title,content,info1,info2,info3,chef_info,food_make;
}






