package Objects;

public class GUISearchGeneralCountryGender extends GUISearchGeneral{
	private String pSearchType;
	
	public GUISearchGeneralCountryGender(String valueSearch, String searchType, String resultsAmount){
		super(valueSearch, resultsAmount);
		pSearchType = searchType;
	}
	
	public String getSearchType() {
		return pSearchType;
	}

	public void setSearchType(String searchType) {
		this.pSearchType = searchType;
	}
}
