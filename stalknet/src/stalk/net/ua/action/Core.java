package stalk.net.ua.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;  
import org.primefaces.model.menu.DefaultMenuModel;  
import org.primefaces.model.menu.MenuModel;

import stalk.net.ua.model.User;
import stalk.net.ua.ejb.UsersDAO;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Core implements Serializable {

	private static final long serialVersionUID = -8116411976966855458L;
	private static final Logger logger = Logger.getLogger(Core.class.getName());

	@EJB UsersDAO userDAO;
	
	private User user = new User();
	private User selUser = new User();
	private List<User> usersList;
	
	private String login = "";
	private String pass = "";
	
	private MenuModel menuModel;
	
	public String loginAction() throws Exception {
		//String login, String pass
		logger.info("loginAction called! LoginName ="+this.user.getName());
		setUser(userDAO.getUser(login, com.nargott.Utils.MD5(pass)));
		//setUser(usersDAO.getListUsers().get(11));
		if (this.user!=null) {
			logger.info("user "+user.getName());
			genMenu();
			setUsersList(userDAO.getListUsers());
			setSelUser(this.user);
			//return "/templates/menuBar.jsp";
			return "/content/users.jsp";
		} else {
			return "/content/login.jsp";
		}
	}

	public void genMenu() {
		this.menuModel = new DefaultMenuModel();
          
        DefaultMenuItem item = new DefaultMenuItem("Профиль");  
        item.setUrl("http://www.primefaces.org");  
        item.setIcon("ui-icon-home");
        this.menuModel.addElement(item);
        item = new DefaultMenuItem("Игроки");  
        item.setUrl("http://www.primefaces.org");  
        item.setIcon("ui-icon-person");
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
	
		
	
}
