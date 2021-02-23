package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Comment;
import models.User;

/**
 * This class simulates a storage of all {@link Comment} objects on the forum.
 */
public class UserRepo {
	
	/**
	 * A list of all users on the forum.
	 */
	public static List<User> users = new ArrayList<>();
	
	/**
	 * Constructor for {@link UserRepo}.
	 */
	private UserRepo() {
		
	}

}
