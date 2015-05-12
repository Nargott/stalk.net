package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.City;
import ua.stalknet.model.Region;

@Stateful
public class CitiesDAO {
private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<City> getCitiesList(Region region) { 
		try{
			List<City> c = (List<City>) em.createQuery("select c from City c where c.region=:region order by c.id desc").setParameter("region", region).getResultList(); //Получаем список всех записей в модели
			logger.info("Loaded "+c.size()+" cities.");
			return c; 
		} catch (Exception e) {logger.fatal("!Exception in CitiesDAO:getCitiesList() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}