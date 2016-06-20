package myfan.resources.base.util;

import java.util.List;

public class Disc {

  private String  genre;
  private int  commentsAmount;
  private int  songsAmount;
  private int  stars;
  private String  recordLabel;
  private String  year;
  private List<Song> songs;
  
  

public String getGenre() {
	return genre;
}
public int getCommentsAmount() {
	return commentsAmount;
}
public int getSongsAmount() {
	return songsAmount;
}
public int getStars() {
	return stars;
}
public String getRecordLabel() {
	return recordLabel;
}
public String getYear() {
	return year;
}
public List<Song> getSongs() {
	return songs;
}

public void setGenre(String genre) {
	this.genre = genre;
}
public void setCommentsAmount(int commentsAmount) {
	this.commentsAmount = commentsAmount;
}
public void setSongsAmount(int songsAmount) {
	this.songsAmount = songsAmount;
}
public void setStars(int stars) {
	this.stars = stars;
}
public void setRecordLabel(String recordLabel) {
	this.recordLabel = recordLabel;
}
public void setYear(String year) {
	this.year = year;
}
public void setSongs(List<Song> songs) {
	this.songs = songs;
}
  
  
}

