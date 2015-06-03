package ua.stalknet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the stalkers database table.
 * 
 */
@Entity
@Table(name="stalkers")
@NamedQuery(name="Stalker.findAll", query="SELECT s FROM Stalker s")
public class Stalker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private boolean active;

	private String callsign;

	@Lob
	private String description;

	private int experience;

	@Lob
	private String legend;

	@Lob
	@Column(name="legend_master")
	private String legendMaster;

	private int money;

	private String passport;

	private String photo;

	private int rank;
	
	@Column(name="has_passport")
	private boolean hasPassport;
	
	//bi-directional many-to-many association to Event
	@ManyToMany
    @JoinTable(name="stalker_events")
	private List<Event> events;

	//uni-directional many-to-one association to Fraction
	@ManyToOne
	@JoinColumn(name="fraction")
	private Fraction fraction;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

	//uni-directional many-to-one association to GPS
	@OneToOne
	@JoinColumn(name="gps")
	private GPS gps;
	
	//bi-directional many-to-one association to GPS
	@ManyToOne
	@JoinColumn(name="home")
	private Location home;
	
	public Stalker() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCallsign() {
		return this.callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getLegend() {
		return this.legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}

	public String getLegendMaster() {
		return this.legendMaster;
	}

	public void setLegendMaster(String legendMaster) {
		this.legendMaster = legendMaster;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public boolean isHasPassport() {
		return hasPassport;
	}

	public void setHasPassport(boolean hasPassport) {
		this.hasPassport = hasPassport;
	}

	public Fraction getFraction() {
		return this.fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public Location getHome() {
		return home;
	}

	public void setHome(Location home) {
		this.home = home;
	}
	
}