package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class BoardDetailModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String msg = "게시판 epdlxj 상세보기";
		// DAO 연결
		request.setAttribute("msg", msg);
		return "board/detail.jsp";
	}
	
	
}
