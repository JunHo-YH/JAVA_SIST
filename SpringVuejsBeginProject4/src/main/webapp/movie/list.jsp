<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.movie_images:hover{
   cursor: pointer;
   border:3px solid green;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var offset = $('.col-sm-4').offset();  
	$('.window').animate({scrollTop: (offset.top - $('.window').height() / 2)}, 500);
})
</script>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container-fluid">
    <div class="col-md-8">
      <table class="table">
       <tr>
         <td class="text-center">
          <select class="input-sm" v-model="type">
           <option value="all">전체</option>
           <option value="T">영화명</option>
           <option value="G">장르</option>
           <option value="A">출연</option>
          </select>
          <input type=text size=20 class="input-sm" v-model="ss">
          <button class="btn btn-sm btn-primary" v-on:click="movieFind()">검색</button>
         </td>
       </tr>
      </table>
      <div style="height: 30px"></div>
      <div class="col-md-4" v-for="vo in movie_data">
		     <div class="thumbnail">
                <img :src="vo.poster" alt="Lights" style="width:320px;height: 320px" class="movie_images" 
                   v-on:click="movieDetail(vo.mno)">
		        <div class="caption">
		          <p style="font-size: 9px">{{vo.title}}</p>
		          <p style="font-size:8px">{{vo.genre}}</p>
		          <p style="font-size:8px">{{vo.actor.substring(0,20)}}</p>
		        </div>
		    </div>
	  </div>
	  <div style="height: 20px"></div>
	  <div class="text-center">
	    <button class="btn btn-sm btn-danger" v-on:click="prev()">이전</button>
	     {{curpage}} page / {{totalpage}} pages
	    <button class="btn btn-sm btn-warning" v-on:click="next()">다음</button>
	  </div>
    </div>
    <div class="col-md-4" v-show="isShow">
      <table class="table">
        <tr>
         <td width=30% class="text-center" rowspan="4">
           <img :src="movie_detail.poster" width=100%>
         </td>
         <td colspan="2">
           <h3>{{movie_detail.title}}</h3>
         </td>
        </tr>
        <tr>
          <td width=20% class="text-right">감독</td>
          <td width=50%>{{movie_detail.director}}</td>
        </tr>
        <tr>
          <td width=20% class="text-right">출연</td>
          <td width=50%>{{movie_detail.actor}}</td>
        </tr>
        <tr>
          <td width=20% class="text-right">장르</td>
          <td width=50%>{{movie_detail.genre}}</td>
        </tr>
        <tr>
          <td colspan="3">{{movie_detail.story}}</td>
        </tr>
      </table>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container-fluid',
    	data:{
    		movie_data:[],
    		curpage:1,
    		totalpage:1,
    		type:'',
    		ss:'',
    		movie_detail:{},
    		isShow:false
    	},
    	mounted:function(){
    		let _this=this;
    		this.movieGetData();
    		this.movieGetTotalPage();
    	},
    	methods:{
    		movieDetail:function(no){
    			this.isShow=true
    			let _this=this;
    			axios.get("http://localhost/web/movie/detail.do",{
    				params:{
    					mno:no
    				}
    			}).then(function(response){
    				_this.movie_detail=response.data
    				console.log(response.data)
    			})
    		},
    	    movieGetData:function(){
    	    	let _this=this;
    	    	axios.get("http://localhost/web/movie/list.do",{
	    			params:{
	    				page:this.curpage,
	        			type:this.type,
	        			ss:this.ss	
	    			}
	    		}).then(function(response){
	    			_this.movie_data=response.data;
	    			console.log(response.data)
	    		})
    	    },
    	    movieGetTotalPage:function(){
    	    	let _this=this;
    	    	axios.get("http://localhost/web/movie/total.do",{
	    			params:{
	        			type:this.type,
	        			ss:this.ss	
	    			}
	    		}).then(function(response){
	    			_this.totalpage=response.data
	    			console.log(response.data)
	    		})
    	    },
    		movieFind:function(){
    			//alert("Type:"+this.type+",검색어:"+this.ss);
    			this.curpage=1;
    			
	    		this.movieGetData();
	    		this.movieGetTotalPage();
    		},
    		prev:function(){
    			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			
    			this.movieGetData()
    		},
    		next:function(){
    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			
    			this.movieGetData()
    		}
    	}
    })
  </script>
</body>
</html>















