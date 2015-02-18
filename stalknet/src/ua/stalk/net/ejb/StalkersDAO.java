package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Stalker;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class StalkersDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Stalker> getListStalkers() { 
		try{
			List<Stalker> s = (List<Stalker>) em.createQuery("select s from Stalker s").getResultList(); //Получаем список всех записей в модели
			logger.info("List size = "+s.size()); //Выведем на уровень инфо, сколько записей получили
			return s; 
		} catch (Exception e) {logger.fatal("!Exception in StalkersDAO:getListStalkers() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
	
	public Boolean isNameExists(String name) {
		try {
			Stalker s = (Stalker) em.createQuery("select s from Stalker s where s.callsign = :name")
					.setParameter("name", name)
					.getSingleResult();
			if (s != null) {return true;} else {return false;}
		}  catch (Exception e) {logger.fatal("!Exception in StalkersDAO:isNameExists() = "+e.getMessage()); return false;}
	}
	
	public Boolean add(Stalker newStalker) {
		try {
			em.persist(newStalker);
			return true;
		} catch (Exception e) {logger.fatal("!Exception in StalkersDAO:add("+newStalker.getCallsign()+") = "+e.getMessage()); return false;}	
	}
}
