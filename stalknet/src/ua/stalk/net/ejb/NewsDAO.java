package ua.stalk.net.ejb;

import java.util.List;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;



//import stalk.net.ua.action.NewsPage;

import ua.stalknet.model.Tiding;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class NewsDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Tiding> getListNews() { 
		try{
			List<Tiding> t = (List<Tiding>) em.createQuery("select n from Tiding n").getResultList(); //Получаем список всех записей в модели
			logger.info("List size = "+t.size()); //Выведем на уровень инфо, сколько записей получили
			return t; 
		} catch (Exception e) {logger.fatal("!Exception in NewsDAO:getListUsers() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
