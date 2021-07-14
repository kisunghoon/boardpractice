<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int cnt = (Integer)request.getAttribute("result");
	int uid = Integer.parseInt(request.getParameter("uid"));
%>

<% if(cnt == 0){ %>
	<script>
		alert("수정에 실패하였습니다");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("수정에 성공하였습니다");
		location.href = "view.do?uid=<%= uid %>";
	</script>
<% } %>