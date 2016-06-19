package myfan.data.models;
// Generated Jun 19, 2016 12:46:28 AM by Hibernate Tools 5.1.0.Alpha1


/**
 * EventsCalifications generated by hbm2java
 */
public class EventsCalifications implements java.io.Serializable {

  private Integer eventCalificationId;
  private Events events;
  private Fanatics fanatics;
  private int calification;
  private String comment;

  public EventsCalifications() {
  }

  public EventsCalifications(Events events, Fanatics fanatics, int calification) {
    this.events = events;
    this.fanatics = fanatics;
    this.calification = calification;
  }

  public EventsCalifications(Events events, Fanatics fanatics, int calification, String comment) {
    this.events = events;
    this.fanatics = fanatics;
    this.calification = calification;
    this.comment = comment;
  }

  public Integer getEventCalificationId() {
    return this.eventCalificationId;
  }

  public void setEventCalificationId(Integer eventCalificationId) {
    this.eventCalificationId = eventCalificationId;
  }

  public Events getEvents() {
    return this.events;
  }

  public void setEvents(Events events) {
    this.events = events;
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
