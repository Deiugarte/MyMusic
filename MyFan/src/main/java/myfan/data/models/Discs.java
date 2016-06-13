package myfan.data.models;
// Generated Jun 13, 2016 1:18:21 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Discs generated by hbm2java
 */
public class Discs implements java.io.Serializable {

  private Integer discId;
  private Artists artists;
  private Genres genres;
  private String name;
  private String description;
  private Date releaseYear;
  private String label;
  private Set discsCalificationses = new HashSet(0);
  private Set songses = new HashSet(0);

  public Discs() {
  }

  public Discs(Artists artists, Genres genres, String name, String description, Date releaseYear) {
    this.artists = artists;
    this.genres = genres;
    this.name = name;
    this.description = description;
    this.releaseYear = releaseYear;
  }

  public Discs(Artists artists, Genres genres, String name, String description, Date releaseYear, String label,
      Set discsCalificationses, Set songses) {
    this.artists = artists;
    this.genres = genres;
    this.name = name;
    this.description = description;
    this.releaseYear = releaseYear;
    this.label = label;
    this.discsCalificationses = discsCalificationses;
    this.songses = songses;
  }

  public Integer getDiscId() {
    return this.discId;
  }

  public void setDiscId(Integer discId) {
    this.discId = discId;
  }

  public Artists getArtists() {
    return this.artists;
  }

  public void setArtists(Artists artists) {
    this.artists = artists;
  }

  public Genres getGenres() {
    return this.genres;
  }

  public void setGenres(Genres genres) {
    this.genres = genres;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getReleaseYear() {
    return this.releaseYear;
  }

  public void setReleaseYear(Date releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Set getDiscsCalificationses() {
    return this.discsCalificationses;
  }

  public void setDiscsCalificationses(Set discsCalificationses) {
    this.discsCalificationses = discsCalificationses;
  }

  public Set getSongses() {
    return this.songses;
  }

  public void setSongses(Set songses) {
    this.songses = songses;
  }

}
