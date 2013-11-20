package stalk.net.ua.action;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Login implements Serializable {

	private static final long serialVersionUID = -8116411976966855458L;
	private static final Logger logger = Logger.getLogger(Login.class.getName());
	
	private String loginName;
	private String pass;
	
	public String loginAction() {
		//String login, String pass
		
		logger.info("loginAction called! LoginName="+loginName);
		
		return "/content/users.jsp";
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
	
	

}
