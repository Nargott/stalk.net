package net.ua.stalk.action;

import java.io.*;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.primefaces.model.menu.*;

import ua.stalk.net.ejb.EventsDAO;
import ua.stalk.net.ejb.UsersDAO;
import ua.stalknet.model.User;

@ManagedBean
@SessionScoped
public class Core implements Serializable {

	private static final long serialVersionUID = -8116411976966855458L;
	private static final Logger logger = Logger.getLogger(Core.class.getName());

	@EJB UsersDAO userDAO;
	@EJB EventsDAO eventsDAO;
	
	private User user = null;
	private User selUser = new User();
	private List<User> usersList;
	
	private String login = "";
	private String pass = "";
	
	private MenuModel menuModel;
	
	private Locale locale;
	
	private Boolean isRegistrationAvailable = false;
	
	@PostConstruct
	public void InitCore() {
		locale = new Locale("ru","RU");	
	}
	
	public String testAction() throws Exception {
		ServletContext servletContext = (ServletContext) FacesContext
			    .getCurrentInstance().getExternalContext().getContext();
		return servletContext.getRealPath(" ") + File.separator;
	}
	
	public String loginAction() throws Exception {
		//String login, String pass
		user = new User();
		BasicConfigurator.configure();
		logger.info("loginAction called! LoginName ="+this.user.getLogin());
		setUser(userDAO.getUser(login, com.nargott.Utils.MD5(pass)));
		//setUser(usersDAO.getListUsers().get(11));
		if (this.user!=null) {
			logger.info("user "+user.getLogin());
			genMenu();
			setUsersList(userDAO.getListUsers());
			setSelUser(this.user);
			//return "/templates/menuBar.jsp";
			return "/content/main.jsf";
		} else {
			setUser(null);
			return "/content/main.jsf";
		}
	}
	
	public String regAction() throws Exception {
		return "/content/register.jsf";
	}
	
	public void fiscal() {
		if (user==null) this.logout(); //else logger.info("user name is "+user.getId()); 
	}
	
	public String logout(){
		logger.info("logout() action");
		//loggedIn = false;
		user = null;
		String retUrl = "/stalknet";
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();	 // Or whatever servlet mapping you use
	    try {
			ec.redirect(retUrl);  
		} catch (IOException e) {
			logger.info("logout redirect exception!" + e.toString());
		}
	    return retUrl;
	}
	
	public String getMD5(String str) {
		String res = com.nargott.Utils.MD5(str);
		return res;
	}
	
	public void genMenu() {
		this.menuModel = new DefaultMenuModel();
        
		DefaultMenuItem item = new DefaultMenuItem("Главная");  
        item.setUrl("/content/main.jsf");  
        item.setIcon("ui-icon-home");
        this.menuModel.addElement(item);
        
        item = new DefaultMenuItem("Профиль");  
        item.setUrl("/content/profile.jsf");  
        item.setIcon("ui-icon-person");
        this.menuModel.addElement(item);
        
        item = new DefaultMenuItem("События");  
        item.setUrl("/content/events.jsf");  
        item.setIcon("ui-icon-star");
        this.menuModel.addElement(item);
        
        /*item = new DefaultMenuItem("Игроки");  
        item.setUrl("/content/users.jsf");  
        item.setIcon("ui-icon-star");
        this.menuModel.addElement(item);*/
        
        /*item = new DefaultMenuItem("Задания");  
        item.setUrl("/content/quests.jsf");  
        item.setIcon("ui-icon-note");
        this.menuModel.addElement(item);*/
        
        /*item = new DefaultMenuItem("Карта");  
        item.setUrl("/content/map.jsf");  
        item.setIcon("ui-icon-image");
        this.menuModel.addElement(item);*/
        
        item = new DefaultMenuItem("Выход");  
        item.setAjax(false);
        item.setCommand("#{core.logout()}");
        item.setIcon("ui-icon-power");
        this.menuModel.addElement(item);  
        
        logger.info("Element is added! "+menuModel.getElements().size());
		
	}
	
	public MenuModel getMenuModel() {  
        return menuModel;  
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public int getUsersListSize() {
		return this.usersList.size();
	}
	
	public User getSelUser() {
		return selUser;
	}

	public void setSelUser(User selUser) {
		this.selUser = selUser;
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Boolean getIsRegistrationAvailable() {
		logger.info("getIsRegistrationAvailable() called!");
		/*if (eventsDAO!=null) if (eventsDAO.checkIsRegistrationOpened()) {this.setIsRegistrationAvailable(true);}
			else {this.setIsRegistrationAvailable(false);}*/
		
		this.setIsRegistrationAvailable(true); //TODO this is hook
		return isRegistrationAvailable;
	}

	public void setIsRegistrationAvailable(Boolean isRegistrationAvailable) {
		this.isRegistrationAvailable = isRegistrationAvailable;
	}
	
	
		
}
