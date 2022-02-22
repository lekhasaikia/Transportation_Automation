package temp;
  public class CreatePoiRequestPayload
    {
        private double radius;

        private double lat;

        private double lng;

        private String poiType;

        private String poiNickName;

        public void setRadius(double d){
            this.radius = d;
        }
        public double getRadius(){
            return this.radius;
        }
        public void setLat(double d){
            this.lat = d;
        }
        public double getLat(){
            return this.lat;
        }
        public void setLng(double d){
            this.lng = d;
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
