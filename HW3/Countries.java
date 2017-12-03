class Countries {
   public String countryName;
   public String latitude;
   public String longitude;
   public int countryArea;
   public int countryPopulation;
   public double countryGDP;
   public int countryYear;

     
   public Countries(String cn, String lat, String lon, int ca, int cp, double cg, int cy){
      this.countryName = cn;
      this.latitude = lat;
      this.longitude = lon;
      this.countryArea = ca;
      this.countryPopulation = cp;
      this.countryGDP = cg;
      this.countryYear = cy;
         }
}
