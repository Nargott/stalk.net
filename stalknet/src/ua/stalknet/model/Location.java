package ua.stalknet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;
	
	private String icon;
	
	private String picture;
	
	//uni-directional many-to-one association to GPS
	@OneToOne
	@JoinColumn(name="gps")
	private GPS gps;
	
	//bi-directional many-to-one association to Stalker
	@OneToMany(mappedBy="home")
	private List<Stalker> citizens;
	
	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="location")
	private List<Quest> quests;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public List<Stalker> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Stalker> citizens) {
		this.citizens = citizens;
	}

	public List<Quest> getQuests() {
		return quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
	
}