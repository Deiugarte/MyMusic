package myfest.objects.delivery;

public class DeliveryGeneral extends DeliverySpecific{
	private String amount;
	
	public DeliveryGeneral(String valueSearch, String resultsAmount){
		super(valueSearch);
		amount = resultsAmount;
	}
	
	public String getResultsAmount() {
		return amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
