package com.example.employeemanagementservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private long id;
	@Column(name = "role_name", unique = true)
	private String name;

	/*
	 * Since role will added through API, I am Not using Many to many as it create
	 * separate entry for role for every new user added.
	 */
//	@ManyToMany(mappedBy = "roles")
//	@JsonIgnore
//	private Set<User> users;

	public Role() {
		super();
	}

	public Role(String name, Set<User> users) {
		super();
		this.name = name;
//		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

}
