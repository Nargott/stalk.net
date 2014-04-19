package stalk.net.ua.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

import stalk.net.ua.ejb.CitiesDAO;
import stalk.net.ua.ejb.CountriesDAO;
import stalk.net.ua.ejb.RegionsDAO;
import stalk.net.ua.model.City;
import stalk.net.ua.model.Country;
import stalk.net.ua.model.Region;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Registrator implements Serializable {
	private static final long serialVersionUID = 2445411524555680008L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	private String login;
	private String pass;
	private String passConfirm;
	private String email;
	private String callsign;
	private UploadedFile photo;
	private String legend;
	private String FIO;
	private String dateBorn;
	private String phone;
	private Country country;
	private Region region;
	private City city;
		
	@EJB CountriesDAO countriesDAO;
	@EJB RegionsDAO regionsDAO;
	@EJB CitiesDAO citiesDAO;
	private List<Country> countries;
	private List<Region> regions;
	private List<City> cities;
	
	public List<Country> getCountries() {
		if (countries==null) {return countriesDAO.getCountriesList();}
		else return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	public void handleRegionsChange() {
		logger.info("Registrator:handleRegionsChange() called!");
		if (cities!=null) {cities.clear();}
		if (regions!=null) {regions.clear();}// else regions = new List<Region>;
		if (this.country!=null) {regions = regionsDAO.getRegionsList(this.country);} 
			else {logger.info("Registrator:handleRegionsChange() country is NULL!");}
	}
	
	public void handleCitiesChange() {
		logger.info("Registrator:handleCitiesChange() called!");
		
		if (cities!=null) {cities.clear();}// else regions = new List<Region>;
		if (this.region!=null) {cities = citiesDAO.getCitiesList(this.region);} 
			else {logger.info("Registrator:handleCitiesChange() region is NULL!");}
	}
	
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPassConfirm() {
		return passConfirm;
	}
	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCallsign() {
		return callsign;
	}
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}
	public UploadedFile getPhoto() {
		return photo;
	}
	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}
	public String getLegend() {
		return legend;
	}
	public void setLegend(String legend) {
		this.legend = legend;
	}
	public String getFIO() {
		return FIO;
	}
	public void setFIO(String fIO) {
		FIO = fIO;
	}
	public String getDateBorn() {
		return dateBorn;
	}
	public void setDateBorn(String dateBorn) {
		this.dateBorn = dateBorn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}
