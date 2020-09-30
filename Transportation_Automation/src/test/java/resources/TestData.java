package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Consigner_trip;
import pojo.Consigner_trip_parent;
import pojo.CreatePoiRequest;
import pojo.Pings;
import pojo.Pings_parent;
import pojo_alert.Alert_parent;
import pojo_alert.New_alert_users;
import pojo_alert.Providers;
import pojo_alert.Settings;


public class TestData {
	CreatePoiRequest createpoi;
	Consigner_trip_parent consignerTripParent;
	Pings_parent pingsParent;
	Alert_parent createAlertSubscription;
	
	// POI test data
	public CreatePoiRequest createPoiRequestData()
	{
		createpoi = new CreatePoiRequest();

		createpoi.setRadius(0.457);
		createpoi.setLat(27.19078606458319);
		createpoi.setLng(78.04550170898439);
		createpoi.setPoiType("altunloading");
		createpoi.setPoiNickName("tes345");

		return createpoi;

	}
	
	//create trip test data
	public Consigner_trip_parent consignerTripData()
	{
		consignerTripParent = new Consigner_trip_parent();
		
		Consigner_trip consignerTrip = new Consigner_trip();
		
		consignerTrip.setStart_date("2020-09-29 18: 15: 00");
		consignerTrip.setOrigin("NOIDA");
		consignerTrip.setDestination("CHIKHALI TALUKA");
		consignerTrip.setConsigner_name("Test_Consigner");
		consignerTrip.setConsignee_name("SHIV CEMENT ARTICLES");
		consignerTrip.setEta("2020-10-05 14: 15: 00");
		consignerTrip.setTransporter("VIJAYSHRI LOGISTICS LLP");
		consignerTrip.setVehicle_no("V1234567");
		consignerTrip.setDriver_name("NA");
		consignerTrip.setDriver_number("9999999999");
		consignerTrip.setReference_number("1232456094200");
		consignerTrip.setConsigner_code("BHUSHAN");
		consignerTrip.setMaterial("JK Lakshmi OPC 53 (H) - NT");
		consignerTrip.setTransporter_code("JKL_0001100579");
		consignerTrip.setCompany_name("JKL");		
		
		consignerTripParent.setConsigner_trip(consignerTrip);
		
		return consignerTripParent;
		
	}
	
	//create ping test data
	
/*	public Pings_parent createPingData()
	{
		pingsParent = new Pings_parent();
				
		Pings[] pings = new Pings[11];
		
		pings[0].setVehicle_no("TestX1-002");
		pings[1].setTransporter_name("TEST - ASM");
		pings[2].setLatitude("28.531236");
		pings[3].setLongitude("28.531236");
		pings[4].setTimestamp("2020-09-05 16:30:20");
		pings[5].setSpeed("53.74");
		pings[6].setIgnition_status("ON");
		pings[7].setLocation("10.9  Kms   NE  OF SOLAR PLANT");
		pings[8].setBattery_strength("20");
		pings[9].setOdometer_km("12347.73");
		pings[10].setClientCode("<YOUR_CLIENTCODE_UPPERCASE>");

		pingsParent.setPings(pings);
		
		Pings p = new Pings();
		
		p.setVehicle_no("TestX1-002");
		p.setTransporter_name("TEST - ASM");
		p.setLatitude("28.531236");
		p.setLongitude("28.531236");
		p.setTimestamp("2020-09-05 16:30:22");
		p.setSpeed("53.74");
		p.setIgnition_status("ON");
		p.setLocation("10.9  Kms   NE  OF SOLAR PLANT");
		p.setBattery_strength("20");
		p.setOdometer_km("12347.73");
		p.setClientCode("<YOUR_CLIENTCODE_UPPERCASE>");
		
		List<Pings> myList = new ArrayList<Pings>();
		myList.add(p);
		
		pingsParent.setPings(myList);
		
		return pingsParent;
	}	
	*/
	public static String createPingsData()
	{
		return "{\r\n" + 
				"   \"pings\":[\r\n" + 
				"      {\r\n" + 
				"         \"vehicle_no\":\"V1234567\",\r\n" + 
				"         \"transporter_name\":\"TEST - ASM\",\r\n" + 
				"         \"latitude\":28.531236,\r\n" + 
				"         \"longitude\":77.377263,\r\n" + 
				"         \"timestamp\":\"2020-09-30 16:35:00\",\r\n" + 
				"         \"speed\":53.74,\r\n" + 
				"         \"ignition_status\":\"ON\",\r\n" + 
				"         \"location\":\"10.9  Kms   NE  OF SOLAR PLANT\",\r\n" + 
				"         \"battery_strength\":20,\r\n" + 
				"         \"odometer_km\":12347.73,\r\n" + 
				"         \"clientCode\":\"<YOUR_CLIENTCODE_UPPERCASE>\",\r\n" + 
				"         \"sync\":true\r\n" + 
				"      }\r\n" + 
				"   ]\r\n" + 
				"}\r\n" + 
				" ";
	}
	
