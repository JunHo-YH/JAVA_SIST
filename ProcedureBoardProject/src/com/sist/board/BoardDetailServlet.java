package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
/*
 *   브라우저 ====> 서블릿,JSP (일반 자바는 전송을 받지 못한다) 
 *          전송
 *   https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=%EC%9E%90%EB%B0%94
 */
/*
 *   웹 : 요청=>응답(HTML)
 *       ===
 *        데이터 전송 , 우편번호 => GET/POST : 한글처리(X) => 전송:인코딩,수신:디코딩
 */
@WebServlet("/BoardDetailServlet")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // GET/POST
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 화면 출력 => 브라우저로 HTML을 전송하다 
		response.setContentType("text/html;charset=UTF-8");
		// 2. 화면 출력 => 요청한 사용자의 브라우저에 읽어서 출력 
		PrintWriter out=response.getWriter();
		// 3. 사용자가 요청한 값을 받는다
		String no=request.getParameter("no");
		// 4. no에 해당되는 게시물을 오라클로부터 받는다 
		BoardDAO dao=new BoardDAO();
		BoardVO vo=dao.board_detail(Integer.parseInt(no));
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
		
		out.println("<h1>내용보기</h1>");
		out.println("<table class=table_main width=700>");
		out.println("<tr>");
		out.println("<th width=20%>번호</th>");
		out.println("<td width=30% align=center>"+vo.getNo()+"</td>");
		out.println("<th width=20%>작성일</th>");
		out.println("<td width=30% align=center>"+vo.getRegdate().toString()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th width=20%>이름</th>");
		out.println("<td width=30% align=center>"+vo.getName()+"</td>");
		out.println("<th width=20%>조회수</th>");
		out.println("<td width=30% align=center>"+vo.getHit()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th width=20%>제목</th>");
		out.println("<td colspan=3>"+vo.getSubject()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 align=left valign=top style=\"height:200px\"><pre>"+vo.getContent()+"</pre></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 align=right>");
		out.println("<a href=BoardUpdateServlet?no="+vo.getNo()+">수정</a>&nbsp;");
		// JSP => main.jsp?no=1
		// Spring => main.do?no=1
		out.println("<a href=BoardDeleteServlet?no="+vo.getNo()+">삭제</a>&nbsp;");
		out.println("<a href=BoardListServlet>목록</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}








