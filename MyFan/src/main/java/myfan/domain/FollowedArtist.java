package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.Genres;
import myfan.data.models.UsersGenres;
import myfan.resources.base.FollowedArtistResponse;

public class FollowedArtist {

	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;

	public FollowedArtist() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
	}

	public String getFollowedArtist(int idUser) {
		Fanatics fanatic = facadeDAO.findFanaticByUserId(idUser);
		List<FanaticsArtists> artistasByFanatic = facadeDAO.findArtistsByFanaticId(fanatic.getFanaticId());
		List<FollowedArtistResponse> fanaticsArtists = new ArrayList<FollowedArtistResponse>();
		Artists artist;
		for (int i = 0; i < artistasByFanatic.size(); i++) {
			artist =facadeDAO.findArtistById( artistasByFanatic.get(i).getId().getArtistId());
			FollowedArtistResponse followedArtistResponse = new FollowedArtistResponse();
			followedArtistResponse.setNameArtist(artist.getUsers().getName());
			followedArtistResponse.setImage(artist.getUsers().getImage());
			followedArtistResponse.setUbicationArtist(artist.getUsers().getUbications().getName());
			followedArtistResponse.setRankingOfArtist(calculateRankingArtist(artistasByFanatic.get(i).getArtists().getArtistId()));
			followedArtistResponse.setTotalOfDiscs(calculateTotalOfDisc(artistasByFanatic.get(i).getArtists().getArtistId()));
			followedArtistResponse.setGenres(getGenresByArtist(idUser));
			fanaticsArtists.add(followedArtistResponse);
			
		}
		return jSONFabrication.jsonConverter(fanaticsArtists);
	}
	
	private List<String> getGenresByArtist(int idUser){
		List<UsersGenres> genresByArtist=facadeDAO.findGenresByUsersId(idUser);
		List<String> nameGenresByArtist= new ArrayList<String>();
		for (int i = 0; i < genresByArtist.size(); i++) {
			nameGenresByArtist.add(genresByArtist.get(i).getGenres().getName());
		}
		return nameGenresByArtist;
		
		
	}
	private int calculateTotalOfDisc(int idArtist){
		//Artists artists = facadeDAO.findArtistById(idArtist);
		return facadeDAO.getDiscsByIdArtist(idArtist).size();
	}
	
	private int calculateRankingArtist(int idArtist){
		//Artists artists = facadeDAO.findArtistById(idArtist);
		List<ArtistsCalifications> artistsCalifications= facadeDAO.getArtistCalificationByIdArtist(idArtist);
		int sumOfCalifications=0;
		int average=0;
		if ( artistsCalifications.size()!=0){
		for (int i = 0; i < artistsCalifications.size(); i++) {
			sumOfCalifications += artistsCalifications.get(i).getCalification();
		}
			average= (sumOfCalifications/artistsCalifications.size())*100; 
		}
		return average;
	}
}
