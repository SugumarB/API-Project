package com.JSON.ReadValues;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightReadValue {
public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	File file = new File("C:\\Users\\kanch\\eclipse-workspace\\APIProject\\src\\test\\resources\\FlightList.json");
	ObjectMapper mapper = new ObjectMapper();
	FlightDetails flightDetails= mapper.readValue(file, FlightDetails.class);
	int page = flightDetails.getPage();
	System.out.println(page);
	int per_page = flightDetails.getPer_page();
	System.out.println(per_page);
	int total = flightDetails.getTotal();
	System.out.println(total);
	int total_pages = flightDetails.getTotal_pages();
	System.out.println(total_pages);
	ArrayList<Data> data = flightDetails.getData();
	for (Data D : data) {
		System.out.println(D.getId());
		System.out.println(D.getFlightName());
		System.out.println(D.getCountry());
		System.out.println(D.getDestinations());
		System.out.println(D.getURL());
	}
	Support support = flightDetails.getSupport();
	String text = support.getText();
	System.out.println(text);
	String url = support.getUrl();
	System.out.println(url);
}
}
