package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import java.util.*;
@WebServlet("/MovieDetailServlet")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에 출력 => 브라우저에 HTML을 전송한다 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		// MovieDetailServlet?mno=5
		// 사용자로 부터 영화 번호를 받는다 
		String mno=request.getParameter("mno");
		// 영화번호 => DAO => 상세내용을 리턴(VO) 
		MovieDAO dao=new MovieDAO();
		MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
		ArrayList<MovieVO> list=dao.replyTop10();
		// 목록을 출력 => DAO(ArrayList)
		// 상세보기 => DAO(VO) VO:영화관련 한개에 대한 모든 정보를 가지고 있다 
		// 화면에 출력 => HTML
		out.println("<html>");
		out.println("<head>");
		// script , css , title , meta => 설정 (화면 출력부분은 아니다)
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		 // container(960px) , container-fluid(Full 화면)
		out.println(".row { width:1200px;margin:0px auto;}");//<center>태그는 사용금지
		 // <center> => margin:0px auto;
		//out.println(".col-sm-9{border:1px solid green;height:450px}");
		//out.println(".col-sm-4{border:1px solid blue;height:450px}");
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		// 화면 출력 부분  ==> <html><head><body> => 생략할 수 있다
		out.println("<div style=\"height:30px\"></div>");
		out.println("<div class=container>");//width=960px
		out.println("<div class=row>"); // 상세보기 , 인기순위
		out.println("<div class=col-sm-9>"); // row => 숫자 => 12
		out.println("<h3>&lt;"+vo.getTitle()+"&gt; 상세보기</h3>");
		out.println("<table class=\"table table-striped\">");
		
		out.println("<tr>");
		out.println("<td width=30% class=text-center rowspan=6>");
		out.println("<img src="+vo.getPoster()+" width=100%>");
		out.println("</td>");
		out.println("<td colspan=2 style=\"color:orange;font-size:15pt\">");
		out.println(vo.getTitle()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">감독</td>");
		out.println("<td width=60%>"+vo.getDirector()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">출연</td>");
		out.println("<td width=60%>"+vo.getActor()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">장르</td>");
		out.println("<td width=60%>"+vo.getGenre()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">등급</td>");
		out.println("<td width=60%>"+vo.getGrade()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">개봉일</td>");
		out.println("<td width=60%>"+vo.getRegdate()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=3 class=text-right>");
		out.println("<a href=# class=\"btn btn-xs btn-danger\">예매하기</a>");
		out.println("<a href=# class=\"btn btn-xs btn-warning\">찜하기</a>");
		out.println("<a href=MovieListServlet class=\"btn btn-xs btn-info\">목록</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("<div class=col-sm-3>");
		out.println("<h3>댓글이 많은 영화</h3>");// 댓글을 올리때마다 자동으로 히트를 증가 (Trigger)
		out.println("<table class=\"table table-hover\">");
		for(MovieVO tvo:list)
		{
			out.println("<tr>");
			out.println("<td class=text-center>");
			out.println("<img src="+tvo.getPoster()+" width=30 height=30>");
			out.println("</td>");
			out.println("<td class=text-center>");
			out.println(tvo.getTitle());
			out.println("</td>");
			out.println("<td class=text-center>");
			out.println(tvo.getHit());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
        out.println("<div class=row>"); // 댓글
        
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("id");
        ArrayList<ReplyVO> rlist=dao.replyListData(Integer.parseInt(mno));
		out.println("<div class=col-sm-9>");
		// 댓글 출력 위치 
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<td>");
		for(ReplyVO rvo:rlist)
		{
			out.println("<table class=table>");
			out.println("<tr>");
			out.println("<td class=text-left>");
			out.println("<span style=\"color:blue\">"+rvo.getName()+"</span>("+rvo.getDbday()+")");
			out.println("</td>");
			out.println("<td class=text-right>");
			if(rvo.getId().equals(id))
			{
				out.println("<a href=# class=\"btn btn-xs btn-danger\">수정</a>");
				out.println("<a href=# class=\"btn btn-xs btn-warning\">삭제</a>");
			}
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=2 valign=top class=text-left>");
			out.println("<pre style=\"background:white;white-space:pre-wrap;\">"+rvo.getMsg()+"</pre>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		if(id!=null) // 로그인이 성공했을때만 
		{
			out.println("<table class=table>");
			out.println("<tr>");
			out.println("<td>");
			out.println("<form method=post action=ReplyInsertServlet>");
			out.println("<input type=hidden name=mno value="+vo.getMno()+">");
			out.println("<textarea rows=3 cols=90 style=\"float:left\" name=msg></textarea>");
			out.println("<input type=submit value=댓글쓰기 class=\"btn btn-sm btn-primary\" style=\"height:68px;float:left\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		out.println("</div>");
		
		out.println("<div class=col-sm-3>");// 영화뉴스 
		out.println("</div>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

}












