package myfan.resources.base;


import java.util.List;

public class FollowedArtistResponse {
	private String nameArtist;
	private String ubicationArtist;
	private int totalOfDiscs;
	private List<String> genres;
	private String image;
	private int rankingOfArtist;
	
	public String getNameArtist() {
		return nameArtist;
	}
	public String getUbicationArtist() {
		return ubicationArtist;
	}
	public int getTotalOfDiscs() {
		return totalOfDiscs;
	}
	public List<String> getGenres() {
		return genres;
	}
	public String getImage() {
		return image;
	}
	public int getRankingOfArtist() {
		return rankingOfArtist;
	}
	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}
	public void setUbicationArtist(String ubicationArtist) {
		this.ubicationArtist = ubicationArtist;
	}
	public void setTotalOfDiscs(int totalOfDiscs) {
		this.totalOfDiscs = totalOfDiscs;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setRankingOfArtist(int rankingOfArtist) {
		this.rankingOfArtist = rankingOfArtist;
	}
	
	
}