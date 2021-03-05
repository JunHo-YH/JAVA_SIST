package com.sist.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
/*
 *   <a href=ReplyInsertServlet?no=1> => doGet()
 *   <form method=post action=ReplyInsertServlet> => doPost()
 *   
 *   => 데이터 전송 방식 (브라우저)
 *      GET : URL뒤에 데이터 전송  ==> ?변수=값  => ?mno=1
 *            보안이 취약
 *            => 영화번호, 단순한 검색 , 페이지 ===================> 서블릿에서 자동호출 (doGet())
 *      POST :URL뒤에 데이터 => 내부 네트워크를 이용해서 전송(보안,데이터가 많은 경우) 
 *            => 로그인 , 회원가입 , 글쓰기 , 파일업로드 ======> doPost()
 */
@WebServlet("/ReplyInsertServlet")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자가 보낸값을 받는다 
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String mno=request.getParameter("mno");
		String msg=request.getParameter("msg");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		// 매개변수가 3개이상이면 => VO를 이용한다 
		ReplyVO vo=new ReplyVO();
		vo.setMno(Integer.parseInt(mno));
		vo.setMsg(msg);
		vo.setId(id);
		vo.setName(name);
		// => DAO로 전송 => 데이터를 오라클에 저장
		MovieDAO dao=new MovieDAO();
		dao.replyInsert(vo);
		// => 이동 => 상세보기로 이동 
		response.sendRedirect("MovieDetailServlet?mno="+mno);
	}

}












