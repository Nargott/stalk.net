package stalk.net.ua.model;

import java.io.Serializable;
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
	private int id;

	private byte active;

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

	private int pda;

	private String photo;

	private int rank;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Event eventBean;

	//bi-directional many-to-one association to Fraction
	@ManyToOne
	@JoinColumn(name="fraction")
	private Fraction fraction;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

	public Stalker() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
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

	public int getPda() {
		return this.pda;
	}

	public void setPda(int pda) {
		this.pda = pda;
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

	public Event getEventBean() {
		return this.eventBean;
	}

	public void setEventBean(Event eventBean) {
		this.eventBean = eventBean;
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

}