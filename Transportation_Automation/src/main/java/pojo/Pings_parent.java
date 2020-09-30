package pojo;

import java.util.List;

public class Pings_parent {

	  /* private Pings[] pings;

	    public Pings[] getPings ()
	    {
	        return pings;
	    }

	    public void setPings (Pings[] pings)
	    {
	        this.pings = pings;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [pings = "+pings+"]";
	    }*/
	
	
	private List<Pings> pings;

	public List<Pings> getPings() {
		return pings;
	}

	public void setPings(List<Pings> pings) {
		this.pings = pings;
	}

	
}
