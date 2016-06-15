package myfest.facade;

import java.util.List;

import javax.ws.rs.core.Response;

import Objects.ObjectGUI;
import myfest.logic.Dashboard;
import myfest.logic.ListGenres;
import myfest.logic.ListUbications;
import myfest.models.Musicalgenres;

public class FacadeGUI {
	private Dashboard dashboard;
	private ListGenres listGenres;
	private ListUbications listUbications;
	
	public FacadeGUI(){
		dashboard      = new Dashboard();
		listGenres     = new ListGenres();
		listUbications = new ListUbications();
	}
	
	public void getSearchArtistData(ObjectGUI facadeRequest){
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
