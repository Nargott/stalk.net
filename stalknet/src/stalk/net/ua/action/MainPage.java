package stalk.net.ua.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import stalk.net.ua.ejb.NewsDAO;
import stalk.net.ua.model.New;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class MainPage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB NewsDAO newsDAO; //Подключим наш ДАО-класс

	List<New> newsList;
	
	
	/*public List<New> getNews() { //Метод для получения списка тестов
		logger.info("MainPage:getNews() called!");
		return newsDAO.getListNews(); //Вот так просто :)
	}*/
	
	public List<New> getNewsList() {
		logger.info("MainPage:getNewsList() called!");
		if (newsList!=null) {return newsList;} 
		else {
			setNewsList(newsDAO.getListNews());
			return newsList;
		}
		
	}

	public void setNewsList(List<New> newsList) {
		this.newsList = newsList;
	}

}