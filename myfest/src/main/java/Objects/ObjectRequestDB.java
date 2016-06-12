package Objects;

public class ObjectRequestDB {
	private String artistPicture;
	private String artistName;
	private String artistGender;
	private String averageArtist;
	private String averageEvents;
	private String averageDiscs;
	private String amountFollowers;
	private String amountMentions;
	
	public ObjectRequestDB(){
		artistPicture   = "";
		artistName      = "";
		artistGender    = "";
		averageArtist   = "";
		averageEvents   = "";
		averageDiscs    = "";
		amountFollowers = "";
		amountMentions  = "";
	}

	public String getArtistPicture() {
		return artistPicture;
	}

	public String getArtistName() {
		return artistName;
	}

	public String getArtistGender() {
		return artistGender;
	}

	public String getAverageArtist() {
		return averageArtist;
	}

	public String getAverageEvents() {
		return averageEvents;
	}

	public String getAverageDiscs() {
		return averageDiscs;
	}

	public String getAmountFollowers() {
		return amountFollowers;
	}

	public String getAmountMentions() {
		return amountMentions;
	}

	public void setArtistPicture(String artistPicture) {
		this.artistPicture = artistPicture;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setArtistGender(String artistGender) {
		this.artistGender = artistGender;
	}

	public void setAverageArtist(String averageArtist) {
		this.averageArtist = averageArtist;
	}

	public void setAverageEvents(String averageEvents) {
		this.averageEvents = averageEvents;
	}

	public void setAverageDiscs(String averageDiscs) {
		this.averageDiscs = averageDiscs;
	}

	public void setAmountFollowers(String amountFollowers) {
		this.amountFollowers = amountFollowers;
	}

	public void setAmountMentions(String amountMentions) {
		this.amountMentions = amountMentions;
	}
	
	

}
