package myfest.Dashboard;

import Objects.ObjectDeliveryDB;
import Objects.ObjectRequestDB;
import Objects.ObjectRequestMyFest;
import myfest.Facade.RequestFacadeDBMyFest;

public class myFestDashboard {
	ObjectRequestMyFest requestMyFestData;
	RequestFacadeDBMyFest requestDBFacade;
	
	ObjectDeliveryDB deliveryDBData;
	ObjectRequestDB  requestDBData;
	
	String searchType;
	
	public myFestDashboard(ObjectRequestMyFest request){
		requestMyFestData   = request;
		requestDBFacade = new RequestFacadeDBMyFest();
		deliveryDBData  = new ObjectDeliveryDB();
		searchType      = "";
		setDeliveryDB();
	}
	
	public void setDeliveryDB(){
		getSearchType(requestMyFestData.getSearchType());
	}
	
	public void getRequestDB(){
		requestDBData = requestDBFacade.getRequestDB();
	}
	
	
	/**
	 * This method allow get the type of filter in the dashboard-search
	 * @param searchType
	 */
	private void getSearchType(String searchType){
		switch (searchType) {
			case "Country":
				deliveryDBData.setSearchType("Country");
				requestDBFacade.setDeliveryDB(deliveryDBData);
				break;
				
			case "Gender":
				deliveryDBData.setSearchType("Gender");
				requestDBFacade.setDeliveryDB(deliveryDBData);
				break;
				
			case "Name":
				deliveryDBData.setSearchType("Name");
				requestDBFacade.setDeliveryDB(deliveryDBData);
				break;
	
			default:
				break;
		}
	}
}
