package myfest.objects.response;

public class Search extends ArtistGenres{
	private String artistID;
	public Search(){
		super();
	}
	public String getArtistID() {
		return artistID;
	}
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}
}
