package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*; // 오라클 연결
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그인 화면 => JSP (파일 두 개를 만들어서 처리)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HTML을 전송 (요청한 클라이언트의 브라우저로 전송)
		// => HTML을 보낸다는 메세지를 브라우저에 알려준다 (text/html, text/xml, text/plain)
		response.setContentType("text/html;charset=UTF-8");
		// 클라이언트 브라우저에서 HTML을 읽어갈 수 있는 위치 확인(메모리)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		// => CSS, JS, title => AJAX
		// CSS사용 => 외부 CSS
		
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
		out.println("<style type=text/css>");
		// container(960px)여백O, contanier-fluid(All) 여백X
		out.println(".row {width:350px; margin:0px auto;}");
		out.println("h3 {text-align: center}");
		out.println("</style>");
		out.println("<body>");
		// => 화면 출력하는 태그를 이용한다
		out.println("<div class=container>");
		out.println("<h3>Login</h3>");
		out.println("</div>");
		out.println("<div class=row>");
		
		// 전송 준비
		out.println("<form method=post action=LoginServlet>");
		
		
		out.println("<table class=\"table table-striped\">");
		out.println("<tr>");
		out.println("<th width=20% class=\"danger text-right\">ID</th>");
		out.println("<td width=80%>");
		out.println("<input type=text name=id size=20>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20% class=\"danger text-right\">PASSWORD</th>");
		out.println("<td width=80%>");
		out.println("<input type=password name=pwd size=20>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=2 class=text-center>");
		out.println("<input type=submit value=로그인 class=\"btn btn-sm btn-primary\">");
		out.println("<input type=button value=로그인 class=\"btn btn-sm btn-danger\">");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</form>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	
	}
	
	// 사용자가 입력한 ID, PWD를 받아서 처리 => 로그인 (영화목록으로 이동)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTML 전송
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 1. 사용자가 보내준 id, pwd를 받는다.
		String id = request.getParameter("id"); // <input type=text name=id>
		String pwd = request.getParameter("pwd");// <input type=password name=pwd>
		// 2. DAO연동 => 결과값 가져오기
		MovieDAO dao = new MovieDAO();
		String result = dao.isLogin(id, pwd);
		// 3. 이동 시도
		if(result.equals("NO ID")) {//ID가 없는 경우
			out.println("<script>");
			out.println("alert(\"아이디가 존재하지 않습니다.\");");
			out.println("history.back();");//로그인 화면으로 이동
			out.println("</script>");
		}else if(result.equals("NO PWD")) {// ID는 존재 => 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert(\"비밀번호가 틀립니다.\");");
			out.println("history.back();");//로그인 화면으로 이동
			out.println("</script>");
		}else { // ID, PWD가 일치하는 경우 => LOGIN
			// 1. 서버에 ID,Name을 저장 => 프로그램 종료시까지 기억: 세션
			HttpSession session = request.getSession();
			session.setAttribute("id", id); // Map방식 => key, value
			session.setAttribute("name", result);
			
			// 이동
			response.sendRedirect("MovieListServlet");
		}
	
	}

}
