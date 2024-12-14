package com.sampleAPI.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPost {
	public static void main(String[] args) {
		RequestSpecification requestSpec;
		 requestSpec = RestAssured.given();
		 requestSpec.headers("content-Type","application/json");
		 requestSpec.body("{\r\n"
		 		+ "    \"flightName\": \"AirIndia\",\r\n"
		 		+ "    \"Country\": \"India\",\r\n"
		 		+ "    \"Destinations\": \"87\",\r\n"
		 		+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
		 		+ "}");
		 Response response = requestSpec.post("https://omrbranch.com/api/flights");
		 int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.asString();
		System.out.println(asString);
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

}
}
