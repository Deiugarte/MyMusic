package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Discs;
import myfan.data.models.DiscsCalifications;
import myfan.resources.base.CalificationsResponse;
import myfan.resources.base.util.Comments;

public class CommentsDisc extends DiscographyLogic {
	private final int DISABLE_ROLE = 13;
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;

	public CommentsDisc() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
	}

	public String getCalificationsOfDisc(int idDisc) {
		Discs discs = facadeDAO.findDiscById(idDisc);
		CalificationsResponse calificationsResponse = new CalificationsResponse();
		calificationsResponse.setAverageOfCalifications(calculateDiscAverage(discs.getDiscId()));
		calificationsResponse.setTotalOfCalifications(calculateTotalOfCalifications(discs.getDiscId()));
		calificationsResponse.setTotalOfComents(calculateTotalOfComments(discs.getDiscId()));
		calificationsResponse.setComents(getCommentForDisc(discs.getDiscId()));
		return jSONFabrication.jsonConverter(calificationsResponse);
	}

	private List<Comments> getCommentForDisc(int idDisc) {
		List<Comments> comments = new ArrayList<Comments>();
		List<DiscsCalifications> discCalifications = facadeDAO.getCalificationsOfDiscs(idDisc);
		for (int i = 0; i < discCalifications.size(); i++) {
			if (!discCalifications.get(i).getComment().equals("") || discCalifications.get(i).getComment() != null) {
				if (discCalifications.get(i).getFanatics().getUsers().getUsersRoles()
						.getUsersRolesId() == DISABLE_ROLE) {
					Comments comment = new Comments();
					comment.setCalification(discCalifications.get(i).getCalification());
					comment.setComment(discCalifications.get(i).getComment());
					comment.setReviewer(discCalifications.get(i).getFanatics().getUsers().getName());
					comments.add(comment);
				}
			}
		}
		return comments;
	}

	private int calculateTotalOfCalifications(int idDisc) {
		List<DiscsCalifications> artistsCalifications = facadeDAO.getCalificationsOfDiscs(idDisc);
		return artistsCalifications.size();

	}

}
