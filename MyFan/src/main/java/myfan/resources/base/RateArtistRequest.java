package myfan.resources.base;

public class RateArtistRequest {
	private int idUserArtist;
	private int idUserFanatic;
	private int qualification;
	private String comment;
	
	public int getIdUserArtist() {
		return idUserArtist;
	}
	public int getIdUserFanatic() {
		return idUserFanatic;
	}
	public int getQualification() {
		return qualification;
	}
	public String getComment() {
		return comment;
	}
	public void setIdUserArtist(int idUserArtist) {
		this.idUserArtist = idUserArtist;
	}
	public void setIdUserFanatic(int idUserFanatic) {
		this.idUserFanatic = idUserFanatic;
	}
	public void setQualification(int calification) {
		this.qualification = calification;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
