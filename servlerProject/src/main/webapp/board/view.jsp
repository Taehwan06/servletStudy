<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delFn(){
		var form = document.getElementsByTagName("form")[0];
		form.setAttribute("action","delete.do");
		form.submit();
	}
</script>
</head>
<body>
	<h2>상세페이지</h2>
	<table border="1">
		<tr>
			<td>글제목</td>
			<td><%=vo.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=vo.getWriter() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=vo.getWdate() %></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=vo.getHit() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%=vo.getContent() %></td>
		</tr>
	</table>
	<br>
	<button onclick="location.href='modify.do?bidx=<%=vo.getBidx() %>'">수정</button>
	<input type="button" value="목록" onclick="location.href='board.do'">
	<input type="button" value="삭제" onclick="delFn()">
	<form name="delFrm" method="post">
		<input type="hidden" name="bidx" value="<%=vo.getBidx()%>">
	</form>
</body>
</html>