<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
}
</style>
</head>
<body>
  <div id="app">
	  <div class="row">
	   <div class="jumbotron text-center">
	     <h1>{{info.title}}</h1>
	     <h4>{{info.subject}}</h4>
	   </div>
	  </div>
	  <div class="row">
	  <%--
	         response=> this는 Vue
	         function(response){
	            this => axios
	         }
	   --%>
	   <table class="table">
	    <tr>
	     <td class="text-right">
	      <a href="../main/main.do" class="btn btn-sm btn-primary">목록</a>
	     </td>
	    </tr>
	   </table>
	   <table class="table">
	     <tr>
	      <td>
	        <table class="table" v-for="vo in food">
	         <tr>
	           <td class="text-center" width="30%" rowspan="3">
	             <a :href="'../food/detail.do?no='+vo.no"><img :src="vo.poster" width=270 height=150></a>
	           </td>
	           <td width=70%>
	              <h3><a :href="'../food/detail.do?no='+vo.no">{{vo.title}}</a>(<span style="color:orange">{{vo.score}}</span>)</h3>
	           </td>
	         </tr>
	         <tr>
	           <td width=70%>주소:{{vo.address}}</td>
	         </tr>
	         <tr>
	           <td width=70%>전화:{{vo.tel}}</td>
	         </tr>
	        </table>
	      </td>
	     </tr>
	   </table>
	  </div>
	  <script>
	   new Vue({
		   el:'#app',
		   data:{
			   info:{},
			   food:[],
			   cno:${no}
		   },
		   created:function(){
	    		console.log("food_list.jsp:created=new Vue()생성");
	    	},
	    	updated:function(){
	    		console.log("food_list.jsp:updated=new Vue()유지");
	    	},
		   mounted:function(){
			   axios.get("http://localhost/web/food/category_list.do",{
				   params:{
					   cno:this.cno
				   }
			   }).then(response=>{
				   console.log(response);
				   this.food=response.data;
			   });
			   
			   axios.get("http://localhost/web/food/category_info.do",{
				   params:{
					   cno:this.cno
				   }
			   }).then(response=>{
				   console.log(response);
				   this.info=response.data;
			   })
		   }
	   })
	  </script>
  </div>
</body>
</html>





