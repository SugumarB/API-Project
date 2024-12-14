package com.sampleAPI.test;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification requestSpec;
	Response response;

	public void addHeader(String key, String Value) {
		requestSpec = RestAssured.given().header(key, Value);
	}
	public void addHeaders(Headers headers) {
		requestSpec = RestAssured.given().headers(headers);
	}
	public void addReqBody(String Payload) {
		requestSpec = requestSpec.body(Payload);
	}
	
	public void addReqBody(Object Payload) {
		requestSpec = requestSpec.body(Payload);
	}
	
	public void addBasicAuth(String userName, String password) {
		requestSpec.auth().preemptive().basic(userName, password);
	}

	public Response addReqType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = requestSpec.get(endPoint);
			break;
		case "POST":
			response = requestSpec.post(endPoint);
			break;
		case "PUT":
			response = requestSpec.put(endPoint);
			break;
		case "PATCH":
			response = requestSpec.patch(endPoint);
			break;
		case "DELETE":
			response = requestSpec.delete(endPoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String GetResBodyString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyPrettyString(Response response) {
		String string = response.asPrettyString();
		return string;
	}
	public void addMultipartFormatData(String key,File file) {
		requestSpec = requestSpec.multiPart(key,file);
	}
}
