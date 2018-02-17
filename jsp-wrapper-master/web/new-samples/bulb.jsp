
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
            
                            
            funcionMap.put("rendered", "function(evtObj,argObj){ setInterval(function(){ FusionCharts(\"chart1\").feedData(\"&value=\"+(parseInt(Math.random() * (25-1)+1)));},10000);}");
            
             dataMap.put("MIvalue", "5");
       
             eventsMap.put("events", gson.toJson(funcionMap));

                             
                             FusionCharts columnChart= new FusionCharts(
                                     "bulb",// chartType
                                                 "chart1",// chartId
                                                 "300","300",// chartWidth, chartHeight
                                                 "chart",// chartContainer
                                                 "json",// dataFormat
                                                 gson.toJson(dataMap),//datasource
                                                 gson.toJson(funcionMap)//dataevents
                                             );
           
            %>
            
<!--    Step 5: Render the chart    -->                
            <%=columnChart.render()%>
        
    </body>
</html>
