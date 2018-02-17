<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fusioncharts.FusionCharts"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FusionCharts || www.fusioncharts.com</title>
        <script src="fusioncharts.js"></script>
        <script src="fusioncharts.charts.js"></script>
        <script src="fusioncharts.widgets.js"></script>
        <script src="fusioncharts.theme.fint.js"></script>
        <script src="data.json"></script>
    </head>
    <body>
         <div id="chart"></div>
         <%
             	
    	String eventfun= "{ setInterval(function() {  var num = parseInt(Math.random() * (25 - 1) + 1); FusionCharts(\"chart1\").feedData(\"&value=\" + num); }, 5000);}";
    	
    	HashMap<String, String> events=new HashMap<String, String>();
    	
    	
    	events.put("rendered",eventfun);
    	
             %>
        <%
        FusionCharts bulb= new FusionCharts(
            "bulb",// chartType
            "chart1",// chartId
            "550","350",// chartWidth, chartHeight
            "chart",// chartContainer
            "jsonurl",// dataFormat
            "data.json",
            events
         
            );
         //  System.out.println(columnChart.render());
            %>
            
            <%=bulb.render()%>
    </body>
</html>
