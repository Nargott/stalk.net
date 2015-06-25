package ua.stalknet.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_end")
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_start")
	private Date dateStart;

	@Lob
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="is_reg_opened")
	private Boolean isRegOpened;
	
	@Column(name="is_started")
	private Boolean isStarted;
	
	@Column(name="is_private")
	private Boolean isPrivate;

	//uni-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="type")
	private EventType event;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="event")
	private List<Quest> quests;
	
	//bi-directional many-to-one association to Quest
	@ManyToMany(mappedBy="events")
	private List<Stalker> stalkers;
	
	@OneToMany(mappedBy="event")
	private List<Payment> payments;
	
	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
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
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsRegOpened() {
		return isRegOpened;
	}

	public void setIsRegOpened(Boolean isRegOpened) {
		this.isRegOpened = isRegOpened;
	}

	public Boolean getIsStarted() {
		return isStarted;
	}

	public void setIsStarted(Boolean isStarted) {
		this.isStarted = isStarted;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public EventType getEvent() {
		return this.event;
	}

	public void setEvent(EventType event) {
		this.event = event;
	}

	public List<Quest> getQuests() {
		return this.quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	public Quest addQuest(Quest quest) {
		getQuests().add(quest);
		quest.setEvent(this);

		return quest;
	}

	public Quest removeQuest(Quest quest) {
		getQuests().remove(quest);
		quest.setEvent(null);

		return quest;
	}
	
	public List<Stalker> getStalkers() {
		return stalkers;
	}

	public void setStalkers(List<Stalker> stalkers) {
		this.stalkers = stalkers;
	}
	
	public Stalker addStalker(Stalker stalker) {
		this.getStalkers().add(stalker);
		stalker.addEvent(this);

		return stalker;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}