package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.BoardReplyDAO;
import com.sist.dao.DataBoardDAO;
import com.sist.vo.BoardReplyVO;
import com.sist.vo.DataBoardVO;

public class BoardReplyModel {
	@RequestMapping("boardreply/list.do")
	public String boardreply_list(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		BoardReplyDAO dao = BoardReplyDAO.newInstance();
		List<BoardReplyVO> list = dao.boardReplyListData(curpage);
		int totalpage = dao.boardReplyTotalPage();

		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("main_jsp", "../boardreply/list.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("boardreply/insert_ok.do")
	public String boardReply_insert_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  
		  DataBoardVO vo=new DataBoardVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		
				
		
		
		return "redirect:../boardreply/list.do";
	}
	public boolean boardReplyCheck(int no) {
		boolean bCheck = false;
		try {
			
		}catch(Exception ex) {
			
		}finally {
			
		}
		
		return bCheck;
		
	}
}
