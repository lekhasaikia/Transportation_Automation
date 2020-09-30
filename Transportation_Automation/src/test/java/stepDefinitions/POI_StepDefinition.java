package stepDefinitions;

import static io.restassured.RestAssured.given;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;


public class POI_StepDefinition extends Utils {

	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response ;
	TestData data = new TestData();
	JsonPath js;
	
		
	@Given("add_poi api payload")
	public void add_poi_api_payload() throws IOException {
		reqspec = given()
				.spec(requestSpecification()) // directly calling requestSpecification() of Utils class, as we are extending it , so no need of object
				.body(data.createPoiRequestData());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}

// should add when run poi 
/*	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		
		//APIResource constructor will be called with value of resource which you pass 
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(httpMethod.equalsIgnoreCase("POST"))
		{
		response = reqspec.when().post(resourceAPI.getResource());
				//then().spec(resspec).extract().response();
		}
		else if (httpMethod.equalsIgnoreCase("GET"))
		{
			response = reqspec.when().get(resourceAPI.getResource());
		}
	}
*/
	//should add , commented as same is defined in Reports_StepDefinition
	/*@Then("api call got succeeded with status code {int}")
	public void api_call_got_succeeded_with_status_code(int responseCode) {
		assertEquals(response.getStatusCode(),responseCode);
	}
*/
	
	//should add
	/*@Then("verify that {string} in response body should be {double}")
	public void verify_that_in_response_body_should_be(String key, Double value) {
		String resp = response.asString();
		js = new JsonPath(resp);
		Double s = js.getDouble(key.toString());
		assertEquals(s,value);
		System.out.println(js.get(key));
	}*/

	//should add when run poi 
	/*@Then("verify that {string} in response body should be {string}")
	public void verify_that_in_response_body_should_be(String key, String value) {
		String resp = response.asString();
		js = new JsonPath(resp);
		assertEquals(js.get(key),value);
	}*/
	
	
	
	
	// get_poi step definitions
	@Given("get_poi api")
	public void get_poi_api() throws IOException {
		reqspec = given()
				.spec(requestSpecification());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}
		
/*	@Then("verify that {string} {string} {int} {string} in response body should be {double}")
	public void verify_that_in_response_body_should_be(String key1, String key2, Integer intKey, String key3, Double value) {
	    String str = String.valueOf(intKey);
	    String pathHierarchy = key1.concat(".").concat(key2).concat(".").concat(str).concat(".").concat(key3);
	    
	    String resp = response.asString();
	    js = new JsonPath(resp);
	    
	    //converting arraylist (*** js.get(pathHierarchy) ***)into string using toString()
	    String getValue = js.get(pathHierarchy).toString();
	    
	    //getValue="[24.599823]" , so replacing [ and ] to match with expected value
	    String actualValue =getValue.replace("[", "").replace("]", "");
	    System.out.println(actualValue);
	   
	    //finally converting String actualValue into double for assertion 
	    Double actual = Double.parseDouble(actualValue);
	    assertEquals(actual, value);	    
	    	   
	}
	*/
	@Then("verify that value of hierarchy {string} {string} {string} {string} in response body should be {double}")
	public void verify_that_value_of_hierarchy_in_response_body_should_be(String key1, String key2, String key3, String key4, Double value) {
		String pathHierarchy = key1.concat(".").concat(key2).concat(".").concat(key3).concat(".").concat(key4);
	    
	    String resp = response.asString();
	    js = new JsonPath(resp);
	    
	    //converting ArrayList (*** js.get(pathHierarchy) ***)into string using toString()
	    String getValue = js.get(pathHierarchy).toString();
	    
	    //getValue="[24.599823]" , so replacing [ and ] to match with expected value
	    String actualValue =getValue.replace("[", "").replace("]", "");
	    System.out.println(actualValue);
	   
	    //finally converting String actualValue into double for assertion 
	    Double actual = Double.parseDouble(actualValue);
	    assertEquals(actual, value);
	}

	
}

