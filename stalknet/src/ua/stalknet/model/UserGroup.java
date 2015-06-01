package ua.stalknet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the items_type database table.
 * 
 */
@Entity
@Table(name="user_group")
@NamedQuery(name="UserGroup.findAll", query="SELECT ug FROM UserGroup ug")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;
	
	private String synonym;
	
	//bi-directional many-to-one association to Stalker
	@OneToMany(mappedBy="group")
	private List<User> users;

	public UserGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynonym() {
		return synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}