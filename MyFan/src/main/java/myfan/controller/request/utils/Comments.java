package myfan.controller.request.utils;

public class Comments {
	private String reviewer;
	private String comment;
	private int calification;
	
	public String getReviewer() {
		return reviewer;
	}
	public String getComment() {
		return comment;
	}
	public int getCalification() {
		return calification;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setCalification(int calification) {
		this.calification = calification;
	}
	
	
}
