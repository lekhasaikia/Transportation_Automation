package test;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Test_GET_POI
{
	@Test
	public void get_POI()
	{
		RestAssured.baseURI="http://35.154.229.215:3000";
		String response = given()
			.header("Host","<calculated when request is sent>")
			.header("User-Agent","PostmanRuntime/7.26.2")
			.header("Accept-Encoding","gzip, deflate, br")
			.header("Connection","keep-alive")
			.header("Accept","application/json")
			.header("X-Change-Case","true")
			.header("Authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo4MzQsIm5hbWUiOiJIemwiLCJlbWFpbCI6ImNvbnNpZ25lci5oemxAbG9naXN0aWNzLmNvbSIsInBob25lX251bWJlciI6IjgyMTgxNzM0NDciLCJyb2xlIjoiQ29uc2lnbmVyIiwiZXhwIjoxNjI4ODQwOTAzfQ.")
			.header("Key-Inflection","camel")
			.header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
			.header("Origin","http://localhost:3000")
			.header("Referer","http://localhost:3000/poi")
			.header("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
			
		.when().get("/api/v2/pois")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String id = js.getString("content.pois.1244417.id");
		String lat = js.getString("content.pois.1244417.latitude");
		String lon = js.getString("content.pois.1244417.longitude");
		System.out.println(id );
		System.out.println(lat);
		System.out.println(lon);
	}
}











