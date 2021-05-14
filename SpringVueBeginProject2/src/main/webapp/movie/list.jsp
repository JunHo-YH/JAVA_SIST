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
<!-- 
  Vue���� �� ��� ==> �Ӽ��� : <img src=""> <a href=""> => �Ӽ� �տ� :  :src :href => {{}}(����ϸ� �ȵȴ�) 
                                  �±װ�: <td>��</td> => {{json�� Ű��}}
                  Vue : �ӵ� => React(����) : �޸𸮸� 2�� ���
                              String + , StringBuffer 
                                             ����(�����) => AngularJS
                  => AngularJS 
 -->
</head>
<body>
  <div id="app">
    <div class="row">
     <div class="col-md-4" v-for="vo in movie">
		     <div class="thumbnail">
               <a :href="'../movie/detail.do?mno='+vo.mno">
                <img :src="vo.poster" style="width:100%">
		        <div class="caption">
		          <p style="font-size: 9px">{{vo.title}}</p>
		        </div>
		      </a>
		    </div>
    </div>
    <div class="row">
      <div class="text-center">
       <button class="btn btn-sm btn-danger" v-on:click="showPrevPage()">����</button>
        {{curpage}} page / {{totalpage}} pages
       <button class="btn btn-sm btn-info" v-on:click="showNextPage()">����</button>
      </div>
    </div>
    <script>
     new Vue({
    	 el:'#app',
    	 data:{
    		 movie:[],
    		 curpage:1,
    		 totalpage:1
    	 },
    	 mounted:function(){
    		 axios.get("http://localhost/web/movie/movie_list.do",{
    			 params:{
    				 page:this.curpage
    			 }
    		 }).then(response=>{
    			 this.movie=response.data
    		 });
    		 
    		 axios.get("http://localhost/web/movie/movie_total.do").then(response=>{
    			 console.log(response)
    			 this.totalpage=response.data
    		 })
    	 },
    	 methods:{
    		 showPrevPage(){
    			 this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			 axios.get("http://localhost/web/movie/movie_list.do",{
    				 params:{
    					 page:this.curpage
    				 }
    			 }).then(response=>{
    				 this.movie=response.data
    			 })
    		 },
    		 showNextPage(){
    			 this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			 axios.get("http://localhost/web/movie/movie_list.do",{
    				 params:{
    					 page:this.curpage
    				 }
    			 }).then(response=>{
    				 this.movie=response.data
    			 })
    		 }
    	 }
     })
    </script>
  </div>
</body>
</html>













