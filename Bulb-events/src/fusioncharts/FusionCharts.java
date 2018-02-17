
package fusioncharts;

import java.util.*;
/**
 *
 * @author FusionCharts
 */
public class FusionCharts {

    private String constructorTemplate = "<script type=\"text/javascript\">FusionCharts.ready(function () {new FusionCharts(__constructorOptions__);});</script>";
    private String renderTemplate = "<script type=\"text/javascript\">FusionCharts.ready(function () {                FusionCharts(\"__chartId__\").render();});</script>";
    private String[] chartOptions = new String[10];
    private int eventPresent = 0;
    private String chartDataSource = "";
    private String eventString=new String();
    
    public FusionCharts(String type, String id, String width, String height, String renderAt, String dataFormat, String dataSource) {
        this.chartOptions[0] = id;
        this.chartOptions[1] = width;
        this.chartOptions[2] = height;
        this.chartOptions[3] = renderAt;
        this.chartOptions[4] = type;
        this.chartOptions[5] = dataFormat;
        if(this.chartOptions[5].contains("url")) {
            this.chartOptions[6] = "\""+dataSource+"\"";
        } else {
            this.chartOptions[6] = "__dataSource__";
            this.chartDataSource = this.addSlashes(dataSource.replaceAll("\n", ""));
        }
    }
    
    //Overloaded wrapper constructor supporting Multiple Events.
    //Event name(s) and Event function(s) must be provided to the wrapper constructor in the form of a HashMap object.
    //The HashMap object must have the eventname-eventfunction mapped as key-value pair.
    public FusionCharts(String type, String id, String width, String height, String renderAt, String dataFormat, String dataSource, HashMap<String, String> events) {
        this.chartOptions[0] = id;
        this.chartOptions[1] = width;
        this.chartOptions[2] = height;
        this.chartOptions[3] = renderAt;
        this.chartOptions[4] = type;
        this.chartOptions[5] = dataFormat;
        if(this.chartOptions[5].contains("url")) {
            this.chartOptions[6] = "\""+dataSource+"\"";
        } else {
            this.chartOptions[6] = "__dataSource__";
            this.chartDataSource = this.addSlashes(dataSource.replaceAll("\n", ""));
        }
        
        //Iterating the keys(Event names) from the HashMap object parameter.
        //Eliminate event names that does not have its corresponding event function mapped in the HashMap object.
        //Adds the "event" code in supported format(JSON) to the eventString variable.
        //This eventString variable is added in the jsonEncode() method.
        for(String key: events.keySet()){
        	if(events.get(key) != "")
        	{
        		eventPresent = 1;
        		eventString += "\""+key+"\":function(eventObj,dataObj)"+events.get(key)+",";
        		System.out.println(events.get(key));
        	}
        }
        
        //The eventString variable is updated with the supported JSON format or with null string,
        //If the presence of valid event is detected or not detected respectively.
        if(eventPresent ==0)
        	eventString = "";
        else
        	eventString = ",events:{" + eventString + "}";
        
        //System.out.println("Final string : " + eventString);
        
    }
    private String addSlashes(String str) {
        str = str.replaceAll("\\\\", "\\\\\\\\");
        str = str.replaceAll("\\n", "\\\\n");
        str = str.replaceAll("\\r", "\\\\r");
        str = str.replaceAll("\\00", "\\\\0");
        str = str.replaceAll("u003d", "=");
        str = str.replaceAll("'", "\\\\'");
        str = str.replaceAll("\\\\", "");
        str = str.replaceAll("\"\\{", "{");
        str = str.replaceAll("\"\\[", "[");
        str = str.replaceAll("\\}\\]\"", "}]");
        str = str.replaceAll("\"\\}\"", "\"}");
        str = str.replaceAll("\\}\"\\}", "}}");
        return str;
    }
    private String jsonEncode(String[] data){
        
    	String json=new String();
    	json = "{type: \""+this.chartOptions[4]+"\",renderAt: \""+this.chartOptions[3]+"\",width: \""+this.chartOptions[1]+"\",height: \""+this.chartOptions[2]+"\",dataFormat: \""+this.chartOptions[5]+"\",id: \""+this.chartOptions[0]+"\",dataSource: "+this.chartOptions[6]+eventString+"}";
    	
        return json;
    }
    public String render() {
        String outputHTML;
        if(this.chartOptions[5].contains("url")) {
            outputHTML = this.constructorTemplate.replace("__constructorOptions__", this.jsonEncode(this.chartOptions))+this.renderTemplate.replace("__chartId__", this.chartOptions[0]);
        } else {
            if("json".equals(this.chartOptions[5])) {
                outputHTML = this.constructorTemplate.replace("__constructorOptions__", this.jsonEncode(this.chartOptions).replace("__dataSource__",this.chartDataSource))+this.renderTemplate.replace("__chartId__", this.chartOptions[0]);
            } else {
                outputHTML = this.constructorTemplate.replace("__constructorOptions__", this.jsonEncode(this.chartOptions).replace("__dataSource__","\'"+this.chartDataSource+"\'"))+this.renderTemplate.replace("__chartId__", this.chartOptions[0]);
            }
        }
        return outputHTML;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
    	
    	String eventfun1= "{console.log(\"Hello1\");"
        		         + "console.log(eventObj);}";
    	
    	String eventfun2= "{console.log(\"Hello2\");"
        		+ "console.log(eventObj);}";
    	
    	HashMap<String, String> events=new HashMap<String, String>();
    	
    	String e="";
    	events.put("dataPlotClick", eventfun1);
    	events.put("dataLabelClick", e);
    	events.put("dataPlotRollOver", eventfun2);
        
        FusionCharts obj= new FusionCharts("column2d","c1", "400","500","here","xml","chartattributes", events);
        System.out.println(obj.render());
    }
    
}
