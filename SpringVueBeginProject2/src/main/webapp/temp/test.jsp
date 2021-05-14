<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
    <ul>
      <li v-for="m in message2.split('\n')">{{m}}</li>
    </ul>
  </div>
  <script>
   new Vue({
	 el:'#app',
	 data:{
		 message:'ABC^DEF^HIO^OPQ',
		 message2:'AB\nCD\nEF\nKK\nOP'
	 }
   })
  </script>
</body>
</html>