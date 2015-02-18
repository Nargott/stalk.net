package ua.stalknet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tidings database table.
 * 
 */
@Entity
@Table(name="tidings")
@NamedQuery(name="Tiding.findAll", query="SELECT t FROM Tiding t")
public class Tiding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_pub")
	private Date datePub;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="publisher")
	private User user;

	public Tiding() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatePub() {
		return this.datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}