package myfan.domain.gestion.genres;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.controller.request.AdminGenresRequest;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;

public class GenresLogic {
	private final String ADD_GENRE_STATUS = "{\"GenreId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_GENRER_FOUND = "{\"Error \": \"Genre found \"}";
	private FacadeDAO facadeDAO;

	public GenresLogic() {
		facadeDAO = new FacadeDAO();
	}

	public Response addNewGenres(AdminGenresRequest newGenres) {
		String response = ADD_GENRE_STATUS;
		Genres genre = facadeDAO.findGenderByName(newGenres.getMusicalGenre());
		if (genre != null) {
			return responseBuilder(ERROR_GENRER_FOUND);
		}

		Genres genreMusical = new Genres();
		// user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		genreMusical.setName(newGenres.getMusicalGenre());
		facadeDAO.saveGenre(genreMusical);

		response = String.format(response,genreMusical.getGenreId(), "OK");
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
