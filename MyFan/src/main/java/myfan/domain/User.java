package myfan.domain;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User  {
	protected String nameUser;
	protected String birthDate;
	protected String gender;
	protected String login;
	protected String password;
	protected String currentDate;
	protected String countryLocation;
	protected Image  profilePicture;
	protected String identificationNumber;
	protected ArrayList <MusicalGenre> musisicalGenres;
	
	public User(String nameUser, String birthDate,String gender,String login,String password,
			String countryLocation,Image profilePicture,ArrayList<MusicalGenre> musisicalGenres){
		this.nameUser = nameUser;
		this.birthDate = birthDate;
		this.gender= gender;
		this.login= login;
		this.password=password;
		this.countryLocation=countryLocation;
		this.profilePicture=profilePicture;
		this.identificationNumber=calculateIdentifacationNumber();
		this.currentDate=calculateCurrentDate();
	}

	private String calculateIdentifacationNumber(){
		String identificationNumber=java.util.UUID.randomUUID().toString();
		System.out.println(identificationNumber);
		return identificationNumber;
	}
	
	private String calculateCurrentDate() {
		String currentDate="";
		Calendar currentDateComputer = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		currentDate = dateFormatter.format(currentDateComputer.getTime());
		System.out.println(currentDate);
		return currentDate;
	}
}
