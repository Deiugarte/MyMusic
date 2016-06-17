package myfest.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Objects.GUISearchGeneral;
import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;

public class GetSearchData {
	private FacadeDB facadeDB;
	private int amountSearch;

	public GetSearchData(){
		facadeDB = new FacadeDB();
		amountSearch = 0;
	}


	public List<Artists> getSearchNames(GUISearchGeneral guiObject) {
		amountSearch = Integer.parseInt(guiObject.getResultsAmount());
		List<Artists> searchName = facadeDB.getSearchName(guiObject.getValueSearch());
		if (amountSearch > searchName.size())
			return searchName;
		else
			return searchName.subList(0, amountSearch);
	}

	public List<Artists> getSearchCountry(GUISearchGeneral guiObject){
		amountSearch = Integer.parseInt(guiObject.getResultsAmount());
		List<Artists> searchCountry = facadeDB.getSearchCountry_Genre(guiObject.getValueSearch());

		if (amountSearch > searchCountry.size())
			return searchCountry;
		else
			return searchCountry.subList(0, amountSearch);
	}

	public List<Artists> getSearchGenres(GUISearchGeneral guiObject){
		List<Artists> genresByName = new ArrayList<Artists>();
		amountSearch = Integer.parseInt(guiObject.getResultsAmount());
		int idGenreList = (Integer) facadeDB.getIdGenre(guiObject.getValueSearch());
		List<Artistsgenres> listArtistId = facadeDB.getArtistId(Integer.toString(idGenreList));
		for (int iterator = 0; iterator < listArtistId.size(); iterator ++){
			Artists artist = new Artists();
			artist = facadeDB.getArtistById(listArtistId.get(iterator).getId().getArtistId());
			genresByName.add(artist);
		}
		if (genresByName.size() < amountSearch)
			return genresByName;
		else
			return genresByName.subList(0, amountSearch);
	}
}
