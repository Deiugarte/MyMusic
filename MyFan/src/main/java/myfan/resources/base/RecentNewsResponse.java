package myfan.resources.base;

public class RecentNewsResponse {
	private int idNews;
	private String titleNews;
	private String contentNews;
	private String creationDate;
	private String dateOfNews;
	public int getIdNews() {
		return idNews;
	}
	public String getTitleNews() {
		return titleNews;
	}
	public String getContentNews() {
		return contentNews;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public String getDateOfNews() {
		return dateOfNews;
	}
	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}
	public void setTitleNews(String titleNews) {
		this.titleNews = titleNews;
	}
	public void setContentNews(String contentNews) {
		this.contentNews = contentNews;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public void setDateOfNews(String dateOfNews) {
		this.dateOfNews = dateOfNews;
	}
	
	

}
