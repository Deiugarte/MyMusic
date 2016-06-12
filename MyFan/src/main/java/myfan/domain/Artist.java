package myfan.domain;

import java.awt.Image;
import java.util.ArrayList;

public class Artist  extends User {

	private String biographyArtist;
	private ArrayList <String> members;
	private ArrayList <String> comments;
	private ArrayList <Integer> scores;
	private ArrayList <News> newsArtist;
	private ArrayList <Event> eventsArtist;
	private Discography discographiesArtist;
	private int followersNumber;
	private double ratingRanking;
	
	public Artist(String nameUser, String birthDate, String gender, String login, String password,
			String countryLocation, Image profilePicture, ArrayList<MusicalGenre> musisicalGenres, 
			String biographyArtist,  ArrayList<String> members) {
		super(nameUser, birthDate, gender, login, password, countryLocation, profilePicture, musisicalGenres);
		// TODO Auto-generated constructor stub
		this.biographyArtist=biographyArtist;
		this.members=members;
	}
	
}
	

	
	
	


     

