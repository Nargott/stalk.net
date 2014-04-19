package stalk.net.ua.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;

import stalk.net.ua.action.Core;
import stalk.net.ua.model.City;

@Stateful
public class CitiesDAO {
private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<City> getCitiesList(Integer region_id) { 
		try{
			List<City> c = (List<City>) em.createQuery("select c from City c where c.region_id="+region_id+" order by c.id desc").getResultList(); //Получаем список всех записей в модели
			logger.info("Loaded "+c.size()+" cities.");
			return c; 
		} catch (Exception e) {logger.fatal("!Exception in CitiesDAO:getCitiesList() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}