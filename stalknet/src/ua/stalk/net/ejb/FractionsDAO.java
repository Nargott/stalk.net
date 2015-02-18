package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Fraction;

@Stateful
public class FractionsDAO {
private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Fraction> getFractionsList() { 
		try{
			List<Fraction> f = (List<Fraction>) em.createQuery("select f from Fraction f order by f.id asc").getResultList(); // getResultList(); //Получаем список всех записей в модели
			logger.info("Loaded "+f.size()+" fractions.");
			return f; 
		} catch (Exception e) {logger.fatal("!Exception in FractionsDAO:getFractionsList() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
