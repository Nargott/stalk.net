package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name="type")
	private EventType eventType;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="eventBean")
	private List<Quest> quests;

	//bi-directional many-to-one association to Stalker
	@OneToMany(mappedBy="eventBean")
	private List<Stalker> stalkers;

	public Event() {
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

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public List<Quest> getQuests() {
		return this.quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	public Quest addQuest(Quest quest) {
		getQuests().add(quest);
		quest.setEventBean(this);

		return quest;
	}

	public Quest removeQuest(Quest quest) {
		getQuests().remove(quest);
		quest.setEventBean(null);

		return quest;
	}

	public List<Stalker> getStalkers() {
		return this.stalkers;
	}

	public void setStalkers(List<Stalker> stalkers) {
		this.stalkers = stalkers;
	}

	public Stalker addStalker(Stalker stalker) {
		getStalkers().add(stalker);
		stalker.setEventBean(this);

		return stalker;
	}

	public Stalker removeStalker(Stalker stalker) {
		getStalkers().remove(stalker);
		stalker.setEventBean(null);

		return stalker;
	}

}