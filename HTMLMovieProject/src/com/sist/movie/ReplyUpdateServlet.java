package com.sist.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/ReplyUpdateServlet")
public class ReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 퍼블릭 보이드 올데이터(정수 에)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			// http : 네트워크(TCP) => 서버로 전송 (1byte씩) 한글(byte로 변환후 전송)
			// 자바 => %EC%9E%90%EB%B0%94 (인코딩) => web에서는 자동으로 인코딩
			// %EC%9E%90%EB%B0%94 => 자바 (디코딩)
			request.setCharacterEncoding("UTF-8");//인코딩 => 디코딩 
		}catch(Exception ex) {}
		// 1. web => 한글 (브라우저,자바...)
		String no=request.getParameter("no");
		String mno=request.getParameter("mno");// 해당위치로 이동 
		String msg=request.getParameter("msg");
		
		//DAO연결
		MovieDAO dao=new MovieDAO();
		dao.replyUpdate(Integer.parseInt(no), msg);
		//화면 이동 
		response.sendRedirect("MovieDetailServlet?mno="+mno);
		
	}

}











