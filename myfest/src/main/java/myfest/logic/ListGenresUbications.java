package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import myfest.facade.FacadeDB;
import myfest.models.Musicalgenres;
import myfest.objects.response.ArtistGenres;
import myfest.utils.JSonConverter;

public class ListGenresUbications {
	private FacadeDB facadeDB;
	private JSonConverter json;
	
	public ListGenresUbications(){
		facadeDB = new FacadeDB();
		json = new JSonConverter();
	}	
	/**
	 * Este método retorna un JSon que contiene todos 
	 * los países que hay disponibles en la base de datos
	 * @return
	 */
	public String getListUbications(){
	    List<String> ubications = facadeDB.getUbicationsArtists();
	    List<ArtistGenres> listUbications = new ArrayList<ArtistGenres>();
	    int amountUbications = ubications.size();
	    for (int ubicationIterator = 0; ubicationIterator < amountUbications; ubicationIterator++){
	    	ArtistGenres ubicationObject = new ArtistGenres();
	    	ubicationObject.setDataResponse(ubications.get(ubicationIterator));
	    	listUbications.add(ubicationObject);
	    }
	    return json.jsonConverter(listUbications);
	}
	
	/**
	 * Este método retorna un JSon que contiene todos los 
	 * géneros musicales que hay disponibles en la base de datos
	 * @return
	 */
	public String getListGenres(){
		List<Musicalgenres> genres = facadeDB.getGenres();
	    List<ArtistGenres> listGenres = new ArrayList<ArtistGenres>();
	    int amountGenres = genres.size();
	    for (int genreIterator = 0; genreIterator < amountGenres; genreIterator++){
	    	ArtistGenres ubicationObject = new ArtistGenres();
	    	ubicationObject.setDataResponse(genres.get(genreIterator).getGenreName());
	    	listGenres.add(ubicationObject);
	    }
	    return json.jsonConverter(listGenres);
	}
}