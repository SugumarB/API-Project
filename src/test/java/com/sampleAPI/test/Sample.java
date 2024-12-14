package com.sampleAPI.test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample {
public static void main(String[] args) throws IOException, ParseException {
	FileReader filereader = new FileReader("C:\\Users\\kanch\\eclipse-workspace\\APIProject\\src\\test\\resources\\sample.json");
	JSONParser jsonparser = new JSONParser();
	Object parse = jsonparser.parse(filereader);
	JSONObject jsonobject = (JSONObject)parse;
	Object data= jsonobject.get("data");
	Object support = jsonobject.get("support");
	
	JSONObject jsonobject2 = (JSONObject)data;
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
	Object Created_Date= jsonobject2.get("Created_Date");
	System.out.println(Created_Date);
	Object Updated_Date= jsonobject2.get("Updated_Date");
	System.out.println(Updated_Date);
	
	JSONObject jsonobject3 = (JSONObject)support;
	Object url= jsonobject3.get("url");
	System.out.println(url);
	Object text= jsonobject3.get("text");
	System.out.println(text);



}
}
