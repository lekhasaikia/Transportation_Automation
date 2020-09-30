package pojo;
  public class CreatePoiRequest
    {
        private double radius;

        private double lat;

        private double lng;

        private String poiType;

        private String poiNickName;

        public void setRadius(double radius){
            this.radius = radius;
        }
        public double getRadius(){
            return this.radius;
        }
        public void setLat(double lat){
            this.lat = lat;
        }
        public double getLat(){
            return this.lat;
        }
        public void setLng(double lng){
            this.lng = lng;
        }
        public double getLng(){
            return this.lng;
        }
        public void setPoiType(String poiType){
            this.poiType = poiType;
        }
        public String getPoiType(){
            return this.poiType;
        }
        public void setPoiNickName(String poiNickName){
            this.poiNickName = poiNickName;
        }
        public String getPoiNickName(){
            return this.poiNickName;
        }
    }
