<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>
<%@ page import="java.util.*" %>
<%
	List<ExamDTO> list = (List<ExamDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>제품 리스트</title>
</head>
<style>
table {width: 100%}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<body>
<hr>
<h2>제품 리스트</h2>
<table>
	<tr>
		<td>제품고유번호</td>
		<td>제품명</td>
		<td>제품재고</td>
		<td>제품소개</td>
		<td>등록일</td>
	</tr>
<%
	if(list != null){
		for(ExamDTO dto : list){
%>
		<tr>
			<td><%= dto.getUid() %></td>
			<td><a href="view.do?uid=<%= dto.getUid() %>"><%= dto.getName() %></a></td>
			<td><%= dto.getTotal() %></td>
			<td><%= dto.getIntro() %></td>
			<td><%= dto.getRegDateTime() %></td>
		</tr>
<%
		} // end for
	} // end if
%>
</table>
<br>
<button onclick="location.href='write.do'">등록하기</button>
</body>
</html>