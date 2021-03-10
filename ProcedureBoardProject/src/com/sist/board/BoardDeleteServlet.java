package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
// 화면 UI ==> DAO 처리 => 실제 처리
@WebServlet("/BoardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 출력
				response.setContentType("text/html;charset=EUC-KR");
				PrintWriter out=response.getWriter();
				// 데이터 받기
				// http://localhost/HTMLBoardProject/BoardDeleteServlet?no=12
				String no=request.getParameter("no");
				
				/*
				 *    InputStream , OutputStream  => 1byte
				 *    Reader , Writer  => 2byte
				 */
				out.println("<html>");
				out.println("<head>");
				out.println("<style type=text/css>");
				out.println("td,th{font-family:맑은 고딕;font-size:9pt;height:35px}");
				out.println(".table_main{border-collapse:collapse;");
				out.println("border-top-width: 2px;"
						+ "border-bottom-width: 1px;"
						+ "border-top-style: solid;"
						+ "border-bottom-style: solid;"
						+ "border-top-color: #333;"
						+ "border-bottom-color: #333;}");
				out.println(".table_main th{");
				out.println("background-color: #999;"
						+ "color: #fff;"
						+ "border-bottom-width: 1px;"
						+ "border-bottom-color: #333;}");
				out.println(".table_main td{");
				out.println("border-bottom-width: 1px;"
						+ "border-bottom-color: #666;"
						+ "border-bottom-style: dotted;}");
				out.println("a{color:black;text-decoration:none}");
				out.println("a:hover{color:green;text-decoration:underline}");
				out.println(".dataTr:HOVER {"
						+ "background-color: #FC6;"
						+ "cursor: pointer;"
						+ "cursor: hand;"
						+ "}");
				out.println("</style>");
				out.println("</head>");
				out.println("<body>");
				out.println("<center>");
				out.println("<h1>삭제하기</h1>");
				out.println("<form method=post action=BoardDeleteServlet>");//a.doGet()
				// 톰캣이 호출 => 서블릿,JSP => 톰캣이 호출한다 
				out.println("<table class=table_main width=350>");
				out.println("<tr>");
				out.println("<th width=30% align=right>비밀번호</th>");
				out.println("<td width=70%>");
				// ?pwd=1234&no=12 => 감춘다 (POST)
				out.println("<input type=password name=pwd size=15>");
				out.println("<input type=hidden name=no value="+no+">");
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan=2 align=center>");
				out.println("<input type=submit value=삭제>");
				out.println("<input type=button value=취소>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // HTML 작성 (자바스크립트)
		   // CSS,HTML,JavaScript 
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out=response.getWriter();
		   
		   // 사용자가 보내분 데이터를 받는다 (no,pwd)
		   String no=request.getParameter("no");
		   String pwd=request.getParameter("pwd");
		   // DAO로 전송 => 결과값
		   BoardDAO dao=new BoardDAO();
		   boolean bCheck=dao.board_delete(Integer.parseInt(no), pwd);
		   // 결과값 => history.back(),list
		   if(bCheck==true)
		   {
			   response.sendRedirect("BoardListServlet");
		   }
		   else
		   {
			   out.println("<script>");
			   out.println("alert(\"비밀번호가 틀립니다!!\");");
			   out.println("history.back();");
			   out.println("</script>");
		   }
		   
		   
	}

}










