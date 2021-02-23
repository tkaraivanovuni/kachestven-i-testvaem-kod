package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link User}.
 */
public class UserTest {

	private User user;

	/**
	 * This method sets up a {@link User} to be used in each test.
	 */
	@Before
	public void setup() {
		user = new User("username", "password");
	}

	/**
	 * This method tests if {@link User#setUsername(String)} correctly throws an
	 * exception if a null string is passed as an argument.
	 */
	@Test
	public void setUsernameShouldThrowAnExceptionIfUsernameIsNull() {
		String username = null;

		assertThrows(IllegalArgumentException.class, () -> user.setUsername(username));
	}

	/**
	 * This method tests if {@link User#setUsername(String)} correctly throws an
	 * exception if an empty string is passed as an argument.
	 */
	@Test
	public void setUsernameShouldThrowAnExceptionIfUsernameIsEmpty() {
		String username = " ";

		assertThrows(IllegalArgumentException.class, () -> user.setUsername(username));
	}

	/**
	 * This method tests if {@link User#setUsername(String)} correctly sets a valid
	 * username that has been passed as an argument.
	 */
	@Test
	public void setUsernameShouldCorrectlyChangeUsernameIfNewUsernameIsValid() {
		String username = "newUsername";
		user.setUsername(username);
		String result = user.getUsername();
		assertEquals("newUsername", result);
	}

	/**
	 * This method tests if {@link User#setPassword(String)} correctly throws an
	 * exception if a null string is passed as an argument.
	 */
	@Test
	public void setPasswordShouldThrowAnExceptionIfPasswordIsNull() {
		String password = null;

		assertThrows(IllegalArgumentException.class, () -> user.setPassword(password));
	}

	/**
	 * This method tests if {@link User#setPassword(String)} correctly throws an
	 * exception if an empty string is passed as an argument.
	 */
	@Test
	public void setPasswordShouldThrowAnExceptionIfPasswordIsEmpty() {
		String password = " ";

		assertThrows(IllegalArgumentException.class, () -> user.setPassword(password));
	}
	
	/**
	 * This method tests if {@link User#setPassword(String)} correctly sets a valid
	 * password that has been passed as an argument.
	 */
	@Test
	public void setPasswordShouldCorrectlyChangePasswordIfNewPasswordIsValid() {
		String password = "newUsername";
		user.setPassword(password);
		String result = user.getPassword();
		assertEquals("newUsername", result);
	}
	
	/**
	 * This method tests the hashCode method.
	 */
	@Test
	public void testIfHashCodeReturnsCorrectCode() {
		User user2 = new User("username", "password");
		assertEquals(user.hashCode(), user2.hashCode());
	}
	
	/**
	 * This method tests the equals method.
	 */
	@Test
	public void testIfEqualsWorksProperly() {
		User user2 = new User("username", "password");
		assertTrue(user.equals(user2));
	}

}
