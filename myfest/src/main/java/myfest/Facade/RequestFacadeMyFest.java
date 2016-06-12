package myfest.Facade;

import Objects.ObjectRequestMyFest;
import myfest.Dashboard.myFestDashboard;

public class RequestFacadeMyFest {
	myFestDashboard dashboard;
	
	public RequestFacadeMyFest(){
		dashboard = new myFestDashboard(new ObjectRequestMyFest());
	}
	
	public void getSearchArtistData(ObjectRequestMyFest facadeRequest){
	
	}
	
	public void qualitySearch(){
		
	}
	
	public void socialSearch(){
		
	}
}
