package myfan.resources.base;

public class AddDiscRequest {
	private int idUser;
	private String nameDisc;
	private String descriptionDisc;
	private int idGenre;
	private String releaseYear;
	private String label;
	
	public int getIdUser() {
		return idUser;
	}
	
	public String getNameDisc() {
		return nameDisc;
	}
	public String getDescriptionDisc() {
		return descriptionDisc;
	}
	public int getIdGenre() {
		return idGenre;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public String getLabel() {
		return label;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setNameDisc(String nameDisc) {
		this.nameDisc = nameDisc;
	}
	public void setDescriptionDisc(String descriptionDisc) {
		this.descriptionDisc = descriptionDisc;
	}
	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
