package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quests database table.
 * 
 */
@Entity
@Table(name="quests")
@NamedQuery(name="Quest.findAll", query="SELECT q FROM Quest q")
public class Quest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	@Lob
	private String description;

	private int experience;

	@Lob
	private String hint;

	private String image;

	private int level;

	private String name;

	private int price;

	private int status;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Event eventBean;

	//bi-directional many-to-one association to Quest
	@ManyToOne
	@JoinColumn(name="parent")
	private Quest quest;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="quest")
	private List<Quest> quests;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="finisher")
	private Stalker stalker1;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="owner")
	private Stalker stalker2;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="target")
	private Stalker stalker3;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="performer")
	private Stalker stalker4;

	public Quest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Event getEventBean() {
		return this.eventBean;
	}

	public void setEventBean(Event eventBean) {
		this.eventBean = eventBean;
	}

	public Quest getQuest() {
		return this.quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	public List<Quest> getQuests() {
		return this.quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	public Quest addQuest(Quest quest) {
		getQuests().add(quest);
		quest.setQuest(this);

		return quest;
	}

	public Quest removeQuest(Quest quest) {
		getQuests().remove(quest);
		quest.setQuest(null);

		return quest;
	}

	public Stalker getStalker1() {
		return this.stalker1;
	}

	public void setStalker1(Stalker stalker1) {
		this.stalker1 = stalker1;
	}

	public Stalker getStalker2() {
		return this.stalker2;
	}

	public void setStalker2(Stalker stalker2) {
		this.stalker2 = stalker2;
	}

	public Stalker getStalker3() {
		return this.stalker3;
	}

	public void setStalker3(Stalker stalker3) {
		this.stalker3 = stalker3;
	}

	public Stalker getStalker4() {
		return this.stalker4;
	}

	public void setStalker4(Stalker stalker4) {
		this.stalker4 = stalker4;
	}

}