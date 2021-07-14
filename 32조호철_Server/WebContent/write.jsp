<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	
	var subject = frm['subject'].value.trim();
	var price = frm['price'].value.trim();
	
	if(subject == ""){
		alert("도서제목은 반드시 작성해야 합니다");
        frm["subject"].focus();
        return false;
	}
	if(price < 0){
		alert("도서가격은 0 미만의 값을 입력할 수 없습니다.")
		frm['price'].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>작성 페이지</h2>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
도서제목:
<input type="text" name="subject"/><br>
도서소개:<br>
<textarea name="content"></textarea><br>
도서가격:
<input type="number" name="price"/><br>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href = 'list.do'">목록으로</button>
</body>
</html>
















