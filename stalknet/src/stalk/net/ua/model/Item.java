package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table(name="items")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Object description;

	private String name;

	//bi-directional many-to-one association to ItemsType
	@ManyToOne
	@JoinColumn(name="type")
	private ItemsType itemsType;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemsType getItemsType() {
		return this.itemsType;
	}

	public void setItemsType(ItemsType itemsType) {
		this.itemsType = itemsType;
	}

}