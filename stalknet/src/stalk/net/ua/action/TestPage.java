package stalk.net.ua.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import stalk.net.ua.ejb.TestDAO;
import stalk.net.ua.model.Test;

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class TestPage implements Serializable {
	private static final long serialVersionUID = -5147686119510554487L;
	
	private static final Logger logger = Logger.getLogger(TestPage.class.getName());
	
	@EJB TestDAO dao; //Подключим наш ДАО-класс

	public List<Test> getTests() { //Метод для получения списка тестов
		logger.info("TestPage:getTests() called!");
		return dao.getListTests(); //Вот так просто :)
	}
}
