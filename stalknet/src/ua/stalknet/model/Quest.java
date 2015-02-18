package ua.stalknet.model;

import java.io.Serializable;
import javax.persistence.*;


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
	private Event event;

	//uni-directional many-to-one association to Quest
	@ManyToOne
	@JoinColumn(name="parent")
	private Quest parent;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="finisher")
	private Stalker finisher;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="owner")
	private Stalker owner;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="performer")
	private Stalker performer;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="target")
	private Stalker target;

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

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Quest getParent() {
		return this.parent;
	}

	public void setParent(Quest parent) {
		this.parent = parent;
	}

	public Stalker getFinisher() {
		return this.finisher;
	}

	public void setFinisher(Stalker finisher) {
		this.finisher = finisher;
	}

	public Stalker getOwner() {
		return this.owner;
	}

	public void setOwner(Stalker owner) {
		this.owner = owner;
	}

	public Stalker getPerformer() {
		return this.performer;
	}

	public void setPerformer(Stalker performer) {
		this.performer = performer;
	}

	public Stalker getTarget() {
		return this.target;
	}

	public void setTarget(Stalker target) {
		this.target = target;
	}

}