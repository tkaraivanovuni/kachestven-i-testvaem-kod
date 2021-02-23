package models;

import java.util.ArrayList;
import java.util.List;

import interfaces.ForumTopic;

/**
 * This class provides the main characteristics of the {@link Topic} data model.
 */
public class Topic implements ForumTopic{
	
	/**
	 * List of subtopic of the topic.
	 */
	public List<Topic> subtopics;
	/**
	 * List of comments on the topic.
	 */
	public List<Comment> comments;
	
	/**
	 * Constructor for {@link Topic}
	 */
	public Topic() {
		this.subtopics = new ArrayList<Topic>();
		this.comments = new ArrayList<>();
	}
	
	/**
	 * This method overrides the hashCode method.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((subtopics == null) ? 0 : subtopics.hashCode());
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
		Topic other = (Topic) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (subtopics == null) {
			if (other.subtopics != null)
				return false;
		} else if (!subtopics.equals(other.subtopics))
			return false;
		return true;
	}
	
}
