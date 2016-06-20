package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Events;
import myfan.data.models.EventsCalifications;
import myfan.resources.base.CalificationsResponse;
import myfan.resources.base.util.Comments;

public class CommentsConcert {

	private static final int DISABLE_ROLE = 13;
	private final int ONE_COMMENT = 1;
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;

	public CommentsConcert() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
	}

	public String getCalificationsOfConcert(int idEvent) {
		Events concert = facadeDAO.findEventById(idEvent);
		CalificationsResponse calificationsResponse = new CalificationsResponse();
		calificationsResponse.setAverageOfCalifications(calculateRankingConcerts(concert.getEventId()));
		calificationsResponse.setTotalOfCalifications(calculateTotalOfCalifications(concert.getEventId()));
		calificationsResponse.setTotalOfComents(calculateTotalOfComments(concert.getEventId()));
		calificationsResponse.setComents(getCommentForConcerts(concert.getEventId()));
		return jSONFabrication.jsonConverter(calificationsResponse);
	}

	private List<Comments> getCommentForConcerts(int idEvent) {
		List<Comments> comments = new ArrayList<Comments>();
		List<EventsCalifications> concertsCalifications = facadeDAO.getCalificationByConcert(idEvent);
		for (int i = 0; i < concertsCalifications.size(); i++) {
			if (!concertsCalifications.get(i).getComment().equals("")|| concertsCalifications.get(i).getComment() != null) {
				if (concertsCalifications.get(i).getFanatics().getUsers().getUsersRoles().getUsersRolesId() != DISABLE_ROLE) {
					Comments comment = new Comments();
					System.out.println(concertsCalifications.get(i).getComment());
					comment.setCalification(concertsCalifications.get(i).getCalification());
					comment.setComment(concertsCalifications.get(i).getComment());
					comment.setReviewer(concertsCalifications.get(i).getFanatics().getUsers().getName());
					comments.add(comment);
				}
			}
		}
		return comments;
	}

	private int calculateTotalOfComments(int idEvent) {
		List<EventsCalifications> concertCalifications = facadeDAO.getCalificationByConcert(idEvent);
		int totalOfComments = 0;
		for (int i = 0; i < concertCalifications.size(); i++) {
			if (!concertCalifications.get(i).getComment().equals("")|| concertCalifications.get(i).getComment() != null) {
				totalOfComments += ONE_COMMENT;
			}
		}
		return totalOfComments;
	}

	public int calculateRankingConcerts(int idEvent) {
		List<EventsCalifications> concertsCalifications = facadeDAO.getCalificationByConcert(idEvent);
		int sumOfCalifications = 0;
		int average = 0;
		if (concertsCalifications.size() != 0) {
			for (int i = 0; i < concertsCalifications.size(); i++) {
				sumOfCalifications += concertsCalifications.get(i).getCalification();
			}
			average = (sumOfCalifications / concertsCalifications.size());
		}
		return average;
	}

	public int calculateTotalOfCalifications(int idEvent) {
		List<EventsCalifications> eventsCalifications = facadeDAO.getCalificationByConcert(idEvent);
		return eventsCalifications.size();

	}

}
