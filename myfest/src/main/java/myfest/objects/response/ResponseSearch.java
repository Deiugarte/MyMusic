package myfest.objects.response;

public class ResponseSearch extends ResponseUnique{
	private String artistID;
	public ResponseSearch(){
		super();
	}
	public String getArtistID() {
		return artistID;
	}
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}
}
