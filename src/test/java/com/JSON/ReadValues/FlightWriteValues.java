package com.JSON.ReadValues;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightWriteValues {
public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	File file = new File("C:\\Users\\kanch\\eclipse-workspace\\APIProject\\src\\test\\resources\\writtenfile.json");
	ObjectMapper objectmapper = new ObjectMapper();
	ArrayList<Data>arraylist = new ArrayList<>();
	Data D = new Data(3,"AirIndia","India","28","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	Data D1 = new Data(33,"AirIndia","India","28","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	Data D2 = new Data(36,"Srilankan AriLines","SriLanka","20","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	Data D3 = new Data(42,"AirIndia.Raj","India","56","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	Data D4 = new Data(49,"AirIndia","India","88","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	Data D5 = new Data(59,"AirIndia","India","87","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	
	arraylist.add(D);
	arraylist.add(D1);
	arraylist.add(D2);
	arraylist.add(D3);
	arraylist.add(D4);
	arraylist.add(D5);
	Support s = new Support("https:\\/\\/www.omrbranch.com","For Joining Automation Course, Please Contact-Velmurugan 9944152058");
	FlightDetails page = new FlightDetails(1,6, 7544, 1258, arraylist, s);
			
	
	objectmapper.writeValue(file, page);
	
}
}
