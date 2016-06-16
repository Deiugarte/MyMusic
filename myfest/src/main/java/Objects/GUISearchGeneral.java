package Objects;

public class GUISearchGeneral extends GUISearchSpecific{
	private String amount;
	
	public GUISearchGeneral(String valueSearch, String resultsAmount){
		super(valueSearch);
		amount = resultsAmount;
	}
	
	public String getResultsAmount() {
		return amount;
	}
}
