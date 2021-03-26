<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sist.dao.*, java.util.*"%>
<%--
	main.jsp?mode=2&no=10
	===============
	detail.jsp?no=10
	
 --%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
<!--메모리를 자동관리해준다.  -->
<%
String no = request.getParameter("no");
//FoodDAO dao = new FoodDAO(); => useBean으로 처리 => 메모리 누적 방지
FoodVO vo = dao.foodDetailData(Integer.parseInt(no));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<table class="table">
			<tr>
				<td>
					<h3><%=vo.getTitle()%>&nbsp;<span style="color: orange"><%=vo.getScore()%></span>
					</h3>
				</td>
			</tr>
			<tr>
				<%
				StringTokenizer st = new StringTokenizer(vo.getPoster(), "^");
				while (st.hasMoreElements()) {
				%>
				<td><img src="<%=st.nextToken()%>" width=100%></td>
				<%
				}
				%>
			</tr>
		</table>
	</div>

	<div class="row">
		<div class="col-sm-6">
			<table class="table">
				<tr>
					<th width=20% class="text-right">주소</th>
					<td width=80%><%=vo.getAddress().substring(0, vo.getAddress().lastIndexOf("지"))%></td>
				</tr>
				<tr>
					<th width=20% class="text-right">전화</th>
					<td width=80%><%=vo.getTel()%></td>
				</tr>
				<tr>
					<th width=20% class="text-right">음식 종류</th>
					<td width=80%><%=vo.getType()%></td>
				</tr>
				<tr>
					<th width=20% class="text-right">가격대</th>
					<td width=80%><%=vo.getPrice()%></td>
				</tr>
				<tr>
					<th width=20% class="text-right">주차</th>
					<td width=80%><%=vo.getParking()%></td>
				</tr>
				<tr>
					<th width=20% class="text-right">영업시간</th>
					<td width=80%><%=vo.getTime()%></td>
				</tr>
				<%
				if (!vo.getMenu().equals("no")) {
				%>
				<tr>
					<th width=20% class="text-right">메뉴</th>
					<td width=80%>
						<ul style="list-style-type: none">
							<%
							st = new StringTokenizer(vo.getMenu(), "원");
							while (st.hasMoreTokens()) {
							%>
							<li><%=st.nextToken().trim()%>원</li>
							<%
							}
							%>
						</ul>
					</td>
				</tr>
				<%
				}
				%>


			</table>

		</div>
		<div class="col-sm-6">
			<div id="map" style="width: 100%; height: 350px;"></div>
			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level : 3
				// 지도의 확대 레벨
				};

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption);

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder
						.addressSearch(
								'<%=vo.getAddress().substring(0, vo.getAddress().lastIndexOf("지"))%>',function(result, status) {

									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});

										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : '<div style="width:150px;text-align:center;padding:6px 0;"><%=vo.getTitle()%></div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			</script>
			<div style="height:30px"></div>
		</div>
	</div>


</body>
</html>