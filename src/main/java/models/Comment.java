package models;

import interfaces.ForumTopic;

/**
 * This class provides the main characteristics of the {@link Comment} data
 * model.
 */
public class Comment {

	private User user;
	private ForumTopic forumTopic;
	private String content;

	/**
	 * Constructor for {@link Comment}.
	 * 
	 * @param user    - the {@link User} that posts the comment.
	 * @param content - string representation of the comment content.
	 */
	public Comment(User user, ForumTopic forumTopic, String content) {
		setUser(user);
		setForumTopic(forumTopic);
		setContent(content);
	}

	/**
	 * This method sets the {@link User} that posts the comment.
	 * 
	 * @param user - a User object.
	 */
	public void setUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("You must be logged in to post a comment!");
		}
		this.user = user;
	}

	/**
	 * This method sets the {@link ForumTopic} of the comment.
	 * 
	 * @param forumTopic - an object of type that implements ForumTopic.
	 */
	public void setForumTopic(ForumTopic forumTopic) {
		if (forumTopic == null) {
			throw new IllegalArgumentException("The comment must be part of a topic!");
		}
		this.forumTopic = forumTopic;
	}

	/**
	 * This method sets the content of the {@link Comment}.
	 * 
	 * @param user - string representation of the comment's content.
	 */
	public void setContent(String content) {
		if (content == null || content.trim().isEmpty()) {
			throw new IllegalArgumentException("You cannot post an empty comment!");
		}
		this.content = content;
	}
	
	/**
	 * This method returns the user that posted the comment.
	 * 
	 * @return - {@link User} object.
	 */
	public User getUser() {
		return this.user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((forumTopic == null) ? 0 : forumTopic.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (forumTopic == null) {
			if (other.forumTopic != null)
				return false;
		} else if (!forumTopic.equals(other.forumTopic))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
