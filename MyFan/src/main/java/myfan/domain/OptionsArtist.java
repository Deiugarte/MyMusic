package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.ArtistsCalifications;
import myfan.resources.base.ArtistCalificationsResponse;
import myfan.resources.base.util.Comments;

public class OptionsArtist {

	private final int ONE_COMMENT = 1;
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;

	public OptionsArtist() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
	}

	public String getCalificationsOfArtist(int idUser){
		Artists artists = facadeDAO.findArtistByUserId(idUser);
		ArtistCalificationsResponse artistCalificationsResponse = new ArtistCalificationsResponse();
		artistCalificationsResponse.setAverageOfCalifications(calculateRankingArtist(artists.getArtistId()));
		artistCalificationsResponse.setTotalOfCalifications(calculateTotalOfCalifications(artists.getArtistId()));
		artistCalificationsResponse.setTotalOfComents(calculateTotalOfComments(artists.getArtistId()));
		artistCalificationsResponse.setComents(getCommentForArtist(artists.getArtistId()));
		return jSONFabrication.jsonConverter(artistCalificationsResponse);
	}
	
	private List<Comments> getCommentForArtist(int idArtist){
		 List<Comments> comments = new ArrayList<Comments>();
		 List<ArtistsCalifications> artistsCalifications = facadeDAO.getArtistCalificationByIdArtist(idArtist);
			for (int i = 0; i < artistsCalifications.size(); i++) {
				if(!artistsCalifications.get(i).getComment().equals("") || artistsCalifications.get(i).getComment()!=null ){
					Comments comment = new Comments();
					comment.setCalification(artistsCalifications.get(i).getCalification());
					comment.setComment(artistsCalifications.get(i).getComment());
					comment.setReviewer(artistsCalifications.get(i).getFanatics().getUsers().getName());
					comments.add(comment);
				}
			}
		 return comments;
	}
	private int calculateTotalOfComments(int idArtist){
		List<ArtistsCalifications> artistsCalifications = facadeDAO.getArtistCalificationByIdArtist(idArtist);
		int totalOfComments=0;
		for (int i = 0; i < artistsCalifications.size(); i++) {
			if(!artistsCalifications.get(i).getComment().equals("") || artistsCalifications.get(i).getComment()!=null ){
				totalOfComments += ONE_COMMENT;
			}
		}
		return totalOfComments;
	}
	public int calculateRankingArtist(int idArtist) {
		// Artists artists = facadeDAO.findArtistById(idArtist);
		List<ArtistsCalifications> artistsCalifications = facadeDAO.getArtistCalificationByIdArtist(idArtist);
		int sumOfCalifications = 0;
		int average = 0;
		if (artistsCalifications.size() != 0) {
			for (int i = 0; i < artistsCalifications.size(); i++) {
				sumOfCalifications += artistsCalifications.get(i).getCalification();
			}
			average = (sumOfCalifications / artistsCalifications.size()) * 100;
		}
		return average;
	}

	public int calculateTotalOfCalifications(int idArtist) {
		List<ArtistsCalifications> artistsCalifications = facadeDAO.getArtistCalificationByIdArtist(idArtist);
		return artistsCalifications.size();

	}

	public int calculateTotalOfDisc(int idArtist) {
		return facadeDAO.getDiscsByIdArtist(idArtist).size();
	}
	

}