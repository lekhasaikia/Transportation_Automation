package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class StepDefinition extends Utils {

	RequestSpecification reqspec;
	ResponseSpecification resspec;
	TestData data = new TestData();
	Response response ;
	JsonPath js;
	String auth_token;



	@Given("create_trip_auth api payload with param {string} {string}")
	public void create_trip_auth_api_payload_with_param(String email, String password) throws IOException {
		reqspec = given()
				.spec(requestSpecification())
				.queryParam("email", email).queryParam("password", password);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}


	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if(httpMethod.equalsIgnoreCase("POST"))
		{
			response = reqspec.when().post(resourceAPI.getResource());

		}
		else if (httpMethod.equalsIgnoreCase("GET"))
		{
			System.out.println(reqspec);
			response = reqspec.when().get(resourceAPI.getResource());
			//System.out.println(response);
		}
	}

	@Then("api call got succeeded with status code {int}")
	public void api_call_got_succeeded_with_status_code(int responseCode) {
		assertEquals(response.getStatusCode(),responseCode);
		System.out.println(responseCode);
		System.out.println(response.getBody().asString());
		
	}

	@Then("{string} should be generated successfully")
	public void should_be_generated_successfully(String auth_key) {
		auth_token = getJsonPath(response, auth_key);
		System.out.println("Generated Auth_token : " + auth_token);
		assertEquals(auth_token, "eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo0OTA0LCJuYW1lIjoiTGVraGEiLCJlbWFpbCI6Imxla2hhc2hyZWUuc2Fpa2lhQGdldGZhcmV5ZS5jb20iLCJwaG9uZV9udW1iZXIiOiI5NjU0MzM2MTk4In0.");
	}



	// create trip Step definitions	
	@Given("create_trip api payload with bearer token generated in create_trip_auth api")
	public void create_trip_api_payload_with_bearer_token_generated_in_create_trip_auth_api() throws IOException {
		reqspec = given()
				.header("Authorization","eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo0OTA0LCJuYW1lIjoiTGVraGEiLCJlbWFpbCI6Imxla2hhc2hyZWUuc2Fpa2lhQGdldGZhcmV5ZS5jb20iLCJwaG9uZV9udW1iZXIiOiI5NjU0MzM2MTk4In0.")
				.spec(requestSpecification())
				.body(data.consignerTripData());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String value) {
		String actual = getJsonPath(response, key);
		assertEquals(actual, value);
	}


	// create ping Step definitions
	@Given("create_pings api payload")
	public void create_pings_api_payload() throws IOException {
		reqspec = given().log().all()
				.spec(requestSpecification())
				.header("Authorization","Basic dGVzdDpGYXJleWVAMTIz")
				.body(TestData.createPingsData());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	
	// get ping Step definitions	
	@Given("get_ping_api with param {string} {string} {string}")
	public void get_ping_api_with_param(String start_date, String end_date, String vehicle_no) throws IOException {
		reqspec = given()
				.spec(requestSpecification())
				.queryParam("start_date", start_date).queryParam("end_date", end_date).queryParam("vehicle_no", vehicle_no);
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}
	
	// Get WayPoint Report Step definitions
	@Given("get_waypoint_report api")
	public void get_waypoint_report_api() throws IOException {
		reqspec = given()
				.spec(requestSpecification())
				.param("endDate", "2020-08-31")
				.param("startDate", "2020-08-01")
				.param("vehicleNo[]", "NL01AB1191")
				.header("authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MzAwNjU2NzR9.");
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}

	@Then("verify that latitude in hierarchy {string} {string} should be reflected in response body")
	public void verify_that_latitude_in_hierarchy_should_be_reflected_in_response_body(String key1, String key2) {
		String pathHierarchy = key1.concat(".").concat(key2);
		System.out.println(pathHierarchy);
		String value = getJsonPath(response, pathHierarchy);
		System.out.println(value);
	}

	@Then("verify that longitude in hierarchy {string} {string} should be reflected in response body")
	public void verify_that_longitude_in_hierarchy_should_be_reflected_in_response_body(String key1, String key2) {
		String pathHierarchy = key1.concat(".").concat(key2);
		System.out.println(pathHierarchy);
		String value = getJsonPath(response, pathHierarchy);
		System.out.println(value);
	}

	@Then("verify that pings in hierarchy {string} {string} should be generated successfully in response body")
	public void verify_that_pings_in_hierarchy_should_be_generated_successfully_in_response_body(String key1, String key2) {
		String pathHierarchy = key1.concat(".").concat(key2);
		System.out.println(pathHierarchy);
		String value = getJsonPath(response, pathHierarchy);
		System.out.println(value);
	}
	

	//Add alert step definitions
	@Given("get_alert_api")
	public void get_alert_api() throws IOException {
		reqspec = given()
				.spec(requestSpecification())
				.header("authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MzExMDEzMzZ9.");			
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}

	@Then("alert username {string} should be visible in response body")
	public void alert_username_should_be_visible_in_response_body(String username) {
		List<String> nameList = new ArrayList<String>();
		nameList.add(getJsonPath(response, "results.fullName"));
		for (String name : nameList)
		{	
			assertTrue(name.contains(username)); 	
		}
	}


	//Create alert subscription step definitions 
	@Given("create_alert_subscription_api")
	public void create_alert_subscription_api() throws IOException {
		reqspec = given()
				.header("authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo3NjcsIm5hbWUiOiJKayBsYWtzaG1pIiwiZW1haWwiOiJjb25zaWduZXIuamtsYWtzaG1pQGxvZ2lzdGljcy5jb20iLCJwaG9uZV9udW1iZXIiOiI4MjE4MTczNDQ3Iiwicm9sZSI6IkNvbnNpZ25lciIsImV4cCI6MTYzMTYwMzA4NH0.")  
				.spec(requestSpecification())
				//.body(data.createAlertSubscriptionData());
				.body(TestData.createAlertData());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	}
	//Add ping for overspeed alert step definitions 
	@Given("create_pings_for_overspeed_alert api payload")
	public void create_pings_for_overspeed_alert_api_payload() throws IOException {
		reqspec = given().header("Authorization","Basic bW9iaTptb2JpR3BzX0BGYXJleWUhNjgy")
				.spec(requestSpecification())
				.body(TestData.addPingsForOverspeedAlertTestData());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	//Get overspeed alert report step definitions 
	@Given("get_overspeed_alert_api")
	public void get_overspeed_alert_api() throws IOException {
	    reqspec = given()
	    		.header("authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo3NjcsIm5hbWUiOiJKayBsYWtzaG1pIiwiZW1haWwiOiJjb25zaWduZXIuamtsYWtzaG1pQGxvZ2lzdGljcy5jb20iLCJwaG9uZV9udW1iZXIiOiI4MjE4MTczNDQ3Iiwicm9sZSI6IkNvbnNpZ25lciIsImV4cCI6MTYzMTc4MjEwNX0.")
	    		.param("type", "OverspeedAlertSubscription")
	    		.spec(requestSpecification());
	    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	@Then("full_name should be {string} in response body")
	public void full_name_should_be_in_response_body(String fullname) {
	   System.out.println(getJsonPath(response, "results.alert_users.id"));
	}
}







