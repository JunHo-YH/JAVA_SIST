package com.sist.board;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;//ArrayList
import com.sist.dao.*;// BoardVO,BoardDAO

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HTML문서 전송 = 브라우저 (web(브라우저): XML(사용자 정의),HTML:고정)
		response.setContentType("text/html;charset=UTF-8");
		/*
		 *    1. 한글을 받는 경우 
		 *       EUC-KR => EUC-KR (O)
		 *       UTF-8  => UTF-8 (O)
		 *       EUC-KR => UTF-8 (O)
		 *       UTF-8  => EUC-KR (X)
		 */
		// 어디 출력 
		PrintWriter out=response.getWriter(); // 사용자의 브라우저에 읽어갈 위치 지정 
		/*
		 *   = 서블릿에서만 존재하는 것이 아니다 
		 *     JSP ,Spring,장고,NodeJS
		 *   request : 사용자가 보내준 데이터를 저장 (브라우저정보(서버정보,URI),사용자 정보(IP,PORT,데이터)
		 *        http://localhost/ProcedureBoardProject/BoardListServlet
		 *        ======================================================== URL
		 *                        ======================================== URI
		 *               ==========
		 *               localhost:80
		 *               ========= ==
		 *               서버 주소    서버포트 
		 *   response : 응답 (결과값을 브라우저 전송) , 화면 이동 정보 (redirect())
		 *   session  : 클라이언트의 일부정보를 서버에 저장 
		 *   ==========
		 *   cookie   : 클라이언트의 일부정보를 클라이언트에 저장 (최근 본 내용)
		 *   
		 *   서블릿의 단점 : 수정할때마다 컴파일을 한다 , HTML코딩이 어렵다 
		 *                장점 : 보안 (소스를 노출하지 않는다)
		 *   JSP의 단점  : 장점: 컴파일없이 실행 (수정..) , HTML코딩이 편하다 
		 *               소스가 노출 (보안 허점) , 자바와 HTML을 구분해서 사용
		 *               
		 *   서블릿과 JSP의 장점만 사용하면 어떨까? MVC
		 *     Model : 자바(VO,DAO)
		 *     View : JSP
		 *     Controller : 서블릿 => Spring에서 제공 => 자바와 HTML을 연결 
		 *     
		 *    *** request,response=>톰캣이 생성해서 매개변수를 채운다 (톰캣에 의해 호출)
		 *    
		 *    생명주기 
		 *     생성자 호출 : 메모리 할당
		 *    => init() : 멤버변수의 초기화   ====> _jspInit()
		 *    => doGet()|doPost() : 사용자가 브라우저에서 요청시마다 호출  ====> _jspService()
		 *     => 화면 이동 , 새로고침 
		 *     destory() : 메모리 해제   ====> _jspDestory()
		 *     ****** JSP를 실행하면 => 자동으로 서블릿 파일로 변경 
		 *     a.jsp ==> class a_jsp
		 */
		// 2. 사용자가 보내준 데이터를 받는다 
		String page=request.getParameter("page");
		if(page==null)
			page="1"; // Default 
		
		int curpage=Integer.parseInt(page);
		// 3. 오라클에서 데이터 읽기
		BoardDAO dao=new BoardDAO();
		// 3-1 목록
		ArrayList<BoardVO> list=dao.board_list(curpage);
		// 3-2 총페이지 
		int totalpage=dao.board_totalpage();
		// 화면에 데이터를 출력(HTML)
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=\"css/table.css\">");
		out.println("<style>");
		out.println("th,td{font-size:9pt;font-family:맑은 고딕}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시판</h1>");
		out.println("<table width=700>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<a href=BoardInsertServlet>새글</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<div style=\"height:400px;\">");
		out.println("<table class=table-content width=700>");
		out.println("<tr height=35>");
		out.println("<th width=10%>번호</th>");
		out.println("<th width=45%>제목</th>");
		out.println("<th width=15%>이름</th>");
		out.println("<th width=20%>작성일</th>");
		out.println("<th width=10%>조회수</th>");
		out.println("</tr>");
		// 1. 오늘 날짜 
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		for(BoardVO vo:list)
		{
			String dbday=vo.getRegdate().toString();
			out.println("<tr class=dataTr height=35>");
			out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
			out.println("<td width=45%><a href=BoardDetailServlet?no="+vo.getNo()+">"+vo.getSubject()+"</a>&nbsp;");
			if(today.equals(dbday))
			{
				out.println("<sup style=\"color:red\">new</sup>");
				// <!ENTITY nbsp " "> XML에서 특수문자 정의 
				// => 호출 &nbsp;
				// <!ENTITY lt "<">
				// <!ENTITY gt ">">  
				// &lt;Hello&gt;  <Hello>
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+vo.getName()+"</td>");
			out.println("<td width=20% align=center>"+vo.getRegdate().toString()+"</td>");
			out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<table width=700>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Search:");
		out.println("<select name=fd>");
		out.println("<option value=name>이름</option>");
		out.println("<option value=subject>제목</option>");
		out.println("<option value=content>내용</option>");
		out.println("</select>");
		out.println("<input type=text name=ss size=10>");
		out.println("<input type=submit value=검색>");
		out.println("</td>");
		out.println("<td align=right>");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">이전</a>&nbsp;");
		out.println(curpage+" page / "+totalpage+" pages");
		out.println("<a href=BoardListServlet?page="+(curpage<totalpage?curpage+1:curpage)+">다음</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}










