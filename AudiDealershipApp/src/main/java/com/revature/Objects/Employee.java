package com.revature.Objects;

/**
 * An employee user of the Audi Dealership application
 * 
 * @author josecanela
 *
 */

public class Employee extends User {

	/**
	 * Instantiates an Employee object.
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Instantiates an Employee object with an employee ID, username, and password
	 * 
	 * @param userId an employee's ID
	 * @param username an employee's username
	 * @param password an employee's password
	 */
	public Employee(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	/**
	 * Instantiates an Employee object with a username and password
	 * 
	 * @param username an employee's username
	 * @param password an employee's password
	 */
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
