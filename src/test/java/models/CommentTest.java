package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.ForumTopic;

/**
 * Test class for {@link Comment}
 */
public class CommentTest {
	
	private Comment comment;
	private ForumTopic topic;
	private User user;
	
	/**
	 * This method sets up a {@link Comment} object for each test.
	 */
	@Before
	public void setup() {
		user = new User("username", "password");
		topic = new Topic();
		comment = new Comment(user, topic, "content");
	}
	
	/**
	 * This method tests if {@link Comment#setUser(User)} correctly throws an exception if a null user is passed as an argument.
	 */
	@Test
	public void setUserShouldThrowAnExceptionIfUserIsNull() {
		user = null;
		
		assertThrows(IllegalArgumentException.class, () -> comment.setUser(user));
	}
	
	@Test
	public void setUserShouldThrowAnExceptionIfTopicIsNull() {
		topic = null;
		
		assertThrows(IllegalArgumentException.class, () -> comment.setForumTopic(topic));
	}
	
	/**
	 * This method tests if {@link Comment#setContent(String)} correctly throws an exception if a null string is passed as an argument.
	 */
	@Test
	public void setContentShouldThrowAnExceptionIfContentIsNull() {
		String content = null;
		
		assertThrows(IllegalArgumentException.class, () -> comment.setContent(content));
	}
	
	/**
	 * This method tests if {@link Comment#setContent(String)} correctly throws an exception if an empty string is passed as an argument.
	 */
	@Test
	public void setContentShouldThrowAnExceptionIfContentIsEmpty() {
		String content = " ";
		
		assertThrows(IllegalArgumentException.class, () -> comment.setContent(content));
	}

}
