<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int cnt = (Integer)request.getAttribute("result");
%>
<% if(cnt == 0){ %>
	<script>
		alert("등록에 실패하였습니다");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("등록에 성공하였습니다");
		location.href = "list.do";
	</script>
<% } %>