package myfest.facade;

import java.util.List;

import Objects.GUISearchGeneral;
import Objects.GUISearchSpecific;
import myfest.logic.Dashboard;
import myfest.logic.GetListGenresUbications;
import myfest.logic.GetSearchData;
import myfest.models.Musicalgenres;

public class FacadeGUI {
	private Dashboard  dashboard;
	private GetListGenresUbications listData;
	private GetSearchData searchData;
	
	public FacadeGUI(){
		dashboard  = new Dashboard();
		listData   = new GetListGenresUbications();
		searchData = new GetSearchData();
	}
	
	public List<String> getSearchArtistData(GUISearchSpecific objectGUI){
		return dashboard.getDataArtist(objectGUI);
	}
	
	public List<Musicalgenres> getListGenres(){
		return listData.getListGenres();
	}
	
	public List<String> getListUbication(){
		return listData.getListUbications();
	}
	
	public List<String> getSearchNames(GUISearchGeneral objectGUI){
		return searchData.getSearchNames(objectGUI);
	}
	
	public List<String> getSearchGenders(GUISearchGeneral objectGUI){
		return searchData.getSearchGenres(objectGUI);
	}
	
	public List<String> getSearchCountries(GUISearchGeneral objectGUI){
		return searchData.getSearchCountry(objectGUI);
	}
	
	public void getQualitySearch(){
		
	}
	
	public void getSocialSearch(){
		
	}
}
