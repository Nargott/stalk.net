package net.ua.stalk.action;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import ua.stalk.net.ejb.EventsDAO;
import ua.stalk.net.ejb.NewsDAO;
import ua.stalknet.model.*;

@ManagedBean
@SessionScoped
public class MainPage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB NewsDAO newsDAO;
	@EJB EventsDAO eventsDAO;
	
	@ManagedProperty(value = "#{core.user}")
	private User user;

	List<Tiding> newsList;
	Event lastEvent;
	
	public Boolean checkIsStalkerInEvent() {
		
		return eventsDAO.isStalkerInEvent(lastEvent, user.getActiveStalker());
	}
	
	public String addStalkerToEvent() {
		logger.info("MainPage:addStalkerToEvent() called!");
		if ((lastEvent!=null) && (user!=null)) {
			if (user.getActiveStalker()!=null) {
				lastEvent.addStalker(user.getActiveStalker());
				logger.info(lastEvent.getStalkers().get(0).getId().toString());
				if (eventsDAO.requestUpdate(lastEvent, user.getActiveStalker())) {
					addMessage(FacesMessage.SEVERITY_INFO, "Вы успешно подали заявку на участие в событии!");
				}
			}	
		}
		return "";
	}
	
	public void addMessage(FacesMessage.Severity type, String summary) {
        FacesMessage message = new FacesMessage(type, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public String getEventTime(Date d) {
		logger.info("MainPage:getEventTime called!");
		SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return formatter.format(d);
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}