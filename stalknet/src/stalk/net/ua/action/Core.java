package stalk.net.ua.action;

import java.io.Serializable;
import java.util.logging.Logger;

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
	
	private User user;
	private UsersDAO userDAO;
	private String loginName;
	private String pass;
	private String passEnc;
	
	private MenuModel menuModel;
	public String loginAction() throws Exception {
		//String login, String pass
		logger.info("loginAction called! LoginName="+loginName);
		this.passEnc=com.nargott.Utils.MD5(pass);
		userDAO = new UsersDAO();
		user=userDAO.getUser(loginName, com.nargott.Utils.MD5(pass));
		if (user!=null) {logger.info("user "+user.getName());}
		//return "/content/testPage.jsp";
		genPdaUi();
		return "/templates/menuBar.jsp";
	}

	public void genPdaUi() {
		this.menuModel = new DefaultMenuModel();
		
        //First submenu  
          
        DefaultMenuItem item = new DefaultMenuItem("Профиль");  
        item.setUrl("http://www.primefaces.org");  
        item.setIcon("ui-icon-home");
        this.menuModel.addElement(item);
        item = new DefaultMenuItem("Игроки");  
        item.setUrl("http://www.primefaces.org");  
        item.setIcon("ui-icon-person");
        this.menuModel.addElement(item);
          
        //Second submenu  
        /*DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");  
  
        item = new DefaultMenuItem("Save");  
        item.setIcon("ui-icon-disk");  
        item.setCommand("#{menuBean.save}");  
        item.setUpdate("messages");  
        secondSubmenu.addElement(item);  
          
        item = new DefaultMenuItem("Delete");  
        item.setIcon("ui-icon-close");  
        item.setCommand("#{menuBean.delete}");  
        item.setAjax(false);  
        secondSubmenu.addElement(item);  
          
        item = new DefaultMenuItem("Redirect");  
        item.setIcon("ui-icon-search");  
        item.setCommand("#{menuBean.redirect}");  
        secondSubmenu.addElement(item);  
  
        menuModel.addElement(secondSubmenu);*/
        logger.info("Element is added! "+menuModel.getElements().size());
        //this.menuModel.addElement(item);
		
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassEnc() {
		return passEnc;
	}

	public void setPassEnc(String passEnc) {
		this.passEnc = passEnc;
	}
	
	public MenuModel getMenuModel() {  
        return menuModel;  
    }

}
