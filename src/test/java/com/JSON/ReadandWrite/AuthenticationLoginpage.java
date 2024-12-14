package com.JSON.ReadandWrite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.sampleAPI.test.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AuthenticationLoginpage extends BaseClass {
	String logtoken;
	@Test(priority = 6)
	public void stateList() {
		List<Header> Header1 = new ArrayList<>();
	    Header h1= new Header("accept", "application/json");
	    Header1.add(h1);Headers headers = new Headers(Header1);
	    addHeaders(headers);
	    StateList_Output_pojo statelist = new StateList_Output_pojo(35, "Tamil Nadu");
	    Response reqType = addReqType("GET", "https://omrbranch.com/api/stateList");
	    int statusCode = getStatusCode(reqType);
	    System.out.println(statusCode);
	    
	}
	@Ignore
	public void profilePictureUpdate() {
		List<Header> Header1 = new ArrayList<>();
	    Header h1= new Header("accept", "application/json");
	    Header h2= new Header("Authorization","Bearer "+ logtoken);
	    Header h3= new Header("Content-Type","application/json");
	    Header1.add(h1);
	    Header1.add(h2);
	    Header1.add(h3);
	    Headers headers = new Headers(Header1);
	    addHeaders(headers);
	    
	    addMultipartFormatData("profile_picture",new File(System.getProperty("user.dir")+"src\\test\\resources\\natural.png") );
	    
	}
	@Test(priority=5)
	public void deleteAddress() {
		 List<Header> Header1 = new ArrayList<>();
		    Header h1= new Header("accept", "application/json");
		    Header h2= new Header("Authorization","Bearer "+ logtoken);
		    Header h3= new Header("Content-Type","application/json");
		    Header1.add(h1);
		    Header1.add(h2);
		    Header1.add(h3);
		    Headers headers = new Headers(Header1);
		    addHeaders(headers);
		    
		    Delete_Address_pojo delete_Address_pojo = new Delete_Address_pojo("87955");
			
		    
		    Response response = addReqType("DELETE", "https://omrbranch.com/api/deleteAddress");
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			//Assert.assertEquals(statusCode, 200, "verify the status code");
			
			
	}
	@Test(priority=4)
	public void getUpdatedAddress() {
		 List<Header> Header1 = new ArrayList<>();
		    Header h1= new Header("accept", "application/json");
		    Header h2= new Header("Authorization","Bearer "+ logtoken);
		    Header1.add(h1);
		    Header1.add(h2);
		    Headers headers = new Headers(Header1);
		    addHeaders(headers);
		    
		    Response response = addReqType("GET", "https://omrbranch.com/api/getUserAddress");
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "verify the status code");
			
			String getResBodyPrettyString = getResBodyPrettyString(response);
			System.out.println(getResBodyPrettyString);
			
		   
	}
	@Test(priority=3)
	public void updateAddress() {
		 List<Header> Header1 = new ArrayList<>();
		    Header h1= new Header("accept", "application/json");
		    Header h2= new Header("Authorization","Bearer "+ logtoken);
		    Header h3= new Header("Content-Type","application/json");
		    Header1.add(h1);
		    Header1.add(h2);
		    Header1.add(h3);
		    Headers headers = new Headers(Header1);
		    addHeaders(headers);
		    //2.payload
		    UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo("87309","Sugumar","Balasubramaniam", "9944729274", "AK", 200, 101, 102, "641659", "Chennai", "Home");
		    addReqBody(updateAddress_Input_pojo);
		    //3.req type
			Response response = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "Address added successfully");
			
			UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
			String message = updateAddress_Output_pojo.getMessage();
			 Assert.assertEquals(message, "Address updated successfully","Verification message");
			 System.out.println(message);
	}
	@Test(priority=2)
	public void addAddress() {
    List<Header> Header1 = new ArrayList<>();
    Header h1= new Header("accept", "application/json");
    Header h2= new Header("Authorization","Bearer "+ logtoken);
    Header h3= new Header("Content-Type","application/json");
    Header1.add(h1);
    Header1.add(h2);
    Header1.add(h3);
    Headers headers = new Headers(Header1);
    addHeaders(headers);
    //2.payload
    AddUserAddress_Input_pojo address_Input_pojo = new AddUserAddress_Input_pojo("Sugumar","B", "9876543211", "AK", 100, 101, 102, "641659", "Chennai", "Home");
    addReqBody(address_Input_pojo);
   //3.req type
	Response response = addReqType("POST", "https://omrbranch.com/api/addUserAddress");
	int statusCode = getStatusCode(response);
	System.out.println(statusCode);
	Assert.assertEquals(statusCode, 200, "Address added successfully");
	
 AddUserAddress_Output_Message_pojo AddUserAddress_Output_pojo = response.as(AddUserAddress_Output_Message_pojo.class);
 String message = AddUserAddress_Output_pojo.getMessage();
 Assert.assertEquals(message, "Address added successfully","Verification message");
 System.out.println(message);
 
	}
@Test(priority=1)
public void login() {
	addHeader("accept", "application/json");
	addBasicAuth("sugubsk@gmail.com", "Greens@2020");
	Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
	
	int statusCode = getStatusCode(response);
	System.out.println(statusCode);
	Assert.assertEquals(statusCode, 200, "verify the status code");
	
	Login_Output_page login_Output_page = response.as(Login_Output_page.class);
	String first_name = login_Output_page.getData().getFirst_name();
	System.out.println(first_name);
	Assert.assertEquals(first_name, "Sugumar","verify");
//	String getResBodyString = GetResBodyString(response);
//	System.out.println(getResBodyString);
//	String getResBodyPrettyString = getResBodyPrettyString(response);
//	System.out.println(getResBodyPrettyString);
	 logtoken = login_Output_page.getData().getLogtoken();
}
}
