package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int id;

	@Lob
	private String description;

	private int influence;

	private int money;

	private String name;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="deputy_leader")
	private Stalker stalker1;

	//bi-directional many-to-one association to Stalker
	@ManyToOne
	@JoinColumn(name="leader")
	private Stalker stalker2;

	//bi-directional many-to-one association to Stalker
	@OneToMany(mappedBy="fractionBean")
	private List<Stalker> stalkers;

	public Fraction() {
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

	public List<Stalker> getStalkers() {
		return this.stalkers;
	}

	public void setStalkers(List<Stalker> stalkers) {
		this.stalkers = stalkers;
	}

	public Stalker addStalker(Stalker stalker) {
		getStalkers().add(stalker);
		stalker.setFractionBean(this);

		return stalker;
	}

	public Stalker removeStalker(Stalker stalker) {
		getStalkers().remove(stalker);
		stalker.setFractionBean(null);

		return stalker;
	}

}