	//create alert test data
	public Alert_parent createAlertSubscriptionData()
	{
		createAlertSubscription = new Alert_parent();
		createAlertSubscription.setIs_consolidated(false);
		createAlertSubscription.setIs_enabled(false);
		
		Settings settings = new Settings();
		settings.setFrequency(0.5);
		settings.setSpeed(70);
		settings.setInstances(5);
		createAlertSubscription.setSettings(settings);
		
		Providers providers = new Providers();
		providers.setId(4);
		providers.setName("Email");
		providers.setKind("email");
		providers.setCreated_at("2017-12-13T08:11:16.000Z");
		providers.setUpdated_at("2017-12-13T08:11:16.000Z");
		List<Providers> p = new ArrayList<Providers>();
		p.add(providers);	
		createAlertSubscription.setProviders(p);
		
		createAlertSubscription.setProviders(p);
		createAlertSubscription.setAlert_users("null");
		
		New_alert_users new_alert_users = new New_alert_users();
		new_alert_users.setFull_name("Lekha Saikia");
		new_alert_users.setEmail("lekhashree.saikia@getfareye.com");
		new_alert_users.setPhone_no("09654336198");
		new_alert_users.setDesignation("test");
		List<New_alert_users> newAlertUsersList = new ArrayList<New_alert_users>();
		createAlertSubscription.setNew_alert_users(newAlertUsersList);
		
		createAlertSubscription.setType("OverspeedAlertSubscription");
		
		return createAlertSubscription;
		
	}
	public static String createAlertData()
	{
		return "{\r\n" + 
				"   \"is_consolidated\":false,\r\n" + 
				"   \"is_enabled\":false,\r\n" + 
				"   \"settings\":{\r\n" + 
				"      \"speed\":70,\r\n" + 
				"      \"instances\":5,\r\n" + 
				"      \"frequency\":0.5\r\n" + 
				"   },\r\n" + 
				"   \"alert_users\":null,\r\n" + 
				"   \"providers\":[\r\n" + 
				"      {\r\n" + 
				"         \"id\":4,\r\n" + 
				"         \"name\":\"Email\",\r\n" + 
				"         \"kind\":\"email\",\r\n" + 
				"         \"created_at\":\"2017-12-13T08:11:16.000Z\",\r\n" + 
				"         \"updated_at\":\"2017-12-13T08:11:16.000Z\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"new_alert_users\":[\r\n" + 
				"      {\r\n" + 
				"         \"full_name\":\"Test_create_alert\",\r\n" + 
				"         \"email\":\"lekhashree.saikia@getfareye.com\",\r\n" + 
				"         \"phone_no\":\"09654336198\",\r\n" + 
				"         \"designation\":\"test\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"type\":\"OverspeedAlertSubscription\"\r\n" + 
				"}";
	}
	
	public static String addPingsForOverspeedAlertTestData()
	{
		return "{\"pings\":\r\n" + 
				"[\r\n" + 
				"    {\"vehicle_no\":\"TestX1-002\",\r\n" + 
				"    \"transporter_name\":\"TEST - ASM\",\r\n" + 
				"    \"latitude\":28.531236,\r\n" + 
				"    \"longitude\":77.377263,\r\n" + 
				"    \"timestamp\":\"2020-09-06 16:30:43\",\r\n" + 
				"    \"speed\":70.75,\r\n" + 
				"    \"ignition_status\":\"ON\",\r\n" + 
				"    \"location\":\"10.9  Kms   NE  OF SOLAR PLANT\",\r\n" + 
				"    \"battery_strength\":20,\r\n" + 
				"    \"odometer_km\":12347.73,\r\n" + 
				"    \"clientCode\":\"<YOUR_CLIENTCODE_UPPERCASE>\"}\r\n" + 
				"]\r\n" + 
				"    }";
	}
	
}
