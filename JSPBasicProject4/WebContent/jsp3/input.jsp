<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
   <form method=post action="input_ok.jsp" 
      enctype="multipart/form-data"><!-- 파일업로드시에만 사용이 가능 -->
   파일첨부:<input type=file name=upload size=20>
   <input type=submit value="파일올리기">
   </form>
  </center>
</body>
</html>