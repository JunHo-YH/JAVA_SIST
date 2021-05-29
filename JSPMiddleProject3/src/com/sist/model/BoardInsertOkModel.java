package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class BoardInsertOkModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String msg = "게시판 데이터 추가 완료";
		request.setAttribute("msg", msg);
		
		
		return "board/insert_ok.jsp";
	}

}
