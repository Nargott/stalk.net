package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Country;

@Stateful
public class CountriesDAO {
private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Country> getCountriesList() { 
		try{
			List<Country> c = (List<Country>) em.createQuery("select c from Country c order by c.id asc").getResultList(); // getResultList(); //Получаем список всех записей в модели
			logger.info("Loaded "+c.size()+" countries.");
			return c; 
		} catch (Exception e) {logger.fatal("!Exception in CounriesDAO:getCountriesList() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
