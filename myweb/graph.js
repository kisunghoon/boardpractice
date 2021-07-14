google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
/*
    구글 차트 버전을 최신으로 불러와준다.
    구글 차트를 로드한다
*/
function drawChart() {

    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      ['황산염,질산염등', 8.47],
      ['탄소류와 검댕',      2.44],
      ['광물',  0.91],
      ['기타', 2.699]
    ]);


    var data2 = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['제조업 연소', 7.4],
    ['생산공정',      0.9],
    ['도로이동오염원',  1.95],
    ['비도로이동오염원', 2.02],
    ['에너지산업연소', 0.789]
  ]);

  var data3 = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['자동차 연소', 3.05],
    ['산업 비산업',2.89],
    ['건설기계',  1.79],
    ['비산먼지', 1.769],
    ['생물성연소', 0.789]
  ]);
/*
    데이터 Setting
*/
    var options = {
      title: '미세먼지 성분 구성',
      pieHole: 0.4
    };

    var options2 = {
        title: '미세먼지 배출량',
        pieHole: 0.4
      };

      var options3 = {
        title: '초미세먼지 배출원별 주요 저감 ',
        pieHole: 0.4
      };
    /*
        옵션 셋팅
    */

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    var chart1 = new google.visualization.PieChart(document.getElementById('piechart1'));
    var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
/**
 * 차트 그리기
 */
    chart.draw(data, options);
    chart1.draw(data2, options2);
    chart2.draw(data3, options3);
  }