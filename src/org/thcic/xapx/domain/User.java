package org.thcic.xapx.domain;

public class User {

	private Long user_id;
	private String username;
	private String password;
	private Character enabled;


	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getEnabled() {
		return enabled;
	}

	public void setEnabled(Character enabled) {
		this.enabled = enabled;
	}

}
