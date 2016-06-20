package myfest.facade;

import java.util.List;

import myfest.dao.ArtistsDAO;
import myfest.dao.ArtistsGenresDAO;
import myfest.dao.ArtistsScoresDAO;
import myfest.dao.ConcertScoresDAO;
import myfest.dao.DiscsScoresDAO;
import myfest.dao.MusicalGenresDAO;
import myfest.dao.TwitterMentionsDAO;
import myfest.models.Musicalgenres;
import myfest.models.Twittermentions;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.models.Artistsscores;
import myfest.models.Concertsscores;
import myfest.models.Discsscores;

public class FacadeDB {
	private MusicalGenresDAO musicalGenresDAO;
	private ArtistsGenresDAO artistsGenresDAO;
	private ArtistsDAO artistsDAO;
	private ArtistsScoresDAO artistsScoresDAO;
	private ConcertScoresDAO concertsscoresDAO;
	private DiscsScoresDAO discsScoresDAO;
	private TwitterMentionsDAO twitterMentionsDAO;

	public FacadeDB() {
		musicalGenresDAO = new MusicalGenresDAO();
		artistsGenresDAO = new ArtistsGenresDAO();
		artistsDAO = new ArtistsDAO();
		artistsScoresDAO = new ArtistsScoresDAO();
		concertsscoresDAO = new ConcertScoresDAO();
		discsScoresDAO = new DiscsScoresDAO();
		twitterMentionsDAO= new TwitterMentionsDAO();
	}

	// country search
	public List<Artists> getSearchCountry(String country) {
		return artistsDAO.getArtistNameByCountry(country);
	}

	// name search
	public List<Artists> getSearchName(String name) {
		return artistsDAO.getArtistNameByName(name);
	}

	// genre search
	public Object getIdGenre(String genreName) {
		return musicalGenresDAO.getGenreId(genreName);
	}

	public Artists getArtistById(int id) {
		return artistsDAO.getArtistsById(id);
	}

	public List<Artistsgenres> getArtistId(String id) {
		return artistsGenresDAO.getArtistId(id);
	}

	// initial petitions
	public List<Musicalgenres> getGenres() {
		return musicalGenresDAO.findAll();
	}

	public List<String> getUbicationsArtists() {
		return artistsDAO.getUbicationsArtists();
	}

	// Get genre id by artist id
	public List<Artistsgenres> getGenresByArtistID(int idArtist) {
		return artistsGenresDAO.getGenreId(idArtist);
	}

	// Get musicalGenres by id

	public Musicalgenres getMusicalGenreByID(int musicalGenreID) {
		return musicalGenresDAO.getGenresById(musicalGenreID);
	}

	// Get artistsScores by id

	public Artistsscores getArtistsscoresByID( int artistID) {
		return artistsScoresDAO.getArtistsScoreById(artistID);
	}

	// Get concertsScores by id
	public Concertsscores getConcertsScoresByID(int artistID) {
		return concertsscoresDAO.getArtistsById(artistID);
	}

	// Get discScores by id
	public Discsscores getDiscScoresByID(int discsID) {
		return discsScoresDAO.getArtistsById(discsID);
	}

	// Get amount twitter mentions by id

	public List<Twittermentions> getTwitterMentionsAmountByID(int  idArtist) {
		return twitterMentionsDAO.getTwitterMentionsByID(idArtist);
	}
}
