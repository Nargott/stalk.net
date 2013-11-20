package stalk.net.ua.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import stalk.net.ua.action.TestPage;
import stalk.net.ua.model.Test;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class TestDAO {
	private static final Logger logger = Logger.getLogger(TestPage.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<Test> getListTests() { //Получить список тестов
		try{
			List<Test> t = (List<Test>) em.createQuery("select t from Test t").getResultList(); //Получаем список всех записей в модели
			logger.info("List size = "+t.size()); //Выведем на уровень инфо, сколько записей получили
			return t; 
		} catch (Exception e) {logger.severe("!Exception in TestDAO:getListTests() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
