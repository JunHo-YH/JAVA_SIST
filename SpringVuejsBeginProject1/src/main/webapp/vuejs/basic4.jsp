<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://unpkg.com/vue"></script>
<!-- 
    if(���ǹ�)
     =>���� System.out.println("Hello1")
      System.out.println("Hello2")
      System.out.println("Hello3")
      
      if(���ǹ�)
      {
	      System.out.println("Hello1")
	      System.out.println("Hello2")
	      System.out.println("Hello3")
      }
      
      �±׿����� {}
      <template v-if="message">
        <p>�ȳ��ϼ���!!</p>
	    <p>Vue JS ���� = v-if (��Ƽ��)</p>
	    <p>message������ ���� ���� ���</p>
      </template>
 -->
</head>
<body>
  <div id="app">
    <h1 v-if="!message">Hello Vue</h1>
    <tempate v-else>
	    <p>�ȳ��ϼ���!!</p>
	    <p>Vue JS ���� = v-if (��Ƽ��)</p>
	    <p>message������ ���� ���� ���</p>
    </tempate>
    <textarea rows="5" cols="25" v-model="message"></textarea>
    <pre>
     {{$data}}
    </pre>
  </div>
  <script>
   new Vue({
	   el:'#app',
	   data:{
		   message:''
	   }
   })
  </script>
</body>
</html>