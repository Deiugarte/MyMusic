package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.resources.base.DiscographyResponse;

public class DiscographyLogic {
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;
	
	public DiscographyLogic() {
	    facadeDAO = new FacadeDAO();
	    jSONFabrication = new JSONFabrication();
	}
	
	public String getDiscography(int idUser){
		List<DiscographyResponse>  discographyResponse = new ArrayList<DiscographyResponse>();
		
		return "";
				
	}
}
