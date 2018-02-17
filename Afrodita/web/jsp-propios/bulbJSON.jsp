<%@ include file="../xava/imports.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>
<%@page import="fusioncharts.FusionCharts" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <div id="chart"></div>
          
        <%
                  	Gson gson = new Gson();
                              
                              
                              
                             
                              Map<String, String> dataMap = new LinkedHashMap<String, String>();
                              Map<String, String> eventsMap = new LinkedHashMap<String, String>();
                              Map<String, String> colorMap = new LinkedHashMap<String, String>();
                              Map<String, String> chartobj = new HashMap<String, String>();
                              Map<String, String> funcionMap = new HashMap<String, String>();
                              ArrayList arrData = new ArrayList();
                              ArrayList arrValue = new ArrayList();
                              
                              chartobj.put("caption", "Indicador");
                              chartobj.put("upperlimit" , "0");
                              chartobj.put("lowerlimit" , "25");
                              chartobj.put("useColorNameAsValue" , "1");
                              chartobj.put("placeValuesInside" , "1");
                              chartobj.put("valueFontSize" , "20");
                              chartobj.put("plottooltext" , "<div id=\'valueDiv\'> $value apps running </div>");
                              chartobj.put("is3donHover" , "1");
                              chartobj.put("theme" , "fint");

                      		chartobj.put("sFormatNumberScale", "1");
                      		chartobj.put("linethickness", "2");
                      		chartobj.put("drawCrossLine", "2");
                      		chartobj.put("crossLineAlpha", "100");
                      		chartobj.put("crossLineColor", "#cc3300");
                      		chartobj.put("ajustDiv", "1");
                      		//chartobj.put("yAxisMaxvalue", "10000000000");
                      		chartobj.put("yAxisMinvalue", "10");
                      		chartobj.put("numDivLines", "200");
                      		chartobj.put("numVDivLines", "200");
                      		//chartobj.put("vDivLineColor", "#00ffaa");
                      		//chartobj.put("VDivLineThickness", "10");//groso line vertical en px
                      		chartobj.put("VDivLineAlpha", "50");//transparencia de la lineas verticales 0 trasparente 100 opaco
                      		chartobj.put("showAlternateVGridColor", "1");
                      		chartobj.put("alternateVGridColor", "#00ffaa");
                      		//chartobj.put("alternateVGridAlpha", "50");
                      		chartobj.put("drawAnchors", "1");
                      		chartobj.put("crossLineColor", "#876EA1");
                      		chartobj.put("logoURL", "http://static.fusioncharts.com/sampledata/images/Logo-HM-72x72.png");
                      		chartobj.put("logoScale", "110");
                      		chartobj.put("logoPosition", "TR");
                      		chartobj.put("logoAlpha", "40");
                      		chartobj.put("exportenabled", "1");
                      		chartobj.put("exportatclient", "1");
                      		chartobj.put("exporthandler", "http://export.api3.fusioncharts.com");
                      		chartobj.put("html5exporthandler", "http://export.api3.fusioncharts.com");
                              dataMap.put("chart", gson.toJson(chartobj));   
                              
                              
                   
                              Map<String, String> valueMap = new HashMap<String, String>();
                  	            valueMap.put("minValue", "0");
                  	            valueMap.put("maxValue", "5");
                  	            valueMap.put("label", "Bajo Carga");
                  	            valueMap.put("code", "#00ff00");
                              arrData.add(0,valueMap);
                              Map<String, String> valueMap1 = new HashMap<String, String>();
                              	valueMap1.put("minValue", "5");
                              	valueMap1.put("maxValue", "10");
                              	valueMap1.put("label", "Carga Moderada");
                              	valueMap1.put("code", "#00cccc");
                              arrData.add(1,valueMap1);
                              Map<String, String> valueMap2 = new HashMap<String, String>();
                              	valueMap2.put("minValue", "10");
                             	 	valueMap2.put("maxValue", "15");
                             		valueMap2.put("label", "Carga Continua");
                              	valueMap2.put("code", "#ff9900");
                              arrData.add(2,valueMap2);
                              Map<String, String> valueMap3 = new HashMap<String, String>();
                              	valueMap3.put("minValue", "15");
                              	valueMap3.put("maxValue", "20");
                              	valueMap3.put("label", "Extremadamente Cargado");
                              	valueMap.put("code", "#ff0000");
                              arrData.add(3,valueMap3);
                              colorMap.put("color", gson.toJson(arrData));
                              
                              dataMap.put("colorrange", gson.toJson(colorMap));   
                              
                                              
                             // funcionMap.put("rendered", "function(evtObj,argObj){ setInterval(function(){ FusionCharts(\"chart1\").feedData(\"&value=\"+(parseInt(Math.random() * (25-1)+1)));},10000);}");
                              
                               dataMap.put("MIvalue", "100");
                         
                               //eventsMap.put("events", gson.toJson(funcionMap));
                               
                               
    	String eventfun= "{ setInterval(function() {  var num = parseInt(Math.random() * (25 - 1) + 1); FusionCharts(\"chart1\").feedData(\"&value=\" + num); }, 5000);}";
    	
    	HashMap<String, String> events=new HashMap<String, String>();
    	
    	
    	events.put("rendered",eventfun);
                                               
                  	FusionCharts columnChart = new FusionCharts("bulb", // chartType
                  			"chart1", // chartId
                  			"300", "400", // chartWidth, chartHeight
                  			"chart", // chartContainer
                  			"jsonurl", // dataFormat
                  			//"http://localhost:8080/Afrodita/xava/editors/js/data.json", //datasource
                  			"http://45.7.229.159:8080/Afrodita/xava/editors/js/data.json", //datasource
                  			events//dataevents
                  			/*		"jsonurl", // dataFormat
                  			"http://localhost:8080/Afrodita/xava/editors/js/data.json", //datasource*/
                  	);
                  %>
<!--    Step 5: Render the chart    -->                
            <%=columnChart.render()%>
     <xava:action action="accionescancelar.cancel1" argv=""/></td>
    </body>
</html>
