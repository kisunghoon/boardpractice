function checkAgree(){
    var regist = document.forms['regist'];

    for(i=0;i<regist['agree'].length;i++){
        if(!regist['agree'][i].checked){
            alert('약관에 동의 하셔야 합니다');

            return;
        }
    }
    regist.submit();

}