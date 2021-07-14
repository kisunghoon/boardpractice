
var api_key= "75794b4f566b697338326d507a4155";
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
/*
    구글 차트 버전을 최신으로 불러와준다.
    구글 차트를 로드한다
*/
var pm10;
$(document).ready(function(){

    $("#btn_load").click(function(){
       
        var start_index = $("#start_index").val();
        var end_index = $("#end_index").val();

        var url = "http://openapi.seoul.go.kr:8088/" + api_key + "/json/RealtimeCityAir/" + start_index + "/" + end_index+"/";
        
        $.ajax({
            url: url,
            type:"GET",
            cache:false,

            success:function(data,status){
                if(status == "success") parseJSON(data);
            }
        });
    });

    $("#btn_remove").click(function(){
        $("#demoJSON").html("");
    });
});

function parseJSON(jsonObj){
    var row=jsonObj.RealtimeCityAir.row;
    var i;

    
var table="<tr><th>측정일시</th><th>측정소명</th><th>미세먼지</th><th>초미세먼지농도</th><th>오존</th><th>이산화질소농도</th><th>일산화질소농도<th>아황산가스농도</th><th>통합대기환경등급</th></tr>";
for (i = 0; i < row.length; i++) { 
table += "<tr>";
table += "<td>" + row[i].MSRDT + "</td>";
table += "<td>" + row[i].MSRSTE_NM + "</td>";
table += "<td>" + row[i].PM10 + "</td>";
table += "<td>" + row[i].PM25 + "</td>";
table += "<td>" + row[i].O3 + "</td>";
table += "<td>" + row[i].NO2 + "</td>";
table += "<td>" + row[i].CO + "</td>";
table += "<td>" + row[i].SO2 + "</td>";
table += "<td>" + row[i].IDEX_NM + "</td>";
// table += "<td>" + row[i].IDEX_MVL + "</td>";
// table += "<td>" + row[i].ARPLT_MAIN + "</td>";
table += "</tr>";
pm10=row[0].PM10;
} 
$("#demoJSON").html(table);
}


function drawChart() {

    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      ['미세먼지', pm10],
      ['탄소류와 검댕',      2.44],
      ['광물',  0.91],
      ['기타', 2.699]
    ]);
/*
    데이터 Setting
*/
var options = {
    title: "Density of Precious Metals, in g/cm^3",
    width: 600,
    height: 400,
    bar: {groupWidth: "95%"},
    legend: { position: "none" },
  };

    /*
        옵션 셋팅
    */

   var chart = new google.visualization.ColumnChart(document.getElementById("google_chart_box"));
   
/**
 * 차트 그리기
 */
    chart.draw(data, options);
   
  }