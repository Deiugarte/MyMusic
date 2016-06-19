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
	 * Este método realiza las búsquedas de los artistas por los filtros que el usuario especifique
	 * @param searchValue
	 * @return
	 */
	public String getSearch(DeliveryGeneral searchValue){
		String countrySearch = searchValue.getCountry();
		String genreSearch   = searchValue.getGenre();
		String nameSearch    = searchValue.getName();
		
		if((countrySearch.equals("false"))){
			if (genreSearch.equals("false"))
				return json.jsonConverter(getSearchNames(searchValue));
			else if (nameSearch.equals("false"))
				return json.jsonConverter(getSearchGenres(searchValue));
			else{
				List<ResponseSearch> aux = new ArrayList<ResponseSearch>();
				List<ResponseSearch> name_Genre = getSearchGenres(searchValue);
				List<ResponseSearch> name_Name  = getSearchNames(searchValue);
				
				for (int genreSize = 0; genreSize < name_Genre.size(); genreSize++){
					for (int nameSize = 0; nameSize < name_Name.size(); nameSize++){
						if(name_Genre.get(genreSize).getArtistID().equals(name_Name.get(nameSize).getArtistID()))
							aux.add(name_Name.get(nameSize));
					}
				}
				return json.jsonConverter(aux);
			}
		}else if(nameSearch.equals("false")){
			if(genreSearch.equals("false"))
				return json.jsonConverter(getSearchCountries(searchValue));
			else if(countrySearch.equals("false"))
				return json.jsonConverter(getSearchGenres(searchValue));
			else{
				List<ResponseSearch> aux = new ArrayList<ResponseSearch>();
				List<ResponseSearch> name_Genre = getSearchGenres(searchValue);
				List<ResponseSearch> name_Country  = getSearchCountries(searchValue);		
				for (int genreSize = 0; genreSize < name_Genre.size(); genreSize++){
					for (int countrySize = 0; countrySize < name_Country.size(); countrySize++){
						if(name_Genre.get(genreSize).getArtistID().equals(name_Country.get(countrySize).getArtistID())){
							aux.add(name_Country.get(countrySize));							
						}
					}
				}
				return json.jsonConverter(aux);
			}
		}else if(genreSearch.equals("false")){
			if(nameSearch.equals("false"))
				return json.jsonConverter(getSearchCountries(searchValue));
			else if(countrySearch.equals("false"))
				return json.jsonConverter(getSearchNames(searchValue));
			else{
				List<ResponseSearch> aux = new ArrayList<ResponseSearch>();
				List<ResponseSearch> name_Name = getSearchNames(searchValue);
				List<ResponseSearch> name_Country  = getSearchCountries(searchValue);				
				for (int nameSize = 0; nameSize < name_Name.size(); nameSize++){
					for (int countrySize = 0; countrySize < name_Country.size(); countrySize++){
						if(name_Name.get(nameSize).getArtistID().equals(name_Country.get(countrySize).getArtistID())){
							aux.add(name_Country.get(countrySize));
							
						}
					}
				}
				return json.jsonConverter(aux);
			}
		}else{
			List<ResponseSearch> aux 		   = new ArrayList<ResponseSearch>();
			List<ResponseSearch> name_Name     = getSearchNames(searchValue);
			List<ResponseSearch> name_Country  = getSearchCountries(searchValue);
			List<ResponseSearch> name_Genre    = getSearchGenres(searchValue);
			
			for (int nameSize = 0; nameSize < name_Name.size(); nameSize++){
				for (int countrySize = 0; countrySize < name_Country.size(); countrySize++){
					for (int genreSize = 0; genreSize < name_Genre.size(); genreSize++){
						if(name_Name.get(nameSize).getArtistID().equals(name_Country.get(countrySize).getArtistID()) && 
								name_Name.get(nameSize).getArtistID().equals(name_Genre.get(genreSize).getArtistID())){
							aux.add(name_Country.get(countrySize));
						}
					}
				}
			}
			return json.jsonConverter(aux);
		}
	}
	
	/**
	 * Este método devuelve la lista de nombres de artistas que poseeen alguna coincidencia
	 * con el país buscado
	 * @param searchValue
	 * @return
	 */
	
	private List<ResponseSearch> getSearchNames(DeliveryGeneral searchValue) {		
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		List<Artists> searchName = facadeDB.getSearchName(searchValue.getName());
		List<ResponseSearch> nameSearch = new ArrayList<ResponseSearch>();
		for (int countryIterator = 0; countryIterator < searchName.size(); countryIterator++){
			ResponseSearch valueResponse = new ResponseSearch();
			valueResponse.setArtistID(Integer.toString(searchName.get(countryIterator).getArtistId()));
			valueResponse.setDataResponse(searchName.get(countryIterator).getArtistName());
			nameSearch.add(valueResponse);
		}
		if (amountSearch > nameSearch.size())
			return nameSearch;
		else
			return nameSearch.subList(0, amountSearch);
	}
	

	/**
	 * Este método devuelve la lista de nombres de artistas que poseen alguna coincidencia
	 * con el país buscado
	 * @param searchValue
	 * @return
	 */
	private List<ResponseSearch> getSearchCountries (DeliveryGeneral searchValue){
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		List<Artists> country = facadeDB.getSearchCountry(searchValue.getCountry());
		List<ResponseSearch> countriesSearch = new ArrayList<ResponseSearch>();
		for (int countryIterator = 0; countryIterator < country.size(); countryIterator++){
			ResponseSearch valueResponse = new ResponseSearch();
			valueResponse.setArtistID(Integer.toString(country.get(countryIterator).getArtistId()));
			valueResponse.setDataResponse(country.get(countryIterator).getArtistName());
			countriesSearch.add(valueResponse);
		}
		if (amountSearch > countriesSearch.size())
			return countriesSearch;
		else
			return countriesSearch.subList(0, amountSearch);
	}

	/**
	 * Este método devuelve la lista de nombres de artistas que poseen alguna coincidencia
	 * con el género musical buscado
	 * @param searchValue
	 * @return
	 */
	private List<ResponseSearch> getSearchGenres(DeliveryGeneral searchValue){
		List<ResponseSearch> genresSearch = new ArrayList<ResponseSearch>();
		amountSearch = Integer.parseInt(searchValue.getResultsAmount());
		int idGenreList = (Integer) facadeDB.getIdGenre(searchValue.getGenre());
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
			return genresSearch;
		else
			return genresSearch.subList(0, amountSearch);
	}
}
