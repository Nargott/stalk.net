package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
@NamedQuery(name="New.findAll", query="SELECT n FROM New n")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_pub")
	private Date datePub;

	@Lob
	private String description;

	private String name;

	private int publisher;

	public New() {
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

	public int getPublisher() {
		return this.publisher;
	}

	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}

}