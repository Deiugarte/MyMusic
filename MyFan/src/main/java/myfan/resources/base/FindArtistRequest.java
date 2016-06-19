package myfan.resources.base;

public class FindArtistRequest {
	private String name;
	private String nameGenere;
	private String nameUbication;
	
	public String getName() {
		return name;
	}
	public String getNameGenere() {
		return nameGenere;
	}
	public String getNameUbication() {
		return nameUbication;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNameGenere(String nameGenere) {
		this.nameGenere = nameGenere;
	}
	public void setNameUbication(String nameUbication) {
		this.nameUbication = nameUbication;
	}
	
	
}
