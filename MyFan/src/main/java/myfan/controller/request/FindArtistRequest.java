package myfan.controller.request;

public class FindArtistRequest {
	private String name;
	private String nameGenre;
	private String nameUbication;
	
	public String getName() {
		return name;
	}
	public String getNameGenre() {
		return nameGenre;
	}
	public String getNameUbication() {
		return nameUbication;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNameGenre(String nameGenere) {
		this.nameGenre = nameGenere;
	}
	public void setNameUbication(String nameUbication) {
		this.nameUbication = nameUbication;
	}
	
	
}
