package models;

import java.util.List;

import interfaces.ForumTopic;

public class Subtopic implements ForumTopic {

	/**
	 * List of comments on the subtopic.
	 */
	public List<Comment> comments;
	private Topic mainTopic;

	/**
	 * Constructor for Subtopic.
	 * 
	 * @param mainTopic - the {@link Topic} that the subtopic is in.
	 */
	public Subtopic(Topic mainTopic) {
		setMainTopic(mainTopic);
	}

	/**
	 * This method sets the main topic of the subtopic.
	 * 
	 * @param mainTopic - an object of type {@link Topic}.
	 */
	public void setMainTopic(Topic mainTopic) {
		if (mainTopic == null) {
			throw new IllegalArgumentException("The subtopic must be part of a main topic!");
		}
		this.mainTopic = mainTopic;
	}
	
	/**
	 * This method overrides hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((mainTopic == null) ? 0 : mainTopic.hashCode());
		return result;
	}
	
	/**
	 * This method overrides equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subtopic other = (Subtopic) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (mainTopic == null) {
			if (other.mainTopic != null)
				return false;
		} else if (!mainTopic.equals(other.mainTopic))
			return false;
		return true;
	}

}
