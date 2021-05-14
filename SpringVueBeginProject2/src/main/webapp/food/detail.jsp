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
   width:700px;
}
</style>
</head>
<body>
   <div id="app">
     <div class="row">
       <table class="table">
        <tr>
         <td class="text-center" v-for="img in food.poster.split('^')">
          <img :src="img" width=100%>
         </td>
        </tr>
       </table>
       <div style="height: 10px"></div>
       <table class="table">
         <tr>
          <td colspan="2">
           <h3>{{food.title}}&nbsp;<span style="color:orange">{{food.score}}</span></h3>
          </td>
         </tr>
         <tr>
           <td width=20% class="text-right">주소</td>
           <td width=80%>{{food.address}}</td>
         </tr>
         <tr>
           <td width=20% class="text-right">전화</td>
           <td width=80%>{{food.tel}}</td>
         </tr>
         <tr>
           <td width=20% class="text-right">음식종류</td>
           <td width=80%>{{food.type}}</td>
         </tr>
         <tr>
           <td width=20% class="text-right">가격대</td>
           <td width=80%>{{food.price}}</td>
         </tr>
         <tr>
           <td width=20% class="text-right">주차</td>
           <td width=80%>{{food.parking}}</td>
         </tr>
         <tr v-if="food.menu">
           <td width=20% class="text-right">메뉴</td>
           <td width=80%>
             <span v-for="m in food.menu.split('원')">{{m}}<br></span>
           </td>
         </tr>
         <tr>
           <td colspan="2" class="text-center">
            <img src="../food/good1.png" width=20 height=20>({{food.good}})&nbsp;
            <img src="../food/good1.png" width=20 height=20>({{food.soso}})&nbsp;
            <img src="../food/good1.png" width=20 height=20>({{food.bad}})
           </td>
         </tr>
       </table>
     </div>
     <script>
      new Vue({
    	  el:'#app',
    	  data:{
    		  food:{},
    		  no:${no}
    	  },
    	  created:function(){
	    		console.log("food_detail.jsp:created=new Vue()생성");
	    	},
	    	updated:function(){
	    		console.log("food_detail.jsp:updated=new Vue()유지");
	    	},
    	  mounted:function(){
    		  axios.get("http://localhost/web/food/food_detail.do",{
    			  params:{
    				  no:this.no
    			  }
    		  }).then(response=>{
    			  console.log(response);
    			  this.food=response.data;
    		  })
    	  }
      })
     </script>
   </div>
</body>
</html>










