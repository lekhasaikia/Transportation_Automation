package pojo_alert;

import java.util.List;

public class Alert_parent {
	private boolean is_consolidated;

    private boolean is_enabled;

    private Settings settings;

    private String alert_users;

    private List<Providers> providers;

    private List<New_alert_users> new_alert_users;

    private String type;

    public void setIs_consolidated(boolean is_consolidated){
        this.is_consolidated = is_consolidated;
    }
    public boolean getIs_consolidated(){
        return this.is_consolidated;
    }
    public void setIs_enabled(boolean is_enabled){
        this.is_enabled = is_enabled;
    }
    public boolean getIs_enabled(){
        return this.is_enabled;
    }
    public void setSettings(Settings settings){
        this.settings = settings;
    }
    public Settings getSettings(){
        return this.settings;
    }
    public void setAlert_users(String alert_users){
        this.alert_users = alert_users;
    }
    public String getAlert_users(){
        return this.alert_users;
    }
    public void setProviders(List<Providers> providers){
        this.providers = providers;
    }
    public List<Providers> getProviders(){
        return this.providers;
    }
    public void setNew_alert_users(List<New_alert_users> new_alert_users){
        this.new_alert_users = new_alert_users;
    }
    public List<New_alert_users> getNew_alert_users(){
        return this.new_alert_users;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }	
}
