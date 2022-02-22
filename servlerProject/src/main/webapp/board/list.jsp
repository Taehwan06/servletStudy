<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%

	ArrayList<BoardVO> alist 
		=(ArrayList<BoardVO>)request.getAttribute("alist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 목록</h2>
	controller에서 넘어온 데이터 : <%=request.getAttribute("data1") %>
	<br><br>
	-가상경로를 이용한 상세페이지 구현하기 (view.do, board/view.jsp)
	<table border="1">
		<thead>
			<tr>
				<th>글제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<%for( int i=0; i<alist.size();i++){
				BoardVO vo = alist.get(i);
			%>
			<tr>
				<td><a href="view.do?bidx=<%=vo.getBidx()%>"><%=vo.getTitle()%></a></td>
				<td><%=vo.getWriter()%></td>
			</tr>
			<%
			}%>
		</tbody>
	</table>
</body>
</html>