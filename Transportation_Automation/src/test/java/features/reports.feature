Feature: Validating Report APIs 

#Login by consigner and generate authentication token
#################################################################
#   Prerequisite : Create a consigner from UI	               		#
#             url: https://tpt-qa.fareye.co 						     		#	
#							credentials : vaibhav@usedipper.com /vaibhav123 	#	
#																									       				#				
#################################################################
@CreateTripAuth
Scenario Outline: Verify if auth_token is successfully generated when we hit create_trip_auth api with POST http request
	Given create_trip_auth api payload with param "<email>" "<password>"
	When user calls "CreateTripAuthAPI" with "POST" http request
	Then api call got succeeded with status code 200 
	And "authToken" should be generated successfully 
	
Examples:
	|email                           |password|		
	|lekhashree.saikia@getfareye.com |Test@123|
	
	
#Create trip with generated authentication token	
##################################################################
# 	Prerequisite : 																							 #	
#		1.Reference_number or invoice no should be unique in payload #
#		2.Vehicle no should be same with Create pings payload        #
##################################################################
@CreateTrip 
Scenario: Verify if trip is successfully created when we hit create_trip_api with POST http request 
	Given create_trip api payload with bearer token generated in create_trip_auth api 
	When user calls "CreateTripAPI" with "POST" http request
	Then api call got succeeded with status code 201
	And "success" in response body should be "true"
	And "message" in response body should be "Created"



#Create pings	
##################################################################
# 	Prerequisite : 																							 #	
#								1.Execute @CreateTrip														 #	
#								2.Timestamps should be unique everytime					 #	
#								3.Vehicle no should be same with @CreateTrip     #
##################################################################
@CreatePings
Scenario: Verify if ping is successfully created when we hit create_ping_api with POST http request 	
	Given create_pings api payload 
	When user calls "CreatePingsAPI" with "POST" http request
	Then api call got succeeded with status code 200
	And "success" in response body should be "true"
	
#Get pings and Validate pings on WayPoint report
##################################################################
#		Prerequisite : 																							 #	
#								1.Execute @CreatePings		     									 #	
#								2.start_date, end_date, vehicle_no should be     #
#								same with @CreateTrip	                  				 #							 																											 #	
##################################################################
@GetPings
Scenario Outline: Verify if pings are successfully retrieved when we hit get_ping_api with GET http request 
	Given get_ping_api with param "<start_date>" "<end_date>" "<vehicle_no>"
	When user calls "GetPingsAPI" with "GET" http request 
	Then api call got succeeded with status code 200
Examples:
	|start_date             |end_date               |vehicle_no   |
	|2020-09-29%2000:00:00  |2020-09-30%2000:00:00  |V1234567     |
	

@GetWaypointReport
Scenario: Verify if trip details are successfully retrieved when we hit get_waypoint_report api with GET http request
	Given  get_waypoint_report api 
	When user calls "GetWaypointReportAPI" with "GET" http request 
	Then api call got succeeded with status code 200 
	And verify that latitude in hierarchy "content" "latitude" should be reflected in response body 
	And verify that longitude in hierarchy "content" "longitude" should be reflected in response body 
	
		
	
	
	