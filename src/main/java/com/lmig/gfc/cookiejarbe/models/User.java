package com.lmig.gfc.cookiejarbe.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cookiejar_user")
public class User {

	@Id
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	private int id;

	@OneToMany(mappedBy = "user")
	private List<Recipe> userRecipes;

	@Column
	private String name;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Recipe> getUserRecipes() {
		return userRecipes;
	}

	public void setUserRecipes(List<Recipe> userRecipes) {
		this.userRecipes = userRecipes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
