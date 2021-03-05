package com.sist.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/ReplyDeleteServlet")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 출력 (X)
		// 1. 사용자 보내준 데이터 받기  ReplyDeleteServlet?no = 1&mno = 2
		String no = request.getParameter("no");
		String mno=request.getParameter("mno");
		// 2. DAO=>오라클로 전송 (삭제)
		MovieDAO dao=new MovieDAO();
		dao.replyDelete(Integer.parseInt(no));
		// 3. 댓글이 있던 위치로 이동 
		response.sendRedirect("MovieDetailServlet?mno="+mno);
	}

}







