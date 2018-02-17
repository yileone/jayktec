<%-- 
    Document   : index
    Author     : FusionChart
        
    ------------------
    | IMPORTANT NOTE |
    ------------------

    'exportenabled' - To enable server-side exporting, 
         the chart level attribute exportEnabled is set to 1.

    'exporthandler' - Set to the absolute path of 
         the export handler, for example:
         http://www.example.com/<project-name>/FCExporter.

     Note - This project-name may be not required.

     Troubleshoots - While exporting using exporthandler, 
        if you get an error like "HTTP Status 404", 
        make sure that you are providing the correct URL to export. 
        For more details click here [http://www.fusioncharts.com/dev/exporting-charts/exporting-charts-as-image-and-pdf.html]
     


    *** please include the jar files(from `required-jar-files`) 
    in project in case of error occured. ***

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>My first chart using FusionCharts Suite XT</title>
<script src="fusioncharts.js"></script>
<script src="fusioncharts.theme.fint.js"></script>
<script type="text/javascript">
  FusionCharts.ready(function(){
    var fusioncharts = new FusionCharts({
    type: 'column2d',
    renderAt: 'chart-container',
    width: '500',
    height: '300',
    dataFormat: 'json',
    dataSource: {
        "chart": {
            "caption": "Monthly revenue for last year",
            "subCaption": "Harry's SuperMart",
            "xAxisName": "Month",
            "yAxisName": "Revenues (In USD)",
            "numberPrefix": "$",
            "theme": "fint",
            "exportenabled": "1",
            "exporthandler": "http://localhost:8080/fc-java-exporter-example/FCExporter"
        },

        "data": [{
            "label": "Jan",
            "value": "420000"
        }, {
            "label": "Feb",
            "value": "810000"
        }, {
            "label": "Mar",
            "value": "720000"
        }, {
            "label": "Apr",
            "value": "550000"
        }, {
            "label": "May",
            "value": "910000"
        }, {
            "label": "Jun",
            "value": "510000"
        }, {
            "label": "Jul",
            "value": "680000"
        }, {
            "label": "Aug",
            "value": "620000"
        }, {
            "label": "Sep",
            "value": "610000"
        }, {
            "label": "Oct",
            "value": "490000"
        }, {
            "label": "Nov",
            "value": "900000"
        }, {
            "label": "Dec",
            "value": "730000"
        }]
    }
}
);
    fusioncharts.render();
});
</script>
</head>
<body>
  <div id="chart-container">FusionCharts XT will load here!</div>
</body>
</html>