package pojo_alert;

public class Settings {
	 private int speed;

	    private int instances;

	    private double frequency;

	    public void setSpeed(int speed){
	        this.speed = speed;
	    }
	    public int getSpeed(){
	        return this.speed;
	    }
	    public void setInstances(int instances){
	        this.instances = instances;
	    }
	    public int getInstances(){
	        return this.instances;
	    }
	    public void setFrequency(double frequency){
	        this.frequency = frequency;
	    }
	    public double getFrequency(){
	        return this.frequency;
	    }	 
}
