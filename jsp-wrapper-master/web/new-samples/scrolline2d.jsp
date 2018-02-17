<%-- 
    Document   : basic-example
    Author     : suvradip saha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.google.gson.*"%>
<%@page import="fusioncharts.FusionCharts"%>
<%
	/* 
	    The following 4 code lines contain the database connection information.
	    Alternatively, you can move these code lines to a separate file and
	    include the file here. You can also modify this code based on your 
	    database connection. 
	 */

	String hostdb = "localhost:3300"; // MySQl host
	String userdb = "root"; // MySQL username
	String passdb = "123456"; // MySQL password
	String namedb = "fateon"; // MySQL database name

	// Establish a connection to the database
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection con = DriverManager.getConnection("jdbc:mysql://" + hostdb + "/" + namedb, userdb, passdb);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actual</title>
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
		Map<String, String> chartobjMap = new HashMap<String, String>();
		Map<String, String> dataMap = new LinkedHashMap<String, String>();
		Map<String, String> categoriesMap = new LinkedHashMap<String, String>();
		chartobjMap.put("caption", "HISTRICO DE ENTRADA");
		chartobjMap.put("subCaption", "**************");
		chartobjMap.put("labelDisplay", "ROTATE");
		chartobjMap.put("slantLabels", "1");
		chartobjMap.put("showValues", "0");
		chartobjMap.put("flatScrollBars", "0");
		chartobjMap.put("scrollColor", "#f2e6d9");
		chartobjMap.put("scrollheight", "10");
		chartobjMap.put("numVisiblePlot", "10");
		chartobjMap.put("anchorBgColor", "#876EA1");
		chartobjMap.put("theme", "fint");
		dataMap.put("chart", gson.toJson(chartobjMap));

		// Categoria
		String sql = "SELECT registro_date_1 FROM fateon.fateon_registro1 GROUP BY registro_date_1";
		// Execute the query.
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();

		// Push the data into the array using map object.
		ArrayList arrData = new ArrayList();
		ArrayList arrDataCategories = new ArrayList();
		while (rs.next()) {
			Map<String, String> lv = new HashMap<String, String>();
			lv.put("label", rs.getString("registro_date_1"));
			arrData.add(lv);
		}
		rs.close();
		categoriesMap.put("category", gson.toJson(arrData));
		arrDataCategories.add(categoriesMap);
		dataMap.put("categories", gson.toJson(arrDataCategories));

		//Serie 1
		Map<String, String> serieMap = new LinkedHashMap<String, String>();
		Map<String, String> confSerieMap = new LinkedHashMap<String, String>();
		sql = "SELECT registro_float_1,registro_float_2,registro_time_1 FROM fateon.fateon_registro1 group by registro_date_1";
		// Execute the query.
		pt = con.prepareStatement(sql);
		rs = pt.executeQuery();

		// Push the data into the array using map object.
		ArrayList arrDataSet = new ArrayList();
		ArrayList arrDataSeries = new ArrayList();
		confSerieMap.put("seriesname", "ENTRADA");
		confSerieMap.put("anchorBgColor", "#876EA1");

		while (rs.next()) {
			Map<String, Float> vv = new HashMap<String, Float>();
			vv.put("value", rs.getFloat("registro_float_1"));
			arrDataSet.add(vv);
		}

		confSerieMap.put("data", gson.toJson(arrDataSet));
		arrDataSeries.add(0, confSerieMap);

		// rs.close();
		//Serie 2
		rs.beforeFirst();
		Map<String, String> confSerieMap1 = new LinkedHashMap<String, String>();
		confSerieMap1.put("seriesname", "SALIDA");
		confSerieMap1.put("anchorBgColor", "#72D7B2");
		ArrayList arrDataSet1 = new ArrayList();
		while (rs.next()) {
			Map<String, Float> vv1 = new HashMap<String, Float>();
			vv1.put("value", rs.getFloat("registro_float_2"));
			arrDataSet1.add(vv1);
		}

		confSerieMap1.put("data", gson.toJson(arrDataSet1));
		arrDataSeries.add(1, confSerieMap1);

		//Serie 3
		/* pt=con.prepareStatement(sql);    
		 rs=pt.executeQuery();
		 Map<String, String> confSerieMap2 = new LinkedHashMap<String, String>();
		 confSerieMap2.put("seriesname","Serie3");
		 confSerieMap2.put("anchorBgColor","#E5B556");
		 ArrayList arrDataSet2 = new ArrayList();
		 while(rs.next()){
		 	Map<String, String> vv2 = new HashMap<String, String>();
		vv2.put("value", rs.getString("registro_time_1"));
		arrDataSet2.add(vv2);             
		 }         
		 confSerieMap2.put("data",gson.toJson(arrDataSet2));
		 arrDataSeries.add(2,confSerieMap2);*/
		rs.close();

		dataMap.put("dataset", gson.toJson(arrDataSeries));

		FusionCharts mslineChat = new FusionCharts("scrollline2d", // chartType
				"chart1", // chartId
				"80%", "600", // chartWidth, chartHeight
				"chart", // chartContainer
				"json", // dataFormat
				gson.toJson(dataMap) //dataSource
		);
	%>

	<!--    Step 5: Render the chart    -->
	<%=mslineChat.render()%>

</body>
</html>
