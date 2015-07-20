package net.ua.stalk.action;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.*;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.menu.*;

import ua.stalk.net.ejb.StalkersDAO;
import ua.stalk.net.ejb.UsersDAO;
import ua.stalknet.model.Stalker;
import ua.stalknet.model.User;

@ManagedBean
@SessionScoped
public class ProfilePage implements Serializable {
	private static final long serialVersionUID = 4409790560087029586L;

	private static final Logger logger = Logger.getLogger(UsersPage.class.getName());
	
	@EJB StalkersDAO stalkersDAO;
	@EJB UsersDAO usersDAO;
	
	@ManagedProperty(value="#{core.user}")
    private User user;
	
	private List<Stalker> userStalkers;
	private Stalker curStalker;
	
	private MenuModel menuModel;
	private Boolean isMenuGenerated = false;
	
	private String rightContent = "profileEdit";
	
	public void showEditStalkerContent(Integer stalkerId) {
		logger.info("ProfilePage:showEditStalkerContent called with stalker id="+stalkerId);
		Stalker stalker = stalkersDAO.getById(stalkerId);
		if (stalker!=null) {
			this.setCurStalker(stalker);
			this.setRightContent("stalkerEdit");
		} else {
			logger.warning("ProfilePage:showEditStalkerContent stalker with id="+stalkerId+" is returned NULL! Nothing to do.");
		}
	}
	
	public void handleSaveStalker() {
		logger.info("ProfilePage: handleSaveStalker called with stalker group.id="+curStalker.getFraction().getName());
		stalkersDAO.save(this.curStalker);
	}
	
	public void handleSaveUser() {
		logger.info("ProfilePage: handleSaveUser called with user.id="+user.getId());
		usersDAO.save(this.user);
	}
	
	public void genMenu() {
		logger.info("ProfilePage:genMenu called!");
		
		userStalkers = stalkersDAO.getStalkersByUser(user);
		
		menuModel = new DefaultMenuModel();
        
		DefaultMenuItem item = new DefaultMenuItem("Основная информация");  
		item.setIcon("fa fa-user");
		item.setUpdate("rightForm");
		item.setStyleClass("ui-state-active");
		item.setCommand("#{profilePage.setRightContent('profileEdit')}");
		
        menuModel.addElement(item);
        
        DefaultSubMenu stalkersMenu = new DefaultSubMenu("Персонажи");
        stalkersMenu.setIcon("fa fa-user");
        menuModel.addElement(stalkersMenu);
        	
        	if (!userStalkers.isEmpty()) {
        		userStalkers.forEach(stalker -> {
        			DefaultMenuItem itemS = new DefaultMenuItem(stalker.getCallsign());
                	itemS.setIcon("fa fa-user-secret");
                	itemS.setUpdate("rightForm");
                	itemS.setCommand("#{profilePage.showEditStalkerContent("+stalker.getId()+")}");
        	        stalkersMenu.addElement(itemS);
        		});
        	} else {
        		DefaultMenuItem itemNone = new DefaultMenuItem("Активных персонажей нет");
            	itemNone.setDisabled(true);
    	        stalkersMenu.addElement(itemNone);
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
	
	public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(File.createTempFile("temp-file-name"+event.getFile().getFileName(), ""));
            logger.info("ProfilePage:handleFileUpload() getFileName()");
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRightContent() {
		return rightContent;
	}

	public void setRightContent(String rightContent) {
		this.rightContent = rightContent;
	}

	public Stalker getCurStalker() {
		return curStalker;
	}

	public void setCurStalker(Stalker curStalker) {
		this.curStalker = curStalker;
	}
	
	
	
}