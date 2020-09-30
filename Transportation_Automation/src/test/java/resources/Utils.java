package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqspec ;
	Response response ;
	public RequestSpecification requestSpecification () throws IOException 
	{
		
		//logging
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
				
		//creating request specification builder 
		reqspec= new RequestSpecBuilder()
				
				.setBaseUri(getProperties("baseUrl"))
				
				//.addHeader("Content-Length", "<calculated when request is sent>")		
				
				.addHeader("Postman-Token", "<calculated when request is sent>")
				.addHeader("Host","<calculated when request is sent>")
				//.addHeader("Content-Type","application/json")
				
				//.addHeader("User-Agent","PostmanRuntime/7.26.3")
				//.addHeader("Accept-Encoding","gzip, deflate, br")
				.addHeader("Connection","keep-alive")
				.addHeader("Accept","application/json")
				//.addHeader("X-Change-Case","true")
				//.addHeader("Authorization","Bearer eyJhbGciOiJub25lIn0.eyJ1c2VyX2lkIjo4MzQsIm5hbWUiOiJIemwiLCJlbWFpbCI6ImNvbnNpZ25lci5oemxAbG9naXN0aWNzLmNvbSIsInBob25lX251bWJlciI6IjgyMTgxNzM0NDciLCJyb2xlIjoiQ29uc2lnbmVyIiwiZXhwIjoxNjI4ODQwOTAzfQ.")		
				//.addHeader("Key-Inflection","camel")
				//.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
				//.addHeader("Origin","http://localhost:3000")
				//.addHeader("Referer","http://localhost:3000/poi")
				//.addHeader("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
		
				
				
				//logging
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
			
		return reqspec;

	}
	
	//reading properties from config.properties file
	public static String  getProperties(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Lekhashree Saikia\\workspace\\Transportation_Automation\\src\\test\\java\\resources\\config.properties");
		prop.load(fis);
		 
		String value = prop.getProperty(key);
		return value;
		
		
	}
	
	//reading any key:value using JsonPath from RESPONSE	
	//making utility for the following lines used in step definition
	
		/*String res  = response.asString();
		JsonPath js = new JsonPath(res);
		auth_token = js.get("key name from response");
		System.out.println(auth_token);*/
	
	public String getJsonPath(Response response, String key)
	{
		String resp  = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
}













