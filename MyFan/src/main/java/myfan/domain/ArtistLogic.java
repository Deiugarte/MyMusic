package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import myfan.data.models.Artists;
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Genres;
import myfan.data.models.Members;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.ArtistProfileResponse;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.UpdateProfileUserRequest;
import myfan.resources.base.util.Member;

public class ArtistLogic extends UserLogic {

  public Response registerNewArtist(RegisterNewArtistRequest dataArtist, String pathProfilePicture) {

    String response = USER_IDENTIFIER_STATUS;
    Users user = facadeDAO.findUserByLogin(dataArtist.getLogin());
    if (existUser(user)) {
      return responseBuilder(ERROR_USER_FOUND);
    }
    Ubications ubication = checkUbication(dataArtist.getCountryLocation());
    ArrayList<Genres> genders = checkGenres(dataArtist.getMusicalGenres());
    UsersRoles usersRoles = facadeDAO.getArtistRole();
    
    createUser(pathProfilePicture, ubication, usersRoles, dataArtist.getNameUser(), dataArtist.getPassword(),
        dataArtist.getLogin(), dataArtist.getBirthDate());

    Artists artist = new Artists();
    user = facadeDAO.findUserByLogin(dataArtist.getLogin());
    artist.setBio(dataArtist.getBiographyArtist());
    artist.setUsers(user);

    facadeDAO.saveArtist(artist);
    saveMembers(artist, dataArtist.getMembers());
    saveGenres(user, genders);
    
    response = String.format(response, user.getUserId().toString(),"artist", "OK");
    return Response.status(Status.OK).entity(response).build();
  }
  
	public Response updateFanatic(UpdateProfileUserRequest dataArtist, String pathProfilePicture ){
		String response = USER_IDENTIFIER_STATUS;
		updateUser(dataArtist, pathProfilePicture);
		response = String.format(response, dataArtist.getIdentificationNumber(), "OK");
		return Response.status(Status.OK).entity(response).build();
		
	}

  private void saveMembers(Artists artist, ArrayList<Member> membersList) {
    Members members = new Members();
    members.setArtists(artist);
    for (int i = 0; i < membersList.size(); i++) {
      System.out.println("---->"+membersList.get(i).getName());
      members.setInstrument(membersList.get(i).getInstrument());
      members.setName(membersList.get(i).getName());
      facadeDAO.saveMembersArtist(members);
    }
  }
  
  public String getPersonalInformationOfArtist(int idUser) {
	    ArtistProfileResponse artistProfileResponse = new ArtistProfileResponse();
	    Users user = facadeDAO.findUserById(idUser);
	    Artists artist= facadeDAO.findArtistByUserId(idUser);
	    artistProfileResponse.setAgeUser(calculadeAge(user.getBirthday()));
	    Ubications ubications = user.getUbications();
	    ubications = facadeDAO.findUbicationsById(ubications.getUbicationId());
	    artistProfileResponse.setCountryLocation(ubications.getName());
	    artistProfileResponse.setLoginUser(user.getUsername());
	    artistProfileResponse.setNameUser(user.getName());
	    artistProfileResponse.setMusicalGenres(getGenresByUser(idUser));
	    artistProfileResponse.setImageProfile(user.getImage());
	    artistProfileResponse.setIdentificationNumber(idUser);
	    artistProfileResponse.setBibliography(artist.getBio());
	    artistProfileResponse.setNumberOfFollowers(artist.getFollowers());
	    artistProfileResponse.setTotalOfCalifications(calculateTotalOfCalifications(artist.getArtistId()));
	    artistProfileResponse.setAverageOfArtist(calculateRankingArtist(artist.getArtistId()));
	    return jSONFabrication.jsonConverter(artistProfileResponse);
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
	
	private int calculateTotalOfCalifications(int idArtist){
		List<ArtistsCalifications> artistsCalifications= facadeDAO.getArtistCalificationByIdArtist(idArtist);
		return artistsCalifications.size(); 
		
	}
}

