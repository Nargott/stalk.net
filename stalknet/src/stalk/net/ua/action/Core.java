package stalk.net.ua.action;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Core implements Serializable {

	private static final long serialVersionUID = -8116411976966855458L;
	private static final Logger logger = Logger.getLogger(Core.class.getName());
	
	private String loginName;
	private String pass;
	private String passEnc;
	
	public String loginAction() {
		//String login, String pass
		
		logger.info("loginAction called! LoginName="+loginName);
		this.passEnc=com.nargott.Utils.MD5(loginName);
		return "/content/testPage.jsp";
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
	
	

}
