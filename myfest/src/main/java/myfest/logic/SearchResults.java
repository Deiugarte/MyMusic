package myfest.logic;

import java.util.List;

import Objects.DBObject;
import Objects.GUISearchGeneral;
import myfest.facade.FacadeDB;

public class SearchResults {	
	private FacadeDB facadeDB;
	
	public SearchResults(){
		facadeDB      = new FacadeDB();
	}
	
	public List<String> getQueryResult(GUISearchGeneral objectGUI){		
		return facadeDB.getSearchGeneral(objectGUI);
	}
}
	

