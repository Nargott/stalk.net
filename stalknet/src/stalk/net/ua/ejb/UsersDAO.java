package stalk.net.ua.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import stalk.net.ua.action.UsersPage;
import stalk.net.ua.model.User;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class UsersDAO {
	private static final Logger logger = Logger.getLogger(UsersPage.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<User> getListUsers() { //Получить список тестов
		try{
			List<User> t = (List<User>) em.createQuery("select u from User u").getResultList(); //Получаем список всех записей в модели
			logger.info("List size = "+t.size()); //Выведем на уровень инфо, сколько записей получили
			return t; 
		} catch (Exception e) {logger.severe("!Exception in TestDAO:getListTests() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
}
