<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 
    <script type="text/javascript"> ES5
    <script type="text/babel"> ES6
    
    https://unpkg.com/axios/dist/axios.min.js
        외부의 데이터를 가지고 올때 (스프링,다른 서버)
 -->
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <center>
    <!-- VueJS적용되는 위치 지정 : id,class -->
    <div id="app">
      <h1>{{message}}</h1>
      <input type=text size=20 v-model="message">
    </div>
    <script>
      // 객체 생성 (Vue)
      new Vue({
    	  el:'#app',
    	  data:{
    		 message:'Hello VueJS!!'
    	  },
    	  beforeCreate(){
    		  console.log("beforeCreate():이벤트등록 ,인스턴스의 초기화..")
    	  },
    	  created(){
    		  console.log("created():인스턴스 작성이 끝난상태")
    	  },
    	  beforeMount(){
    		  console.log("beforeMount():메모리에 저장 전 상태:서버연결후 데이터를 읽어오는 상태")
    	  },
    	  mounted(){
    		  console.log("mounted():메모리에 저장되는 상태:window.onload,$(function(){}):데이터 배치 종료")
    	  },
    	  beforeUpdate(){
    		  console.log("beforeUpdate():데이터나 화면 변경전 호출")
    	  },
    	  updated(){
    		  console.log("updated():데이터나 화면 변경후 호출")
    	  },
    	  beforeDestory(){
    		  console.log("beforeDestory() Call...")
    	  },
    	  destroryed(){
    		  console.log("destoryed() Call...")
    	  }
      })
    </script>
  </center>
</body>
</html>

















