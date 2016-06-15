package myfan.resources.base;

import java.util.ArrayList;
import java.util.Date;

import myfan.resources.base.util.Member;

public class RegisterNewArtistRequest {
	private String nameUser;
	private Date   birthDate; /*verificar*/
	private String login;     /*verificar*/
	private String password;
	private String countryLocation; 
	private ArrayList<String> musisicalGenres; /*opcional*/
	private String identificationNumber;
	private String currentDate;
	private String biographyArtist;
	private ArrayList <Member> members;
	
	public String getNameUser() {
		return nameUser;
	}
	public Date getBirthDate() {
		return birthDate;
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
	public ArrayList<String> getMusisicalGenres() {
		return musisicalGenres;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public String getBiographyArtist() {
		return biographyArtist;
	}
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	public void setMusisicalGenres(ArrayList<String> musisicalGenres) {
		this.musisicalGenres = musisicalGenres;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public void setBiographyArtist(String biographyArtist) {
		this.biographyArtist = biographyArtist;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
}
