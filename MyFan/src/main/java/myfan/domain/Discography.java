package myfan.domain;

import java.util.ArrayList;

public class Discography {
	private ArrayList <Disc> Discs;
	
	public void createAlbum(String discName, String discDescription, MusicalGenre musicalGenre, int yearReleased, 
			String recordLabel, ArrayList <String> songs){
		Disc disc =new Disc(discName, discDescription, musicalGenre, yearReleased, recordLabel, songs);
		Discs.add(disc);
	}
}
