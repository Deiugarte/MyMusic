package myfest.objects.response;

import java.util.List;

public class ResponseDashboard {
	private String 				 name;
	private String  		     picture;
	private int					 followersAmount;
	private List<Unique> artistGenders;
	private Scores 		 concertScore;
	private Scores 	     discScore;
	private Scores 		 artistScore;
	private int          		 twitterMentionsAmount;
	
	public ResponseDashboard(){
		name 				  = "";
		picture 			  = "";
		followersAmount 	  = 0;
		artistGenders 		  = null;
		concertScore 		  = null;
		discScore 			  = null;
		artistScore 		  = null;
		twitterMentionsAmount = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setImage(String picture) {
		this.picture = picture;
	}
	public int getFollowersAmount() {
		return followersAmount;
	}
	public void setFollowersAmount(int followersAmount) {
		this.followersAmount = followersAmount;
	}
	public List<Unique> getArtistGenders() {
		return artistGenders;
	}
	public void setArtistGenders(List<Unique> artistGenders) {
		this.artistGenders = artistGenders;
	}
	public Scores getConcertScore() {
		return concertScore;
	}
	public void setConcertScore(Scores concertScore) {
		this.concertScore = concertScore;
	}
	public Scores getDiscScore() {
		return discScore;
	}
	public void setDiscScore(Scores discScore) {
		this.discScore = discScore;
	}
	public Scores getArtistScore() {
		return artistScore;
	}
	public void setArtistScore(Scores artistScore) {
		this.artistScore = artistScore;
	}
	public int getTwitterMentionsAmount() {
		return twitterMentionsAmount;
	}
	public void setTwitterMentionsAmount(int twitterMentionsAmount) {
		this.twitterMentionsAmount = twitterMentionsAmount;
	}
	
	
}
