package ua.stalknet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

	@Lob
	@Column(name="description")
	private String description;
	
	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Event event;

	@Column(name="amount", precision=15, scale=2)
    private BigDecimal amount;
	
	//bi-directional many-to-one association to Quest
	@ManyToOne
	@JoinColumn(name="stalker")
	private Stalker stalker;
	
	public Payment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Stalker getStalker() {
		return stalker;
	}

	public void setStalker(Stalker stalker) {
		this.stalker = stalker;
	}
	
	public User getUser() {
		return this.stalker.getUser();
	}

}