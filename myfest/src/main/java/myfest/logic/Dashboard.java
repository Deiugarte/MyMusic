package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.models.Artistsscores;
import myfest.models.Concertsscores;
import myfest.models.Discsscores;
import myfest.models.Musicalgenres;
import myfest.models.Twittermentions;
import myfest.objects.delivery.DeliverySpecific;
import myfest.objects.response.ResponseDashboard;
import myfest.objects.response.ResponseScores;
import myfest.objects.response.ResponseUnique;
import myfest.utils.JSonConverter;

public class Dashboard {
	private FacadeDB 	  facadeDB;
	private JSonConverter json;

	public Dashboard(){
		facadeDB = new FacadeDB();
		json     = new JSonConverter();
	}

	public String getDataArtist(DeliverySpecific artistID){
		ResponseDashboard artistDashboard = new ResponseDashboard();		
		
		Artists artist = facadeDB.getArtistById(Integer.parseInt(artistID.getValueSearch()));
		artistDashboard.setImage(artist.getImage());
		artistDashboard.setName(artist.getArtistName());
		artistDashboard.setFollowersAmount(artist.getFollowersAmount());
		// sublist of genders name
		List<ResponseUnique> artistGenres = new ArrayList<ResponseUnique>();
		List<Artistsgenres> genresOfArtist = facadeDB.getGenresByArtistID(artistID.getValueSearch());
		for (int i = 0; i < genresOfArtist.size(); i++){
		    int musicalGenreId = genresOfArtist.get(i).getId().getGendeId();
			Musicalgenres musicalgenres = facadeDB.getMusicalGenreByID(musicalGenreId);
			ResponseUnique genre = new ResponseUnique();
			genre.setDataResponse(musicalgenres.getGenreName());
			artistGenres.add(genre);
		}
		artistDashboard.setArtistGenders(artistGenres);
		// Artist Score
		ResponseScores artistsScore = new ResponseScores();
		Artistsscores scoreArtist = facadeDB.getArtistsScoresByID(Integer.parseInt(artistID.getValueSearch()));
		artistsScore.setCommentsAmount(scoreArtist.getCommentAmount());
		artistsScore.setScore(scoreArtist.getScore());
		artistsScore.setVoters(scoreArtist.getVoters());
		artistDashboard.setArtistScore(artistsScore);
		
		// Concert Score
		ResponseScores concertsScore = new ResponseScores();
		Concertsscores scoreConcert = facadeDB.getConcertsScoresByID(Integer.parseInt(artistID.getValueSearch()));
		concertsScore.setScore(scoreConcert.getScore());
		concertsScore.setVoters(scoreConcert.getVoters());
		concertsScore.setCommentsAmount(scoreConcert.getCommentAmount());
		artistDashboard.setConcertScore(concertsScore);
		
		// Disc Score
		ResponseScores discsScore = new ResponseScores();
		Discsscores discscores = facadeDB.getDiscScoresByID(Integer.parseInt(artistID.getValueSearch()));
		discsScore.setScore(discscores.getScore());
		discsScore.setVoters(discscores.getVoters());
		discsScore.setCommentsAmount(discscores.getCommentAmount());
		artistDashboard.setDiscScore(discsScore);
		
		// Twitter Mentions
		List<Twittermentions> twittermentions = facadeDB.getTwitterMentionsAmountByID(artistID.getValueSearch());
		artistDashboard.setTwitterMentionsAmount(twittermentions.size());
			
		return json.jsonConverter(artistDashboard);
	}
}
