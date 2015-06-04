package ua.stalknet.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the items_type database table.
 * 
 */
@Entity
@Table(name="item_type")
@NamedQuery(name="ItemType.findAll", query="SELECT i FROM ItemType i")
public class ItemType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private String name;

	public ItemType() {
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

}