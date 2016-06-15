package myfest.logic;

import java.util.List;

import Objects.GUISearchSpecific;
import myfest.facade.FacadeDB;

public class Dashboard {
	private FacadeDB facadeDB;
	
	public Dashboard(){
		facadeDB = new FacadeDB();
	}
	
	public List<String> getDataArtist(GUISearchSpecific guiSearchSpecific){
		return facadeDB.getSearchSpecific(guiSearchSpecific);
	}
}
