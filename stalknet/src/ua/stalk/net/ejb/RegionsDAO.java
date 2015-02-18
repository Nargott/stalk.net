package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Country;
import ua.stalknet.model.Region;

@Stateful
public class RegionsDAO {
private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Region> getRegionsList(Country country) { 
		try{
			List<Region> r = (List<Region>) em.createQuery("select r from Region r where r.country=:country order by r.id desc").setParameter("country", country).getResultList(); //Получаем список всех записей в модели
			logger.info("Loaded "+r.size()+" regions.");
			return r; 
		} catch (Exception e) {logger.fatal("!Exception in RegionsDAO:getRegionsList() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
