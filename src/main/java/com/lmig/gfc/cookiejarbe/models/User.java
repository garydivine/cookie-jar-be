package com.lmig.gfc.cookiejarbe.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "cookiejar_user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	private int id;

	@OneToMany(mappedBy = "user")
	private List<Recipe> userRecipes;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> roles;

	public User() {
		roles = new ArrayList<Role>();
	}

	public User(String username) {
		this.username = username;
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

	public void addRole(String roleName) {
		Role role = new Role();
		role.setName(roleName);
		role.setUser(this);
		roles.add(role);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : roles) {
			String roleName = "ROLE_" + role.getName();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorities.add(authority);
		}

		return authorities;
	}

	private boolean hasRole(String roleName) {
		boolean hasRole = false;
		for (Role role : roles) {
			if (role.getName().equals(roleName)) {
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	public boolean canSeeAdmin() {
		return hasRole("ADMIN");
	}

	public boolean canSeeRecipes() {
		return hasRole("BAKER") || hasRole("ADMIN");
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
