<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>    
<%@ page import="java.util.*" %>
<% // Controller 로부터 결과 데이터 받음
	List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>목록</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<hr>
	<h2>목록 페이지</h2>
	<table>
		<tr>
			<th>도서고유번호</th>
			<th>도서제목</th>
			<th>도서소개</th>
			<th>도서가격</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%
	if(list != null){
		for(WriteDTO dto : list){
%>
		<tr>
			<td><%= dto.getUid() %></td>
			<td><a href="view.do?uid=<%=dto.getUid() %>"><%= dto.getSubject() %></a></td>
			<td><%= dto.getContent() %></td>
			<td><%= dto.getPrice() %></td>
			<td><%= dto.getViewCnt() %></td>
			<td><%= dto.getRegDateTime() %></td>
		</tr>
<%			
		} // end for
	} // end if
%>	
	</table>
	<br>
	<button onclick="location.href='write.do'">신규등록</button>
</body>
</html>



