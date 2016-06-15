package Objects;

public class DBObject {
	private String value;
	private String resultsAmount;
	
	public DBObject(){
		value = "";
		resultsAmount = "";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getResultsAmount() {
		return resultsAmount;
	}

	public void setResultsAmount(String resultsAmount) {
		this.resultsAmount = resultsAmount;
	}
	
	
}
