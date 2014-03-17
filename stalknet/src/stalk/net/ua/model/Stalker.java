package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private int experience;

	@Lob
	private String legend;

	@Column(name="legend_master")
	private int legendMaster;

	private int money;

	private String passport;

	private String photo;

	private int rank;

	//bi-directional many-to-one association to Fraction
	@OneToMany(mappedBy="stalker1")
	private List<Fraction> fractions1;

	//bi-directional many-to-one association to Fraction
	@OneToMany(mappedBy="stalker2")
	private List<Fraction> fractions2;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="stalker1")
	private List<Quest> quests1;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="stalker2")
	private List<Quest> quests2;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="stalker3")
	private List<Quest> quests3;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="stalker4")
	private List<Quest> quests4;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Event eventBean;

	//bi-directional many-to-one association to Fraction
	@ManyToOne
	@JoinColumn(name="fraction")
	private Fraction fractionBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User userBean;

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

	public int getLegendMaster() {
		return this.legendMaster;
	}

	public void setLegendMaster(int legendMaster) {
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

	public List<Fraction> getFractions1() {
		return this.fractions1;
	}

	public void setFractions1(List<Fraction> fractions1) {
		this.fractions1 = fractions1;
	}

	public Fraction addFractions1(Fraction fractions1) {
		getFractions1().add(fractions1);
		fractions1.setStalker1(this);

		return fractions1;
	}

	public Fraction removeFractions1(Fraction fractions1) {
		getFractions1().remove(fractions1);
		fractions1.setStalker1(null);

		return fractions1;
	}

	public List<Fraction> getFractions2() {
		return this.fractions2;
	}

	public void setFractions2(List<Fraction> fractions2) {
		this.fractions2 = fractions2;
	}

	public Fraction addFractions2(Fraction fractions2) {
		getFractions2().add(fractions2);
		fractions2.setStalker2(this);

		return fractions2;
	}

	public Fraction removeFractions2(Fraction fractions2) {
		getFractions2().remove(fractions2);
		fractions2.setStalker2(null);

		return fractions2;
	}

	public List<Quest> getQuests1() {
		return this.quests1;
	}

	public void setQuests1(List<Quest> quests1) {
		this.quests1 = quests1;
	}

	public Quest addQuests1(Quest quests1) {
		getQuests1().add(quests1);
		quests1.setStalker1(this);

		return quests1;
	}

	public Quest removeQuests1(Quest quests1) {
		getQuests1().remove(quests1);
		quests1.setStalker1(null);

		return quests1;
	}

	public List<Quest> getQuests2() {
		return this.quests2;
	}

	public void setQuests2(List<Quest> quests2) {
		this.quests2 = quests2;
	}

	public Quest addQuests2(Quest quests2) {
		getQuests2().add(quests2);
		quests2.setStalker2(this);

		return quests2;
	}

	public Quest removeQuests2(Quest quests2) {
		getQuests2().remove(quests2);
		quests2.setStalker2(null);

		return quests2;
	}

	public List<Quest> getQuests3() {
		return this.quests3;
	}

	public void setQuests3(List<Quest> quests3) {
		this.quests3 = quests3;
	}

	public Quest addQuests3(Quest quests3) {
		getQuests3().add(quests3);
		quests3.setStalker3(this);

		return quests3;
	}

	public Quest removeQuests3(Quest quests3) {
		getQuests3().remove(quests3);
		quests3.setStalker3(null);

		return quests3;
	}

	public List<Quest> getQuests4() {
		return this.quests4;
	}

	public void setQuests4(List<Quest> quests4) {
		this.quests4 = quests4;
	}

	public Quest addQuests4(Quest quests4) {
		getQuests4().add(quests4);
		quests4.setStalker4(this);

		return quests4;
	}

	public Quest removeQuests4(Quest quests4) {
		getQuests4().remove(quests4);
		quests4.setStalker4(null);

		return quests4;
	}

	public Event getEventBean() {
		return this.eventBean;
	}

	public void setEventBean(Event eventBean) {
		this.eventBean = eventBean;
	}

	public Fraction getFractionBean() {
		return this.fractionBean;
	}

	public void setFractionBean(Fraction fractionBean) {
		this.fractionBean = fractionBean;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

}