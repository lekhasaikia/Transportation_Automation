package resources;

public enum APIResources {

	AddPoiAPI("/api/v2/pois"),
	GetPoiAPI("/api/v2/pois"),
	
	CreateTripAuthAPI("/api/v1/consigner/authentication"),
	CreateTripAPI("/api/v1/consigner_trips/fareye_trip_create"),
	
	//CreatePingsAPI("/trucks/fareye/gpsTrackPost"),
	CreatePingsAPI("/fareye/real-time-gpsTrackPost"),
	GetPingsAPI("/truck_histories/duration_based"),
	
	GetWaypointReportAPI("/api/v2/reports/way_point"),
	
	GetAlertAPI("/api/v1/alert_users"),
	CreateAlertSubscriptionAPI("/api/v1/alert_subscriptions"),
	GetOverspeedAlertReportAPI("/api/v1/alert_subscriptions");
	
	
	
	
	private String resource; 
	private APIResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
