package myfest.logic;

import java.util.List;

import Objects.GUISearchGeneral;
import myfest.facade.FacadeDB;

public class ListNames {
	private FacadeDB facadeDB;
	
	public ListNames(){
		facadeDB = new FacadeDB();
	}

	public List<String> getListNames(GUISearchGeneral guiObject) {
		return facadeDB.getSearchName(guiObject);
		}	
	
}
