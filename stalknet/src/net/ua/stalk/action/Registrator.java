package net.ua.stalk.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import ua.stalk.net.ejb.CitiesDAO;
import ua.stalk.net.ejb.CountriesDAO;
import ua.stalk.net.ejb.EventsDAO;
import ua.stalk.net.ejb.FractionsDAO;
import ua.stalk.net.ejb.RegionsDAO;
import ua.stalk.net.ejb.StalkersDAO;
import ua.stalk.net.ejb.UsersDAO;
import ua.stalknet.model.City;
import ua.stalknet.model.Country;
import ua.stalknet.model.Event;
import ua.stalknet.model.Fraction;
import ua.stalknet.model.Region;
import ua.stalknet.model.Stalker;
import ua.stalknet.model.User;

import com.nargott.Utils;

@ManagedBean 
@SessionScoped
public class Registrator implements Serializable {
	private static final long serialVersionUID = 2445411524555680008L;

	private static final Logger logger = Logger.getLogger(Registrator.class.getName());
	
	/*private String login;
	private String pass;
	private String passConfirm;
	/*private String email;*/
	private String callsign;
	private UploadedFile photo;
	/*private String legend;
	private String FIO;
	private String dateBorn;
	private String phone;*/
	private Country country;
	private Region region;
	private City city;
	private Fraction fraction;
	
	private Boolean allFine = false;
	
	private User newUser;
	private Stalker newStalker;
	
	@EJB CountriesDAO countriesDAO;
	@EJB RegionsDAO regionsDAO;
	@EJB CitiesDAO citiesDAO;
	@EJB UsersDAO usersDAO;
	@EJB StalkersDAO stalkersDAO;
	@EJB FractionsDAO fractionsDAO;
	@EJB EventsDAO eventsDAO;
	private List<Country> countries;
	private List<Region> regions;
	private List<City> cities;
	private List<Fraction> fractions;
	
	private Event lastEvent;
	
	public void clean() {
		newUser = new User();
		newStalker = new Stalker();
		callsign = "";
		country = countriesDAO.getCountriesList().get(0); //По-умолчанию используем первую страну, Украину.
		region = new Region(); 
		if (this.country!=null) {regions = regionsDAO.getRegionsList(this.country);} 
			else {logger.info("Registrator:handleRegionsChange() country is NULL!");}
		city = new City();
	}
	
	public List<Country> getCountries() {
		if (countries==null) {return countriesDAO.getCountriesList();}
		else return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	public void handleRegionsChange() {
		if (cities!=null) {cities.clear();}
		if (regions!=null) {regions.clear();}// else regions = new List<Region>;
		if (this.country!=null) {regions = regionsDAO.getRegionsList(this.country);} 
			else {logger.info("Registrator:handleRegionsChange() country is NULL!");}
	}
	
	public void handleCitiesChange() {
		if (cities!=null) {cities.clear();}// else regions = new List<Region>;
		if (this.region!=null) {cities = citiesDAO.getCitiesList(this.region);} 
			else {logger.info("Registrator:handleCitiesChange() region is NULL!");}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(File.createTempFile("temp-file-name"+event.getFile().getFileName(), ""));
            logger.info("Registrator:handleFileUpload() getFileName()");
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String register() {
		logger.info("login = "+newUser.getLogin());
		String notCrypted = Utils.genPass(com.nargott.PasswordStrength.MEDIUM,8);
		newUser.setPass(Utils.MD5(notCrypted));
		logger.info("pass = "+newUser.getPass());
		//logger.info("passConfirm = "+passConfirm);
		logger.info("email = "+newUser.getEmail());
		logger.info("callsign = "+callsign);
		if (photo!=null) {
			try {
	            File targetFolder = new File(System.getProperty("catalina.base")+"/eclipseApps/stalknet/resources/img/photos");
	            InputStream inputStream = photo.getInputstream();
	            OutputStream out = new FileOutputStream(new File(targetFolder, com.nargott.Utils.MD5(newUser.getLogin())+"-photo.jpg"));
	            int read = 0;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            }
	            inputStream.close();
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			logger.info("photo = "+photo.getFileName());
		}
		logger.info("legend = "+newUser.getDescription());
		logger.info("FIO = "+newUser.getFio());
		logger.info("dateBorn = "+newUser.getBirthdate().toString());
		logger.info("phone = "+newUser.getPhone());
		logger.info("country = "+country.getName());
		logger.info("region = "+region.getName());
		newUser.setCity(city);
		logger.info("city = "+newUser.getCity().getName());
		if (!usersDAO.isUserExistsByLogin(newUser.getLogin())) {
			logger.info("All fine! Try to add new user...");
			newUser.setCreated(new Date());
			newStalker.setActive(true);
			newStalker.setUser(newUser);
			if (stalkersDAO.add(newStalker)) {
				logger.info("New user ("+newUser.getLogin()+") sucessfully added!");
				//user = usersDAO.getUser(newUser.getLogin(), newUser.getPass());
				logger.info("New stalker ("+newStalker.getCallsign()+") sucessfully added!");
			}
		} else {logger.warning("User "+newUser.getLogin()+" is exists already in db!");}
		
		//newUser.getStalkers();
		//newStalker.setId(null);
		//usersDAO.addUser(newUser);
		
		//newUser.addStalker(newStalker);
		
		
		String msgText = "Вы (или кто-то другой) указали этот адрес e-mail при регистрации на сайте stalk.net.ua . \n "
						 +"Ваш логин для входа: "+newUser.getLogin()+" \n"
						 +"Ваш пароль для входа: "+notCrypted+" \n \n"
						 +"Спокойной Зоны тебе, Сталкер!";				
		if (Utils.SendMail(newUser.getEmail(), "Регистрация в STALKNET", msgText)) {} else {}
		return "/content/message.jsf";
	}
	
	public void validateLogin(FacesContext context, 
								UIComponent toValidate, Object value) {
	  
	  String message = "";
	  String login = (String) value;
	  if (usersDAO.isUserExistsByLogin(login)) {
	    ((UIInput)toValidate).setValid(false);
	    message = "Такой пользователь уже существует!";
	    context.addMessage(toValidate.getClientId(context),
	      new FacesMessage(message));
	  }
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

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public Boolean getAllFine() {
		return allFine;
	}

	public void setAllFine(Boolean allFine) {
		this.allFine = allFine;
	}

	public List<Fraction> getFractions() {
		if ((fractions == null) || (fractions.size()<1)) {
			fractions = fractionsDAO.getFractionsList();
		}
		return fractions;
	}

	public void setFractions(List<Fraction> fractions) {
		this.fractions = fractions;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public Stalker getNewStalker() {
		return newStalker;
	}

	public void setNewStalker(Stalker newStalker) {
		this.newStalker = newStalker;
	}

	public Event getLastEvent() {
		logger.info("MainPage:getLastEvent() called!");
		if (lastEvent==null) setLastEvent(eventsDAO.getLastActiveEvent());
		return lastEvent;
	}

	public void setLastEvent(Event lastEvent) {
		this.lastEvent = lastEvent;
	}
	
	
	
}
