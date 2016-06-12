package myfest.Facade;

import Objects.ObjectDeliveryDB;
import Objects.ObjectRequestDB;

public class RequestFacadeDBMyFest {
	
	public RequestFacadeDBMyFest(){}
	
	public ObjectRequestDB getRequestDB(){
		return new ObjectRequestDB();
	}
	
	public void setDeliveryDB(ObjectDeliveryDB data){
		
	}
}
