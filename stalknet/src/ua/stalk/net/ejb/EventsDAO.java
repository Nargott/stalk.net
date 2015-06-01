package ua.stalk.net.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Event;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class EventsDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	public Event getLastActiveEvent() { 
		try{
			Event e = (Event) em.createQuery("select e from Event "
					+ "WHERE "
					+ "isActive = true AND"
					+ "isPrivate = false AND"
					+ "isRegOpened = true "
					+ " e order by e.id desc").getSingleResult();
			return e; 
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:getLastActiveEvent() = "+e.getMessage()); return null;}
	}
	
	public Boolean checkIsRegistrationOpened() {
		try{
			Event ev = (Event) em.createQuery("select e from Event e"
					/*+ "WHERE "
					+ "e.isActive = TRUE AND "
					+ "e.isPrivate = FALSE AND "
					+ "e.isRegOpened = TRUE "*/
					+ " ").getSingleResult();
			//if (ev != null) {return true;} 
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:getLastActiveEvent() = "+e.getMessage()); return null;}
		return false;
	}
}
