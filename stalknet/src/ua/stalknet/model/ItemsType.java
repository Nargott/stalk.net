package ua.stalknet.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the items_type database table.
 * 
 */
@Entity
@Table(name="items_type")
@NamedQuery(name="ItemsType.findAll", query="SELECT i FROM ItemsType i")
public class ItemsType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;

	public ItemsType() {
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