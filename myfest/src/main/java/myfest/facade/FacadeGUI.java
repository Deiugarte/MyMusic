package myfest.facade;

import myfest.logic.Dashboard;
import myfest.logic.GetListGenresUbications;
import myfest.logic.GetSearchData;
import myfest.objects.delivery.DeliveryGeneral;
import myfest.objects.delivery.DeliverySpecific;

public class FacadeGUI {
	private Dashboard  dashboard;
	private GetListGenresUbications listData;
	private GetSearchData searchData;
	
	public FacadeGUI(){
		dashboard  = new Dashboard();
		listData   = new GetListGenresUbications();
		searchData = new GetSearchData();
	}
	
	// ****************** DASHBOARD ***************
	// Dashboard
	public String getSearchArtistData(DeliverySpecific searchValue){
		return dashboard.getDataArtist(searchValue);
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
	
	public String getSearch(DeliveryGeneral searchValue){
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
