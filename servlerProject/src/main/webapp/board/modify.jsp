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
</head>
<body>
	<h2>게시글 수정</h2>
	<form name="modifyFrm" action="modifyOk.do">
		<input type="hidden" name="bidx" value="<%=vo.getBidx() %>">
		<table border="1">
			<tr>
				<td>글제목</td>
				<td><input type="text" name="title" value="<%=vo.getTitle() %>"></td>
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
				<td><textarea name="content"><%=vo.getContent() %></textarea></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="저장">
		<input type="button" value="취소" onclick="location.href='view.do'">
	</form>
</body>
</html>