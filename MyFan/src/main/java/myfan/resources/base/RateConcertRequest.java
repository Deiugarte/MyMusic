package myfan.resources.base;

public class RateConcertRequest {
	private int idUserFanatic;
	private int idEvent;
	private int qualification;
	private String comment;
	public int getIdUserFanatic() {
		return idUserFanatic;
	}
	public int getIdEvent() {
		return idEvent;
	}
	public int getQualification() {
		return qualification;
	}
	public String getComment() {
		return comment;
	}
	public void setIdUserFanatic(int idUserArtist) {
		this.idUserFanatic = idUserArtist;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
