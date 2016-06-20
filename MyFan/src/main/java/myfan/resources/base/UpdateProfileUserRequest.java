package myfan.resources.base;

import java.util.ArrayList;

public class UpdateProfileUserRequest {
	private String nameUser;
	private String birthday;    /*verificar*/
	private boolean gender;
	private String password;
	private String countryLocation; 
	private ArrayList<String> musisicalGenres; /*opcional*/
	private int identificationNumber;

	public String getNameUser() {
		return nameUser;
	}
	public String getBirthday() {
		return birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public String getPassword() {
		return password;
	}
	public String getCountryLocation() {
		return countryLocation;
	}
	public ArrayList<String> getMusisicalGenres() {
		return musisicalGenres;
	}
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCountryLocation(String countryLocation) {
		this.countryLocation = countryLocation;
	}
	public void setMusisicalGenres(ArrayList<String> musisicalGenres) {
		this.musisicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

 
}
