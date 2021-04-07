package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  CHEF_NAME NOT NULL VARCHAR2(300) 
	POSTER    NOT NULL VARCHAR2(260) 
	MC1                VARCHAR2(20)  
	MC2                VARCHAR2(20)  
	MC3                VARCHAR2(20)  
	MC7                VARCHAR2(20)
 */
@Getter
@Setter
public class ChefVO {
   private String chef_name,poster,mc1,mc2,mc3,mc7;
}
