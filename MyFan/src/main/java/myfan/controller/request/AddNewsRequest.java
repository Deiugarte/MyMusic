package myfan.controller.request;

public class AddNewsRequest {
	private int idUser;
	private String titleNews;
	private String contentNews;
	private String dateNews;
	
	public int getIdUser() {
		return idUser;
	}
	public String getTitleNews() {
		return titleNews;
	}
	public String getContentNews() {
		return contentNews;
	}
	public String getDateNews() {
		return dateNews;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setTitleNews(String titleNews) {
		this.titleNews = titleNews;
	}
	public void setContentNews(String contentNews) {
		this.contentNews = contentNews;
	}
	public void setDateNews(String dateNews) {
		this.dateNews = dateNews;
	}
	
	
	
}
