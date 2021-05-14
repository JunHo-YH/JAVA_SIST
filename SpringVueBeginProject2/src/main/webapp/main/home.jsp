<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
  /*
        beforeCreate 
        created 
        ============= new Vue() 생성 
        beforeMount
        mounted =======> $(function()),window.onload
        ============= HTML을 메모리에 트리형태로 저장  => render():브라우저에 출력 
        beforeUpdate
        updated
        ============= 데이터 수정   => render():브라우저에 출력 
        beforeDestory
        destoryed
        ============= new Vue()해제
        data:{"no":no}
    */
 --%>
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
	   <div class="text-center">
	     <button class="btn btn-sm btn-danger" v-on:click="categoryChange(1)">믿고 보는 맛집 리스트</button>
	     <button class="btn btn-sm btn-success" v-on:click="categoryChange(2)">지역별 인기 맛집</button>
	     <button class="btn btn-sm btn-info" v-on:click="categoryChange(3)">메뉴별 인기 맛집</button>
	   </div>
	  </div>
	  <div style="height:30px"></div>
	  <div class="row">
	       <div class="col-md-4" v-for="vo in food">
		     <div class="thumbnail">
               <a :href="'../food/food_list.do?no='+vo.no">
                <img :src="vo.poster" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p style="font-size: 9px">{{vo.title}}</p>
		          <sub style="font-size:8px">{{vo.subject}}</sub>
		        </div>
		      </a>
		    </div>
	  </div>
  </div>
  <script>
	    new Vue({
	    	el:'#app',
	    	data:{
	    		food:[],
	    		no:1
	    	},
	    	created:function(){
	    		console.log("home.jsp:created=new Vue()생성");
	    	},
	    	updated:function(){
	    		console.log("home.jsp:updated=new Vue()유지");
	    	},
	    	mounted:function(){
	    		axios.get("http://localhost/web/food/category.do",{
	    			params:{
	    				no:this.no
	    			}
	    		}).then(response=>{
	    			console.log(response);
	    			this.food=response.data;
	    		})
	    	},
	    	methods:{
	    		categoryChange(n){
	    			axios.get("http://localhost/web/food/category.do",{
		    			params:{
		    				no:n
		    			}
		    		}).then(response=>{
		    			console.log(response);
		    			this.food=response.data;
		    		})
	    		}
	    	}
	    	
	    })
  </script>
  
</body>
</html>







