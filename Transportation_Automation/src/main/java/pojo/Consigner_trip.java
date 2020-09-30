package pojo;

public class Consigner_trip {
	

    private String driver_number;

    private String consigner_name;

    private String origin;

    private String consignee_name;

    private String vehicle_no;

    private String destination;

    private String reference_number;

    private String driver_name;

    private String eta;

    private String material;

    private String consigner_code;

    private String transporter_code;

    private String transporter;

    private String company_name;

    private String start_date;

    public String getDriver_number ()
    {
        return driver_number;
    }

    public void setDriver_number (String driver_number)
    {
        this.driver_number = driver_number;
    }

    public String getConsigner_name ()
    {
        return consigner_name;
    }

    public void setConsigner_name (String consigner_name)
    {
        this.consigner_name = consigner_name;
    }

    public String getOrigin ()
    {
        return origin;
    }

    public void setOrigin (String origin)
    {
        this.origin = origin;
    }

    public String getConsignee_name ()
    {
        return consignee_name;
    }

    public void setConsignee_name (String consignee_name)
    {
        this.consignee_name = consignee_name;
    }

    public String getVehicle_no ()
    {
        return vehicle_no;
    }

    public void setVehicle_no (String vehicle_no)
    {
        this.vehicle_no = vehicle_no;
    }

    public String getDestination ()
    {
        return destination;
    }

    public void setDestination (String destination)
    {
        this.destination = destination;
    }

    public String getReference_number ()
    {
        return reference_number;
    }

    public void setReference_number (String reference_number)
    {
        this.reference_number = reference_number;
    }

    public String getDriver_name ()
    {
        return driver_name;
    }

    public void setDriver_name (String driver_name)
    {
        this.driver_name = driver_name;
    }

    public String getEta ()
    {
        return eta;
    }

    public void setEta (String eta)
    {
        this.eta = eta;
    }

    public String getMaterial ()
    {
        return material;
    }

    public void setMaterial (String material)
    {
        this.material = material;
    }

    public String getConsigner_code ()
    {
        return consigner_code;
    }

    public void setConsigner_code (String consigner_code)
    {
        this.consigner_code = consigner_code;
    }

    public String getTransporter_code ()
    {
        return transporter_code;
    }

    public void setTransporter_code (String transporter_code)
    {
        this.transporter_code = transporter_code;
    }

    public String getTransporter ()
    {
        return transporter;
    }

    public void setTransporter (String transporter)
    {
        this.transporter = transporter;
    }

    public String getCompany_name ()
    {
        return company_name;
    }

    public void setCompany_name (String company_name)
    {
        this.company_name = company_name;
    }

    public String getStart_date ()
    {
        return start_date;
    }

    public void setStart_date (String start_date)
    {
        this.start_date = start_date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [driver_number = "+driver_number+", consigner_name = "+consigner_name+", origin = "+origin+", consignee_name = "+consignee_name+", vehicle_no = "+vehicle_no+", destination = "+destination+", reference_number = "+reference_number+", driver_name = "+driver_name+", eta = "+eta+", material = "+material+", consigner_code = "+consigner_code+", transporter_code = "+transporter_code+", transporter = "+transporter+", company_name = "+company_name+", start_date = "+start_date+"]";
    }


}
