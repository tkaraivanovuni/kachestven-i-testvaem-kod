package repositories;

import java.util.ArrayList;
import java.util.List;

import interfaces.ForumTopic;
import models.Comment;

/**
 * This class simulates a storage of all {@link Comment} objects on the forum.
 */
public class ForumRepo {
	
	/**
	 * A list of all comments on the forum.
	 */
	public static List<Comment> forumComments = new ArrayList<>();
	/**
	 * A list of all topics on the forum.
	 */
	public static List<ForumTopic> forumTopics = new ArrayList<ForumTopic>();
	
	/**
	 * Constructor for {@link ForumRepo}.
	 */
	private ForumRepo() {
		
	}
		
}
