package com.sist.model;
import java.util.*;
/*
 * class A {
 * 	int a = 10;
 * 
 * 
 * }
 * class B {
 * 	public void disp(A aa) {
 * 		aa.a = 100
 * 	}
 * }
 * 
 */
import javax.servlet.http.HttpServletRequest;
public class SawonModel {
	public void sawonInit(HttpServletRequest request) {
		String name = "심청이";
		request.setAttribute("name", name); // jsp로 전송
	}
	
	public void sawonDetailData(HttpServletRequest aa) {
		SawonVO vo = new SawonVO(1, "홍길동", "개발부");
		// vo => jsp에 전송
		aa.setAttribute("vo", vo);
	}
	
	public void sawonTwoData(HttpServletRequest request) {
		String firstName ="박";
		String lastName ="문수";
		request.setAttribute("first", firstName);
		request.setAttribute("last", lastName);
	}
}
