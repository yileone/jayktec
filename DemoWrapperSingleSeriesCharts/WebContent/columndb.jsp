<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>

<%

	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String password="";

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Charts with Data from a Database - fusioncharts.com</title>

        <script type="text/javascript" src="fusioncharts.js"></script>
    </head>
    <body>
         <div id="chart"></div>

        <%@page import="fusioncharts.FusionCharts" %>
      
        <%
         
            Gson gson = new Gson();
            
        Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,password);
		
		Statement st=con.createStatement();
		
		ResultSet r1=st.executeQuery("select * from singleseriestabl");
	    
		
		/*while (r1.next())
		{
			System.out.println(r1.getString(1));
			System.out.println(r1.getInt(2));
	    }*/
	
            
            // The 'chartobj' map object holds the chart attributes and data.
            Map<String, String> chartobj = new HashMap<String, String>();
            
            chartobj.put("caption", "Top 10 most populous countries");
            chartobj.put("paletteColors", "#0075c2");
            chartobj.put("bgColor", "#ffffff");
            chartobj.put("borderAlpha", "20");
            chartobj.put("canvasBorderAlpha", "0");
            chartobj.put("usePlotGradientColor", "0");
            chartobj.put("plotBorderAlpha", "10");
            chartobj.put("showXAxisLine", "1");
            chartobj.put("xAxisLineColor", "#999999");
            chartobj.put("showValues", "0");
            chartobj.put("divlineColor", "#999999");
            chartobj.put("divLineIsDashed", "1");
            chartobj.put("showAlternateHGridColor", "0");
 
            // Push the data into the array using map object.
            ArrayList arrData = new ArrayList();
            while(r1.next()) {
                Map<String, String> lv = new HashMap<String, String>();
                lv.put("label", r1.getString(1));
                lv.put("value", r1.getString(2));
                arrData.add(lv);             
            }
            System.out.println(arrData);
            
            //close the connection.
            r1.close();
 
            //create 'dataMap' map object to make a complete FC datasource.
             Map<String, String> dataMap = new LinkedHashMap<String, String>();  
        /*
            gson.toJson() the data to retrieve the string containing the
            JSON representation of the data in the array.
        */
             dataMap.put("chart", gson.toJson(chartobj));
             dataMap.put("data", gson.toJson(arrData));
             System.out.println(dataMap);
			//System.out.println(gson.toJson(arrData));
            FusionCharts columnChart= new FusionCharts(
            			"column2d",				//type of chart
                        "myChart",				//unique chart ID
                        "500","300",			//width and height of the chart
                        "chart",				//div ID of the chart container
                        "json",					//data format
                        gson.toJson(dataMap) 	//data source
                    );
           
            %>
            
<!--    Step 5: Render the chart    -->                
            <%=columnChart.render()%>
        
    </body>
</html>