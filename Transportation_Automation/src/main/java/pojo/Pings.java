package pojo;

public class Pings {
	
		private String odometer_km;

	    private String transporter_name;

	    private String battery_strength;

	    private String clientCode;

	    private String vehicle_no;

	    private String latitude;

	    private String location;

	    private String ignition_status;

	    private String speed;

	    private String longitude;

	    private String timestamp;

	    public String getOdometer_km ()
	    {
	        return odometer_km;
	    }

	    public void setOdometer_km (String odometer_km)
	    {
	        this.odometer_km = odometer_km;
	    }

	    public String getTransporter_name ()
	    {
	        return transporter_name;
	    }

	    public void setTransporter_name (String transporter_name)
	    {
	        this.transporter_name = transporter_name;
	    }

	    public String getBattery_strength ()
	    {
	        return battery_strength;
	    }

	    public void setBattery_strength (String battery_strength)
	    {
	        this.battery_strength = battery_strength;
	    }

	    public String getClientCode ()
	    {
	        return clientCode;
	    }

	    public void setClientCode (String clientCode)
	    {
	        this.clientCode = clientCode;
	    }

	    public String getVehicle_no ()
	    {
	        return vehicle_no;
	    }

	    public void setVehicle_no (String vehicle_no)
	    {
	        this.vehicle_no = vehicle_no;
	    }

	    public String getLatitude ()
	    {
	        return latitude;
	    }

	    public void setLatitude (String latitude)
	    {
	        this.latitude = latitude;
	    }

	    public String getLocation ()
	    {
	        return location;
	    }

	    public void setLocation (String location)
	    {
	        this.location = location;
	    }

	    public String getIgnition_status ()
	    {
	        return ignition_status;
	    }

	    public void setIgnition_status (String ignition_status)
	    {
	        this.ignition_status = ignition_status;
	    }

	    public String getSpeed ()
	    {
	        return speed;
	    }

	    public void setSpeed (String speed)
	    {
	        this.speed = speed;
	    }

	    public String getLongitude ()
	    {
	        return longitude;
	    }

	    public void setLongitude (String longitude)
	    {
	        this.longitude = longitude;
	    }

	    public String getTimestamp ()
	    {
	        return timestamp;
	    }

	    public void setTimestamp (String timestamp)
	    {
	        this.timestamp = timestamp;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [odometer_km = "+odometer_km+", transporter_name = "+transporter_name+", battery_strength = "+battery_strength+", clientCode = "+clientCode+", vehicle_no = "+vehicle_no+", latitude = "+latitude+", location = "+location+", ignition_status = "+ignition_status+", speed = "+speed+", longitude = "+longitude+", timestamp = "+timestamp+"]";
	    }

}
