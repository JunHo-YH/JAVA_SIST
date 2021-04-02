package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *      NO     NOT NULL NUMBER         
		POSTER NOT NULL VARCHAR2(260)  
		TITLE  NOT NULL VARCHAR2(1000) 
		CHEF   NOT NULL VARCHAR2(200)  
		HIT             VARCHAR2(100)  
		LINK            VARCHAR2(100)
 */
@Getter
@Setter
public class RecipeVO {
   private int no;
   private String poster;
   private String title;
   private String chef;
   private String hit;
   private String link;
}
