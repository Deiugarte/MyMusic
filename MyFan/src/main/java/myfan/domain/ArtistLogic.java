package myfan.domain;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import myfan.data.models.Artists;
import myfan.data.models.Genres;
import myfan.data.models.Members;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
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
    ArrayList<Genres> genders = checkGenres(dataArtist.getMusisicalGenres());
    UsersRoles usersRoles = facadeDAO.getArtistRole();

    createUser(pathProfilePicture, ubication, usersRoles, dataArtist.getNameUser(), dataArtist.getPassword(),
        dataArtist.getLogin(), dataArtist.getBirthDate());

    Artists artist = new Artists();
    user = facadeDAO.findUserByLogin(dataArtist.getLogin());
    // artist.setBiographyArtist(dataArtist.getBiographyArtist());
    artist.setUsers(user);

    facadeDAO.saveArtist(artist);
    saveMembers(artist, dataArtist.getMembers());
    saveGenres(user, genders);

    response = String.format(response, user.getUserId().toString(), "OK");
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
}
