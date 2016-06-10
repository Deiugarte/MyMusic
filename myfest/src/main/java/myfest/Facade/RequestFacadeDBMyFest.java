package myfest.Facade;

import Objects.ObjectDeliveryDB;
import Objects.ObjectRequestDB;
import Objects.ObjectRequestMyFest;

public class RequestFacadeDBMyFest {
	
	public RequestFacadeDBMyFest(){}
	
	public ObjectRequestDB getRequestDB(){
		return new ObjectRequestDB();
	}
	
	public void setDeliveryDB(ObjectDeliveryDB data){
		
	}
}
