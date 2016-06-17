package myfan.resources.base;

import java.util.ArrayList;

public class UserProfileResponse {
	private String nameUser;
	private String loginUser;
	private String ageUser;    /*verificar*/
	private String countryLocation; 
	private ArrayList<GenresResponse> musisicalGenres; /*opcional*/
	private int identificationNumber;
	
	
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
	public ArrayList<GenresResponse> getMusisicalGenres() {
		return musisicalGenres;
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
	public void setMusisicalGenres(ArrayList<GenresResponse> musisicalGenres) {
		this.musisicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	
}
