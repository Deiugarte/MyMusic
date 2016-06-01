package myfan.domain;

import java.util.ArrayList;

public class Disc {
	private String discName;
	private String discDescription;
	private MusicalGenre musicalGenre; 
	private int yearReleased;
	private String recordLabel;
	private ArrayList <String> songs;
	private ArrayList <String> comments;
	private ArrayList <Integer> scores;
	
	public Disc(String discName, String discDescription, MusicalGenre musicalGenre, int yearReleased, 
			String recordLabel, ArrayList <String> songs){
		this.discName=discName;
		this.discDescription=discDescription;
		this.musicalGenre=musicalGenre;
		this.yearReleased=yearReleased;
		this.recordLabel=recordLabel;
		this.songs=songs;
	}
	
  public void addSong(String durationTime, boolean isRecordedInRecordingStudio, String urlVideo, boolean onlyLimitedEdition){
	  
  }
}
