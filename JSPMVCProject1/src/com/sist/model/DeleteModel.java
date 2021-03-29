package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel implements Model {
	public void handlerRequest(HttpServletRequest request) {
		String msg = "사원 삭제입니다.";
		request.setAttribute("msg", msg);

	}
}
