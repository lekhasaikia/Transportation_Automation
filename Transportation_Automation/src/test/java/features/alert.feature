Feature: Validating alert APIs 

##################################################################
# Prerequisite : Add Overspeed Alert on UI for:                  # 
#                user : "Lekha" 	                  			 #
#				 speed : 50.0                                    #
#				 frequency: 0.5		                             #		   	
# url : https://ta-qa.fareye.co/alert				             #	
##################################################################
@AddAlert
Scenario: Verify if alerts are being successfully retrived when we hit GetAlertAPI with GET http request 
	Given get_alert_api 
	When user calls "GetAlertAPI" with "GET" http request
	Then api call got succeeded with status code 200
	And "success" in response body should be "true"
	And alert username "Lekha" should be visible in response body 
	
@CreateAlertSubscription	
Scenario: Verify if alert is successfully created when we hit CreateAlertSubscriptionAPI with POST http request 
	Given create_alert_subscription_api 
	When user calls "CreateAlertSubscriptionAPI" with "POST" http request
	Then api call got succeeded with status code 200
	And "success" in response body should be "true"
	
@AddPings
Scenario: Verify if ping is successfully created when we hit create_ping_api with POST http request 	
	Given create_pings_for_overspeed_alert api payload 
	When user calls "CreatePingsAPI" with "POST" http request
	Then api call got succeeded with status code 200
	And "success" in response body should be "true"	
	
#Prerequisite : Run @CreateAlertSubscription with "full_name":"Test_create_alert" under "new_alert_users"	
@GetOverspeedAlertReport
Scenario: Verify if Overspeed alert report is getting generated when we hit CreateAlertSubscriptionAPI with POST http request 
	Given get_overspeed_alert_api 
	When user calls "GetOverspeedAlertReportAPI" with "GET" http request
	Then api call got succeeded with status code 200
	And "success" in response body should be "true"	
	And full_name should be "Test_create_alert" in response body 
	
	