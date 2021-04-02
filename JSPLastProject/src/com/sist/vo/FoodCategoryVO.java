package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO      NOT NULL NUMBER        
	TITLE   NOT NULL VARCHAR2(100) 
	SUBJECT NOT NULL VARCHAR2(100) 
	POSTER  NOT NULL VARCHAR2(260) 
	LINK             VARCHAR2(100)
 */
@Getter
@Setter
public class FoodCategoryVO {
  private int no;
  private String title;
  private String subject;
  private String poster;
  private String link;
}
