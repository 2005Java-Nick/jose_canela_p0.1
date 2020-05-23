package com.revature.Objects;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	@Override
	public int hashCode() {
		return Objects.hash(password, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(username, other.username);
	}

	protected int userId;
	protected String username;
	protected String password;

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param userPolicy
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
