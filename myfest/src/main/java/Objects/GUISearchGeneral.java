package Objects;

public class GUISearchGeneral {
	private String searchType;
	private String resultsAmount;
	private String value;
	
	public GUISearchGeneral(){
		searchType    = "";
		resultsAmount = "";
		value         = "";
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getResultsAmount() {
		return resultsAmount;
	}

	public void setFilterType(String filterType) {
		this.resultsAmount = filterType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
