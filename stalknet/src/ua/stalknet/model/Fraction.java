package ua.stalknet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the fractions database table.
 * 
 */
@Entity
@Table(name="fractions")
@NamedQuery(name="Fraction.findAll", query="SELECT f FROM Fraction f")
public class Fraction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean active;

	@Lob
	private String description;

	private int influence;

	private int money;

	private String name;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="deputy_leader")
	private Stalker deputyLeader;

	//uni-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="leader")
	private Stalker leader;
	
	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="fraction")
	private List<Quest> quests;

	public Fraction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInfluence() {
		return this.influence;
	}

	public void setInfluence(int influence) {
		this.influence = influence;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stalker getDeputyLeader() {
		return this.deputyLeader;
	}

	public void setDeputyLeader(Stalker deputyLeader) {
		this.deputyLeader = deputyLeader;
	}

	public Stalker getLeader() {
		return this.leader;
	}

	public void setLeader(Stalker leader) {
		this.leader = leader;
	}

	public List<Quest> getQuests() {
		return quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
	
}