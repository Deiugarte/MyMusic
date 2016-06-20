package myfest.objects.response;

import java.util.List;

public class ResponseDashboard {
	private String name;
	private String picture;
	private int followersAmount;
	private int concertScore;
	private int discScore;
	private int artistScore;
	private int twitterMentionsAmount;
	private List<String> artistGenders;
	
	public String getName() {
		return name;
	}
	public String getPicture() {
		return picture;
	}
	public int getFollowersAmount() {
		return followersAmount;
	}
	public List<String> getArtistGenders() {
		return artistGenders;
	}
	public int getConcertScore() {
		return concertScore;
	}
	public int getDiscScore() {
		return discScore;
	}
	public int getArtistScore() {
		return artistScore;
	}
	public int getTwitterMentionsAmount() {
		return twitterMentionsAmount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setFollowersAmount(int followersAmount) {
		this.followersAmount = followersAmount;
	}
	public void setArtistGenders(List<String> artistGenders) {
		this.artistGenders = artistGenders;
	}
	public void setConcertScore(int concertScore) {
		this.concertScore = concertScore;
	}
	public void setDiscScore(int discScore) {
		this.discScore = discScore;
	}
	public void setArtistScore(int artistScore) {
		this.artistScore = artistScore;
	}
	public void setTwitterMentionsAmount(int twitterMentionsAmount) {
		this.twitterMentionsAmount = twitterMentionsAmount;
	}
	

}
