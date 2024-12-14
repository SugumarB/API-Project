package com.sampleAPI.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthenticationLogin extends BaseClass {
	@Test
	public void login() {
		addHeader("accept", "application/json");
		addBasicAuth("sugubsk@gmail.com", "Greens@2020");
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		String getResBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(getResBodyPrettyString);
	}
}
