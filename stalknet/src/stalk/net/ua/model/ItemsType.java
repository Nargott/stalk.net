package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private Object description;

	private String name;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="itemsType")
	private List<Item> items;

	public ItemsType() {
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItemsType(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItemsType(null);

		return item;
	}

}