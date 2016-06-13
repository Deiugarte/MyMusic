package myfan.data.models;
// Generated Jun 13, 2016 12:10:00 AM by Hibernate Tools 5.1.0.Alpha1

/**
 * ArtistsCalifications generated by hbm2java
 */
public class ArtistsCalifications implements java.io.Serializable {

  private Integer artistCalificationId;
  private Artists artists;
  private Fanatics fanatics;
  private int calification;
  private String comment;

  public ArtistsCalifications() {
  }

  public ArtistsCalifications(Artists artists, Fanatics fanatics, int calification) {
    this.artists = artists;
    this.fanatics = fanatics;
    this.calification = calification;
  }

  public ArtistsCalifications(Artists artists, Fanatics fanatics, int calification, String comment) {
    this.artists = artists;
    this.fanatics = fanatics;
    this.calification = calification;
    this.comment = comment;
  }

  public Integer getArtistCalificationId() {
    return this.artistCalificationId;
  }

  public void setArtistCalificationId(Integer artistCalificationId) {
    this.artistCalificationId = artistCalificationId;
  }

  public Artists getArtists() {
    return this.artists;
  }

  public void setArtists(Artists artists) {
    this.artists = artists;
  }

  public Fanatics getFanatics() {
    return this.fanatics;
  }

  public void setFanatics(Fanatics fanatics) {
    this.fanatics = fanatics;
  }

  public int getCalification() {
    return this.calification;
  }

  public void setCalification(int calification) {
    this.calification = calification;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
