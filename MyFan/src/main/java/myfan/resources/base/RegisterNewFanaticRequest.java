package myfan.resources.base;

import java.util.ArrayList;
import java.util.Date;



public class RegisterNewFanaticRequest {
	private String nameUser;
	private Date birthDate; /*verificar*/
	private boolean gender;
	private String login;     /*verificar*/
	private String password;
	private String countryLocation; 
	private String profilePicture; /*opcional*/
	private ArrayList<String> musisicalGenres; /*opcional*/
	private String identificationNumber;
	private String currentDate;
	
	public String getNameUser() {
		return nameUser;
	}
	public Date getBirthDate() {
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
	public String getProfilePicture() {
		return profilePicture;
	}
	public ArrayList<String> getMusisicalGenres() {
		return musisicalGenres;
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
	public void setBirthDate(Date birthDate) {
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
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public void setMusisicalGenres(ArrayList<String> musisicalGenres) {
		this.musisicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
	
	
	
	
	
}
