
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>
<%@page import="fusioncharts.FusionCharts" %>


<%
 String hostdb = "localhost:3300";  // MySQl host
 String userdb = "root";  // MySQL username
 String passdb = "123456";  // MySQL password
 String namedb = "fateon";  // MySQL database name

    // Establish a connection to the database
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Connection con = DriverManager.getConnection("jdbc:mysql://" + hostdb + "/" + namedb , userdb , passdb);
   
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indicador</title>
       <script src="../scripts/fusioncharts.js"></script>
       <script src="../scripts/fusioncharts.widgets.js"></script>
       <script src="../scripts/themes/fusioncharts.theme.fint.js"></script>
       <script src="../scripts/themes/fusioncharts.theme.carbon.js"></script>
       <script src="../scripts/themes/fusioncharts.theme.ocean.js"></script>
       <script src="../scripts/themes/fusioncharts.theme.zune.js"></script>
        <script type="text/javascript">
			FusionCharts['debugger'].outputTo(function (message) {
    			console.log(message);
				});
			FusionCharts['debugger'].enable(true);
		</script>
    </head>
    <body>
         <div id="chart"></div>
          
        <%
    
         Gson gson = new Gson();
            
            
            // Form the SQL query that returns the top 10 most populous countries
            String sql="SELECT * FROM fateon.fateon_registro1 group by registro_date_1 DESC LIMIT 10";

            // Execute the query.
            PreparedStatement pt=con.prepareStatement(sql);    
            ResultSet rs=pt.executeQuery();
            
           
            Map<String, String> dataMap = new LinkedHashMap<String, String>();
            Map<String, String> chartobj = new HashMap<String, String>();
            Map<String, String> categoriesMap = new LinkedHashMap<String, String>();
            Map<String, String> eventsMap = new LinkedHashMap<String, String>();
            Map<String, String> funcionMap = new HashMap<String, String>();

            
            chartobj.put("caption","Stock Price Monitor");
            chartobj.put("subCaption","Harry's Supermart");
            chartobj.put("captionFontSize","14");
            chartobj.put("subcaptionFontSize","14");
            chartobj.put("baseFontColor" ,"#333333");
            chartobj.put("baseFont" ,"Helvetica Neue,Arial");                        
            chartobj.put("subcaptionFontBold","0");
            chartobj.put("paletteColors" ,"#0075c2,#1aaf5d,#f2c500");
            chartobj.put("bgColor" ,"#ffffff");
            chartobj.put("canvasBgColor" ,"#ffffff");
            chartobj.put("showBorder" ,"0");
            chartobj.put("showShadow" ,"0");
            chartobj.put("showCanvasBorder","0");
            chartobj.put("showRealTimeValue","0");
            chartobj.put("legendBorderAlpha","0");
            chartobj.put("legendShadow","0");
            chartobj.put("numberprefix","$");
            chartobj.put("setadaptiveymin","1");
            chartobj.put("setadaptivesymin","1");
            chartobj.put("xaxisname","Time");
            chartobj.put("labeldisplay","Rotate");
            chartobj.put("slantlabels","1");
            chartobj.put("pyaxisminvalue","35");
            chartobj.put("pyaxismaxvalue","36");
            chartobj.put("syaxisminvalue","10000");
            chartobj.put("syaxismaxvalue","12000");
            chartobj.put("divlineAlpha" ,"100");
            chartobj.put("divlineColor" ,"#999999");
            chartobj.put("showAlternateHGridColor" ,"0");
            chartobj.put("divlineThickness" ,"1");
            chartobj.put("divLineIsDashed" ,"1");
            chartobj.put("divLineDashLen" ,"1");
            chartobj.put("divLineGapLen" ,"1");	
            dataMap.put("chart", gson.toJson(chartobj));   
            
         // Categoria
    		Map<String, String> lv = new HashMap<String, String>();
			lv.put("label", "Day Start");
			arrData.add(lv);
			categoriesMap.put("category", gson.toJson(arrData));
			arrDataCategories.add(categoriesMap);
			dataMap.put("categories", gson.toJson(arrDataCategories));
			
			

			//Serie 1


			Map<String, String> serieMap = new LinkedHashMap<String, String>();
			Map<String, String> confSerieMap = new LinkedHashMap<String, String>();
			Map<String, String> vv = new HashMap<String, String>();
			vv.put("value","35.27");
			arrDataSet.add(vv);
			confSerieMap.put("seriesname", "HRYS Price");
			confSerieMap.put("showvalues", "0");
			confSerieMap.put("data", gson.toJson(arrDataSet));
			arrDataSeries.add(0, confSerieMap);
			
			
			//Serie 2
			
			Map<String, String> serieMap1 = new LinkedHashMap<String, String>();
			Map<String, String> confSerieMap1 = new LinkedHashMap<String, String>();
			Map<String, String> vv1 = new HashMap<String, String>();
			vv.put("value","35.27");
			arrDataSet1.add(vv);
			confSerieMap1.put("seriesname", "HRYS Price");
			confSerieMap1.put("showvalues", "0");
			confSerieMap1.put("data", gson.toJson(arrDataSet));
			arrDataSeries.add(1, confSerieMap);
			
			dataMap.put("dataset", gson.toJson(arrDataSeries));
			
			
			
			/// Lines
			Map<String, String> lineMap = new LinkedHashMap<String, String>();
			Map<String, String> confLineMap = new LinkedHashMap<String, String>();
			ArrayList arrDataLine = new ArrayList();
			ArrayList arrDataAllLine = new ArrayList();
			Map<String, String> reg = new HashMap<String, String>();
			reg.put("parentyaxis","P");
			reg.put("startvalue","35.1");
			reg.put("displayvalue","Open");
			reg.put("thickness","1");
			reg.put("color","#0075c2");
			reg.put("dashed","1");

			arrDataLine.add(0,reg);
			
			
			
			Map<String, String> lineMap1 = new LinkedHashMap<String, String>();
			Map<String, String> confLineMap1 = new LinkedHashMap<String, String>();
			ArrayList arrDataLine1 = new ArrayList();
			Map<String, String> reg1 = new HashMap<String, String>();
			reg1.put("parentyaxis","S");
			reg1.put("startvalue","10962.87");
			reg1.put("displayvalue","Open");
			reg1.put("thickness","1");
			reg1.put("color","#1aaf5d");
			reg1.put("dashed","1");

			arrDataLine.add(1,reg1);
			lineMap.put("line", gson.toJson(arrDataLine));
			arrDataAllLine.add(lineMap);
			dataMap.put("trendlines", gson.toJson(arrDataAllLine));
			
			
			
			
			
	        String funcions ="function (e) { ";
	        funcions +="function formatTime(num){";
	        funcions +="return (num <= 9)? (\"0\"+num) : num;"; 
	        funcions +="} "; 
	        funcions +="function updateData() { "; 
	        funcions +="var chartRef = FusionCharts(\"chart1\"), "; 
	        funcions +="currDate = new Date(), "; 
	        funcions +="label = formatTime(currDate.getHours()) + \":\" + formatTime(currDate.getMinutes()) + \":\" + formatTime(currDate.getSeconds()),"; 
	        funcions +="hrys = Math.floor(Math.random()  "; 
	        funcions +="* 50) / 100 + 35.25,"; 
	        funcions +="nyse = Math.floor(Math.random() "; 
	        funcions +=" * 9000)/100 + 10962.87,"; 
	        funcions +="strData = \"&label=\" + label + \"&value=\" + hrys + \"|\" + nyse;"; 
	        funcions +="chartRef.feedData(strData);"; 
	        funcions +="console.log(nyse);"; 
	        funcions +="}"; 
	        funcions +="var myVar = setInterval(function () {"; 
	        funcions +="updateData(); "; 
	        funcions +="}, 5000);"; 
	        funcions +=" }";
       
	        
	        funcionMap.put("initialized", funcions);
             eventsMap.put("events", gson.toJson(funcionMap));

                             
                             
                             FusionCharts realtimelinedy= new FusionCharts(
                                     "realtimelinedy",// chartType
                                                 "chart1",// chartId
                                                 "500","300",// chartWidth, chartHeight
                                                 "chart",// chartContainer
                                                 "json",// dataFormat
                                                 gson.toJson(dataMap),//datasource
                                                 gson.toJson(funcionMap)//dataevents
                                             );
           
            %>
            
<!--    Step 5: Render the chart    -->                
            <%=realtimelinedy.render()%>
        
    </body>
</html>
