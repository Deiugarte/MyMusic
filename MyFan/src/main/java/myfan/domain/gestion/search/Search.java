package myfan.domain.gestion.search;

import java.util.ArrayList;
import java.util.List;

import myfan.controller.request.FindArtistRequest;
import myfan.controller.response.SearchResponse;
import myfan.controller.response.json.JSONFabrication;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;

public class Search {

	private final String EMPTY = "";
	private FacadeDAO facadeDAO;
	private JSONFabrication jsonFabrication;

	public Search() {
		facadeDAO = new FacadeDAO();
		jsonFabrication = new JSONFabrication();
	}

	public String searchArtist(FindArtistRequest artist) {
		String name = artist.getName();
		String nameGenreMusical = artist.getNameGenre();
		String nameUbication = artist.getNameUbication();
		String response = null;

		if (!name.equals(EMPTY) && nameGenreMusical.equals(EMPTY) && nameUbication.equals(EMPTY)) {
			response = convertListOfSearchOfUsers(searchByName(name));
		} else if (!name.equals(EMPTY) && !nameGenreMusical.equals(EMPTY) && nameUbication.equals(EMPTY)) {
			response = convertListOfSearch(searchByNameAndGenre(nameGenreMusical, name));
		} else if (!name.equals(EMPTY) && nameGenreMusical.equals(EMPTY) && !nameUbication.equals(EMPTY)) {
			response = convertListOfSearchOfUsers(searchByNameAndUbication(name, nameUbication));
		} else if (!name.equals(EMPTY) && !nameGenreMusical.equals(EMPTY) && !nameUbication.equals(EMPTY)) {
			response = convertListOfSearch(searchByNameGenreAndUbication(name, nameUbication, nameGenreMusical));
		} else if (name.equals(EMPTY) && !nameGenreMusical.equals(EMPTY) && !nameUbication.equals(EMPTY)) {
			response = convertListOfSearch(searchByGenreAndUbication(nameGenreMusical, nameUbication));
		} else if (name.equals(EMPTY) && !nameGenreMusical.equals(EMPTY) && nameUbication.equals(EMPTY)) {
			response = convertListOfSearch(searchByGenreName(nameGenreMusical));
		} else if (name.equals(EMPTY) && nameGenreMusical.equals(EMPTY) && !nameUbication.equals(EMPTY)) {
			response = convertListOfSearchOfUsers(searchByUbication(nameUbication));
		}

		return response;

	}

	private List<Users> searchByUbication(String nameUbication) {
		Ubications ubications = facadeDAO.findUbicationsByName(nameUbication);
		return facadeDAO.getArtistsByUbication(ubications.getUbicationId());
	}

	private List<Artists> searchByGenreAndUbication(String nameGenreMusical, String nameUbication) {
		List<Artists> artistsByUbicationAndGenre = new ArrayList<Artists>();
		List<Artists> artistsByNameGenre = searchByGenreName(nameGenreMusical);
		for (int i = 0; i < artistsByNameGenre.size(); i++) {
			if (artistsByNameGenre.get(i).getUsers().getUbications().getName().equals(nameUbication)) {
				artistsByUbicationAndGenre.add(artistsByNameGenre.get(i));
			}
		}
		return artistsByUbicationAndGenre;

	}

	private List<Artists> searchByGenreName(String nameGenreMusical) {
		Genres genre = facadeDAO.findGenderByName(nameGenreMusical);
		List<UsersGenres> usersGenres = facadeDAO.findGenresByGenreId(genre.getGenreId());
		List<Artists> artistsByNameGenre = new ArrayList<Artists>();
		for (int i = 0; i < usersGenres.size(); i++) {
			artistsByNameGenre.add(facadeDAO.findArtistByUserId(usersGenres.get(i).getUsers().getUserId()));
		}
		return artistsByNameGenre;
	}

	private List<Artists> searchByNameGenreAndUbication(String name, String nameUbication, String nameGenreMusical) {
		List<Artists> artistsByNameGenreAndName = searchByNameAndGenre(nameGenreMusical,name );
		Ubications ubications = facadeDAO.findUbicationsByName(nameUbication);
		for (int i = 0; i < artistsByNameGenreAndName.size(); i++) {
			List<Artists> artistsByNameUbicationAndGenre = new ArrayList<Artists>();
			if (artistsByNameGenreAndName.get(i).getUsers().getUbications().getUbicationId() == ubications
					.getUbicationId()) {
				artistsByNameUbicationAndGenre.add(artistsByNameGenreAndName.get(i));
			}
		}
		return artistsByNameGenreAndName;
	}

	private List<Users> searchByName(String name) {
		return facadeDAO.getArtistByName(name);
	}

	private List<Users> searchByNameAndUbication(String name, String nameUbication) {
		Ubications ubications = facadeDAO.findUbicationsByName(nameUbication);
		return facadeDAO.getArtistsByNameAndUbication(name, ubications.getUbicationId());

	}

	private List<Artists> searchByNameAndGenre(String nameGenreMusical, String name) {
		List<Artists> artistsByNameGenre = searchByGenreName(nameGenreMusical);
		List<Users> artistsByName = searchByName(name);
		List<Artists> artistsByNameAndGenreUsers = new ArrayList<Artists>();
		for (int i = 0; i < artistsByNameGenre.size(); i++) {
			for (int j = 0; j < artistsByName.size(); j++) {
				if (artistsByNameGenre.get(i).getUsers().getUserId() == artistsByName.get(j).getUserId()) {
					artistsByNameAndGenreUsers.add(artistsByNameGenre.get(i));
				}
			}
		}
		return artistsByNameAndGenreUsers;
	}

	private String convertListOfSearch(List<Artists> artistList) {
		List<SearchResponse> searchResponses = new ArrayList<SearchResponse>();
		if (artistList != null) {
			for (int i = 0; i < artistList.size(); i++) {
				SearchResponse response = new SearchResponse();
				response.setNameArtist(artistList.get(i).getUsers().getName());
				response.setIdUserArtist(artistList.get(i).getUsers().getUserId());
				// response.setIdArtist(artistList.get(i).getArtistId());
				searchResponses.add(response);
			}
		}
		return jsonFabrication.jsonConverter(searchResponses);
	}

	private String convertListOfSearchOfUsers(List<Users> artistList) {
		List<SearchResponse> searchResponses = new ArrayList<SearchResponse>();
		if (artistList != null) {
			for (int i = 0; i < artistList.size(); i++) {
				SearchResponse response = new SearchResponse();
				response.setNameArtist(artistList.get(i).getName());
				response.setIdUserArtist(artistList.get(i).getUserId());
				// response.setIdArtist(artistList.get(i).getArtistId());
				searchResponses.add(response);
			}
		}
		return jsonFabrication.jsonConverter(searchResponses);
	}
}
