<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    // �ڹ� �ڵ� ����
    MusicDAO dao=new MusicDAO();
    ArrayList<MusicVO> list=dao.musicListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
   <div style="height: 30px"></div>
   <div class="container-fluid">
     <h3 class="text-center">���� Top 200</h3>
     <div class="row">
       <!-- 
            success : green
            danger : pink
            
        -->
       <table class="table table-bordered">
         <tr class="success">
           <th>����</th>
           <th></th>
           <th></th>
           <th>���</th>
           <th>������</th>
           <th>�ٹ�</th>
         </tr>
         <%
             for(MusicVO vo:list)
             {
         %>
                <tr>
                  <td><%=vo.getNo() %></td>
                  <td>
                    <%
                        String state=vo.getState();
                        String str="";
                        if(state.equals("���"))
                        {
                        	str="�� "+vo.getIdcrement();
                        }
                        else if(state.equals("�ϰ�"))
                        {
                        	str="�� "+vo.getIdcrement();
                        }
                        else if(state.equals("new"))
                        {
                        	str="new";
                        }
                        else
                        {
                        	str="-";
                        }
                    %>
                    <%=str %>
                  </td>
                  <td><img src="<%=vo.getPoster() %>" width=30 height=30></td>  
                  <td><%=vo.getTitle() %></td>
                  <td><%=vo.getSinger() %></td>
                  <td><%=vo.getAlbum() %></td>
                </tr>  
         <%
             }
         %>
       </table>
     </div>     
   </div>
</body>
</html>












