package utility;
import java.io.IOException;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class TestClass {
	static String[][] createPingsExcel;
	
	public static  String[][] getExcel(String sheet) throws IOException
	{
		String excelPath = "./data/CreatePings.xlsx";
		//String sheetName = "CreatePings";
		ExcelReaderUtil reader = new ExcelReaderUtil(excelPath, sheet);
		String[][] excelData = reader.getCellData();
		
		return excelData;	
		
	}
	public static Map<String, Object> getCreatePingsAPIPayload() throws IOException
	{
		Map<String, Object> payload = new HashMap<String, Object>(); 
		
		createPingsExcel = getExcel("CreatePings");
		
		for (int i = 1; i<2;i++) //i<createPingsExcel.length
		{
			payload.put("vehicle_no", createPingsExcel[i][0]);		
			payload.put("transporter_name", createPingsExcel[i][1]);
			payload.put("speed", Integer.parseInt(createPingsExcel[i][2]));
			payload.put("clientCode", createPingsExcel[i][3]);
			//payload.put("ignition_status", createPingsExcel[i][3]);
			//payload.put("sync", createPingsExcel[i][4].toLowerCase());
			//payload.put("battery_strength", createPingsExcel[i][5]);	
			//payload.put("odometer_km", createPingsExcel[i][6]);
			
			System.out.println(payload.toString());
			//String sheetNumber = createPingsExcel[i][8];
			
			
		}
		return payload;
	}

	//To read the sheet name from CreatePings sheet
	public static String getSheetName() throws IOException
	{
		String sheetName = null;
		for (int i = 1; i<2;i++) //i<createPingsExcel.length
		{	
		String[][] createPingsExcel = getExcel("CreatePings");
		sheetName = createPingsExcel[i][4].toString();
		
		}
		return sheetName;
	}
	
	
	
	//public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		
		@Test (enabled=true)
		public static void createMultiplePings() throws IOException, ParseException, InterruptedException
		{
		//JSON object

		/*Map<String, Object> staticPingData = new HashMap<String, Object>();  //For all Static Data which will get added to individual pings	

		staticPingData.put("vehicle_no", "UP14ET7303_TEST");
		staticPingData.put("transporter_name", "TEST - ASM");
		staticPingData.put("speed", 60.00);
		staticPingData.put("ignition_status", "ON");
		staticPingData.put("sync", true);
		staticPingData.put("battery_strength", 20);
		staticPingData.put("odometer_km", 12347.73);
		staticPingData.put("clientCode", "lekha");	*/	       
			
			
		/*String excelPath = "./data/CreatePings.xlsx";
		String sheetName = "Sheet5";
		ExcelReaderUtil reader = new ExcelReaderUtil(excelPath, sheetName);
		String[][] tripDetails = reader.getCellData();*/		
			
		
		Map<String, Object> returnedPayload = getCreatePingsAPIPayload();
		String sheetName = getSheetName();
		String[][] tripDetails = getExcel(sheetName);
		
		//To send 50 pings of bulk all together 
		for(int k = 1; k<tripDetails.length-1; k=k+50)
		{
			//Map<String, Object> pingsData = new HashMap<String, Object>();
			List<Map<String,Object>> jsonArrayPayload = new ArrayList();  
			
			
			List<String> mockPings = ExcelReaderUtil.getUpdatedMockPing();
			//Long timeConstant = ExcelReaderUtil.getConstantDiff(tripDetails[1][2]);
			
	
		for (int i = k; i<k+50 && i <tripDetails.length-1; i++)
		{
			Map<String, Object> pingsData = new HashMap<String, Object>();
					
		//pingsData.putAll(staticPingData);	
			pingsData.putAll(returnedPayload);
		pingsData.put("latitude", tripDetails[i][0]);
		pingsData.put("longitude", tripDetails[i][1]);
		
		pingsData.put("timestamp",mockPings.get(i-1));
		//pingsData.put("timestamp", ExcelReaderUtil.getUpdatedPing(tripDetails[i][2], timeConstant));
		
		jsonArrayPayload.add(pingsData);
		//System.out.println(jsonArrayPayload.toString());
	
		}
		
					
		Map<String,Object> pings = new HashMap();
		pings.put("pings", jsonArrayPayload);

		RestAssured.baseURI="http://13.127.205.146:3000";
		String response = given().log().all()
		//.auth().basic("lekha", "lekha123")
		.header("Authorization","Basic dGVzdDpGYXJleWVAMTIz")
		.header("Content-Type","application/json")

		.body(pings)

		.when().post("/trucks/fareye/gpsTrackPost")
		.then().assertThat().statusCode(200).extract().response().asString();

		//System.out.println(response);   
		
		//Giving 1min gap between bulks of 50 pings 
		Thread.sleep(1000);
		
		System.out.println("Total pings in this request : " +jsonArrayPayload.size());
		} 
				
		
		
/*		JSONObject requestParams = new JSONObject();
		requestParams.put("vehicle_no", "RJ09GB2913_TEST");
		requestParams.put("transporter_name", "TEST - ASM");
		
		requestParams.put("Latitude", 28.531208); 
		requestParams.put("Longitude", 77.377288);
		requestParams.put("TimeStamp", "2020-11-20 09:45:00");
		
		requestParams.put("speed", 60.00);
		requestParams.put("ignition_status", "ON");
		requestParams.put("sync", true);
		requestParams.put("battery_strength", 20);
		requestParams.put("odometer_km", 12347.73);
		requestParams.put("clientCode", "lekha");
		
		String excelPath = "./data/CreatePings.xlsx";	
		String sheetName = "Sheet1";
		ExcelReaderUtil reader = new ExcelReaderUtil(excelPath, sheetName);
		String[][] tripDetails = reader.getCellData();

		for(int i = 1; i<tripDetails.length; i++)
		{
			requestParams.put("Latitude", tripDetails[i][0]); 
			requestParams.put("Longitude", tripDetails[i][1]);
			requestParams.put("TimeStamp", tripDetails[i][3]);
		
			
			 RestAssured.baseURI="https://gts.fareye.co";
			 String response = given().log().all()
					.auth().basic("lekha", "lekha123")
					
			.header("Authorization","Basic bGVraGE6bGVraGExMjM=")
			.header("Accept", "application/json")
			.header("Content-Type","application/json")	
			//.header("Host","<calculated when request is sent>")
			.header("Connection","keep-alive")
			//.header("Postman-Token", "<calculated when request is sent>")
			
			.body(requestParams.toString())
			
			.when().post("/trucks/fareye/gpsTrackPost")
			.then().assertThat().statusCode(200).extract().response().asString();
			
			 System.out.println(response);
		}*/
		
			
		
	}
		
		//Get alert report test method
		/*@Test(enabled=false)
		public void getAlertReport() throws IOException
		{
			//RestAssured.baseURI="https://transportation.fareye.co";
			RestAssured.baseURI="https://tpt-qa.fareye.co";
			createPingsExcel = getExcel("CreatePings");
			
			
			for (int i = 1; i<2;i++) //i<createPingsExcel.length
			{
			String response = given()
					.param("start_date", createPingsExcel[i][10])
					.param("end_date", createPingsExcel[i][11])
					.param("subscription_id", createPingsExcel[i][12])
					.param("type", createPingsExcel[i][13])
					.header("Authorization",createPingsExcel[i][14])
			//.param("end_date", "2020-12-07")
			//.param("start_date", "2020-12-05")
			//.param("subscription_id", "6737")
			//.header("Authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjoxOTU0LCJuYW1lIjoiQWppdCBrdW1hciIsImVtYWlsIjoiYWppdGtyQHRhdGFzdGVlbGJzbC5jby5pbiIsInBob25lX251bWJlciI6Ijc3NjM4MDc0NDMiLCJyb2xlIjoiQ29uc2lnbmVyIiwiZXhwIjoxNjA3NTAzMzA3fQ.")
			
			//.when().get("/api/v1/alerts/alert_report")
			.when().get("/api/v1/alert_subscriptions")
			.then().assertThat().statusCode(200).extract().response().asString();
			
			System.out.println(response.toString());
			}
		}*/
			
}
