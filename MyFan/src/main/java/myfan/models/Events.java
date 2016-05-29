package myfan.models;
// Generated May 29, 2016 3:37:51 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Events generated by hbm2java
 */
public class Events implements java.io.Serializable {

  private int eventId;
  private Artists artists;
  private Ubications ubications;
  private String tittle;
  private Date eventDate;
  private String content;
  private boolean type;
  private Set eventsCalificationses = new HashSet(0);

  public Events() {
  }

  public Events(int eventId, Artists artists, Ubications ubications, String tittle, Date eventDate, boolean type) {
    this.eventId = eventId;
    this.artists = artists;
    this.ubications = ubications;
    this.tittle = tittle;
    this.eventDate = eventDate;
    this.type = type;
  }

  public Events(int eventId, Artists artists, Ubications ubications, String tittle, Date eventDate, String content,
      boolean type, Set eventsCalificationses) {
    this.eventId = eventId;
    this.artists = artists;
    this.ubications = ubications;
    this.tittle = tittle;
    this.eventDate = eventDate;
    this.content = content;
    this.type = type;
    this.eventsCalificationses = eventsCalificationses;
  }

  public int getEventId() {
    return this.eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public Artists getArtists() {
    return this.artists;
  }

  public void setArtists(Artists artists) {
    this.artists = artists;
  }

  public Ubications getUbications() {
    return this.ubications;
  }

  public void setUbications(Ubications ubications) {
    this.ubications = ubications;
  }

  public String getTittle() {
    return this.tittle;
  }

  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  public Date getEventDate() {
    return this.eventDate;
  }

  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isType() {
    return this.type;
  }

  public void setType(boolean type) {
    this.type = type;
  }

  public Set getEventsCalificationses() {
    return this.eventsCalificationses;
  }

  public void setEventsCalificationses(Set eventsCalificationses) {
    this.eventsCalificationses = eventsCalificationses;
  }

}
