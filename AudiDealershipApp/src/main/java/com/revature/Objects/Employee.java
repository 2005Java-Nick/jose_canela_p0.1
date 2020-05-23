package com.revature.Objects;

/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public class Employee extends User {

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

	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}
	
		public Employee(int userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
		}

		public Employee(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		
		}

}
