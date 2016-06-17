package myfest.logic;

import java.util.ArrayList;
import java.util.List;

import myfest.facade.FacadeDB;
import myfest.models.Musicalgenres;
import myfest.objects.response.ResponseUnique;
import myfest.utils.JSonConverter;

public class GetListGenresUbications {
	private FacadeDB facadeDB;
	private JSonConverter json;
	
	public GetListGenresUbications(){
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
	    List<ResponseUnique> listUbications = new ArrayList<ResponseUnique>();
	    int amountUbications = ubications.size();
	    for (int ubicationIterator = 0; ubicationIterator < amountUbications; ubicationIterator++){
	    	ResponseUnique ubicationObject = new ResponseUnique();
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
	    List<ResponseUnique> listGenres = new ArrayList<ResponseUnique>();
	    int amountGenres = genres.size();
	    for (int genreIterator = 0; genreIterator < amountGenres; genreIterator++){
	    	ResponseUnique ubicationObject = new ResponseUnique();
	    	ubicationObject.setDataResponse(genres.get(genreIterator).getGenreName());
	    	listGenres.add(ubicationObject);
	    }
	    return json.jsonConverter(listGenres);
	}
}