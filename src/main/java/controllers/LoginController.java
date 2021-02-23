package controllers;

import enums.Role;
import models.User;
import repositories.UserRepo;

/**
 * This class handles user login operations.
 */
public class LoginController {

	/**
	 * This method registers a new {@link User}.
	 * 
	 * @param user - the user to be added.
	 */
	public void registerUser(User user) {
		user.roles.add(Role.USER);
		UserRepo.users.add(user);
	}

	/**
	 * This method registers a new {@link User} admin.
	 * 
	 * @param user - the user to be added.
	 */
	public void registerAdmin(User user) {
		user.roles.add(Role.USER);
		user.roles.add(Role.ADMIN);
		UserRepo.users.add(user);
	}

}
