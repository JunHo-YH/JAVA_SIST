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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
  $(function(){
	  
	$('div#chat').toggleClass('active');
	var $win = $(window);
	var top = $(window).scrollTop(); // 현재 스크롤바의위치값을 반환합니다.
	
	/*사용자 설정 값 시작*/
	var speed          = 1000;     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
	var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
	var $layer         = $('div#chat_container'); // 레이어셀렉팅
	var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
	$layer.css('position', 'absolute');
	/*사용자 설정 값 끝*/
	
	// 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
	if (top > 0 )
	  $win.scrollTop(layerTopOffset+top);
	else
	  $win.scrollTop(0);
	
	//스크롤이벤트가 발생하면
	$(window).scroll(function(){
	
	  var yPosition = $win.scrollTop()+300;
	  if (yPosition< 0)
	  {
	    yPosition = $win.scrollTop()+300;
	  }
	  $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
	});
  })
</script>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto+Slab);
div#chat_container{
    position: absolute;
    bottom: 0;
    right: 10px;
    width: 270px;
    height: 310px;
    overflow: hidden;
    z-index: 1000;
    /*top:300px;*/
}
div#chat{
    position: absolute;
    bottom: 0;
    right: 10px;
    width: 250px;
    height: 300px;
    background-color: #efefef;
    box-shadow: 0px 0px 7px rgba(0, 0, 0, 0.25);
    transition:transform 300ms;
}

div#chat.active{transform: translateY(271px);}
div#chat header{
    width: 100%;
    height: auto;
    background-color: #FDCE6E;
    cursor: pointer;
}
div#chat header h1{
    font-family: 'Roboto Slab', sans-serif;
    color: white;
    font-size: 16px;
    text-align: left;
    whidth: 100%;
    margin: 0;
    padding: 3px 0 3px 20px;
}
div#chat section.content{
    overflow:scroll;
    background-color: #ffe1e1;
    position:absolute;
    top:29px;
    left: 0;
    right: 0;
    bottom:0;
}
div#chat form{
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 40px;
    background-color: white;
}
div#chat form input{
    display: block;
    width: 90%;
    height: 30px;
    border: none;
    line-height: 30px;
    margin: 5px auto;
    border-botom: 1px solid #303030;
    background-color: white;
    font-size: 16px;
}
div#chat form a{}

/* Experience digital logo */
#Provided_by{
    position:fixed;
    bottom: 20px;
    left:70px;
    color: #424242;
    text-decoration: none;
    font-family: sans-serif;
    margin-top: -20px;
    font-weight: 200;
}
#Provided_by img{
    position: absolute;
    bottom: -8px;
    width: 40px;
    left: -50px;
}
</style>
</head>
<body>
   <div id="app">
    <div class="container-fluid">
    <div class="row">
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
    </div>
    <div id="chat_container">
          <div id="chat" className="active">
              <header><h1>Chat</h1></header>
              <section className="content">
                  <div className="message_content">
                      
                  </div>
              </section>
              <form>
                <input type="text" id="input_chat"/>
            </form>
          </div>
       </div>
     </div>
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