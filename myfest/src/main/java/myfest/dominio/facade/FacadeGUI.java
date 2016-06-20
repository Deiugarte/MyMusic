package myfest.dominio.facade;

import myfest.dominio.gestionarlogicamyfest.dashboard.Dashboard;
import myfest.dominio.gestionarlogicamyfest.dashboard.General;
import myfest.dominio.gestionarlogicamyfest.dashboard.ListGenresUbications;
import myfest.dominio.gestionarlogicamyfest.dashboard.PersonalDataArtist;
import myfest.dominio.gestionarlogicamyfest.dashboard.SearchData;


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
