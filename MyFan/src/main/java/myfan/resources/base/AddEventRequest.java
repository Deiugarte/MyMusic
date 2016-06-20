package myfan.resources.base;

public class AddEventRequest {
	private int idUser;
	private String titleEvent;
	private String contentEvent;
	private String dateEvent;
	private String ubicationEvent;
	private boolean isConcert;
	private String creationDate;
	
	public int getIdUser() {
		return idUser;
	}
	public String getTitleEvent() {
		return titleEvent;
	}
	public String getContentEvent() {
		return contentEvent;
	}
	public String getDateEvent() {
		return dateEvent;
	}
	public String getUbicationEvent() {
		return ubicationEvent;
	}
	public boolean getIsConcert() {
		return isConcert;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setTitleEvent(String titleEvent) {
		this.titleEvent = titleEvent;
	}
	public void setContentEvent(String contentEvent) {
		this.contentEvent = contentEvent;
	}
	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}
	public void setUbicationEvent(String ubicationEvent) {
		this.ubicationEvent = ubicationEvent;
	}
	public void setIsConcert(boolean isConcert) {
		this.isConcert = isConcert;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
