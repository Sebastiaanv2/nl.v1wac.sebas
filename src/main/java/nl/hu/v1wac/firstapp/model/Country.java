package nl.hu.v1wac.firstapp.model;

public class Country {
	private String iso2Code;
	private String iso3Code;
	private String name;
	private String capital;
	private String continent;
	private String region;
	private double surface;
	private int population;
	private String government;
	private double latitude;
	private double longitude;
	
	public Country(String iso2cd, String iso3cd, String nm, String cap, String ct, String reg, double sur, int pop, String gov, double lat, double lng) {
		iso2Code = iso2cd;
		iso3Code = iso3cd;
		name = nm;
		capital = cap;
		continent = ct;
		region = reg;
		surface = sur;
		population = pop;
		government = gov;
		latitude = lat;
		longitude = lng;
	}

	@Override
	public String toString() {
		return "Country{" +
				"iso2Code='" + iso2Code + '\'' +
				", iso3Code='" + iso3Code + '\'' +
				", name='" + name + '\'' +
				", capital='" + capital + '\'' +
				", continent='" + continent + '\'' +
				", region='" + region + '\'' +
				", surface=" + surface +
				", population=" + population +
				", government='" + government + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}

	public Country(String code, String name, String continent, String region, double surface, int population, String governmentForm) {
	    this.iso2Code = code;
	    this.name = name;
	    this.continent = continent;
	    this.region = region;
	    this.surface = surface;
	    this.population = population;
	    this.government = governmentForm;
    }

	public Country(String iso2Code, String name, String capital, String continent, String region, double surface, int population, String government, double latitude, double longitude) {
		this.iso2Code = iso2Code;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
		this.region = region;
		this.surface = surface;
		this.population = population;
		this.government = government;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Country(){
    }

    public Country(String iso2Code){
		this.iso2Code = iso2Code;
	}

	public void setIso2Code(String iso2Code) {
		this.iso2Code = iso2Code;
	}

	public void setIso3Code(String iso3Code) {
		this.iso3Code = iso3Code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCode() {
		return iso2Code;
	}
	
	public String getIso3Code() {
		return iso3Code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getRegion() {
		return region;
	}
	
	public double getSurface() {
		return surface;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public String getGovernment() {
		return government;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
