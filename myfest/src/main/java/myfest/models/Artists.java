package myfest.models;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

/**
 * Artists generated by hbm2java
 */
public class Artists implements java.io.Serializable {

  private int artistId;
  private ArtistsScores artistsScores;
  private Concertsscores concertsscores;
  private Discsscores discsscores;
  private String artistName;
  private int followersAmount;
  private String ubication;
  private String image;
  private Set<Artistsgenres> artistsgenreses = new HashSet<Artistsgenres>(0);
  private Set<Twittermentions> twittermentionses = new HashSet<Twittermentions>(0);

  public Artists() {
  }

  public Artists(int artistId, ArtistsScores artistsScores, Concertsscores concertsscores, Discsscores discsscores,
      String artistName, int followersAmount, String ubication) {
    this.artistId = artistId;
    this.artistsScores = artistsScores;
    this.concertsscores = concertsscores;
    this.discsscores = discsscores;
    this.artistName = artistName;
    this.followersAmount = followersAmount;
    this.ubication = ubication;
  }

  public Artists(int artistId, ArtistsScores artistsScores, Concertsscores concertsscores, Discsscores discsscores,
      String artistName, int followersAmount, String ubication, String image, Set<Artistsgenres> artistsgenreses,
      Set<Twittermentions> twittermentionses) {
    this.artistId = artistId;
    this.artistsScores = artistsScores;
    this.concertsscores = concertsscores;
    this.discsscores = discsscores;
    this.artistName = artistName;
    this.followersAmount = followersAmount;
    this.ubication = ubication;
    this.image = image;
    this.artistsgenreses = artistsgenreses;
    this.twittermentionses = twittermentionses;
  }

  public int getArtistId() {
    return this.artistId;
  }

  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }

  public ArtistsScores getArtistsscores() {
    return this.artistsScores;
  }

  public void setArtistsscores(ArtistsScores artistsScores) {
    this.artistsScores = artistsScores;
  }

  public Concertsscores getConcertsscores() {
    return this.concertsscores;
  }

  public void setConcertsscores(Concertsscores concertsscores) {
    this.concertsscores = concertsscores;
  }

  public Discsscores getDiscsscores() {
    return this.discsscores;
  }

  public void setDiscsscores(Discsscores discsscores) {
    this.discsscores = discsscores;
  }

  public String getArtistName() {
    return this.artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public int getFollowersAmount() {
    return this.followersAmount;
  }

  public void setFollowersAmount(int followersAmount) {
    this.followersAmount = followersAmount;
  }

  public String getUbication() {
    return this.ubication;
  }

  public void setUbication(String ubication) {
    this.ubication = ubication;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Set<Artistsgenres> getArtistsgenreses() {
    return this.artistsgenreses;
  }

  public void setArtistsgenreses(Set<Artistsgenres> artistsgenreses) {
    this.artistsgenreses = artistsgenreses;
  }

  public Set<Twittermentions> getTwittermentionses() {
    return this.twittermentionses;
  }

  public void setTwittermentionses(Set<Twittermentions> twittermentionses) {
    this.twittermentionses = twittermentionses;
  }

}
