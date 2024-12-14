package com.sampleAPI.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class CreateFlights extends BaseClass {
	String fno;

	@Test(priority = 3)
	public void createFlight() {
		// 1.Header
		addHeader("Content-Type", "application/json");
		// 2.payload
		addReqBody("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}\r\n"
				+ "");
		// 3.req the endpoint
		addReqType("POST", "https://www.omrbranch.com/api/flights");
		// 4.Status Code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		JsonPath path = response.jsonPath();
		Object object = path.get("data.id");

		System.out.println(object);
		Integer id = (Integer) object;
		fno = id.toString();

		// 5.Get Res Body
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		// 6.get res body pretty
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);
	}

	@Test(priority = 4)
	public void updateFlight() {

		addHeader("Content-Type", "application/json");
		addReqBody("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 19,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		addReqType("PUT", "https://www.omrbranch.com/api/flight/" + fno);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode, "verify statuscode");
		JsonPath path = response.jsonPath();
		Object object = path.get("data.URL");

		System.out.println(object);
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		 System.out.println(resBodyPrettyString);
	}

	@Test(priority = 5)
	public void patchFlight() {
		addHeader("Content-Type", "application/json");
		addReqBody("{\\r\\n\"\r\n" + "		 		+ \"    \\\"flightName\\\": \\\"AirMohan\\\",\\r\\n\"\r\n"
				+ "		 		+ \"    \\\"Country\\\": \\\"India\\\",\\r\\n\"\r\n"
				+ "		 		+ \"    \\\"Destinations\\\": 20,\\r\\n\"\r\n"
				+ "		 		+ \"    \\\"URL\\\": \\\"https:\\\\/\\\\/en.wikipedia.org\\\\/wiki\\\\/Air_India\\\"\\r\\n\"\r\n"
				+ "		 		+ \"}");
		addReqType("PATCH", "https://www.omrbranch.com/api/flight/" + fno);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode, "verify statuscode");
		JsonPath path = response.jsonPath();
		Object object = path.get("data.Country");

		System.out.println(object);
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 6)
	public void deleteFlight() {
		addHeader("Content-Type", "application/json");
		addReqType("DELETE", "https://www.omrbranch.com/api/flight/" + fno);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 2)
	public void getSingleFlight() {
		addHeader("Content-Type", "application/json");
		addReqType("GET", "https://www.omrbranch.com/api/flights?page=1");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String getResBodyString = GetResBodyString(response);
		System.out.println(getResBodyString);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 1)
	public void getListFlight() {
		addHeader("Content-Type", "application/json");
		addReqType("GET", "https://www.omrbranch.com/api/flights?page=1");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

}
