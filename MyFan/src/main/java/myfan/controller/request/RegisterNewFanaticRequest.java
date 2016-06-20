package myfan.controller.request;

import java.util.ArrayList;

public class RegisterNewFanaticRequest {
	private String nameUser;
	private String birthDate; /*verificar*/
	private boolean gender;
	private String login;     /*verificar*/
	private String password;
	private String countryLocation; 
	private ArrayList<String> musicalGenres; /*opcional*/
	private String identificationNumber;
	private String currentDate;
	
	public String getNameUser() {
		return nameUser;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public boolean getGender() {
		return gender;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getCountryLocation() {
		return countryLocation;
	}

	public ArrayList<String> getMusicalGenres() {
		return musicalGenres;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCountryLocation(String countryLocation) {
		this.countryLocation = countryLocation;
	}

	public void setMusicalGenres(ArrayList<String> musisicalGenres) {
		this.musicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
	
	
	
	
	
}
