package stalk.net.ua.ejb;

import java.util.List;

import org.apache.log4j.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


import stalk.net.ua.action.Core;
import stalk.net.ua.model.Event;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class EventsDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Event> getListLastEvent() { 
		try{
			List<Event> t = (List<Event>) em.createQuery("select e from Event e order by e.id desc").setMaxResults(1).getResultList(); //Получаем список всех записей в модели
			logger.info("Last event id = "+t.get(0).getId());
			return t; 
		} catch (Exception e) {logger.fatal("!Exception in UsersDAO:getListLastEvent() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
