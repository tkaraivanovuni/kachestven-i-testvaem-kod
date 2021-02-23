package models;

import java.util.ArrayList;
import java.util.List;
import enums.Role;

/**
 * This class provides the main characteristics of the {@link User} data model.
 */
public class User {

	private String username;
	private String password;
	/**
	 * A list of the all {@link Role} the user has.
	 */
	public List<Role> roles = new ArrayList<>();

	/**
	 * Constructor for {@link User}
	 * 
	 * @param username - string representation of username.
	 * @param password - string representation of password.
	 */
	public User(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	/**
	 * This method sets a {@link User} object's username.
	 * 
	 * @param username - string representation of the username to be set.
	 */
	public void setUsername(String username) {
		if (username == null || username.trim().isEmpty()) {
			throw new IllegalArgumentException("Username cannot be null!");
		}
		this.username = username;
	}

	/**
	 * This method returns the {@link User} username.
	 * 
	 * @return - string representing the username.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * This method sets a {@link User} object's username.
	 * 
	 * @param username - string representation of the username to be set.
	 */
	public void setPassword(String password) {
		if (password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("Username cannot be null!");
		}
		this.password = password;
	}

	/**
	 * This method returns the {@link User} object's password.
	 * 
	 * @return - string representing the password.
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * This method overrides the hashCode method.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	/**
	 * This method overrides the equals method.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
