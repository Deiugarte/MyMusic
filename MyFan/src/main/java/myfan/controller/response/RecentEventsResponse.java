package myfan.controller.response;

public class RecentEventsResponse {
  private int eventId;
  private String title;
  private String content;
  private String date;
  private String creationDate;
  private boolean isConcert;
  private String ubication;
  private double AverageCalificationsConcerts;
  private String type;
  private boolean isCancel;
  
  
  
  public boolean getIsCancel() {
	return isCancel;
}
public void setIsCancel(boolean isCancel) {
	this.isCancel = isCancel;
}
public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getEventId() {
    return eventId;
  }
  public void setEventId(int eventId) {
    this.eventId = eventId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }
  public boolean isConcert() {
    return isConcert;
  }
  public void setConcert(boolean isConcert) {
    this.isConcert = isConcert;
  }
  public String getUbication() {
    return ubication;
  }
  public void setUbication(String ubication) {
    this.ubication = ubication;
  }
  public double getAverageCalificationsConcerts() {
    return AverageCalificationsConcerts;
  }
  public void setAverageCalificationsConcerts(double averageCalificationsConcerts) {
    AverageCalificationsConcerts = averageCalificationsConcerts;
  }

  
}