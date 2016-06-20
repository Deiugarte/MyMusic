package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.models.Twittermentions;
import myfest.objects.response.ResponseDashboard;
import myfest.utils.JSonConverter;

public class Dashboard {
	private FacadeDB facadeDB;
	private JSonConverter json;

	public Dashboard() {
		facadeDB = new FacadeDB();
		json = new JSonConverter();
	}

	public String getDataArtist(int artistID) {
		ResponseDashboard artistDashboard = new ResponseDashboard();
		Artists artist = facadeDB.getArtistById(artistID);
		artistDashboard.setName(artist.getArtistName());
		artistDashboard.setFollowersAmount(artist.getFollowersAmount());
		artistDashboard.setPicture(artist.getImage());
		artistDashboard.setArtistScore(artist.getArtistsscores().getScore());
		artistDashboard.setConcertScore(artist.getConcertsscores().getScore());
		artistDashboard.setDiscScore(artist.getDiscsscores().getScore());
		artistDashboard.setTwitterMentionsAmount(getTotalOfTwitterMentions(artistID));
		artistDashboard.setArtistGenders(getGenresOfArtist(artistID));

		return json.jsonConverter(artistDashboard);
	}

	private List<String> getGenresOfArtist(int artistID) {
		List<String> artistGenres = new ArrayList<String>();

		List<Artistsgenres> genresOfArtist = facadeDB.getGenresByArtistID(artistID);
		for (int i = 0; i < genresOfArtist.size(); i++) {
			artistGenres.add(genresOfArtist.get(i).getMusicalgenres().getGenreName());
		}
		return artistGenres;
	}

	private int getTotalOfTwitterMentions(int artistID) {
		List<Twittermentions> twittermentions = facadeDB.getTwitterMentionsAmountByID(artistID);
		return twittermentions.size();
	}

}
