package myfan.domain.gestion.discography;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.controller.request.AddSongRequest;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Discs;
import myfan.data.models.Songs;

public class SongLogic {
	private final String ADD_SONG_STATUS = "{\"SongId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_DISC_NOT_FOUND = "{\"Error \": \"Disc not found \"}";
	private FacadeDAO facadeDAO;


	public SongLogic(){
		facadeDAO = new FacadeDAO();
	}

	public Response createSong(AddSongRequest song) {
		String response = ADD_SONG_STATUS;
		Discs disc = facadeDAO.findDiscById(song.getIdDisc());
		if (disc == null) {
			return responseBuilder(ERROR_DISC_NOT_FOUND);
		}
		Songs newSong = new Songs();
		newSong.setDiscs(disc);
		newSong.setDuration(song.getDurationSong());
		newSong.setLimitation(song.getIsLimitEdition());
		newSong.setName(song.getNameSong());
		newSong.setState(song.getIsLife());
		newSong.setVideoLink(song.getVideoLink());
		facadeDAO.saveSong(newSong);
		
		response = String.format(response, newSong.getSongId(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	/**
	 * Determina el tipo de Response
	 * 
	 * @param response
	 * @return
	 */
	private Response responseBuilder(String response) {
		return Response.status(Status.UNAUTHORIZED).entity(response).build();
	}
}
