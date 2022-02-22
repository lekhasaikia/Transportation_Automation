package utility;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReaderUtil {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	static long difference_In_Seconds;
	static long difference_In_Minutes;
	static long difference_In_Hours;
	static long difference_In_Days;
	static long difference_In_Years;
	
	
	
	
	public ExcelReaderUtil(String excelPath, String sheetName) throws IOException
	{
		 workbook = new XSSFWorkbook(excelPath);
		 sheet = workbook.getSheet(sheetName);
	}
	
	public static String[][] getCellData() throws IOException
	{	
		int rowCount= sheet.getLastRowNum();
		int colCount= sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		
		for(int row=0; row<rowCount; row++)
		{
			for(int col=0; col<colCount;col++)
			{
				DataFormatter formatter = new DataFormatter();
				data[row][col]= formatter.formatCellValue(sheet.getRow(row).getCell(col));
			}
		}
		return data;
		
	}
	
	
	//public static void main(String args[]) throws IOException, ParseException
	public static List<String> getUpdatedMockPing() throws IOException, ParseException
	{
		
		List<String> newMockList = new ArrayList<String>();
		//adding first mock ping - which is TODAY-9hours
		String firstMock = getFirstMockPing();
		//System.out.println("first mock :"+firstMock);
		newMockList.add(firstMock);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		Date firstMockPingDate = format.parse(firstMock);
		//System.out.println("first mock ping date:" +firstMockPingDate);
		
	    //String excelPath = "./data/CreatePings.xlsx";
		//String sheetName = "Sheet3";
		//ExcelReaderUtil reader = new ExcelReaderUtil(excelPath, sheetName);	
		String[][] tripDetails1 = getCellData();
		
		//String firstRealPing = tripDetails1[1][2];
		//System.out.println(firstRealPing);
		//getConstantTimeDifference(firstRealPing);
		
		//addingConstantToEveryMockPing_recursive();
		
		//adding time diff to real ping everytime //not useful
		/*for (int i = 1; i<10;i++)
		{
			String firstRealPing1 = tripDetails1[i][2];
					
			DateFormat dffrom = new SimpleDateFormat("M/dd/yyyy h:mm");
			DateFormat dfto = new SimpleDateFormat("yyYY-MM-dd HH:mm:ss");  	
			Date firstRealPingDate = dffrom.parse(firstRealPing1);
			String formatted_firstRealPing = dfto.format(firstRealPingDate);
			System.out.println("First Formatted Real Ping: "+formatted_firstRealPing);	
					
		}*/
		
		// 1st real - 2nd real
		for(int i =1; i<tripDetails1.length-1;i++)
		{
			String first = tripDetails1[i][2];
			String second = tripDetails1[i+1][2];
				
			DateFormat dffrom = new SimpleDateFormat("M/dd/yyyy h:mm");
			DateFormat dfto = new SimpleDateFormat("yyYY-MM-dd HH:mm:ss");  
			
			Date firstRealPingDate = dffrom.parse(first);
			String formatted_firstRealPing = dfto.format(firstRealPingDate);
			//System.out.println("First Formatted Real Ping: "+formatted_firstRealPing);	
			Date secondRealPingDate = dffrom.parse(second);
			String formatted_secondRealPing = dfto.format(secondRealPingDate);
			//System.out.println("Second Formatted Real Ping: "+formatted_secondRealPing);
			
			
			long timeDifference_between_two_real_pings = secondRealPingDate.getTime() - firstRealPingDate.getTime(); 
			difference_In_Seconds = TimeUnit.MILLISECONDS .toSeconds(timeDifference_between_two_real_pings)% 60; 
			difference_In_Minutes = TimeUnit.MILLISECONDS .toMinutes(timeDifference_between_two_real_pings)% 60; 
			difference_In_Hours  = TimeUnit .MILLISECONDS .toHours(timeDifference_between_two_real_pings)% 24; 
			difference_In_Days = TimeUnit .MILLISECONDS .toDays(timeDifference_between_two_real_pings) % 365; 
			difference_In_Years = TimeUnit .MILLISECONDS .toDays(timeDifference_between_two_real_pings)/ 365l; 
			
			/*System.out.println("---Difference between second real and first real ping---");
			System.out.println("Difference in seconds: " + difference_In_Seconds + " seconds.");         
			System.out.println("Difference in minutes: " + difference_In_Minutes + " minutes.");         
			System.out.println("Difference in hours: " + difference_In_Hours + " hours."); 
			System.out.println("Difference in days: "+difference_In_Days + " days.");*/
			
			/*Calendar calendar = Calendar.getInstance();
			calendar.setTime(firstMockPingDate);
			calendar.add(Calendar.YEAR, (int) difference_In_Years);
			calendar.add(Calendar.DAY_OF_MONTH, (int) difference_In_Days);
			calendar.add(Calendar.HOUR_OF_DAY,(int) difference_In_Hours);
			calendar.add(Calendar.MINUTE, (int) difference_In_Minutes);
			calendar.add(Calendar.SECOND, (int) difference_In_Seconds);		
			Date new_mock_ping = calendar.getTime();*/
			//System.out.println(new_mock_ping);
			
			//adding time difference of two real pings into first mock ping
			Date new_mock_ping= addTime(firstMockPingDate);
			
			//System.out.println(new_mock_ping);
			String formatted_new_mock_ping = new SimpleDateFormat("y-MM-dd HH:mm:ss").format(new_mock_ping);	
			//System.out.println("Next mock ping after adding time difference : "+formatted_new_mock_ping);
			
			firstMockPingDate = new_mock_ping;
			
			//debugging : yyYY-MM-dd HH:mm:ss is changed into y-MM-dd HH:mm:ss
			String newMockPing = new SimpleDateFormat("y-MM-dd HH:mm:ss").format(firstMockPingDate);
			//System.out.println("new mock ping: " +newMockPing);
			newMockList.add(newMockPing);
			//System.out.println(newMockPing);
			
		}	
		
		return newMockList;
		
	}
	
	public  static Date  addTime(Date d)
	{
		System.out.println(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.YEAR, (int) difference_In_Years);
		calendar.add(Calendar.DAY_OF_MONTH, (int) difference_In_Days);
		calendar.add(Calendar.HOUR_OF_DAY,(int) difference_In_Hours);
		calendar.add(Calendar.MINUTE, (int) difference_In_Minutes);
		calendar.add(Calendar.SECOND, (int) difference_In_Seconds);
		
	
		
		Date new_mock_ping = calendar.getTime();
		return new_mock_ping;
	}

	// Get first mock ping from TODAY-9Hours 
	public static String getFirstMockPing()
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Current Date " + dateFormat.format(date));
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, -9);
		Date currentDateMinusNine = c.getTime();
		System.out.println("First Mock ping started at: " + dateFormat.format(currentDateMinusNine));
		
		//Debugging Timestamp issue 
		//yyYY-MM-dd HH:mm:ss is changed into Y-MM-dd HH:mm:ss
		String first_mock_ping = new SimpleDateFormat("Y-MM-dd HH:mm:ss").format(currentDateMinusNine);

		return first_mock_ping;
		
	}
	
	
	
	
	
	
	
	// latest /////
	
	public static long getConstantDiff(String firstPing) throws IOException, ParseException

	{	

	String firstMock = getFirstMockPing();

	SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

	Date firstMockPingDate = format.parse(firstMock);

	

	DateFormat dffrom = new SimpleDateFormat("M/dd/yyyy h:mm");

	//DateFormat dfto = new SimpleDateFormat("yyYY-MM-dd HH:mm:ss");  

	

	

	Date secondRealPingDate = dffrom.parse(firstPing);

	



	long timeDifference_between_two_real_pings = firstMockPingDate.getTime() - secondRealPingDate.getTime();

	// System.out.println("Constant is :"+timeDifference_between_two_real_pings);



	

	return timeDifference_between_two_real_pings;

	

	}

	

	public static String getUpdatedPing(String pingDate,long constant)  throws IOException, ParseException

	{

		//System.out.println("Inside Update Ping :"+pingDate);	

		DateFormat dffrom = new SimpleDateFormat("M/dd/yyyy h:mm");
		DateFormat dfto = new SimpleDateFormat("yyYY-MM-dd HH:mm:ss");  


		Date firstRealPingDate = dffrom.parse(pingDate); //first real from excel 

		String formatted_firstRealPing = dfto.format(firstRealPingDate);

		//System.out.println("First Formatted Real Ping: "+formatted_firstRealPing);

		

		//To calculate Diff

		difference_In_Seconds = TimeUnit.MILLISECONDS .toSeconds(constant)% 60;

		difference_In_Minutes = TimeUnit.MILLISECONDS .toMinutes(constant)% 60;

		difference_In_Hours  = TimeUnit .MILLISECONDS .toHours(constant)% 24;

		difference_In_Days = TimeUnit .MILLISECONDS .toDays(constant) % 365;

		//difference_In_Years = TimeUnit .MILLISECONDS .toDays(constant)/ 365l;

	

	

		//To add difference to date got from excel

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(firstRealPingDate);

		//calendar.add(Calendar.YEAR, (int) difference_In_Years);

		calendar.add(Calendar.DAY_OF_MONTH, (int) difference_In_Days);

		calendar.add(Calendar.HOUR_OF_DAY,(int) difference_In_Hours);

		calendar.add(Calendar.MINUTE, (int) difference_In_Minutes);

		calendar.add(Calendar.SECOND, (int) difference_In_Seconds);

		Date new_mock_ping = calendar.getTime();



		

		

		String newMockPing = new SimpleDateFormat("yyYY-MM-dd HH:mm:ss").format(new_mock_ping);

		//System.out.println("Ping is: "+newMockPing);

		

		return newMockPing;

			

	}
	
	
	
	
}





