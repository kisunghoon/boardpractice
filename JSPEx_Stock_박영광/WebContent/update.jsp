<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>
<%@ page import="java.util.*" %>
<%
	List<ExamDTO> list = (List<ExamDTO>)request.getAttribute("list");
	int uid = Integer.parseInt(request.getParameter("uid"));
%>
<%
	if(list == null || list.size() == 0) {
%>
	<script>
		alert("해당정보가 삭제되거나 없습니다");
		history.back();
	</script>
<%		
		return; // 종료
	} 

	ExamDTO dto = list.get(0);
%>
<%
	String name = dto.getName();
	String intro = dto.getIntro();
	int total = dto.getTotal();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title><%= name %> 수정</title>
</head>
<script>
	function chkSubmit(){
		frm = document.forms['frm'];
		
		var name = frm['name'].value.trim();
		var total = frm['total'].value.trim();
		
		if(name == "") {
			alert("재고명을 입력하세요");
			frm['name'].focus();
			return false;
		}
		if(isNaN(total) || total == "" || total < 0) {
			alert(total + " 은 유효한 값이 아닙니다.");
			frm['total'].focus();
			return false;
		} 
		return true;
	}
</script>
<body>
<h2>수정</h2>
<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%= uid %>"/>
제품명:
<input type="text" name="name" value="<%= name %>"/><br>
제품재고:
<input type="text" name="total" value="<%= total %>"/><br>
제품소개:
<textarea name="intro"><%= intro %></textarea><br>
<br><br>
<input type="submit" value="수정"/>
</form>
<button type="button" onclick="history.back()">이전으로</button>
<button type="button" onclick="location.href='list.do'">목록보기</button>

</body>
</html>