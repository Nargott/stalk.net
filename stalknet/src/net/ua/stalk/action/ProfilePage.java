package net.ua.stalk.action;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.*;

import org.primefaces.model.menu.*;

import ua.stalk.net.ejb.StalkersDAO;
import ua.stalknet.model.Stalker;
import ua.stalknet.model.User;

@ManagedBean
@SessionScoped
public class ProfilePage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB StalkersDAO stalkersDAO;
	
	@ManagedProperty(value="#{core.user}")
    User user;
	
	private List<Stalker> userStalkers;
	
	private MenuModel menuModel;
	private Boolean isMenuGenerated = false;
	
	public void genMenu() {
		logger.info("ProfilePage:genMenu called!");
		
		userStalkers = stalkersDAO.getStalkersByUser(user);
		
		menuModel = new DefaultMenuModel();
        
		DefaultMenuItem item = new DefaultMenuItem("Основная информация");  
		item.setIcon("fa fa-user");
		item.setUpdate("rightForm");
        menuModel.addElement(item);
        
        DefaultSubMenu stalkersMenu = new DefaultSubMenu("Персонажи");
        stalkersMenu.setIcon("fa fa-user");
        menuModel.addElement(stalkersMenu);
        	
        	if (!userStalkers.isEmpty()) {
        		userStalkers.forEach(stalker -> {
        			DefaultMenuItem itemS = new DefaultMenuItem(stalker.getCallsign());
                	itemS.setIcon("fa fa-user-secret");
        	        stalkersMenu.addElement(itemS);
        		});
        	} else {
        		
        	}
        	
	        	
		        /*item = new DefaultMenuItem("Задания");  
				item.setIcon("fa fa-file-text-o");
				item.setUpdate("rightForm");
		        stalkerMenu.addElement(item);
		        
		        item = new DefaultMenuItem("Инвентарь");  
				item.setIcon("fa fa-inbox");
				item.setUpdate("rightForm");
		        stalkerMenu.addElement(item);*/
		
        menuModel.generateUniqueIds();
        
        isMenuGenerated = true;
	}

	public MenuModel getMenuModel() {
		if (!isMenuGenerated) {genMenu();}
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public List<Stalker> getUserStalkers() {
		return userStalkers;
	}

	public void setUserStalkers(List<Stalker> userStalkers) {
		this.userStalkers = userStalkers;
	}
	
}