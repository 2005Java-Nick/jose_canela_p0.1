package com.revature.Objects;

import java.util.Objects;

/**
 * A user of the Audi Dealership application
 * 
 * @author josecanela
 */
public class User {
	/** A user's ID*/
	protected int userId;
	/** A user's username that must be unique/distinct from all other users*/
	protected String username;
	/** A user's password*/
	protected String password;

	/**
	 * Instantiates a User object without a username and password.
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a User object with a username and password
	 * 
	 * @param username a user's username
	 * @param password a user's password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets a user's ID and returns it.
	 * @return A user's ID
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets a user's ID
	 * @param userId a user's ID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets a user's username and returns it.
	 * 
	 * @return A user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets a user's username
	 * 
	 * @param username a user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets a user's password and returns it.
	 * 
	 * @return a user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets a user's password
	 * 
	 * @param password a user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
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

}
