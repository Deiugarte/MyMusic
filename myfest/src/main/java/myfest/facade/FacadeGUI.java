package myfest.facade;

import myfest.logic.Dashboard;
import myfest.logic.ListGenresUbications;
import myfest.logic.SearchData;
import myfest.objects.request.General;
import myfest.objects.request.PersonalDataArtist;


public class FacadeGUI {
	private Dashboard  dashboard;
	private ListGenresUbications listData;
	private SearchData searchData;
	
	public FacadeGUI(){
		dashboard  = new Dashboard();
		listData   = new ListGenresUbications();
		searchData = new SearchData();
	}
	
	// ****************** DASHBOARD ***************
	// Dashboard
	public String getSearchArtistData(int  idArtist){
		return dashboard.getDataArtist(idArtist);
	}
	
	// ****************** INITIAL ****************
	// Initial Genres
	public String getListGenres(){
		return listData.getListGenres();
	}
	
	// Initial Ubications
	public String getListUbications(){
		return listData.getListUbications();
	}
	
	// ******************** SEARCH *****************
	
	public String getSearch(General searchValue){
		return searchData.getSearch(searchValue);
	}
	// Search Names
	//public String getSearchNames(DeliveryGeneral searchValue){
	//	return searchData.getSearchNames(searchValue);
	//}
	
	// Search Genders
	//public String getSearchGenders(DeliveryGeneral searchValue){
	//	return searchData.getSearchGenres(searchValue);
	//}
	
	// Search Countries
	//public String getSearchCountries(DeliveryGeneral searchValue){
	//	return searchData.getSearchCountry(searchValue);
	//}
}
