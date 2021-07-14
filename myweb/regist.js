function sendit(){
    var regist = document.forms['regform'];
    const userid=document.getElementById('userid');
    const userpw=document.getElementById('userpw');
    const userpw_re=document.getElementById('userpw_re');
    const username=document.getElementById('username');
    const hp = document.getElementById('hp');
    const email = document.getElementById('email');
    const ssn1 = document.getElementById('ssn1');
    const ssn2 = document.getElementById('ssn2');
    const isSSN= document.getElementById('isSSN');
    //숫자와 문자 포함 형태의 6~12자리 이내의 암호 정규식
     // 정규식
     const expPwText = /^[A-Za-z0-9]{6,12}$/;
     const expNametext = /[가-힣]+$/;
     const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
     const expEmailText = /^[A-Za-z0-9\.\-]+@[A-Za-z0-9\.\-]+\.[A-Za-z0-9\.\-]+$/;
//비번 ki1004
     if(userid.value== ''){
         alert('아이디를 입력하세요');
         userid.focus();
         return false;
     }
     
    if(userid.value.length < 4 || userid.value.length > 20){
        alert('아이디를 4자이상 20자 이하로 입력하세요.');
        userid.focus();
        return false;
    }
 
    if(userpw.value==''){
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }
    if(!expPwText.test(userpw.value)){
        alert('비밀번호 형식을 확인하세요');
        userpw.focus();
        return false;
    }
    if(userpw.value != userpw_re.value){
        alert('비밀번호 비밀번호 확인의 값이 서로 다릅니다');
        userpw.focus();
        return false;
    }
    if(username.value==''){
        alert('이름을 입력하세요');
        username.focus();
        return false;
    }
    if(expNametext.test(username.value)==false){
        alert('이름 형식을 확인하세요');
        username.focus();
        return false;
    }
    if(hp.value==''){
        alert('휴대폰 번호 입력하세요');
        hp.focus();
        return false;
    }
    if(expHpText.test(hp.value) == false){
        alert('휴대폰 번호 형식 확인')
        hp.focus();
        return false;
    }
    
    if(email.value==''){
        alert('이메일 입력하세요');
        email.focus();
        return false;
    }

    if(expEmailText.test(email.value)==false){
        alert('이메일 형식을 확인하세요');
        email.focus();
        return false;
    }
    if(sample6_postcode.value==''){
        alert('우편번호 입력하세요');
        return false;
    }
    if(sample6_detailaddress.value==''){
        alert('상세주소 입력하세요');
        return false;
    }

    if(isSSN.value == 'false'){
        alert('주민등록번호 검증을 확인하세요.');
        ssn1.focus();
        return false;
    }

    alert('가입을 축하드립니다');
    regist.submit();
}
function moveFocus(){
    const ssn1 = document.getElementById('ssn1');
    if(ssn1.value.length >= 6){
        document.getElementById('ssn2').focus();
    }
}

/*
1.주민번호 앞부터 12자리(지역번호까지)까지 각 자리를 2~9까지 곱한다.
2. 나온 숫자를 모두 더한다. 
③ 더한 숫자를 11로 나눈 나머지를 구한다.
3. 11에서 나머지를 뺀 숫자가 검증번호이다.
*/

function ssnCheck(){
    const ssn1 = document.getElementById('ssn1');
    const ssn2 = document.getElementById('ssn2');
    const isSSN = document.getElementById('isSSN');
  
    if(ssn1.value == "" || ssn2.value==""){
        alert('주민등록번호를 입력하세요');
        ssn1.focus();
        return false;
    }

    const ssn = ssn1.value+ssn2.value;
    const s1 = Number(ssn.substr(0, 1)) * 2;
    const s2 = Number(ssn.substr(1, 1)) * 3;
    const s3 = Number(ssn.substr(2, 1)) * 4;
    const s4 = Number(ssn.substr(3, 1)) * 5;
    const s5 = Number(ssn.substr(4, 1)) * 6;
    const s6 = Number(ssn.substr(5, 1)) * 7;
    const s7 = Number(ssn.substr(6, 1)) * 8;
    const s8 = Number(ssn.substr(7, 1)) * 9;
    const s9 = Number(ssn.substr(8, 1)) * 2;
    const s10 = Number(ssn.substr(9, 1)) * 3;
    const s11 = Number(ssn.substr(10, 1)) * 4;
    const s12 = Number(ssn.substr(11, 1)) * 5;
    const s13 = Number(ssn.substr(12, 1));

    let result = s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12;

    result = result % 11;
    result =11-result;
    if(result >= 10) result = result % 10;

    if(result == s13){
        alert('유효한 주민등록번호입니다.');
        isSSN.value = 'true';
    }else{
        alert('유효하지 않은 주민등록번호입니다.');
    }
    
}

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();

}