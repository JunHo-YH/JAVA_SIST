package com.sist.vo;
/*
 *  no NUMBER,
  id VARCHAR2(20),
  title VARCHAR(200),
  day VARCHAR2(30),
  time VARCHAR2(10),
  inwon VARCHAR2(10),
  state NUMBER
 */

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ReserveVO {
   private int no;
   private String id;
   private String title;
   private String day;
   private String time;
   private String inwon;
   private int state;
   private Date regdate;
   private String dbday;
}
