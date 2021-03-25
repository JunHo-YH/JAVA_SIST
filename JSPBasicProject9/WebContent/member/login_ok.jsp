<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<%
    // id,pwd 받는다
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    // DAO연결
    String result=dao.isLogin(id, pwd);
    // 결과출력 
    if(result.equals("NOID"))
    {
%>
         <script>
         alert("ID가 존재하지 않습니다!!");
         history.back();
         </script>
<%
    }
    else if(result.equals("NOPWD"))
    {
%>
        <script>
        alert("비밀번호가 틀립니다!!");
        history.back();
        </script>
<%    	
    }
    else
    {
    	// 로그인 상태 => session에 ID,Name저장
        /*
            1. 서버에 정보 저장 : setAttribute(키,값) 
            2. 저장된 데이터 읽기 : getAttribute(키)
            3. 일부정보를 지운다 : removeAttribute(키) => 장바구니,찜
            4. 전체 정보 지울 때 : invalidate() => 브라우저 종료 , 로그아웃 
            5. 기간(저장) : setMaxinactiveInterval(30분)
            6. 서버컴퓨터에 저장 , 모든 JSP에서 사용이 가능 (공유)
            =====> 로그인 처리 , 장바구니, 예매,댓글 (로그인 상태 확인)
            내장 객체 => 미리 생성이 되어 있다 
            request를 이용해서 생성이 가능 : request.getSession()
            => HttpSession 
            ** session: 실행중인 프로세스 
        */
        session.setAttribute("id", id);
        session.setAttribute("name", result);
        // 이동 => main.jsp
        response.sendRedirect("../main/main.jsp");
    }
%>











