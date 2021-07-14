
var api_key= "75794b4f566b697338326d507a4155";

$(document).ready(function(){


 $("#btn_load").click(function(){
     var id = $("#id").val();
     var start_index = $("#start_index").val();
     var end_index  = $("#end_index").val();
     var treename = $("#treename").val();
   
     $("[name='key']").val(api_key);
 // JSON
    var url = "http://openapi.seoul.go.kr:8088/" + api_key + "/json/gangnamTreeSaveInfo/" + start_index + "/" + end_index+"/";

 var req_url = ""
 if(start_index <=0 || end_index <=0){
     alert("0초과의 값을 입력하세요");
     return;
 }

 if(end_index >5){
     alert("마지막 행수를 초과하셨습니다 행 수는 최대 행 수는 5입니다");
 }
  $.ajax({
      url :  url,
      type : "GET",
      data: $("[name='frm']").serialize(),
      cache : false,
      success : function(data, status){
          if(status == "success") parseJSON(data);
        
      }
   });
});

$("#btn_remove").click(function(){
 $("#demoJSON").html("");
});



});
function parseJSON(jsonObj){

var row = jsonObj.gangnamTreeSaveInfo.row;
var i;


var table="<tr><th>도시</th><th>구</th><th>유형</th><th>종류</th><th>기관명</th><th>나이</th><th>지정일자</th><th>주소</th><th>지번</th></tr>";
for (i = 0; i < row.length; i++) { 
table += "<tr>";
table += "<td>" + row[i].SIDO + "</td>";
table += "<td>" + row[i].SIGUNGU + "</td>";
table += "<td>" + row[i].TYPE_NM + "</td>";
table += "<td>" + row[i].TREE_KIND + "</td>";
table += "<td>" + row[i].MANAGE_NM + "</td>";
table += "<td>" + row[i].AGE + "</td>";
table += "<td>" + row[i].APPOINMENT_DT + "</td>";


table += "<td>" + row[i].ADDR + "</td>";
table += "<td>" + row[i].ADDR_OLD + "</td>";
table += "</tr>";
} 
$("#demoJSON").html(table);

}
