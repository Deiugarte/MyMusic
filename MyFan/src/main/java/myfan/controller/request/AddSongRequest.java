package myfan.controller.request;

public class AddSongRequest {
	private int idDisc;
	private String nameSong;
	private String durationSong;
	private boolean isLimitEdition;
	private String videoLink;
	private boolean isLife;
	
	
	public int getIdDisc() {
		return idDisc;
	}
	public String getNameSong() {
		return nameSong;
	}
	public String getDurationSong() {
		return durationSong;
	}
	public boolean getIsLimitEdition() {
		return isLimitEdition;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public boolean getIsLife() {
		return isLife;
	}
	public void setIdDisc(int idDisc) {
		this.idDisc = idDisc;
	}
	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}
	public void setDurationSong(String durationSong) {
		this.durationSong = durationSong;
	}
	public void setIsLimitEdition(boolean isLimitEdition) {
		this.isLimitEdition = isLimitEdition;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public void setIsLife(boolean isLife) {
		this.isLife = isLife;
	}
	
	
}
