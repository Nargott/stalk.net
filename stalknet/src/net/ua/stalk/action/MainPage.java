package net.ua.stalk.action;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.*;

import ua.stalk.net.ejb.*;
import ua.stalknet.model.*;

@ManagedBean
@SessionScoped
public class MainPage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB NewsDAO newsDAO;
	@EJB EventsDAO eventsDAO;

	List<Tiding> newsList;
	Event lastEvent;
	
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
		Event ev = eventsDAO.getLastActiveEvent();
		if ((ev!=null)&&(lastEvent==null)) setLastEvent(ev);
		return lastEvent;
	}

	public void setLastEvent(Event lastEvent) {
		this.lastEvent = lastEvent;
	}
}