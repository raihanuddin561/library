package com.spring.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="authorities")
@Table(name="authorities")
public class Authorities {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="authority")
	private String authority;
	
	public Authorities() {
		
	}
	public Authorities(String username, String authority) {
		
		this.username = username;
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
