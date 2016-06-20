package myfan.resources.base;

import java.util.ArrayList;
import java.util.List;

public class ArtistProfileResponse {
	private String nameUser;
	private String loginUser;
	private String ageUser;    /*verificar*/
	private String countryLocation; 
	private ArrayList<GenresResponse> musicalGenres; /*opcional*/
	private int identificationNumber;
	private String imageProfile;
	private int numberOfFollowers;
	private int totalOfCalifications;
	private int averageOfArtist;
	private String bibliography;
	private String birthday ;
	private List <String> members;
	
	public String getBirthday() {
		return birthday;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setMembers(List<String> list) {
		this.members = list;
	}
	public int getAverageOfArtist() {
		return averageOfArtist;
	}
	public void setAverageOfArtist(int averageOfArtist) {
		this.averageOfArtist = averageOfArtist;
	}
	public String getNameUser() {
		return nameUser;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public String getAgeUser() {
		return ageUser;
	}
	public String getCountryLocation() {
		return countryLocation;
	}
	public ArrayList<GenresResponse> getMusicalGenres() {
		return musicalGenres;
	}
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public String getImageProfile() {
		return imageProfile;
	}
	public int getNumberOfFollowers() {
		return numberOfFollowers;
	}
	public int getTotalOfCalifications() {
		return totalOfCalifications;
	}
	public String getBibliography() {
		return bibliography;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public void setAgeUser(String ageUser) {
		this.ageUser = ageUser;
	}
	public void setCountryLocation(String countryLocation) {
		this.countryLocation = countryLocation;
	}
	public void setMusicalGenres(ArrayList<GenresResponse> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}
	public void setNumberOfFollowers(int numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	public void setTotalOfCalifications(int totalOfCalifications) {
		this.totalOfCalifications = totalOfCalifications;
	}
	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}
	
	
	
	
}
