package myfest.logic;

import java.util.List;

import myfest.facade.FacadeDB;

public class ListUbications {
	private FacadeDB facadeDB;
	
	public ListUbications(){
		facadeDB = new FacadeDB();
	}
	
	public List<String> getListUbications(){
		return facadeDB.getUbicationsArtists();
	}
}
