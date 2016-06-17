package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import Objects.GUISearchSpecific;
import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.models.Artistsscores;
import myfest.models.Concertsscores;
import myfest.models.Discsscores;
import myfest.models.Musicalgenres;
import myfest.models.Twittermentions;

public class Dashboard {
	private FacadeDB facadeDB;

	public Dashboard(){
		facadeDB = new FacadeDB();
	}

	public List<Object> getDataArtist(int artistID){
		// return list
		List<Object> artistDashboard = new ArrayList<Object>();
		
		List<Artistsgenres> genresOfArtist = facadeDB.getGenresByArtistID(Integer.toString(artistID));
		Artists artist = facadeDB.getArtistById(artistID);
		artistDashboard.add(artist.getImage());
		artistDashboard.add(artist.getArtistName());
		artistDashboard.add(artist.getFollowersAmount());
		// sublist of genders name
		List<String> genresName = new ArrayList<String>();
		for (int i = 0; i < genresOfArtist.size(); i++){
			int musicalGenreId = genresOfArtist.get(i).getId().getGendeId();
			Musicalgenres musicalgenres = facadeDB.getMusicalGenreByID(musicalGenreId);
			genresName.add(musicalgenres.getGenreName());
		}
		artistDashboard.add(genresName);
		
		// sublist of artist scores
		Artistsscores artistsscores = facadeDB.getArtistsScoresByID(artistID);
		List<String> artistScores = new ArrayList<String>();
		artistScores.add(Integer.toString(artistsscores.getScore()));
		artistScores.add(Integer.toString(artistsscores.getVoters()));
		artistScores.add(Integer.toString(artistsscores.getCommentAmount()));
		artistDashboard.add(artistScores);
		
		// sublist of concert scores
		Concertsscores concertsscores = facadeDB.getConcertsScoresByID(artistID);
		List<String> concertScores = new ArrayList<String>();
		concertScores.add(Integer.toString(concertsscores.getScore()));
		concertScores.add(Integer.toString(concertsscores.getVoters()));
		concertScores.add(Integer.toString(concertsscores.getCommentAmount()));
		artistDashboard.add(concertScores);
		
		// sublist of disc scores
		Discsscores discscores = facadeDB.getDiscScoresByID(artistID);
		List<String> discScores = new ArrayList<String>();
		discScores.add(Integer.toString(discscores.getScore()));
		discScores.add(Integer.toString(discscores.getVoters()));
		discScores.add(Integer.toString(discscores.getCommentAmount()));
		artistDashboard.add(discScores);
		
		// amount of twitter mentions
		//List<Twittermentions> twittermentions = facadeDB.getTwitterMentionsAmountByID(Integer.toString(artistID));
		//artistDashboard.add(twittermentions.size());
			
		return artistDashboard;
    //return facadeDB.getSearchSpecific(guiSearchSpecific);
	}
}
