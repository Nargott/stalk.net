package ua.stalk.net.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.ua.stalk.action.Core;

import org.apache.log4j.Logger;

import ua.stalknet.model.Stalker;
import ua.stalknet.model.User;

@Stateful
public class StalkersDAO {
	private static final Logger logger = Logger.getLogger(Core.class.getName());
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Stalker> getAllStalkersList() { 
		try{
			List<Stalker> s = (List<Stalker>) em.createQuery("select s from Stalker s").getResultList();
			logger.info("List size = "+s.size());
			return s; 
		} catch (Exception e) {logger.fatal("!Exception in StalkersDAO:getListStalkers() = "+e.getMessage()); return null;}
	}
	
	@SuppressWarnings("unchecked")
	public List<Stalker> getStalkersByUser(User user) { 
		try{
			List<Stalker> s = (List<Stalker>) em.createQuery("select s from Stalker s where s.user = :user")
												.setParameter("user", user)
												.getResultList();
			logger.info("List size = "+s.size());
			return s; 
		} catch (Exception e) {logger.fatal("!Exception in StalkersDAO:getListStalkers() = "+e.getMessage()); return null;}
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
