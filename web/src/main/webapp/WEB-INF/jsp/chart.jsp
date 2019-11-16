<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', 'X');
      data.addColumn('number', 'Sensor');



   data.addRows([
           [0, 0],   [1, 10],  [2, 23],  [3, 17],  [4, 18],  [5, 9],
           [6, 11],  [7, 27],  [8, 33],  [9, 40]
         ]);



      var options = {
        hAxis: {
          title: 'ID'
        },
        vAxis: {
          title: 'Speed'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
    </script>
  </head>
  <body>
  <!--Div that will hold the pie chart-->
      <div id="chart_div" style="width:400; height:600"></div>
    </body>
</html>