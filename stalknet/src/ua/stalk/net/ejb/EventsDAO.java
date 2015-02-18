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
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public Event getLastActiveEvent() { 
		try{
			Event e = (Event) em.createQuery("select e from Event e order by e.id desc").getSingleResult(); //Получаем список всех записей в модели
			logger.info("Last event id = "+e.getId());
			return e; 
		} catch (Exception e) {logger.fatal("!Exception in EventsDAO:getLastActiveEvent() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
