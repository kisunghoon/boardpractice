<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>제품목록작성</title>
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
<h2> 제품 목록 작성 </h2>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
제품명:
<input type="text" name="name"/><br>
제품재고:
<input type="text" name="total" value="0"/><br>
제품소개:
<textarea name="intro"></textarea><br>
<br><br>
<input type="submit" value="등록"/>
</form>

<button type="button" onclick="location.href='list.do'">목록보기</button>

</body>
</html>