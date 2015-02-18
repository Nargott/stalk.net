package ua.stalk.net.ejb;

import java.util.List;

import net.ua.stalk.action.UsersPage;

import org.apache.log4j.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ua.stalknet.model.User;

@Stateful //Означает, что хранить данные вне сессий, можно назвать "кэшем"
public class UsersDAO {
	private static final Logger logger = Logger.getLogger(UsersPage.class.getName()); //Создать логгер для дебага
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em; //Создаётся EntityManager
	
	@SuppressWarnings("unchecked") //Это чтобы не ругалось на "возможное" несоответствие типов
	public List<User> getListUsers() { 
		try{
			List<User> t = (List<User>) em.createQuery("select u from User u").getResultList(); //Получаем список всех записей в модели
			logger.info("List size = "+t.size()); //Выведем на уровень инфо, сколько записей получили
			return t; 
		} catch (Exception e) {logger.fatal("!Exception in UsersDAO:getListUsers() = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
	
	public User getUser(String login, String pass) {
		logger.info("User.getUser called, login = "+login+", pass = "+pass);
		try{
			User u = (User) em.createQuery("SELECT OBJECT(u) FROM User u WHERE u.login = :un AND u.pass = :up")
					.setParameter("un", login)
					.setParameter("up", pass)
					.getSingleResult();
			logger.info("User.getUser selected, user.login = "+u.getLogin());
			return u; 
		} catch (Exception e) {logger.fatal("!Exception in UsersDAO:getUser("+login+","+pass+") = "+e.getMessage()); return null;} //Вывод ошибки, если ничего не вернулось
	}
	
	public Boolean isUserExistsByLogin(String login) {
		logger.info("User.isUserExistsByLogin called, login = "+login);
		try{
			User u = (User) em.createQuery("SELECT OBJECT(u) FROM User u WHERE u.login = :un")
					.setParameter("un", login)
					.getSingleResult();
			logger.info("User.getUser selected, user.login = "+u.getLogin());
			if (u!=null) {return true;}
		} catch (Exception e) {logger.fatal("!Exception in UsersDAO:isUserExistsByLogin("+login+") = "+e.getMessage()); return false;}
		return false;
	}
	
	public Boolean addUser(User newUser) {
		try {
			em.persist(newUser);
			return true;
		} catch (Exception e) {logger.fatal("!Exception in UsersDAO:addUser("+newUser.getLogin()+") = "+e.getMessage()); return false;}	
	}
}
