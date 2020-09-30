Feature: Validating create POI APIs 

@CreatePOI
Scenario: Verify if poi is successfully created when we hit create_poi api with POST http request
	Given  add_poi api payload 
	When user calls "AddPoiAPI" with "POST" http request 
	Then api call got succeeded with status code 200 
	And verify that "latitude" in response body should be 27.1907860
	And verify that "longitude" in response body should be 78.04550
	And verify that "radius" in response body should be 0.46
	And verify that "poiType" in response body should be "altunloading"
	And verify that "poiNickName" in response body should be "tes345"
	
@GetPOI	
Scenario: Verify if poi is successfully retrieved when we hit get_poi api with GET http request
	Given  get_poi api 
	When user calls "GetPoiAPI" with "GET" http request 
	Then api call got succeeded with status code 200 
	And verify that value of hierarchy "content" "pois" "1230905" "latitude" in response body should be 28.572567
	And verify that value of hierarchy "content" "pois" "1230905" "longitude" in response body should be 77.35505
	And verify that value of hierarchy "content" "pois" "1230905" "radius" in response body should be 0.09
	