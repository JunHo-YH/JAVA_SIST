<%@ page info="2021-04-12 홍길동" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1.웹프로그램 실행을 위한 구성요소(38p)
	  1)웹 브라우저: 클라이언트 영역
	  2)웹 서버: 서버(요청을 받고 결과값 응답하는 역할)
	  			번역이 필요없는 파일 요청시 브라우저에서 실행이 가능
	  			HTML, XML, CSS, JavaScript
	  			=> Java, C#, Python는 반드시 컴파일을 시켜야 한다 => WAS필요
	  3)웹 어플리케이션 서버(WAS): 번역 => HTML, XML로 변환
	  				=> 톰캣, 레진(자바 번역기), IIS 
	  4)데이터베이스: 오라클 => 웹 사이트에 필요한 데이터를 저장하는 장소
	  					
	  					자바번역
	  웹브라우저 ===> 웹서버 ===> WAS ===> 오라클
	  		  <===      HTML변환  <===  
	  /main.jsp
	  /main.do
	  /main.html => 직접 처리
	  
	  ========================여기까지
	  
	  1. URL => 웹에서는 반드시 마지막에 파일명을 전송
	     /main.do => 서블릿을 찾아라(DispatcherServlet)
	     
	     page 37
	     ===> 웹은 거의 대부분이 Map
	          map("localhost","211.238.142.196")
	     http://localhost(IP,Domain)/JSPTotalLastProject/jsp/total1.jsp
	  	=====  ===================   ====================================
	  	프로토콜    서버주소                          URI
	  								====================
	  								ContextPath
	  	======================================================================== URL
	  	
	  	다른 파일로 데이터 전송
	  	main.jsp?no=1
	  	두 개를 전송
	  	main.jsp?no=1&page=1 => &로 구분
	 =======================================================================================
	 
	 page 51,56
	 1. page지시자
	 	ContentType = ""
	 	 => JSP를 변환할 때 (브라우저: XML, HTML) => 브라우저에서는 XML, HTML외의 모든 것은 txt
	 	 	HTML => text/html;charset=UTF-8
	 	 	XML  => text/xml;charset=UTF-8
	 	errorPage="" : 오류가 났을 경우 파일 이동 (error파일 출력)
	 		404: 요청판 파일이 없는 경우
	 		500: 자바 번역에서 오류가 나는 경우
	 		415: 스프링에서 등장 => 데이터명이 틀릴 경우
	 			 main.do?no=1&page=1
	 			 public String main_list(int page, BoardVO vo)
	 		200: 정상수행
	 		200
	 	import=""
	 		=> import="패키지.*"
	 		=> import="패키지.*"
	 		=> import="패키지.*"
	 		=> import="패키지.*,패키지.*,패키지.*"
	 	buffer="16kb"
	 		=> JSP번역 => Java => 컴파일 => .class => 실행 => HTML만 출력한다.
	 		   출력하는 위치를 Buffer(메모리 공간) => 저장된 HTML을 브라우저가 읽어서 출력
	 		   기본 8kb (one page) => 증가가 가능하게 만들었다. => 최대 32kb
	 		   (framework: spring, struts, jfs, 마이플랫폼) 
	 	
	 	page 65 ~ 72
	 	JSP => 자바+HTML
	 	자바 영역
	 		<% %>: 스크립트릿 => 일반 자바 코딩, 변수 선언, 제어문, 연산자, 기타 로직
	 		<%= %>: 표현식 => 브라우저에 출력
	 		<%! %>: 선언식 => 메서드를 만들 경우 => 자바를 이용해서 만든다 (import => 호출) => 거의 사라짐(보안문제가 있음)
	 	HTML 영역
	 	
	 	
		page 72: 내장객체(기본 객체)
			*** 전송방식 (GET, POST) => 한글처리
				GET: server.xml에서 작업
				POST: setCharacterEncoding() => Spring: Web.xml
			사용 요청 ==> request
						요청 => 요청값: getParameter(), getParameterValues()==========> 76page
									&hobby=a&hobby=b...
									(String[] hobby) => 415error
						IP 얻기 => getRemoteAddr()
						요청주소 확인 => getRequestURL() getRequestURI() ==============> 73page
						요청값 받기 => 데이터 전송 => setAttribute()
			
			요청처리 => JSP전체에서 사용 session
						setAttribute, getAttribute, invalidate, removeAttribute
						
			결과응답(HTML로 응답) ==> response
	 					setHeader =========> 91page
	 					redirect ==========> 93page
	 					
	 					
	 		주석 ==> 96page
	 		
	 		99page JSP 처리 과정
	 		브라우저 =================> WAS(톰캣) =======> JSP ========> 자바변환 ========> 컴파일
	 				==> 실행=======> 버퍼(HTML) =======> 브라우저 전송
	 				
	 				
	 		101page TCP
	 		115page 기본객체
	 			Application(121page) ==> getInitParameter(), getRealPath()
	 									==================
	 										web.xml을 읽을 때 사용
	 		
	 		132page 영역
	 			request: 화면이 변경되면 자동 초기화 (요청한 파일에서만 사용)
	 			session: 기간이 지나면 초기화 (프로젝트에 있는 모든 JSP파일에서 사용이 가능)
	 					 로그아웃, 브라우저 종료
	 		
	 		134page => request, session에 데이터를 추가해서 저장
	 					setAttribute(), getAttribute()
	 					
	 	
			141page => <%@ page errorPage=""> (우선순위 => web.xml에 적용한걸 무시하고 이게 우선 적용해서 web.xml에 작성한 error코드 무시)
						web.xml에 분리
			
			157page => JSP 특정 영역에 다른 JSP를 추가 <jsp:include> => Spring(라이브러리: tiles)
			<jsp:include>: HTML + HTML  => 변수명 충돌 x => 주로 이걸 사용한다.
			<%@ include %>: Java+Java => 변수명 충돌
			<iframe>: HTML안에 HTML첨부
			
			
			191page => 자바 클래스 연동
					   =============
					   ~VO, ~DAO, ~Manger
					   ===
					   Bean:데이터를 모아서 한 번에 전송할 목적으로 만든다.
					   195page: <jsp:useBean> 메모리 할당
					   199page: <jsp:setProperty>
			
			206page => 쿠키 (클라이언트 브라우저에 저장)
					  ==> 최신방문
					  ==> JSP는 응답시에 response를 이용한다 => 한 번만 사용가능(= HTML, 쿠키 두 가지 동시에 사용 불가능) => ~before를 이용해서 분리
					      response => HTML, 쿠키
					  ==> 생성, 값 얻기, 기간
					  ==> Cookie cookie = new Cookie(키,값)
					  								키: String
					  								값: String
					  ==> 저장 기간
					  	  setMaxAge(초단위)
					  ==> Cookie[] cookies = request.getCookie()
					  	  => 키 가져오기 => getname()
					  	  => 값 가져오기 => getValue()
					  
					  ==> 클라이언트로 전송
					  	  response.addCookie(cookie명)
					  	  
			232page => 세션 (서버에 일부 정보를 저장)
						==> 저장
							setAttribute
						==> 값 얻기
							getAttribute
						==> 해제
							invalidate()
							removeAttribute()
						==> setAttribute(String, Object)
						
			======================================================== MODEL 1방식 JSPBasicProject 시리즈 보기
			
			
			
						
			
	 
	  
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>