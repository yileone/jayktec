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

//String hostdb = "localhost:3306";  // MySQl host
String hostdb = "45.7.229.159:3306";
   String userdb = "mysql";  // MySQL username
   String passdb = "afrodita";  // MySQL password

   String namedb = "fateon";  // MySQL database name

    // Establish a connection to the database
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Connection con = DriverManager.getConnection("jdbc:mysql://" + hostdb + "/" + namedb , userdb , passdb);
         Gson gson = new Gson();
            
            // Form the SQL query that returns the top 10 most populous countries
           // String sqlQuery="SELECT * FROM fateon.fateon_registro where origen_id = '"+view.getValue("origen.oid")+"' GROUP BY registro_date_1";
            
            String sqlQuery = "SELECT * FROM fateon.fateon_registro where sensor_id= '"+view.getValue("sensor.oid")+"' and origen_id='"+view.getValue("origen.oid")+"' order by registro_date_1 asc limit 20";

            // Prepare the query statement    
            PreparedStatement pt=con.prepareStatement(sqlQuery);  
            // Prepare the query statement
            ResultSet rs=pt.executeQuery();
            
            // The 'chart' map object holds the chart attributes and data.
            Map<String, String> chart = new HashMap<String, String>();
            
            chart.put("caption", "Detalle por Dia Entrada Top 20");
            chart.put("paletteColors", "#0075c2");
            chart.put("bgColor", "#ffffff");
            chart.put("usePlotGradientColor", "0");
            chart.put("plotBorderAlpha", "10");
            chart.put("showXAxisLine", "1");
            chart.put("xAxisLineColor", "#999999");
            chart.put("showValues", "0");
            chart.put("divlineColor", "#999999");
            chart.put("divLineIsDashed", "1");
            chart.put("showAlternateHGridColor", "0");
            chart.put("showBorder", "0");
            chart.put("baseFont", "Helvetica Neue,Arial");
            chart.put("captionFontSize", "14");
            chart.put("drawCrossLine", "2");
    		chart.put("crossLineAlpha", "100");
    		chart.put("crossLineColor", "#cc3300");
    		chart.put("ajustDiv", "1");
    		//chart.put("yAxisMaxvalue", "10000000000");
    		chart.put("yAxisMinvalue", "10");
    		chart.put("numDivLines", "20");
    		//chart.put("numVDivLines", "200");
    		//chart.put("vDivLineColor", "#00ffaa");
    		//chart.put("VDivLineThickness", "10");//groso line vertical en px
    		chart.put("VDivLineAlpha", "50");//transparencia de la lineas verticales 0 trasparente 100 opaco
    		chart.put("showAlternateVGridColor", "1");
    		chart.put("alternateVGridColor", "#00ffaa");
    		//chart.put("alternateVGridAlpha", "50");
    		chart.put("drawAnchors", "1");
    		chart.put("crossLineColor", "#FAFAFA");
    		//chart.put("logoURL", "http://static.fusioncharts.com/sampledata/images/Logo-HM-72x72.png");
    		chart.put("logoScale", "110");
    		chart.put("logoPosition", "TR");
    		chart.put("logoAlpha", "40");
    		chart.put("exportenabled", "1");
    		chart.put("exportatclient", "1");
    		chart.put("exporthandler", "http://export.api3.fusioncharts.com");
    		chart.put("html5exporthandler", "http://export.api3.fusioncharts.com");
            // Push the data into the array using map object.
            ArrayList data = new ArrayList();
            
            /*
                `linkeddata` array: It contains data for individual linked 
                items. The links should be defined in the format 
                `newchart-dataformat-datasource`. 
            */
            ArrayList linkeddata = new ArrayList();
            while(rs.next()) {
                Map<String, String> lv = new HashMap<String, String>();
                lv.put("label", rs.getString("registro_date_1"));
                lv.put("value", rs.getString("registro_float_1"));
                lv.put("link", "newchart-json-" + rs.getString("registro_id"));
                data.add(lv);
      
                // Create the linkedDataObj for cities drilldown    
                Map<String, String> linkedDataObj = new HashMap<String, String>();
                // Inititate the linkedDataObj for cities drilldown
                linkedDataObj.put("id", rs.getString("registro_id"));
                
               // The 'linkedChartAttribute' map object holds the chart attributes .
                Map<String, String> linkedChartAttribute = new HashMap<String, String>();
                linkedChartAttribute.put("caption" , "Detalle Dia: " + rs.getString("registro_date_1") +"Top 25");
                linkedChartAttribute.put("paletteColors" , "#72D7B2");
                linkedChartAttribute.put("bgColor" , "#ffffff");
                linkedChartAttribute.put("borderAlpha", "20");
                linkedChartAttribute.put("canvasBorderAlpha", "0");
                linkedChartAttribute.put("usePlotGradientColor", "0");
                linkedChartAttribute.put("plotBorderAlpha", "10");
                linkedChartAttribute.put("showXAxisLine", "1");
                linkedChartAttribute.put("xAxisLineColor" , "#999999");
                linkedChartAttribute.put("showValues", "0");
                linkedChartAttribute.put("divlineColor" , "#999999");
                linkedChartAttribute.put("divLineIsDashed" , "1");
                linkedChartAttribute.put("showAlternateHGridColor" , "0");

                ArrayList linkedChartData = new ArrayList();
                
                //String sqlQueryDetail="SELECT registro_id, registro_time_1, registro_date_1, registro_float_1 from fateon.fateon_registro where origen_id ='"+view.getValue("origen.oid")+"' and registro_date_1 = ? ";
                String sqlQueryDetail="SELECT registro_id, registro_time_1, registro_date_1, registro_float_1 from fateon.fateon_registro where sensor_id= '"+view.getValue("sensor.oid")+"' and origen_id='"+view.getValue("origen.oid")+"' and registro_date_1 = ?  order by registro_date_1 asc limit 25";
                System.out.println(" JSP-->"+sqlQueryDetail);

                // Prepare the query statement.
                PreparedStatement ptDetail=con.prepareStatement(sqlQueryDetail);  
                ptDetail.setString(1, rs.getString("registro_date_1"));
                // Execute the query.
                ResultSet rsDetail=ptDetail.executeQuery();
                while(rsDetail.next()) {
                  Map<String, String> arrDara = new HashMap<String, String>();
                  arrDara.put("label", rsDetail.getString("registro_time_1"));
                  arrDara.put("value", rsDetail.getString("registro_float_1"));
                  linkedChartData.add(arrDara);
                } 
                
                //closing the connection.
                rsDetail.close();
            
            /*  create a 'linkedchart' map object to make a FC's 
                linkedchart structure.
            */    
                Map<String, String> linkedchart = new HashMap<String, String>();
            /*
                gson.toJson() the data to retrieve the string containing the
                JSON representation of the data in the array.
            */    
                linkedchart.put("chart", gson.toJson(linkedChartAttribute));
                linkedchart.put("data", gson.toJson(linkedChartData));
                
               
                linkedDataObj.put("linkedchart", gson.toJson(linkedchart));
                linkeddata.add(linkedDataObj);
            } //end of while loop
            
            //closing the connection.
            rs.close();
 
            
            
            /* Valores de referencia */
            
            
             /* Valores Flotante*/
            
         //sqlQuery = "SELECT (max(registro_float_1)*1.20) as lineatope FROM fateon.fateon_registro where origen_id ='"+view.getValue("origen.oid")+"'";
         sqlQuery ="SELECT (max(registro_float_1)*1.20) as lineatope FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id='"+view.getValue("origen.oid")+"' order by registro_date_1";
		 pt=con.prepareStatement(sqlQuery);    
		 rs=pt.executeQuery();
		 rs.next();
		 String valorFlotabte= rs.getString("lineatope");
		 rs.close();
		 
		 
		 
		 /* Valores Percentil */
		  
		 sqlQuery = "SELECT (count(1)*95)/100 as total FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"'";
		  
		 System.out.println(" JSP-->"+sqlQuery);
		 
		 pt=con.prepareStatement(sqlQuery);    
		 rs=pt.executeQuery();
		 rs.next();
		 int fila= rs.getInt("total");
		 rs.close();
		 
		 sqlQuery = "SELECT registro_float_1 as percentil FROM fateon.fateon_registro  where sensor_id='"+view.getValue("sensor.oid")+"' and origen_id= '"+view.getValue("origen.oid")+"' order by registro_float_1 asc limit "+fila+",1";
		  
		 System.out.println(" JSP-->"+sqlQuery);
		 
		 pt=con.prepareStatement(sqlQuery);    
		 rs=pt.executeQuery();
		 rs.next();
		 String percentil= rs.getString("percentil");
		 rs.close();
		
		 System.out.println("***************************************");
		 System.out.println("");
		 System.out.println(percentil);
		 System.out.println("");
		 System.out.println("***************************************");
		 
		 
            
            
            //create 'dataMap' map object to make a complete FC datasource.
            Map<String, String> dataMap = new LinkedHashMap<String, String>();  
        
            dataMap.put("chart", gson.toJson(chart));
            dataMap.put("data", gson.toJson(data));


    		Map<String, String> lineMap = new LinkedHashMap<String, String>();
    		ArrayList arrDataLine = new ArrayList();
    		ArrayList arrDataAllLine = new ArrayList();
    		Map<String, String> reg = new HashMap<String, String>();
    		reg.put("startvalue",valorFlotabte);
    		reg.put("displayvalue","TOPE CALCULADO: "+valorFlotabte);
    		reg.put("valueonright","1");
    		reg.put("color","#173B0B");
    		reg.put("origText","TOPE CALCULADO");
    		arrDataLine.add(0,reg);
    /*************/
    	Map<String, String> reg1 = new HashMap<String, String>();
    		reg1.put("startvalue",percentil);
    		reg1.put("displayvalue","PERCENTIL: "+percentil);
    		reg1.put("valueonright","1");
    		reg1.put("color","#FF3300");
    		reg1.put("origText","PERCENTIL");
    		arrDataLine.add(1,reg1);
    		lineMap.put("line", gson.toJson(arrDataLine));
    		arrDataAllLine.add(lineMap);
    		dataMap.put("trendlines", gson.toJson(arrDataAllLine));
    		
            dataMap.put("linkeddata", gson.toJson(linkeddata));
            
            

            FusionCharts columnChart= new FusionCharts(
                    "column2d",             //type of chart
                    "chart1",               //unique chart ID
                    "90%", "600", // chartWidth, chartHeight
                    "chart",                //div ID of the chart container
                    "json",                 //data format
                    gson.toJson(dataMap)    //data source
                );
           
            %>
            <%=columnChart.render()%>
 
	<div id="chart"></div>
	<input type="button" value="Actualizar Pagina" onclick="window.location='/Afrodita/m/VerOrigen'">
