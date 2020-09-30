package pojo_alert;

public class Providers {
		private int id;

	    private String name;

	    private String kind;

	    private String created_at;

	    private String updated_at;

	    public void setId(int id){
	        this.id = id;
	    }
	    public int getId(){
	        return this.id;
	    }
	    public void setName(String name){
	        this.name = name;
	    }
	    public String getName(){
	        return this.name;
	    }
	    public void setKind(String kind){
	        this.kind = kind;
	    }
	    public String getKind(){
	        return this.kind;
	    }
	    public void setCreated_at(String created_at){
	        this.created_at = created_at;
	    }
	    public String getCreated_at(){
	        return this.created_at;
	    }
	    public void setUpdated_at(String updated_at){
	        this.updated_at = updated_at;
	    }
	    public String getUpdated_at(){
	        return this.updated_at;
	    }
}
