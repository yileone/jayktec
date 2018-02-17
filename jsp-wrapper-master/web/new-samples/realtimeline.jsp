
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
            
            ArrayList arrDataCategories = new ArrayList();
            ArrayList arrData = new ArrayList();
            ArrayList arrValue = new ArrayList();
            ArrayList arrDataSet = new ArrayList();
            ArrayList arrDataSeries= new ArrayList();
            chartobj.put("caption", "Indicador EJE XY");
            chartobj.put("subCaption" , "******************");
            chartobj.put("xAxisName" , "Time");
            chartobj.put("yAxisName" , "VERRRR");
            chartobj.put("numberPrefix" , " MPS");
            chartobj.put("refreshinterval" , "5");
            chartobj.put("yaxisminvalue" , "35");
            chartobj.put("yaxismaxvalue" , "36");
            chartobj.put("numdisplaysets" , "10");
            chartobj.put("labeldisplay" , "10");
            chartobj.put("showValues" , "rotate");
            chartobj.put("showRealTimeValue" , "0");
            chartobj.put("theme" , "fint");
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
			confSerieMap.put("data", gson.toJson(arrDataSet));
			arrDataSeries.add(0, confSerieMap);
			dataMap.put("dataset", gson.toJson(arrDataSeries));
	        String funcions ="function (e) { ";
	        funcions +="function addLeadingZero(num){ ";
	        funcions +="return (num <= 9)? (\"0\"+num) : num; "; 
	        funcions +="} "; 
	        funcions +="function updateData() { "; 
	        funcions +="var chartRef = FusionCharts(\"chart1\"), "; 
	        funcions +="currDate = new Date(), "; 
	        funcions +="label = addLeadingZero(currDate.getHours()) + \":\" +"; 
	        funcions +="addLeadingZero(currDate.getMinutes()) + \":\" + "; 
	        funcions +="addLeadingZero(currDate.getSeconds()), "; 
	        funcions +="randomValue = Math.floor(Math.random() "; 
	        funcions +="* 50) / 100 + 35.25,"; 
	        funcions +=" strData = \"&label=\" + label  "; 
	        funcions +="+ \"&value=\" "; 
	        funcions +=" + randomValue;"; 
	        funcions +="chartRef.feedData(strData);"; 
	        funcions +=" }"; 
	        funcions +="var myVar = setInterval(function () { "; 
	        funcions +=" updateData();"; 
	        funcions +="}, 5000);";
	        funcions +=" }";
       
	        
	        funcionMap.put("initialized", funcions);
             eventsMap.put("events", gson.toJson(funcionMap));

                             
                             
                             FusionCharts realtimeline= new FusionCharts(
                                     "realtimeline",// chartType
                                                 "chart1",// chartId
                                                 "500","300",// chartWidth, chartHeight
                                                 "chart",// chartContainer
                                                 "json",// dataFormat
                                                 gson.toJson(dataMap),//datasource
                                                 gson.toJson(funcionMap)//dataevents
                                             );
           
            %>
            
<!--    Step 5: Render the chart    -->                
            <%=realtimeline.render()%>
        
    </body>
</html>
