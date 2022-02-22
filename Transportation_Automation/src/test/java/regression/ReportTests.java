package regression;

import java.util.List;

import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReportTests {

	// Test input data 
	/*public Response init()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response response = RestAssured.given().
		param("endDate","2021-01-31").
		param("startDate", "2021-01-01").
		param("state[]", "completed").
		//param("vehicleNo[]","AP16TH3395_TEST").
		header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTE5MDc4MDB9.-Yt2nfTz_KRkorcKqI1pCoWUQJtczdg_L2Qacq_ZYww").

		when().get("/api/v2/reports/daily_trip");

		return response;
	}*/

	// TRN-2305 : verify trip records should be filtered as per given state 
	@Test(enabled = false)
	public void verifyDailyTripStateFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("state[]", "untracked").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/daily_trip");

		//this is for single JSON Object 
		/*then().assertThat().
	statusCode(200).
	body("content.state[0]",Is.is("Completed")).extract().response();*/

		//System.out.println("Trips containing given state : "+jsonResponse.asString());


		//this is for JSON array - count of 'id' key 
		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		//list of 'ids' in JSON array 
		List<Integer> values_of_id_key  = jsonResponse.jsonPath().getList("content.id");
		for (int n : values_of_id_key)
		{
			System.out.println(n);
		}

		for (int i = 0; i<count;i++)
		{
			String state_present_in_path = jsonResponse.jsonPath().getString("content.state["+i+"]");	
			System.out.println(state_present_in_path);	

			jsonResponse.then().assertThat().
			statusCode(200);

			//body(state_present_in_path,Is.is("Completed"));
			Assert.assertEquals(state_present_in_path, "untracked");


			System.out.println("Trips containing state = " + state_present_in_path + " : " +jsonResponse.asString());

		}

	}

	// TRN-2306 :  verify trip records should be filtered as per transporter name 
	@Test (enabled = false )
	public void verifyDailyTripAsPerTransporter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("transporter[]", "VIJAYSHRI LOGISTICS LLP").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/daily_trip");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String transporter_value = jsonResponse.jsonPath().getString("content.transporter["+i+"]");	
			System.out.println(transporter_value);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(transporter_value, "VIJAYSHRI LOGISTICS LLP");


			System.out.println("Trips containing transporter = " + transporter_value + " : " +jsonResponse.asString());

		}

	}


	// TRN-2307 : verify daily trip records should be filtered as per vehicle number 
	@Test (enabled = false)
	public void verifyDailyTripVehicleNoFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("vehicleNo[]","AP16TH3395_TEST").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/daily_trip");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String vehicle_number = jsonResponse.jsonPath().getString("content.vehicle_no["+i+"]");	
			System.out.println(vehicle_number);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(vehicle_number, "AP16TH3395_TEST");


			System.out.println("Trips containing vehicle no = " + vehicle_number + " : " +jsonResponse.asString());		
		}			
	}

	// TRN-2313 : verify day based trip reports should be filtered as per vehicle number
	@Test (enabled = false)
	public void verifyDayBasedTripsVehicleNoFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("vehicleNo[]","AP16TH3395_TEST").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/day_based");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String vehicle_number = jsonResponse.jsonPath().getString("content.vehicle_no["+i+"]");	
			System.out.println(vehicle_number);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(vehicle_number, "AP16TH3395_TEST");


			System.out.println("Trips containing vehicle no = " + vehicle_number + " : " +jsonResponse.asString());		
		}			
	}

	// TRN-2320 : verify state based trip reports should be filtered as per vehicle number
	@Test (enabled = true)
	public void verifyStateBasedTripsVehicleNoFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("vehicleNo[]","AP16TH3395_TEST").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/state_based");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String vehicle_number = jsonResponse.jsonPath().getString("content.vehicle_no["+i+"]");	
			System.out.println(vehicle_number);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(vehicle_number, "AP16TH3395_TEST");


			System.out.println("Trips containing vehicle no = " + vehicle_number + " : " +jsonResponse.asString());		
		}			
	}

	// TRN-2321 : verify state based trip reports should be filtered as per state filter
	@Test(enabled = false)
	public void verify_StateBasedReport_State_Filter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("state[]", "untracked").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/state_based");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String state_present_in_path = jsonResponse.jsonPath().getString("content.state["+i+"]");	
			System.out.println(state_present_in_path);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(state_present_in_path, "untracked");

			System.out.println("Trips containing state = " + state_present_in_path + " : " +jsonResponse.asString());

		}
	}
	
	
	// TRN-2326 : verify trips in Way Point Report should be filtered as per vehicle no 
	@Test (enabled = false)
	public void verifyWayPointReportVehicleNoFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("vehicleNo[]","AP16TH3395_TEST").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/way_point");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String vehicle_number = jsonResponse.jsonPath().getString("content.vehicle_no["+i+"]");	
			System.out.println(vehicle_number);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(vehicle_number, "AP16TH3395_TEST");


			System.out.println("Trips containing vehicle no = " + vehicle_number + " : " +jsonResponse.asString());		
		}			
	}

	
	// TRN-2335 : verify poi history report should be filtered as per POI filter 
	@Test (enabled = false)
	public void verifyPOIReportPOIFilter()
	{
		RestAssured.baseURI = "https://tpt-qa.fareye.co";

		Response jsonResponse = RestAssured.given().
				param("endDate","2021-01-31").
				param("startDate", "2021-01-01").
				param("poi_id[]","test_poi").
				header("authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NTIxLCJuYW1lIjoiVHJhbnNwb3J0YXRpb24iLCJlbWFpbCI6InRyYW5zcG9ydGF0aW9udjJAZmFyZXllLmNvIiwicGhvbmVfbnVtYmVyIjoiODIxODE3MzQ0NyIsInJvbGUiOiJDb25zaWduZXIiLCJleHAiOjE2MTI0MzA4NDZ9.Tql46JAxTCA534I4StRsDWOHywB1vMJ4n9GU3zGHLNE").

				when().get("/api/v2/reports/poi_history");

		int count = jsonResponse.jsonPath().getList("content.id").size();
		System.out.println("Response body JSON array size : " +count);

		for (int i = 0; i<count;i++)
		{
			String poi_name = jsonResponse.jsonPath().getString("content.poiNickName["+i+"]");	
			System.out.println(poi_name);	

			jsonResponse.then().assertThat().
			statusCode(200);

			Assert.assertEquals(poi_name, "test_poi");


			System.out.println("Trips containing vehicle no = " + poi_name + " : " +jsonResponse.asString());		
		}			
	}

	
	

}

