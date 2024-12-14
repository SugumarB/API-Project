package com.sampleAPI.test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FlightListSample {
public static void main(String[] args) throws IOException, ParseException {
	FileReader filereader = new FileReader("\\Users\\kanch\\eclipse-workspace\\APIProject\\src\\test\\resources\\FlightList.json");
	JSONParser jsonparser = new JSONParser();
	Object parse = jsonparser.parse(filereader);
	JSONObject jsonobject = (JSONObject)parse;
	Object page= jsonobject.get("page");
	System.out.println(page);
	Object per_page= jsonobject.get("per_page");
	System.out.println(per_page);
	Object total= jsonobject.get("total");
	System.out.println(total);
	Object total_pages= jsonobject.get("total_pages");
	System.out.println(total_pages);
	Object data= jsonobject.get("data");
	Object support= jsonobject.get("support");

	
	JSONArray array = (JSONArray)data;
	for (int i = 0; i < array.size(); i++) {
		Object object = array.get(i);
		
	JSONObject jsonobject2 = (JSONObject)object;
	Object id= jsonobject2.get("id");
	System.out.println(id);
	Object flightName= jsonobject2.get("flightName");
	System.out.println(flightName);
	Object Country= jsonobject2.get("Country");
	System.out.println(Country);
	Object Destinations= jsonobject2.get("Destinations");
	System.out.println(Destinations);
	Object URL= jsonobject2.get("URL");
	System.out.println(URL);
	
	JSONObject jsonobject3 = (JSONObject)support;
	Object url= jsonobject3.get("url");
	System.out.println(url);
	Object text= jsonobject3.get("text");
	System.out.println(text);
		
	}
	

}
	
}

