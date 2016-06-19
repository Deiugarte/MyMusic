package myfan.resources.base;

public class RateDiscRequest {
	private int idDisc;
	private int idUserFanatic;
	private int qualification;
	private String comment;
	
	public int getIdDisc() {
		return idDisc;
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
	public void setIdDisc(int idDisc) {
		this.idDisc = idDisc;
	}
	public void setIdUserFanatic(int idUserFanatic) {
		this.idUserFanatic = idUserFanatic;
	}
	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
