package ua.stalknet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String description;

	private String email;

	private String fio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastlogin;

	private String login;

	private String pass;

	private String phone;

	private String picture;

	//bi-directional many-to-one association to Stalker
	@OneToMany(mappedBy="user")
	private List<Stalker> stalkers;

	//bi-directional many-to-one association to Tiding
	@OneToMany(mappedBy="user")
	private List<Tiding> tidings;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city")
	private City city;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFio() {
		return this.fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public Date getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Stalker> getStalkers() {
		return this.stalkers;
	}

	public void setStalkers(List<Stalker> stalkers) {
		this.stalkers = stalkers;
	}

	public Stalker addStalker(Stalker stalker) {
		getStalkers().add(stalker);
		stalker.setUser(this);

		return stalker;
	}

	public Stalker removeStalker(Stalker stalker) {
		getStalkers().remove(stalker);
		stalker.setUser(null);

		return stalker;
	}

	public List<Tiding> getTidings() {
		return this.tidings;
	}

	public void setTidings(List<Tiding> tidings) {
		this.tidings = tidings;
	}

	public Tiding addTiding(Tiding tiding) {
		getTidings().add(tiding);
		tiding.setUser(this);

		return tiding;
	}

	public Tiding removeTiding(Tiding tiding) {
		getTidings().remove(tiding);
		tiding.setUser(null);

		return tiding;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}