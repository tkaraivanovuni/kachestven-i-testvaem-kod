package controllers;

import java.util.ArrayList;
import java.util.List;

import enums.Role;
import interfaces.ForumTopic;
import models.Comment;
import models.User;
import repositories.ForumRepo;

/**
 * This class handles operations on {@link Comment} and {@link ForumTopic} type
 * objects.
 */
public class ForumController {

	/**
	 * This method provides a list of all comments made by the user.
	 * 
	 * @param user - the {@link User} checking his comments.
	 * @return - a list of all comments by the user.
	 */
	public List<Comment> getUserComments(User user) {
		List<Comment> userComments = new ArrayList<>();
		for (Comment comment : ForumRepo.forumComments) {
			if (comment.getUser().equals(user)) {
				userComments.add(comment);
			}
		}
		return userComments;
	}

	/**
	 * This method deletes a comment from the forum.
	 * 
	 * @param user    - the user requesting the deletion.
	 * @param comment - the comment to be deleted.
	 * @return - string representation of the outcome.
	 */
	public String delete(User user, Comment comment) {
		if (user.roles.contains(Role.ADMIN)) {
			ForumRepo.forumComments.remove(comment);
			return "Comment deleted!";
		}
		return "You do not have permission to delete a comment!";
	}

}
