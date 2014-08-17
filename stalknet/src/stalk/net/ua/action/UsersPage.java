package stalk.net.ua.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import stalk.net.ua.ejb.UsersDAO;
import stalk.net.ua.model.User;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class UsersPage implements Serializable {
	private static final long serialVersionUID = -5147686119510554487L;
	
	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB UsersDAO dao; //Подключим наш ДАО-класс
	
	User u;
	
	public List<User> getUsers() { //Метод для получения списка тестов
		logger.info("UsersPage:getUsers() called!");
		return dao.getListUsers(); //Вот так просто :)
		
		
	}
}
