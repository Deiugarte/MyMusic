package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Discs;
import myfan.data.models.DiscsCalifications;
import myfan.data.models.Songs;
import myfan.resources.base.DiscographyResponse;
import myfan.resources.base.util.Disc;
import myfan.resources.base.util.Song;

public class DiscographyLogic {
	private final int ONE_COMMENT = 1;
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;

	public DiscographyLogic() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();

	}

	public String getDiscography(int idUser) {
		Artists artists = facadeDAO.findArtistByUserId(idUser);
		List<Discs> discs = facadeDAO.findDiscByArtistId(artists.getArtistId());
		List<Disc> discsResponse = new ArrayList<Disc>();
		DiscographyResponse discographyResponse = new DiscographyResponse();
		for (int i = 0; i < discs.size(); i++) {
			Disc disc = new Disc();
			disc.setRecordLabel(discs.get(i).getLabel());
			disc.setYear(discs.get(i).getReleaseYear().toString());
			disc.setGenre(discs.get(i).getGenres().getName());
			disc.setStars(calculateDiscAverage(discs.get(i).getDiscId()));
			disc.setSongsAmount(calculateTotalOfSongs(discs.get(i).getDiscId()));
			disc.setCommentsAmount(calculateTotalOfComments(discs.get(i).getDiscId()));
			disc.setSongs( findSongByIdDisc(discs.get(i).getDiscId()));
			discsResponse.add(disc);
		}
		discographyResponse.setDiscs(discsResponse);
		return jSONFabrication.jsonConverter(discographyResponse);

	}

	private List<Song> findSongByIdDisc(int idDisc) {
		List<Songs> songs = facadeDAO.getSongsByIdDisc(idDisc);
		List<Song> songsList = new ArrayList<Song>();
		for (int i = 0; i < songs.size(); i++) {
			Song song = new Song();
			song.setDuration(songs.get(i).getDuration());
			song.setName(songs.get(i).getName());
			song.setType(songs.get(i).isState());
			song.setVersion(songs.get(i).getLimitation());
			song.setVideo(songs.get(i).getVideoLink());
			songsList.add(song);
		}
		return songsList;
	}

	private int calculateTotalOfComments(int idDisc) {
		List<DiscsCalifications> discCalifications = facadeDAO.getCalificationsOfDiscs(idDisc);
		int totalOfComments = 0;
		for (int i = 0; i < discCalifications.size(); i++) {
			if (!discCalifications.get(i).getComment().equals("") || discCalifications.get(i).getComment() != null) {
				totalOfComments += ONE_COMMENT;
			}
		}
		return totalOfComments;
	}

	private int calculateTotalOfSongs(int idDisc) {
		return facadeDAO.getSongsByIdDisc(idDisc).size();
	}

	private int calculateDiscAverage(int idDisc) {
		List<DiscsCalifications> discsCalifications = facadeDAO.getCalificationsOfDiscs(idDisc);
		int sumCalifications = 0;
		int average = 0;
		for (int i = 0; i < discsCalifications.size(); i++) {
			sumCalifications += discsCalifications.get(i).getCalification();
		}
		average = (sumCalifications / discsCalifications.size()) * 100;
		return average;

	}
}
