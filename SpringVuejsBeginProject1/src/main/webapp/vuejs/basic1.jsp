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
        �ܺ��� �����͸� ������ �ö� (������,�ٸ� ����)
 -->
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <center>
    <!-- VueJS����Ǵ� ��ġ ���� : id,class -->
    <div id="app">
      <h1>{{message}}</h1>
      <input type=text size=20 v-model="message">
    </div>
    <script>
      // ��ü ���� (Vue)
      new Vue({
    	  el:'#app',
    	  data:{
    		 message:'Hello VueJS!!'
    	  },
    	  beforeCreate(){
    		  console.log("beforeCreate():�̺�Ʈ��� ,�ν��Ͻ��� �ʱ�ȭ..")
    	  },
    	  created(){
    		  console.log("created():�ν��Ͻ� �ۼ��� ��������")
    	  },
    	  beforeMount(){
    		  console.log("beforeMount():�޸𸮿� ���� �� ����:���������� �����͸� �о���� ����")
    	  },
    	  mounted(){
    		  console.log("mounted():�޸𸮿� ����Ǵ� ����:window.onload,$(function(){}):������ ��ġ ����")
    	  },
    	  beforeUpdate(){
    		  console.log("beforeUpdate():�����ͳ� ȭ�� ������ ȣ��")
    	  },
    	  updated(){
    		  console.log("updated():�����ͳ� ȭ�� ������ ȣ��")
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

















