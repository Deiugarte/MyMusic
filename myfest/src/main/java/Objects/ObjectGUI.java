package Objects;

public class ObjectGUI {
	private String searchType;
	private String filterType;
	private String value;
	
	public ObjectGUI(){
		searchType = "";
		filterType = "";
		value = "";
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
