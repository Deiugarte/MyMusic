package Objects;

public class GUISearchGeneral {
	private String pValue;
	private String pResultsAmount;
	
	public GUISearchGeneral(String valueSearch, String resultsAmount){
		pValue 		   = valueSearch;
		pResultsAmount = resultsAmount;
	}

	public String getValueSearch() {
		return pValue;
	}	
	
	public String getResultsAmount() {
		return pResultsAmount;
	}
}
