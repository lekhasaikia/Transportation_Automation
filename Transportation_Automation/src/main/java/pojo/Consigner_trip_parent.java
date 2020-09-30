package pojo;

public class Consigner_trip_parent {
    private Consigner_trip consigner_trip;

    public Consigner_trip getConsigner_trip ()
    {
        return consigner_trip;
    }

    public void setConsigner_trip (Consigner_trip consigner_trip)
    {
        this.consigner_trip = consigner_trip;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [consigner_trip = "+consigner_trip+"]";
    }
}
