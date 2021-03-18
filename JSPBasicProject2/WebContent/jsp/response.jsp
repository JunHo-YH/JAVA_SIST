<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%--
   		1. 404: 파일이 존재하지 않는 경우
   		2. 500: 자바 변경 => 컴파일, 인터프리터: 오류가 있는 경우
   		3. 403: 접속 거부
   		4. 405: 데이터를 잘못 보낸 경우 => 스프링에서 자주 발생
   		
   		요청 => 화면 이동
    	 =============
    	 1. header처리 ==> 데이터를 보내기 전에 먼저 실행할 내용
    	 				다운로드시(파일명, 파일크기) 미리 보여줄 때 사용
    	 				*****setHeader()
    	 2. 화면 이동 => *****response.sendRedirect(""): request가 초기화 된다. (화면 이동했으니까)
    	 					request에 있는 값을 받아서 => 오라클로 전송
    	 	insert.jsp =====> insert_ok.jsp ===> list.jsp
    	 			  request(추가한 내용)    request
   	 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="temp.jsp?id=admin&pwd=1234">클릭</a>

</body>
</html>





