<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>
<%@ page import="java.util.*" %>
<%
	List<ExamDTO> list = (List<ExamDTO>)request.getAttribute("list");
%>
<%
	if(list == null || list.size() == 0) {
%>
	<script>
		alert("해당정보가 삭제되었거나 없습니다");
		history.back();
	</script>
<%
		return;  // 종료!
	}

	ExamDTO dto = list.get(0);
%>
<%
	int uid = dto.getUid();
	String name = dto.getName();
	String intro = dto.getIntro();
	int total = dto.getTotal();
	String regdate = dto.getRegDateTime();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title><%= name %>제품 정보</title>
</head>
<script>
function chkDelete(uid){
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = "deleteOk.do?uid=" + uid;
	}
}
</script>
<body>
<br>
제품고유번호 : <%= uid %><br>
제품명 : <%= name %><br>
제품재고 : <%= total %><br>
등록일 : <%= regdate %><br>
제품소개 : <br> 
<div>
<%= intro %>
</div>
<hr>
<button onclick="location.href='update.do?uid=<%= uid %>'">수정하기</button>
<button onclick="chkDelete(<%= uid %>)">삭제하기</button>
<button onclick="location.href='list.do'">목록보기</button>
<button onclick="location.href='write.do'">신규등록</button>
</body>
</html>