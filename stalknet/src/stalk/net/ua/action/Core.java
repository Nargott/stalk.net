package stalk.net.ua.action;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;  
import org.primefaces.model.menu.DefaultMenuModel;  
import org.primefaces.model.menu.DefaultSubMenu;  
import org.primefaces.model.menu.MenuModel;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Core implements Serializable {

	private static final long serialVersionUID = -8116411976966855458L;
	private static final Logger logger = Logger.getLogger(Core.class.getName());
	
	private String loginName;
	private String pass;
	private String passEnc;
	
	private MenuModel menuModel;
	
	public String loginAction() {
		//String login, String pass
		
		logger.info("loginAction called! LoginName="+loginName);
		this.passEnc=com.nargott.Utils.MD5(loginName);
		//return "/content/testPage.jsp";
		this.genPdaUi();
		return "/templates/tabMenu.jsp";
	}

	public void genPdaUi() {
		menuModel = new DefaultMenuModel();
		
        DefaultMenuItem item = new DefaultMenuItem("External");  
        item.setUrl("http://www.primefaces.org");  
        item.setIcon("ui-icon-home");  
        item.setTitle("External");
        menuModel.addElement(item);
        //menuModel.
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
