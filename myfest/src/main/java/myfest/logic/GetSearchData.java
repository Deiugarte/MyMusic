package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.objects.delivery.DeliveryGeneral;
import myfest.objects.response.ResponseSearch;
import myfest.utils.JSonConverter;

public class GetSearchData {
	private FacadeDB facadeDB;
	private int amountSearch;
	private JSonConverter json;

	public GetSearchData(){
		facadeDB = new FacadeDB();
		amountSearch = 0;
		json = new JSonConverter();
	}

	
	/**
	 * Este método devuelve la lista de nombres de artistas que poseeen alguna coincidencia
	 * con el país buscado
	 * @param searchValue
	 * @return
	 */
	public String getSearchNames(DeliveryGeneral searchValue) {		
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		List<Artists> searchName = facadeDB.getSearchName(searchValue.getValueSearch());
		List<ResponseSearch> nameSearch = new ArrayList<ResponseSearch>();
		for (int countryIterator = 0; countryIterator < searchName.size(); countryIterator++){
			ResponseSearch valueResponse = new ResponseSearch();
			valueResponse.setArtistID(Integer.toString(searchName.get(countryIterator).getArtistId()));
			valueResponse.setDataResponse(searchName.get(countryIterator).getArtistName());
			nameSearch.add(valueResponse);
		}
		if (amountSearch > nameSearch.size())
			return json.jsonConverter(nameSearch);
		else
			return json.jsonConverter(nameSearch.subList(0, amountSearch));
	}
	

	/**
	 * Este método devuelve la lista de nombres de artistas que poseen alguna coincidencia
	 * con el país buscado
	 * @param searchValue
	 * @return
	 */
	public String getSearchCountry(DeliveryGeneral searchValue){
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		List<Artists> country = facadeDB.getSearchCountry(searchValue.getValueSearch());
		List<ResponseSearch> countriesSearch = new ArrayList<ResponseSearch>();
		for (int countryIterator = 0; countryIterator < country.size(); countryIterator++){
			ResponseSearch valueResponse = new ResponseSearch();
			valueResponse.setArtistID(Integer.toString(country.get(countryIterator).getArtistId()));
			valueResponse.setDataResponse(country.get(countryIterator).getArtistName());
			countriesSearch.add(valueResponse);
		}
		if (amountSearch > countriesSearch.size())
			return json.jsonConverter(countriesSearch);
		else
			return json.jsonConverter(countriesSearch.subList(0, amountSearch));
	}

	/**
	 * Este método devuelve la lista de nombres de artistas que poseen alguna coincidencia
	 * con el género musical buscado
	 * @param searchValue
	 * @return
	 */
	public String getSearchGenres(DeliveryGeneral searchValue){
		List<ResponseSearch> genresSearch = new ArrayList<ResponseSearch>();
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		int idGenreList = (Integer) facadeDB.getIdGenre(searchValue.getValueSearch());
		List<Artistsgenres> listArtistId = facadeDB.getArtistId(Integer.toString(idGenreList));
		for (int iterator = 0; iterator < listArtistId.size(); iterator ++){
			Artists artist = new Artists();
			artist = facadeDB.getArtistById(listArtistId.get(iterator).getId().getArtistId());
			ResponseSearch genre = new ResponseSearch();
			genre.setArtistID(Integer.toString(artist.getArtistId()));
			genre.setDataResponse(artist.getArtistName());
			genresSearch.add(genre);
		}
		if (genresSearch.size() < amountSearch)
			return json.jsonConverter(genresSearch);
		else
			return json.jsonConverter(genresSearch.subList(0, amountSearch));
	}
}
