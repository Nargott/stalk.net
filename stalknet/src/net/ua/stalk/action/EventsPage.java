package net.ua.stalk.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class EventsPage implements Serializable {
	private static final long serialVersionUID = -3261247947821833832L;
	private static final Logger logger = Logger.getLogger(EventsPage.class.getName());
	
	
    
    public EventsPage() {  
        
        logger.info("EventsPage() constructor called!");
    }  
  
}
