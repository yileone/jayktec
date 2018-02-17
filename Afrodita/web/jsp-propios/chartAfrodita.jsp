<%@page import="org.openxava.view.View"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.google.gson.*"%>
<%@page import="fusioncharts.FusionCharts"%>
<%@page import="org.openxava.*"%>
<%@ include file="../xava/imports.jsp"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<%


String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
View view = (org.openxava.view.View) context.get(request,viewObject);
String hostdb = "localhost:3306";  // MySQl host
//String hostdb = "45.7.229.159:3306";
    String userdb = "mysql";  // MySQL username
	String passdb = "afrodita";  // MySQL password
	
	String namedb = "fateon";  // MySQL database name

	// Establish a connection to the database
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection con = DriverManager.getConnection("jdbc:mysql://" + hostdb + "/" + namedb, userdb, passdb);
		Gson gson = new Gson();
		Map<String, String> chartobjMap = new HashMap<String, String>();
		Map<String, String> dataMap = new LinkedHashMap<String, String>();
		Map<String, String> categoriesMap = new LinkedHashMap<String, String>();
		chartobjMap.put("caption", "HISTRICO DE ENTRADA Y SALIDA");
		chartobjMap.put("subCaption", "**************");
		chartobjMap.put("theme", "fint");
		chartobjMap.put("compactDataMode", "1");
		//chartobjMap.put("compactDataMode", "1");
		chartobjMap.put("dataSeparetor", "|");
		chartobjMap.put("showYAxisLine", "0");
		chartobjMap.put("pYAxisName", "Entrada");
		chartobjMap.put("sYAxisName", "Salida");
		//chartobjMap.put("pYAxisMaxValue", "1500");
		//chartobjMap.put("pYAxisMinValue", "900");
		//chartobjMap.put("sYAxisMaxValue", "1500");
		//chartobjMap.put("sYAxisMinValue", "900");
		chartobjMap.put("forceAxisLimits", "0");
		chartobjMap.put("sFormatNumberScale", "1");
		chartobjMap.put("numbersuffix", "BPS");
		chartobjMap.put("linethickness", "2");
		chartobjMap.put("drawCrossLine", "0");
		chartobjMap.put("crossLineAlpha", "100");
		chartobjMap.put("crossLineColor", "#FAFAFA");
		chartobjMap.put("ajustDiv", "1");
		//chartobjMap.put("yAxisMaxvalue", "10000000000");
		chartobjMap.put("yAxisMinvalue", "10");
		chartobjMap.put("numDivLines", "10");
		//chartobjMap.put("numVDivLines", "200");
		chartobjMap.put("vDivLineColor", "#FAFAFA");
		//chartobjMap.put("VDivLineThickness", "10");//groso line vertical en px
		chartobjMap.put("VDivLineAlpha", "50");//transparencia de la lineas verticales 0 trasparente 100 opaco
		chartobjMap.put("showAlternateVGridColor", "0");
		//chartobjMap.put("alternateVGridColor", "#FAFAFA");
		//chartobjMap.put("alternateVGridAlpha", "50");
		chartobjMap.put("drawAnchors", "1");
		//chartobjMap.put("crossLineColor", "#876EA1");
		//chartobjMap.put("logoURL", "http://static.fusioncharts.com/sampledata/images/Logo-HM-72x72.png");
		//chartobjMap.put("logoScale", "110");
		//chartobjMap.put("logoPosition", "TR");
		//chartobjMap.put("logoAlpha", "40");
		chartobjMap.put("exportenabled", "1");
		chartobjMap.put("exportatclient", "1");
		chartobjMap.put("exporthandler", "http://export.api3.fusioncharts.com");
		chartobjMap.put("html5exporthandler", "http://export.api3.fusioncharts.com");
		dataMap.put("chart", gson.toJson(chartobjMap));

		// Categoria
		//String sql = "SELECT registro_date_1 FROM fateon.fateon_registro where origen_id = '"+view.getValue("origen.oid")+"'  GROUP BY registro_date_1";
		String sql = "SELECT * FROM fateon.fateon_registro where sensor_id= '"+view.getValue("sensor.oid")+"' and origen_id='"+view.getValue("origen.oid")+"' order by registro_date_1";
		
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
		
		
		
        /* Valores Flotante*/
	       
    //sql = "SELECT (max(registro_float_1)*1.20) as lineatope FROM fateon.fateon_registro where origen_id ='"+view.getValue("origen.oid")+"'";;
	 
     sql = "SELECT (max(registro_float_1)*1.20) as lineatope FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id='"+view.getValue("origen.oid")+"' order by registro_date_1";
    pt=con.prepareStatement(sql);    
	 rs=pt.executeQuery();
	 rs.next();
	 String valorFlotabte= rs.getString("lineatope");
	 rs.close();
	 
	 
	  /* Valores Percentail */
	 //sql = "SELECT (count(1)*95)/100 as percentil FROM fateon.fateon_registro where origen_id ='"+view.getValue("origen.oid")+"'";
	 //sql = "SELECT (count(1)*95)/100 as percentil FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"' order by registro_date_1";
			  /* Valores Percentil */
		  
		 sql = "SELECT (count(1)*95)/100 as total FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"'";
		  
		 System.out.println(" JSP-->"+sql);
		 
		 pt=con.prepareStatement(sql);    
		 rs=pt.executeQuery();
		 rs.next();
		 int fila= rs.getInt("total");
		 rs.close();
	 
	 
	 
	 sql = "SELECT registro_float_1 as percentil FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"' order by registro_float_1 asc limit "+fila+",1";
	 pt=con.prepareStatement(sql);    
	 rs=pt.executeQuery();
	 rs.next();
	 String percentil= rs.getString("percentil");
	 rs.close();
	 
	 sql = "SELECT (count(1)*95)/100 as total FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"'";
	  
	 System.out.println(" JSP-->"+sql);
	 
	 pt=con.prepareStatement(sql);    
	 rs=pt.executeQuery();
	 rs.next();
	 fila= rs.getInt("total");
	 rs.close();
	 //int fila = Math.round((count(1)*95)/100);
	 sql = "SELECT registro_float_2 as percentil FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"' order by registro_float_1 asc limit "+fila+",1"; 
	 System.out.println(" JSP-->"+sql);
	  
	 pt=con.prepareStatement(sql);    
	 rs=pt.executeQuery();
	 rs.next();
	 String percentil2= rs.getString("percentil");
	 rs.close();
	
	 System.out.println("***************************************");
	 System.out.println("");
	 System.out.println(percentil2);
	 System.out.println("");
	 System.out.println("***************************************");
 
	 
	 
	 
	
		Map<String, String> serieMap = new LinkedHashMap<String, String>();
		Map<String, String> confSerieMap = new LinkedHashMap<String, String>();
		//sql = "SELECT registro_float_1,registro_float_2,registro_time_1 FROM fateon.fateon_registro where origen_id ='"+view.getValue("origen.oid")+"'";
		sql = "SELECT registro_float_1,registro_float_2,registro_time_1 FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id = '"+view.getValue("origen.oid")+"' order by registro_date_1";
		// Execute the query.
		pt = con.prepareStatement(sql);
		rs = pt.executeQuery();

		
		
		//Serie 1 Entrada
		// Push the data into the array using map object.
		ArrayList arrDataSet = new ArrayList();
		ArrayList arrDataSeries = new ArrayList();
		confSerieMap.put("seriesname", "ENTRADA");
		confSerieMap.put("anchorBgColor", "#876EA1");
		confSerieMap.put("drawAnchors", "0");

		while (rs.next()) {
			Map<String, String> vv = new HashMap<String, String>();
			vv.put("value", rs.getString("registro_float_1"));
			arrDataSet.add(vv);
		}

		confSerieMap.put("data", gson.toJson(arrDataSet));
		arrDataSeries.add(0, confSerieMap);

		// rs.close();
		//Serie 2 Salida
		rs.beforeFirst();
		Map<String, String> confSerieMap1 = new LinkedHashMap<String, String>();
		confSerieMap1.put("seriesname", "SALIDA");
		confSerieMap1.put("anchorBgColor", "#72D7B2");
		confSerieMap1.put("drawAnchors", "0");
		ArrayList arrDataSet1 = new ArrayList();
		while (rs.next()) {
			Map<String, String> vv1 = new HashMap<String, String>();
			vv1.put("value", rs.getString("registro_float_2"));
			arrDataSet1.add(vv1);
		}

		confSerieMap1.put("data", gson.toJson(arrDataSet1));
		arrDataSeries.add(1, confSerieMap1);
		
		
		//Serie 3 Valor Flotante
		rs.beforeFirst();
		Map<String, String> confSerieMap4 = new LinkedHashMap<String, String>();
		confSerieMap4.put("seriesname", "Valor Flotante");
		confSerieMap4.put("anchorBgColor", "#4B0082");
		confSerieMap4.put("drawAnchors", "1");
		ArrayList arrDataSet4 = new ArrayList();
		while (rs.next()) {
			Map<String, String> vv4 = new HashMap<String, String>();
			vv4.put("value",valorFlotabte);
			arrDataSet4.add(vv4);
		}

		confSerieMap4.put("data", gson.toJson(arrDataSet4));
		arrDataSeries.add(2, confSerieMap4);
		
		//Serie 4 Percentil
		rs.beforeFirst();
		Map<String, String> confSerieMap5 = new LinkedHashMap<String, String>();
		confSerieMap5.put("seriesname", "Percentil 95 Entrada");
		confSerieMap5.put("anchorBgColor", "#4B0082");
		confSerieMap5.put("drawAnchors", "2");
		ArrayList arrDataSet5 = new ArrayList();
		while (rs.next()) {
			Map<String, String> vv5 = new HashMap<String, String>();
			vv5.put("value",percentil);
			arrDataSet5.add(vv5);
		}

		confSerieMap5.put("data", gson.toJson(arrDataSet5));
		arrDataSeries.add(3, confSerieMap5);
		
		//Serie 5 Percentil
		rs.beforeFirst();
		Map<String, String> confSerieMap6 = new LinkedHashMap<String, String>();
		confSerieMap6.put("seriesname", "Percentil 95 Salida");
		confSerieMap6.put("anchorBgColor", "#642113");
		confSerieMap6.put("drawAnchors", "0");
		ArrayList arrDataSet6 = new ArrayList();
		while (rs.next()) {
			Map<String, String> vv6 = new HashMap<String, String>();
			vv6.put("value",percentil2);
			arrDataSet6.add(vv6);
		}

		confSerieMap6.put("data", gson.toJson(arrDataSet6));
		arrDataSeries.add(4, confSerieMap6);
		dataMap.put("dataset", gson.toJson(arrDataSeries));
		dataMap.put("dataset", gson.toJson(arrDataSeries));

		rs.close();

		FusionCharts mslineChat = new FusionCharts("zoomlinedy", // chartType
				"chart1", // chartId
				"90%", "600", // chartWidth, chartHeight
				"chart", // chartContainer
				"json", // dataFormat
				gson.toJson(dataMap) //dataSource
		);
	%>

	<%=mslineChat.render()%>
	<div id="chart"></div>
	<input type="button" value="Actualizar Pagina" onclick="window.location='/Afrodita/m/VerOrigen'">
