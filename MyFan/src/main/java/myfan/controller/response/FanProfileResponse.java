package myfan.controller.response;

import java.util.ArrayList;

public class FanProfileResponse {
	private String nameUser;
	private String loginUser;
	private String ageUser;    /*verificar*/
	private String countryLocation; 
	private ArrayList<GenresResponse> musicalGenres; /*opcional*/
	private int identificationNumber;
	private String imageProfile;
	
	public String getImageProfile() {
		return imageProfile;
	}
	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
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
	public void setMusicalGenres(ArrayList<GenresResponse> musisicalGenres) {
		this.musicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	
}
