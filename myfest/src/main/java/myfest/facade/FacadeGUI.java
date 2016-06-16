package myfest.facade;

import java.util.List;

import Objects.GUISearchGeneral;
import myfest.logic.Dashboard;
import myfest.logic.ListGenres;
import myfest.logic.ListNames;
import myfest.logic.ListUbications;
import myfest.models.Musicalgenres;

public class FacadeGUI {
	private Dashboard  dashboard;
	private ListGenres     listGenres;
	private ListUbications listUbications;
	private ListNames      listNames;
	
	public FacadeGUI(){
		dashboard      = new Dashboard();
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
	
	public List<String> getArtistNames(GUISearchGeneral objectGUI){
		return listNames.getListNames(objectGUI);
	}
	
	public void getQualitySearch(){
		
	}
	
	public void getSocialSearch(){
		
	}
}
