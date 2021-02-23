package controllers;

import models.User;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import enums.Role;

/**
 * Test class for {@link LoginController}
 */
public class LoginControllerTest {
	
	private LoginController loginController;
	private User user;
	
	@Before
	public void setup() {
		loginController = new LoginController();
	}
	
	/**
	 * This method tests if {@link LoginController#registerUser(models.User)} adds user role.
	 */
	@Test
	public void registerUserShouldAddUserRole() {
		user = new User("username", "password");
		loginController.registerUser(user);
		assertTrue(user.roles.contains(Role.USER));
	}
	
	/**
	 * This method tests if {@link LoginController#registerAdmin(models.User)} adds user and admin roles.
	 */
	@Test
	public void registerAdminShouldAddUserAndAdminRole() {
		user = new User("username", "password");
		loginController.registerAdmin(user);
		assertTrue(user.roles.contains(Role.USER) && user.roles.contains(Role.ADMIN));
	}

}
