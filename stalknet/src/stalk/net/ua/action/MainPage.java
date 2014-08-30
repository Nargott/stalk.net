package stalk.net.ua.action;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import stalk.net.ua.ejb.EventsDAO;
import stalk.net.ua.ejb.NewsDAO;
import stalk.net.ua.model.Event;
import stalk.net.ua.model.Tiding;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class MainPage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB NewsDAO newsDAO;
	@EJB EventsDAO eventsDAO;

	List<Tiding> newsList;
	Event lastEvent;
	
	/*public List<New> getNews() { //Метод для получения списка тестов
		logger.info("MainPage:getNews() called!");
		return newsDAO.getListNews(); //Вот так просто :)
	}*/
	
	public String getEventTime(Event e) {
		logger.info("MainPage:getEventTime called!");
		SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return "Начало игры: " + formatter.format(e.getDateStart()) + " <BR /> Окончание игры: " + formatter.format(e.getDateEnd());
	}
	
	public List<Tiding> getNewsList() {
		logger.info("MainPage:getNewsList() called!");
		if (newsList==null)	setNewsList(newsDAO.getListNews());
		return newsList;
	}

	public void setNewsList(List<Tiding> newsList) {
		this.newsList = newsList;
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