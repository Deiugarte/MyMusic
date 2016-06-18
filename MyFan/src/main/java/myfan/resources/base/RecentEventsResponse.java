package myfan.resources.base;

public class RecentEventsResponse {
		private int eventId;
		private String titleEvent;
		private String contentEvent;
		private String dateEvent;
		private String creationDate;
		private boolean isConcert;
		private String ubicationEvent;
		
		
		public int getEventId() {
			return eventId;
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
		public String getCreationDate() {
			return creationDate;
		}
		public boolean isConcert() {
			return isConcert;
		}
		public String getUbicationEvent() {
			return ubicationEvent;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
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
		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}
		public void setConcert(boolean isConcert) {
			this.isConcert = isConcert;
		}
		public void setUbicationEvent(String ubicationEvent) {
			this.ubicationEvent = ubicationEvent;
		}
		
		
}
