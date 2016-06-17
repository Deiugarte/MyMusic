package myfest.facade;

import java.util.List;

import Objects.GUISearchGeneral;
import Objects.GUISearchSpecific;
import myfest.logic.Dashboard;
import myfest.logic.GetListGenresUbications;
import myfest.logic.GetSearchData;
import myfest.models.Musicalgenres;
import myfest.models.Artists;

public class FacadeGUI {
	private Dashboard  dashboard;
	private GetListGenresUbications listData;
	private GetSearchData searchData;
	
	public FacadeGUI(){
		dashboard  = new Dashboard();
		listData   = new GetListGenresUbications();
		searchData = new GetSearchData();
	}
	
	// Dashboard
	public List<Object> getSearchArtistData(int artistID){
		return dashboard.getDataArtist(artistID);
	}
	
	// Initial
	public List<Musicalgenres> getListGenres(){
		return listData.getListGenres();
	}
	
	public List<String> getListUbication(){
		return listData.getListUbications();
	}
	
	// Search
	public List<Artists> getSearchNames(GUISearchGeneral objectGUI){
		return searchData.getSearchNames(objectGUI);
	}
	
	public List<Artists> getSearchGenders(GUISearchGeneral objectGUI){
		return searchData.getSearchGenres(objectGUI);
	}
	
	public List<Artists> getSearchCountries(GUISearchGeneral objectGUI){
		return searchData.getSearchCountry(objectGUI);
	}
	
	public void getQualitySearch(){
		
	}
	
	public void getSocialSearch(){
		
	}
}
