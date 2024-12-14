package com.sampleAPI.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGet {
public static void main(String[] args) {
	RequestSpecification requestSpec;
	 requestSpec = RestAssured.given();
	 requestSpec.headers("content.Type","application/json");
	 Response response = requestSpec.get("https://omrbranch.com/api/flights?page=1");
	 int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	String asString = response.asString();
	System.out.println(asString);
	String asPrettyString = response.asPrettyString();
	System.out.println(asPrettyString);
}
}
