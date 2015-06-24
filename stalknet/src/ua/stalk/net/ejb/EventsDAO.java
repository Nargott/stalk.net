package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.*;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Event;
import ua.stalknet.model.Stalker;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class EventsDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked")
	public Event getLastActiveEvent() { 
		try{
			List<Event> events = (List<Event>) em.createQuery("select e from Event e "
					+ "WHERE "
					+ "e.isActive = TRUE AND "
					+ "e.isPrivate = FALSE AND "
					+ "e.isRegOpened = TRUE "
					+ "order by e.id desc").getResultList();
			if ((events!=null)&&(!events.isEmpty())) {
				return events.get(0);
			} else return null;	
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:getLastActiveEvent() = "+e.getMessage()); return null;}
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getStalkerEvents(Stalker stalker) {
		try{
			List<Event> events = (List<Event>) em.createQuery("select e from Event e "
					+ "WHERE "
					+ ":stalker IN e.stalkers "
					+ "order by e.id desc")
					.setParameter("stalker", stalker)
					.getResultList();
			return events;
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:getStalkerEvents() = "+e.getMessage()); return null;}
	}
	
	
	public Boolean checkIsRegistrationOpened() {
		try{
			Event ev = (Event) em.createQuery("select e from Event e"
					/*+ "WHERE "
					+ "e.isActive = TRUE AND "
					+ "e.isPrivate = FALSE AND "
					+ "e.isRegOpened = TRUE "*/
					+ " ").getSingleResult();
			if (ev != null) {return false;} 
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:checkIsRegistrationOpened() = "+e.getMessage()); return null;}
		return false;
	}
	
	public Boolean add(Event event) {
		try {
			em.persist(event);
			return true;
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:add("+event.getId()+") = "+e.getMessage()); return false;}	
	}
	
	public Boolean update(Event event) {
		logger.info("EventsDAO:update() called!");
		try {
			em.merge(event);
			return true;
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:update("+event.getId()+") = "+e.getMessage()); return false;}	
	}
}
