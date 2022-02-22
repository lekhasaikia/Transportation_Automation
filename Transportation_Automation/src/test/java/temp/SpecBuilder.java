package temp;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {


	@Test
	public void create_POI()
	{
		
	CreatePoiRequestPayload createpoi = new CreatePoiRequestPayload();
	createpoi.setRadius(0.457);
	createpoi.setLat(27.19078606458319);
	createpoi.setLng(78.04550170898439);
	createpoi.setPoiType("altunloading");
	createpoi.setPoiNickName("tes345");
	
	//creating request spec builder 
    RequestSpecification reqspec = new RequestSpecBuilder()
    								.setBaseUri("http://35.154.229.215:3000")
    								.addHeader("Host", "<calculated when request is sent>")
    								.addHeader("User-Agent", "PostmanRuntime/7.26.2")
    								.addHeader("Accept-Encoding","gzip, deflate, br")
    								.addHeader("Connection","keep-alive")
    								.addHeader("Accept","application/json")
    								.addHeader("X-Change-Case","true")
    								.addHeader("Authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo4MzQsIm5hbWUiOiJIemwiLCJlbWFpbCI6ImNvbnNpZ25lci5oemxAbG9naXN0aWNzLmNvbSIsInBob25lX251bWJlciI6IjgyMTgxNzM0NDciLCJyb2xlIjoiQ29uc2lnbmVyIiwiZXhwIjoxNjI4ODQwOTAzfQ.")
    								.addHeader("Key-Inflection","camel")
    								.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
    								.addHeader("Content-Type","application/json")
    								.addHeader("Origin","http://localhost:3000")
    								.addHeader("Referer","http://localhost:3000/poi")
    								.addHeader("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
    								
    								.build();

	RequestSpecification res = given().spec(reqspec).body(createpoi);


		
	
	//creating response spec builder 
//ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

//res.when().post("/api/v2/pois").	
//then().spec(resspec).extract().response();
	
	
	/*RestAssured.baseURI="http://35.154.229.215:3000";
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
	.header("Content-Type","application/json")
	.header("Origin","http://localhost:3000")
	.header("Referer","http://localhost:3000/poi")
	.header("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")*/
	
	//.body(createpoi)
	
	//.when().post("/api/v2/pois")
	
	//.then().assertThat().statusCode(200).extract().response().asString();
	
	//System.out.println(response);
	
	}


	
}
