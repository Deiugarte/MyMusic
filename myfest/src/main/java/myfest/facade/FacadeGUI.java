package myfest.facade;

import java.util.List;

import javax.ws.rs.core.Response;

import Objects.GUISearchGeneral;
import myfest.logic.SearchResults;
import myfest.logic.ListGenres;
import myfest.logic.ListUbications;
import myfest.models.Musicalgenres;

public class FacadeGUI {
	private SearchResults dashboard;
	private ListGenres listGenres;
	private ListUbications listUbications;
	
	public FacadeGUI(){
		dashboard      = new SearchResults();
		listGenres     = new ListGenres();
		listUbications = new ListUbications();
	}
	
	public void getSearchArtistData(GUISearchGeneral objectGUI){
		// return dashboard.
	}
	
	public List<Musicalgenres> getListGenres(){
		return listGenres.getListGenres();
	}
	
	public List<String> getArtistUbication(){
		return listUbications.getListUbications();
	}
	
	
	public void getQualitySearch(){
		
	}
	
	public void getSocialSearch(){
		
	}
}
