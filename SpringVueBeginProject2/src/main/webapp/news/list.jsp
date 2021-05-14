<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.row{
  margin: 0px auto;
  width:700px;
}
</style>
</head>
<%--
      생성 단계  => new Vue()  ===> created (메모리 할당 => 멤버변수의 값)
      저장단계   => HTML을 메모리  ===> mounted ======> rePrint
                              window.onload,$(function(){})
      수정단계   => 값이 변경 (검색변경,페이지변경) ====> rePrint
   메모리해제   => 메모리에서 객체삭제 ==> 화면 변경 destoryed
 --%>
<body>
   <div class="app">
     <div class="row">
       <table class="table">
        <tr>
         <td>
           <input type=text size="20" class="input-sm" v-model="fd">
           <button class="btn btn-sm btn-primary" v-on:click="sendData()">검색</button>
         </td>
        </tr>
       </table>
       <div style="height: 20px"></div>
       <table class="table">
        <tr>
          <td>
            <%-- 스프링에서 들어오는 뉴스데이터 출력  --%>
            <table class="table" v-for="n in news">
              <tr>
                <td style="color:orange">{{n.title}}</td>
              </tr>
              <tr>
                <td><a :href="n.link">{{n.desc}}</a></td>
              </tr>
              <tr>
                <td class="text-right">{{n.author}}</td>
              </tr>
            </table>
          </td>
        </tr>
       </table>
     </div>
   </div>
   <script>
    new Vue({
    	el:'.app',
    	data:{
    		news:[],
    		fd:'영화'
    	},
    	created:function(){
    		console.log("news_list.jsp:created")
    	},
    	mounted:function(){
    		console.log("news_list.jsp:mountd")
    		// news_list.do?fd=영화
    		// data:{"fd":'영화'}
    		/*
    		   axios({
    			   url:'',
    			   method:''
    		   })
    		*/
    		let _this=this;
    		axios.get("http://localhost/web/news/news_list.do",{
    			params:{
    				fd:this.fd
    			}
    		}).then(function(result){
    			_this.news=result.data;
    		})
    	},
    	updated:function(){
    		console.log("news_list.jsp:updated")
    	},
    	methods:{
    		sendData:function(){
        		axios.get("http://localhost/web/news/news_list.do",{
        			params:{
        				fd:this.fd
        			}
        		}).then(result=>{
        			this.news=result.data;
        		})
   		    }
    	}
    })
   </script>
</body>
</html>














