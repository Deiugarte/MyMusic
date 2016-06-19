package myfan.domain;

import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.services.twitter.TwitterConnection;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterLogic {
	private Twitter twitter;
	private final int STATUS_RATE = 0;
	private final int STATUS_FOLLOW = 1;
	private final int STATUS_RATE_AND_COMMENT = 2;

	/**
	 * Contructor de la clase que crea una nueva instancia de la conexion de
	 * twitter
	 */
	public TwitterLogic() {
		TwitterConnection twitterConnection = new TwitterConnection();
		twitter = twitterConnection.getTwitter();

	}

	public void postTwitter(Fanatics fanatic, Artists artists, int estado) {
		String nameFanatic = fanatic.getUsers().getName();
		String nameArtist = artists.getUsers().getName();

		postStatusTwitter(nameFanatic, nameArtist, estado);
	}

	/**
	 * Este metodo es el encargado de pubicar un nuevo estado en Twitter
	 * 
	 * @param statusTwitter:
	 *            Corresponde a un nuevo estado para twittear
	 */
	private void postTwitter(String statusTwitter) {
		try {
			twitter.updateStatus(statusTwitter);
		} catch (TwitterException ex) {
			 System.out.println("Se han violado las politicas de Twitter, se ignoró la petición del nuevo post");
			//Logger.getLogger(TwitterLogic.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void postStatusTwitter(String nameUser, String nameArtist, int typeInstruction) {
		String finalStatusTwitter = "";
		switch (typeInstruction) {
		case STATUS_RATE:
			finalStatusTwitter = "El fánatico " + nameUser + " publico un nuevo comentario en el perfil del artista "
					+ nameArtist;
			break;
		case STATUS_FOLLOW:
			finalStatusTwitter = "El fánatico " + nameUser + " comenzó a seguir el perfil del artista " + nameArtist;
			break;
		case STATUS_RATE_AND_COMMENT:
			finalStatusTwitter = "El fánatico " + nameUser + " comentó y calificó  el perfil del artista " + nameArtist;
			break;
		}
		postTwitter(finalStatusTwitter);
	}

}
