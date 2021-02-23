package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import enums.Role;
import models.Comment;
import models.Topic;
import models.User;
import repositories.ForumRepo;

/**
 * Test class for {@link ForumController}.
 */
public class ForumControllerTest {

	private User user1 = new User("username1", "password1");
	private User user2 = new User("username2", "password2");
	private Topic topic = new Topic();
	private Comment comment;
	private ForumController forumController = new ForumController();

	/**
	 * This method sets up the environment before each test.
	 */
	@Before
	public void setup() {
		comment = new Comment(user2, topic, "test");
		ForumRepo.forumComments.clear();
		ForumRepo.forumTopics.clear();
		ForumRepo.forumComments.add(comment);
	}

	/**
	 * This method checks if an empty list is correctly returned when no comments
	 * are posted by the user.
	 */
	@Test
	public void getUserCommentsShouldReturnAnEmptyListIfNoCommentsArePosted() {
		List<Comment> result = forumController.getUserComments(user1);

		assertTrue(result.isEmpty());
	}

	/**
	 * This method checks if the correct list is returned when comments are posted
	 * by the user.
	 */
	@Test
	public void getUserCommentsShouldReturnTheCorrectList() {
		List<Comment> result = forumController.getUserComments(user2);
		List<Comment> expected = new ArrayList<>(Arrays.asList(new Comment(user2, topic, "test")));
		assertTrue(result.equals(expected));
	}

	/**
	 * This method tests if {@link ForumController#delete(User, Comment)} returns
	 * correct message when user is not an admin.
	 */
	@Test
	public void deleteShouldReturnCorrectMessageIfUserIsNotAdmin() {
		String result = forumController.delete(user1, comment);
		assertEquals(result, "You do not have permission to delete a comment!");
	}

	/**
	 * This method tests if {@link ForumController#delete(User, Comment)} returns
	 * correct message.
	 */
	@Test
	public void deleteShouldReturnCorrectMessageIfUserIsAdmin() {
		user1.roles.add(Role.ADMIN);
		String result = forumController.delete(user1, comment);
		assertEquals(result, "Comment deleted!");
	}

}
