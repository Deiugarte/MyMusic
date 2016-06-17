package myfest.objects.response;

import java.util.List;

public class ResponseDashboard {
	private String 				 name;
	private String  		     picture;
	private int					 followersAmount;
	private List<ResponseUnique> artistGenders;
	private ResponseScores 		 concertScore;
	private ResponseScores 	     discScore;
	private ResponseScores 		 artistScore;
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
	public List<ResponseUnique> getArtistGenders() {
		return artistGenders;
	}
	public void setArtistGenders(List<ResponseUnique> artistGenders) {
		this.artistGenders = artistGenders;
	}
	public ResponseScores getConcertScore() {
		return concertScore;
	}
	public void setConcertScore(ResponseScores concertScore) {
		this.concertScore = concertScore;
	}
	public ResponseScores getDiscScore() {
		return discScore;
	}
	public void setDiscScore(ResponseScores discScore) {
		this.discScore = discScore;
	}
	public ResponseScores getArtistScore() {
		return artistScore;
	}
	public void setArtistScore(ResponseScores artistScore) {
		this.artistScore = artistScore;
	}
	public int getTwitterMentionsAmount() {
		return twitterMentionsAmount;
	}
	public void setTwitterMentionsAmount(int twitterMentionsAmount) {
		this.twitterMentionsAmount = twitterMentionsAmount;
	}
	
	
}
